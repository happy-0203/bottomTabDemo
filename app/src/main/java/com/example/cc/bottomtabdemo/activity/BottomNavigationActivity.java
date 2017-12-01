package com.example.cc.bottomtabdemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.cc.bottomtabdemo.R;
import com.example.cc.bottomtabdemo.fragments.AccountFragment;
import com.example.cc.bottomtabdemo.fragments.BrandsFragment;
import com.example.cc.bottomtabdemo.fragments.HistoryFragment;
import com.example.cc.bottomtabdemo.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FrameLayout mContainer;
    private BottomNavigationView mBottomNavigationView;

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
        setContentView(R.layout.activity_bottom_navigation);

        initFragments();
        initView();
        
    }

    private void initView() {
        mContainer = findViewById(R.id.container);
        mBottomNavigationView = findViewById(R.id.bottomNavigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initFragments() {
        mFragments.add(new HomeFragment());
        mFragments.add(new BrandsFragment());
        mFragments.add(new HistoryFragment());
        mFragments.add(new AccountFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        onTabItemSelected(item.getItemId());

        return true;
    }

    private void onTabItemSelected(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.tab_home:
                fragment = mFragments.get(0);
                break;
            case R.id.tab_brand:
                fragment = mFragments.get(1);
                break;
            case R.id.tab_history:
                fragment = mFragments.get(2);
                break;
            case R.id.tab_account:
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
