package com.example.GoIceland.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.GoIceland.R;
import com.example.GoIceland.adapters.NavDrawerListAdapter;
import com.example.GoIceland.enums.FragmentEnum;
import com.example.GoIceland.fragments.ConcertFragment;
import com.example.GoIceland.fragments.HomeFragment;
import com.example.GoIceland.models.NavDrawerItem;
import com.example.GoIceland.services.NavDrawerItemService;
import com.example.GoIceland.services.NavDrawerItemServiceStub;

import java.util.ArrayList;

public class MainActivity extends Activity {
    /**
     * Member variables
     */
    private DrawerLayout m_DrawerLayout;
    private ListView m_DrawerList;

    private ActionBarDrawerToggle m_DrawerToggle;

    private NavDrawerItemService m_NavDrawerItemService;
    private ArrayList<NavDrawerItem> m_NavDrawerItems;
    private NavDrawerListAdapter m_NavDrawerListAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_NavDrawerItemService = new NavDrawerItemServiceStub();
        m_DrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        m_DrawerList = (ListView) findViewById(R.id.nav_drawer_list);

        m_NavDrawerItems = m_NavDrawerItemService.getNavDrawerItems();

        // Set item click listener for drawer list
        m_DrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // Set the nav drawer list adapter
        m_NavDrawerListAdapter = new NavDrawerListAdapter(getApplicationContext(), m_NavDrawerItems);
        m_DrawerList.setAdapter(m_NavDrawerListAdapter);

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        m_DrawerToggle = new ActionBarDrawerToggle(this, m_DrawerLayout,
                R.drawable.ic_toggle,   //nav menu toggle icon
                R.string.app_name,      // nav drawer open - description for accessibility
                R.string.app_name       // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                //getActionBar().setTitle(m_Title);
                getActionBar().setTitle(R.string.app_name);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                //getActionBar().setTitle(m_DrawerTitle);
                getActionBar().setTitle(R.string.app_name);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        m_DrawerLayout.setDrawerListener(m_DrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     */
    public void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case FragmentEnum.HomeFragment:
                fragment = new HomeFragment();
                break;
            case FragmentEnum.ConcertFragment:
                fragment = new ConcertFragment();
                break;
            case 2:
                fragment = new HomeFragment();
                break;
            case 3:
                fragment = new HomeFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            m_DrawerList.setItemChecked(position, true);
            m_DrawerList.setSelection(position);
            //setTitle(m_NavMenuTitles[position]);
            m_DrawerLayout.closeDrawer(m_DrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    /**
     * Initialize the contents of the Activity's standard options menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * This hook is called whenever an item in options menu is selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (m_DrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = m_DrawerLayout.isDrawerOpen(m_DrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        m_DrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        m_DrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Slide menu item click listener
     */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }
}