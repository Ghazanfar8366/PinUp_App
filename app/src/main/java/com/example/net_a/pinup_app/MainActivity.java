package com.example.net_a.pinup_app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout mdrawerlayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    String[] mDrawerListItem;
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
       toolbar.setVisibility(View.VISIBLE);
       setSupportActionBar(toolbar);
        mdrawerlayout= (DrawerLayout) findViewById(R.id.drawer_layout);
       mDrawerList = (ListView) findViewById(R.id.list);
        mDrawerListItem=getResources().getStringArray(R.array.menu_items);
       ExploreFragment fragment=new ExploreFragment();
        android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDrawerListItem));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int positio=position+1;
                //Toast.makeText(MainActivity.this, position+"clicked", Toast.LENGTH_LONG).show();
                if(positio==1){
                    LoginFragment fragment=new LoginFragment();
                    android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container,fragment);
                    transaction.commit();
                }else if(positio==2){
                    SignupFragment fragment=new SignupFragment();
                    android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container,fragment);
                    transaction.commit();

                }else if(positio==3){
                    Intent intent=new Intent(MainActivity.this,NewLoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
                mdrawerlayout.closeDrawer(mDrawerList);
            }
        });
        mDrawerToggle=new ActionBarDrawerToggle(this,mdrawerlayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                syncState();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                syncState();
            }
        };
        mdrawerlayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

  }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case android.R.id.home:{
                if(mdrawerlayout.isDrawerOpen(mDrawerList)){
                    mdrawerlayout.closeDrawer(mDrawerList);
                }else {
                    mdrawerlayout.openDrawer(mDrawerList);
                }
                return true;
            }
            default:return super.onOptionsItemSelected(item);

        }
    }


}
