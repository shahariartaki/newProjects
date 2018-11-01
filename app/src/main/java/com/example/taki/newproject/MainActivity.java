package com.example.taki.newproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.taki.newproject.books.books_fragment;
import com.example.taki.newproject.bus.bus_fragment;
import com.example.taki.newproject.faculty_members.faculty_member_fragment;
import com.example.taki.newproject.main_view.main_fragment;
import com.example.taki.newproject.notice_board.notice_fragment;
import com.example.taki.newproject.programming_calculator.programming_calculator;
import com.example.taki.newproject.programming_convertor.programming_converter;
import com.example.taki.newproject.student_batch.Student_Batch_Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static MainActivity  mainActivity;
    long firstTime,lastTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new main_fragment());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //addFragment(new main_fragment());
        //addFragment(new main_fragment());


        mainActivity = this;

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        lastTime=firstTime;
        firstTime = System.currentTimeMillis();
        if (firstTime-lastTime<200){
            finish();
        }
        else {
            addFragment(new main_fragment());
            Toast.makeText(this, "press double click to Exit", Toast.LENGTH_SHORT).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_student_batch) {

            Toast.makeText(this, "Pressed on Student Batch", Toast.LENGTH_SHORT).show();
            addFragment(new Student_Batch_Fragment());
            // Handle the camera action
        } else if (id == R.id.nav_notice_board) {
            Toast.makeText(this, "Pressed on Notice Board", Toast.LENGTH_SHORT).show();
            addFragment(new notice_fragment());

        } else if (id == R.id.nav_books) {
            Toast.makeText(this, "Pressed on Book", Toast.LENGTH_SHORT).show();
            addFragment(new books_fragment());

        } else if (id == R.id.faculty_members) {
            Toast.makeText(this, "Pressed on Faculty Member", Toast.LENGTH_SHORT).show();
            addFragment(new faculty_member_fragment());

        } else if (id == R.id.nav_bus) {

            Toast.makeText(this, "Pressed on Bus", Toast.LENGTH_SHORT).show();
            addFragment(new bus_fragment());


            // startActivity(new Intent(this, faculty_member.class));


        } else if (id == R.id.nav_calculator) {
            Toast.makeText(this, "Pressed on Calculator", Toast.LENGTH_SHORT).show();
            addFragment(new programming_calculator());

        }
        else if (id == R.id.nav_convert) {

            Toast.makeText(this, "Pressed on Converter", Toast.LENGTH_SHORT).show();
            addFragment(new programming_converter());

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.fragment_place,fragment);
        transaction.commit();

    }

   /* @Override
    public void onBackPressed(){
        lastTime=firstTime;
        firstTime = System.currentTimeMillis();
        if (firstTime-lastTime<200){
            finish();
        }
        else {
            Toast.makeText(this, "press double click to Exit", Toast.LENGTH_SHORT).show();
        }
    }*/
}
