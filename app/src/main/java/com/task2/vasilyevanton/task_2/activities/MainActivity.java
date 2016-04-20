package com.task2.vasilyevanton.task_2.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.task2.vasilyevanton.task_2.R;
import com.task2.vasilyevanton.task_2.fragments.AppealsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawer;
    private static long sBackPressed;
    private static final int APPEALS_ALL = 0;
    private static final int APPEALS_ON_MAP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityInit();
        selectItem(APPEALS_ALL);
    }




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        mDrawer.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_appeal: {
                selectItem(APPEALS_ALL);
                return true;
            }
            case R.id.nav_appeal_map: {
                setTitle(R.string.on_map_appeals);
                return true;
            }
        }
        return true;
    }


    private void selectItem(int position) {

        // Update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case APPEALS_ALL:
                setTitle(R.string.all_appeals);
                fragment = new AppealsFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        } else {
            // Error
            Log.e(this.getClass().getName(), "Error. Fragment is not created");
        }
    }

    private void activityInit() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);


        ActionBar mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView itRuhTV = (TextView) findViewById(R.id.it_ruh_dnipro);
        itRuhTV.setMovementMethod(LinkMovementMethod.getInstance());
        TextView yalantisTV = (TextView) findViewById(R.id.yalantis);
        yalantisTV.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            if (sBackPressed + 3000 > System.currentTimeMillis()) {
                super.onBackPressed();
            }else {
                Toast.makeText(this, R.string.press_again_to_exit,Toast.LENGTH_SHORT).show();
            }
            sBackPressed = System.currentTimeMillis();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_action_sort) {
            Toast.makeText(MainActivity.this,"Sort Button",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
