package com.example.cc.bottomtabdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cc.bottomtabdemo.R;
import com.example.cc.bottomtabdemo.fragments.AccountFragment;
import com.example.cc.bottomtabdemo.fragments.BrandsFragment;
import com.example.cc.bottomtabdemo.fragments.HistoryFragment;
import com.example.cc.bottomtabdemo.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class TabLayOutActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private FrameLayout mContainer;
    private TabLayout mTabLayout;


    public static final int[] TAB_ICONS = {R.drawable.tab_category_selector,
            R.drawable.tab_brand_selector,
            R.drawable.tab_history_selector,
            R.drawable.tab_account_selector
    };

    public static final String[] TBA_TITLE = {"首页", "品牌", "历史", "我的"};

    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_lay_out);

        initFragments();
        initViews();

    }

    private void initFragments() {
        mFragments.add(new HomeFragment());
        mFragments.add(new BrandsFragment());
        mFragments.add(new HistoryFragment());
        mFragments.add(new AccountFragment());
    }

    private void initViews() {
        mContainer = findViewById(R.id.container);
        mTabLayout = findViewById(R.id.tabLayout);


        mTabLayout.addOnTabSelectedListener(this);

        //注意addTab需要在设置监听之后调用,才会默认选中第一个tab
        for (int i = 0; i < TBA_TITLE.length; i++) {
            View view = View.inflate(this, R.layout.item_tab_view, null);
            ImageView tabIcon = view.findViewById(R.id.tab_iv);
            TextView tabTv = view.findViewById(R.id.tab_tv);
            tabIcon.setImageResource(TAB_ICONS[i]);
            tabTv.setText(TBA_TITLE[i]);

            mTabLayout.addTab(mTabLayout.newTab().setCustomView(view));
        }


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //选中
        onTabItemSelected(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragments.get(0);
                break;
            case 1:
                fragment = mFragments.get(1);
                break;
            case 2:
                fragment = mFragments.get(2);
                break;
            case 3:
                fragment = mFragments.get(3);
                break;
            default:
                break;
        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }


    }


}
