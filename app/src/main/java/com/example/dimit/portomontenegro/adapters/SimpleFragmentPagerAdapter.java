package com.example.dimit.portomontenegro.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.dimit.portomontenegro.EventFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        Fragment f=new EventFragment();
        if (position == 0) {
            f=new EventFragment();
        } else if (position == 1) {
            f=new EventFragment();
        } else if (position == 2) {
            f=new EventFragment();
        }  else {
            f= new EventFragment();
        }
        return f;
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    public Fragment getFragment(ViewPager container, int position, FragmentManager fm) {
        String name = makeFragmentName(container.getId(), position);
        return fm.findFragmentByTag(name);
    }

    private String makeFragmentName(int viewId, int index) {
        return "android:switcher:" + viewId + ":" + index;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        String Title="";
        if (position == 0) {
            Title="TODAY";
        } else if (position == 1) {
            Title="TOMORROW";
        } else if (position == 2) {
            Title="27.05.2018";
        } else {
            Title="28.05.2018";
        }
        return Title;
    }

}