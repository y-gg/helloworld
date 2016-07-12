package com.example.yg.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yg.helloworld.view.Footbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yg on 2016/5/8.
 */
public class Viewpager extends AppCompatActivity {
    String[] tvs={"item1","item2","item3"};
    List<VpFragment> vpFragments = new ArrayList<VpFragment>();
    FragmentPagerAdapter mAdapter;
    Footbar mFootbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        mFootbar = (Footbar) findViewById(R.id.footbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager1);
        for (String item:tvs) {
            VpFragment fragment = VpFragment.newInstance(item);
            vpFragments.add(fragment);
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return vpFragments.get(position);
            }

            @Override
            public int getCount() {
                return vpFragments.size();
            }
        };
        viewPager.setAdapter(mAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //tabWidth*positionOffset+position*tabWidth
                mFootbar.scroll(position,positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
