package gyndroids.com.studyjam;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import gyndroids.com.studyjam.fragments.BirthdayCard;
import gyndroids.com.studyjam.fragments.JustJava;
import gyndroids.com.studyjam.fragments.ScoreTracker;

public class MainActivity extends AppCompatActivity {

    private static String FRAGMENT_TAG_STRING = "com.gyndroids.studyjam.FRAGMENT_TAG";

    // refer to the app components
    // navigation drawer, toolbar and so on.
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationDrawer;
    private ActionBarDrawerToggle mDrawerToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        // set up the drawer layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mDrawerToogle = setUpDrawerToggle();
        mDrawerLayout.setDrawerListener(mDrawerToogle);

        setUpNavigationDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToogle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToogle.onConfigurationChanged(newConfig);
    }

    private void setUpToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setUpNavigationDrawer() {
        mNavigationDrawer = (NavigationView) findViewById(R.id.main_nav_view);
        if (mNavigationDrawer != null)
            setUpDrawerContent();
    }

    private ActionBarDrawerToggle setUpDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
    }

    private void setUpDrawerContent() {
        mNavigationDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });

        // select Default Item
        mNavigationDrawer.getMenu().performIdentifierAction(R.id.drawer_scorecounter, 0);

        // http://stackoverflow.com/questions/33194594/navigationview-get-find-header-layout/33194816
        View mHeaderView = mNavigationDrawer.inflateHeaderView(R.layout.drawer_header);
        //mHeaderView = mNavigationDrawer.getHeaderView(0);
    }

    private void selectDrawerItem(MenuItem menuItem) {

        Class fragmentClass;
        switch (menuItem.getItemId()) {
            // bithday card
            case R.id.drawer_birthdaycard:
                fragmentClass = BirthdayCard.class;
                break;
            // court score counter
            case R.id.drawer_scorecounter:
                fragmentClass = ScoreTracker.class;
                break;
            // just java
            case R.id.drawer_justjava:
                fragmentClass = JustJava.class;
                break;

            // configs
            case R.id.drawer_settings:
                fragmentClass = BirthdayCard.class;
                break;

            // default
            default:
                fragmentClass = BirthdayCard.class;
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;

        try {
            setTitle(menuItem.getTitle());
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, FRAGMENT_TAG_STRING)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerLayout.closeDrawers();

    }

}
