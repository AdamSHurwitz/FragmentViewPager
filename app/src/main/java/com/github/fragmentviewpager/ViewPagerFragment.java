package com.github.fragmentviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPagerFragment extends Fragment {

    private SmartFragmentStatePagerAdapter adapterViewPager;

    public ViewPagerFragment() {
    }

    /**
     * @return A new instance of fragment ViewPagerFragment.
     */
    public static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        adapterViewPager = new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        viewPager.setOffscreenPageLimit(1);

        TabLayout tableLayout = (TabLayout) view.findViewById(R.id.tabs);
        tableLayout.setupWithViewPager(viewPager);

        return view;
    }

    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public com.github.fragmentviewpager.Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return com.github.fragmentviewpager.Fragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return com.github.fragmentviewpager.Fragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return com.github.fragmentviewpager.Fragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + position;
        }
    }

}