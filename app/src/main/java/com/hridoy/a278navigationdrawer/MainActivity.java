package com.hridoy.a278navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    MaterialToolbar meterialtoolBar;
    NavigationView navigationView;
    TextView headerTitle;
    View headerView;
    ImageView imageHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawerLayout);
        meterialtoolBar=findViewById(R.id.meterialtoolBar);
        navigationView=findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView( 0);
        headerTitle = headerView.findViewById(R.id.headerTitle);
        imageHeader = headerView.findViewById(R.id.imageHeader);





        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(

                MainActivity.this,drawerLayout,meterialtoolBar,R.string.drawer_close,R.string.drawer_open);

         drawerLayout.addDrawerListener(toggle);



        meterialtoolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

              if (item.getItemId()==R.id.share){
                  Toast.makeText(MainActivity.this,"Share",Toast.LENGTH_LONG).show();
              }

              else if (item.getItemId()==R.id.like){

                  Toast.makeText(MainActivity.this,"Like",Toast.LENGTH_LONG).show();

              }
                return false;
            }
        });






         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 if (item.getItemId()==R.id.dse){

                     //Toast.makeText(MainActivity.this,"Home",Toast.LENGTH_LONG).show();

                     FirstFragment.Web_Url = "https://www.dsebd.org/";

                     FragmentManager fmanager = getSupportFragmentManager();
                     FragmentTransaction ftransaction = fmanager.beginTransaction();
                     ftransaction.add(R.id.framelayout, new FirstFragment() );
                     ftransaction.commit();


                     drawerLayout.closeDrawer(GravityCompat.START);

                 }

                else if (item.getItemId()==R.id.cse){

                     //Toast.makeText(MainActivity.this,"Profile",Toast.LENGTH_LONG).show();

                     FirstFragment.Web_Url = "https://www.cse.com.bd/";

                     FragmentManager fmanager = getSupportFragmentManager();
                     FragmentTransaction ftransaction = fmanager.beginTransaction();
                     ftransaction.add(R.id.framelayout, new FirstFragment() );
                     ftransaction.commit();

                     drawerLayout.closeDrawer(GravityCompat.START);
                 }


                 else if (item.getItemId()==R.id.notification){

                     Toast.makeText(MainActivity.this,"Notification",Toast.LENGTH_LONG).show();
                     drawerLayout.closeDrawer(GravityCompat.START);
                 }

                 else if (item.getItemId()==R.id.setting){

                     Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_LONG).show();
                     drawerLayout.closeDrawer(GravityCompat.START);


                 }


                 return true;
             }
         });


    }

    //--------oncreate Ends

}