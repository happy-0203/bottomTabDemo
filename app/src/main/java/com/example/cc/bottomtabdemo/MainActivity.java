package com.example.cc.bottomtabdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cc.bottomtabdemo.activity.BottomNavigationActivity;
import com.example.cc.bottomtabdemo.activity.CustomViewActivity;
import com.example.cc.bottomtabdemo.activity.FragmentTabHostActivity;
import com.example.cc.bottomtabdemo.activity.RidioGroupActivity;
import com.example.cc.bottomtabdemo.activity.TabLayOutActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Intent mIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button tabLayOut = findViewById(R.id.tabLayout);
        Button bottomNavigation = findViewById(R.id.bottomNavigation);
        Button fragmentTabHost = findViewById(R.id.fragmentTabHost);
        Button ridioGroup = findViewById(R.id.ridioGroup);
        Button customView = findViewById(R.id.customView);

        tabLayOut.setOnClickListener(this);
        bottomNavigation.setOnClickListener(this);
        fragmentTabHost.setOnClickListener(this);
        ridioGroup.setOnClickListener(this);
        customView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tabLayout:
                mIntent = new Intent(this, TabLayOutActivity.class);
                break;

            case R.id.bottomNavigation:
                mIntent = new Intent(this, BottomNavigationActivity.class);
                break;

            case R.id.fragmentTabHost:
                mIntent = new Intent(this, FragmentTabHostActivity.class);
                break;

            case R.id.ridioGroup:
                mIntent = new Intent(this, RidioGroupActivity.class);
                break;

            case R.id.customView:
                mIntent = new Intent(this, CustomViewActivity.class);
                break;
            default:
                break;
        }
        startActivity(mIntent);
    }
}
