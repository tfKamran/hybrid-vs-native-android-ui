package com.tf.hybridvsnativeui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamran on 7/7/16.
 */

public class FragmentNative extends Fragment {

    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_native, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new ListAdapter(getSampleItems()));
    }

    private List<ListItem> getSampleItems() {
        List<ListItem> sampleItems = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            try {
                sampleItems.add(new ListItem(Drawable.createFromStream(getResources()
                        .getAssets().open("avatars/tfKamran.png"), null),
                        "tfKamran",
                        "Just another developer :P"));
                sampleItems.add(new ListItem(Drawable.createFromStream(getResources()
                        .getAssets().open("avatars/myTerminal.jpg"), null),
                        "myTerminal",
                        "Programmer, Gamer, Trance-lover, Nerd, Imposter, Thoughtful, Muslim, Methodical, Righteous"));
                sampleItems.add(new ListItem(Drawable.createFromStream(getResources()
                        .getAssets().open("avatars/genialRysa.jpg"), null),
                        "genialRysa",
                        "virtually VIRTUAL"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sampleItems;
    }

    private class ListItem {

        private Drawable avatar;
        private String name;
        private String description;

        public ListItem(Drawable avatar, String name, String description) {
            this.avatar = avatar;
            this.name = name;
            this.description = description;
        }

        public Drawable getAvatar() {
            return avatar;
        }

        public void setAvatar(Drawable avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    private class ListItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView lblName;
        TextView lblDescription;

        public ListItemViewHolder(View itemView) {
            super(itemView);

            imgAvatar = (ImageView) itemView.findViewById(R.id.img_avatar);
            lblName = (TextView) itemView.findViewById(R.id.lbl_name);
            lblDescription = (TextView) itemView.findViewById(R.id.lbl_description);
        }
    }

    private class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

        private List<ListItem> items;

        public ListAdapter(List<ListItem> items) {
            this.items = items;
        }

        @Override
        public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListItemViewHolder(LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ListItemViewHolder holder, int position) {
            holder.imgAvatar.setImageDrawable(items.get(position).getAvatar());
            holder.lblName.setText(items.get(position).getName());
            holder.lblDescription.setText(items.get(position).getDescription());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
