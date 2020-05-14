package com.phc.bilibiliinfo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private NavigationView activityNavigationView;
    private Toolbar activityToolbar;
    private DrawerLayout activityDrawerLayout;
    private ViewPager2 activityViewpager;
    private RadioButton activityRadioButtonHub;
    private RadioButton activityRadioButtonMusic;
    private RadioButton activityRadioButtonFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //侧滑栏
        sideSlidingColumn();

//        //做单元测试,将av号和bv号互转的方法
//        String av = ToBvAv.toAv("BV14k4y1k7Tw");
//        String bv = ToBvAv.toBv("100437093");
//        Log.d(TAG, "onCreate: " + av + "\n" + bv);
    }

    private void sideSlidingColumn() {
        setSupportActionBar(activityToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.home);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_github);
        }
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                activityDrawerLayout.openDrawer(GravityCompat.START);
            default:
        }
        return true;
    }

    private void initView() {
        activityNavigationView = (NavigationView) findViewById(R.id.activity_NavigationView);
        activityToolbar = (Toolbar) findViewById(R.id.activity_Toolbar);
        activityDrawerLayout = (DrawerLayout) findViewById(R.id.activity_DrawerLayout);
        activityViewpager = (ViewPager2) findViewById(R.id.activity_Viewpager);
        activityRadioButtonHub = (RadioButton) findViewById(R.id.activity_RadioButton_hub);
        activityRadioButtonMusic = (RadioButton) findViewById(R.id.activity_RadioButton_music);
        activityRadioButtonFire = (RadioButton) findViewById(R.id.activity_RadioButton_fire);
    }
}
