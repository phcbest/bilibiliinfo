package com.phc.bilibiliinfo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 版权：没有版权 看得上就用
 *
 * @author peng
 * 创建日期：2020/5/14 11
 * 描述：
 */
public class MainActivityViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList ;

    public MainActivityViewPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
