package com.tf.hybridvsnativeui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.tf.library.tabs.TabsHolder;
import com.tf.library.tabs.TabsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        // Set up the tabs
        final TabsHolder tabsHolder = (TabsHolder) findViewById(R.id.tabs);
        tabsHolder.setViewPager(viewPager);

        // When swiping between different sections, select the corresponding tab.
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                tabsHolder.setCurrentTabIndex(position);
            }
        });
    }

    private class PagerAdapter extends TabsPagerAdapter {

        private ArrayList<TabItem> pages = new ArrayList<>();

        PagerAdapter(FragmentManager fm) {
            super(fm);

            pages.add(new TabItem(getResources().getDrawable(R.drawable.ic_ionic_material),
                    "Ionic Material", new FragmentIonic()));
            pages.add(new TabItem(getResources().getDrawable(R.mipmap.ic_launcher),
                    "Native", new FragmentNative()));
        }

        @Override
        public Drawable getPageIcon(int position) {
            return pages.get(position).icon;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return pages.get(position).title;
        }

        @Override
        public Fragment getItem(int position) {
            return pages.get(position).fragment;
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }

    private class TabItem {
        Drawable icon;
        String title;
        Fragment fragment;

        public TabItem(Drawable icon, String title, Fragment fragment) {
            this.icon = icon;
            this.title = title;
            this.fragment = fragment;
        }
    }
}
