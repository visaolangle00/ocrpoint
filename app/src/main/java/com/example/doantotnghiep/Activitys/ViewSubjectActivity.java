package com.example.doantotnghiep.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.ViewSubjectAdapter;
import com.example.doantotnghiep.Models.ViewSubject;
import com.example.doantotnghiep.R;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_MAINVIEW;


public class ViewSubjectActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Profile profile;

    ListView lvViewMon;
    ArrayList<ViewSubject> viewSubjectArrayList;

    ViewSubjectAdapter viewSubjectAdapter;

    SharedPreferences sharedPreferences,sharedPreferences1,sharedPreferences2,sharedPreferences3,sharedPreferences4,sharedPreferences5,sharedPreferences6;

    SharedPreferences sharedPreferences8, sharedPreferences7;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;

    Button ctdiem,ctsinhvien,ctthoikhoabieu, ctsearchsinhvien;

    TextView dashboard_name,dashboard_id,dashboard_email;

    ImageButton buttonctdiem, buttonkhoabieu, buttonserachsinhvien, buttonpointshp, buttonsearch;

    LinearLayout layoutpointpt;
    NavigationView navigationView;
    String loginStatus3, loginStatus4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subject);

        getSupportActionBar().setTitle("Home Screen");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView =(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        // init view
        showInfo();





       buttonctdiem=(ImageButton)findViewById(R.id.dashboardDiem);
       buttonctdiem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(ViewSubjectActivity.this,LvCrudPointsActivity.class));
           }
       });

       buttonkhoabieu=(ImageButton)findViewById(R.id.dashboardSchedule);
       buttonkhoabieu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(ViewSubjectActivity.this,LvScheduleActivity.class));
           }
       });

       buttonpointshp=(ImageButton)findViewById(R.id.dashboardPointsHp);
       buttonpointshp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(ViewSubjectActivity.this,PointsHPActivity.class));
           }
       });

       buttonsearch=(ImageButton)findViewById(R.id.dashboardSearch);
       buttonsearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(ViewSubjectActivity.this,SearchActivity.class));
           }
       });




        Menu menu = navigationView.getMenu();



        MenuItem menuRegister = menu.findItem(R.id.register);

        MenuItem menuPointpt =menu.findItem(R.id.pointpt);

        MenuItem menuSelectSubject   =menu.findItem(R.id.selectsubjects);

        layoutpointpt=(LinearLayout)findViewById(R.id.layoutPointsHp);

        if(loginStatus3.equals("Yes1")){
            menuRegister.setVisible(true);
        }else{
            menuRegister.setVisible(false);
        }

        if(loginStatus4.equals("Yes2")){

            menuPointpt.setVisible(true);
            menuSelectSubject.setVisible(true);
        }else{
            layoutpointpt.setVisibility(View.INVISIBLE);
           menuPointpt.setVisible(false);
           menuSelectSubject.setVisible(false);
        }









        lvViewMon =(ListView)findViewById(R.id.lvviewmon);

        viewSubjectArrayList = new ArrayList<>();

        viewSubjectAdapter = new ViewSubjectAdapter(this,viewSubjectArrayList);

        lvViewMon.setAdapter(viewSubjectAdapter);


//       ctdiem= findViewById(R.id.buttonctdiem);
//
//       ctdiem.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               startActivity(new Intent(ViewSubjectActivity.this,LvCrudPointsActivity.class));
//           }
//       });
//
//       ctthoikhoabieu = findViewById(R.id.buttontkb);
//
//       ctthoikhoabieu.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               // startActivity(new Intent(ViewSubjectActivity.this,LecturerScheduleActivity.class));
//               startActivity(new Intent(ViewSubjectActivity.this,LvScheduleActivity.class));
//           }
//       });
//
//       ctsearchsinhvien=findViewById(R.id.buttonsearch);
//
//       ctsearchsinhvien.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               startActivity(new Intent(ViewSubjectActivity.this,SearchActivity.class));
//           }
//       });









    }

    @Override
    protected void onResume() {
        super.onResume();
        showInfo();
    }

    public  void showInfo(){

        // for get save data
        sharedPreferences =getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        sharedPreferences1 =getSharedPreferences("UserInfo1", Context.MODE_PRIVATE);
        sharedPreferences2=getSharedPreferences("UserInfo2", Context.MODE_PRIVATE);
        sharedPreferences3 =getSharedPreferences("UserInfo3", Context.MODE_PRIVATE);
        sharedPreferences4 =getSharedPreferences("UserInfo4", Context.MODE_PRIVATE);
        sharedPreferences5 =getSharedPreferences("UserInfo5", Context.MODE_PRIVATE);
        sharedPreferences6 =getSharedPreferences("UserInfo6", Context.MODE_PRIVATE);
        sharedPreferences7 =getSharedPreferences("UserInfo7", Context.MODE_PRIVATE);


        String loginStatus =sharedPreferences.getString(getResources().getString(R.string.prefLoginState),"");
        String loginStatus1 =sharedPreferences1.getString(getResources().getString(R.string.prefLoginState),"");
        String loginStatus2 =sharedPreferences2.getString(getResources().getString(R.string.prefLoginState),"");
         loginStatus3 =sharedPreferences3.getString(getResources().getString(R.string.prefLoginState),"");
         loginStatus4 =sharedPreferences4.getString(getResources().getString(R.string.prefLoginState),"");
        String loginStatus5 =sharedPreferences5.getString(getResources().getString(R.string.prefLoginState),"");
        String loginStatus6 =sharedPreferences6.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus7= sharedPreferences7.getString(getResources().getString(R.string.prefLoginState),"");

        // hien ra man hinh header
        View hView = navigationView.getHeaderView(0);
        TextView user_email=(TextView)hView.findViewById(R.id.user_email);
        TextView user_id=(TextView)hView.findViewById(R.id.user_id);
        TextView user_name=(TextView)hView.findViewById(R.id.user_name);
        ImageView user_setting =(ImageView)hView.findViewById(R.id.userSetting);



        user_id.setText(loginStatus1);

        user_email.setText(loginStatus2);

        user_name.setText(loginStatus5);



        user_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewSubjectActivity.this,UserSettingActivity.class));
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });


    }


    private void getAllTasksFromDB() {

       // String URL_GET_ALL_TASKS="http://192.168.1.193/DoAnTotNghiep/get_all_task.php";

        String URL_GET_ALL_TASKS="http://192.168.1.193/studentpoint/get_all_task.php";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST,URL_MAINVIEW,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // JSON parsing
                        try {
                            //JSONObject jsonObject = new JSONObject(response.toString());
                            //JSONArray jsonArray = new JSONArray(response);
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray jsonArray = jsonObject.getJSONArray("monhocs");
                            int totalTasks = jsonArray.length();
                            if (totalTasks > 0) {
                                viewSubjectArrayList.clear();
                                for (int i = 0; i < totalTasks; i++) {
                                    JSONObject MonJSONObject = jsonArray.getJSONObject(i);
                                    String TENMON = MonJSONObject.getString("tenmon");
                                    String MONHOC_ID =MonJSONObject.getString("monhoc_id");
                                    String TKB =MonJSONObject.getString("tkb");
                                    String SOTINCHI=MonJSONObject.getString("sotinchi");
                                    String GV_ID=MonJSONObject.getString("gv_id");
                                    String LICH=MonJSONObject.getString("lich");

                                    ViewSubject subjects=new ViewSubject(TENMON,MONHOC_ID,TKB,SOTINCHI,GV_ID,LICH);

                                    viewSubjectArrayList.add(subjects);
                                }
                                // taskArrayAdapter.notifyDataSetChanged();

                                viewSubjectAdapter.notifyDataSetChanged();

                            } else {
                             //   Toast.makeText(ViewSubjectActivity.this, "No tasks added yet", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                        // Log.d("Tasks",response);

                        // Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                        Log.d("Tasks", response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();


                sharedPreferences8 =getSharedPreferences("UserInfo8", Context.MODE_PRIVATE);

                String gv_id= sharedPreferences8.getString(getResources().getString(R.string.prefLoginState),"");

                String gv_idspace=gv_id.replaceAll("\\s", "");






                Log.d("gv_id",gv_idspace);








                map.put("gv_id",gv_idspace);





                return map;
            }
        };

        queue.add(request);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getAllTasksFromDB();
    }


//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        if(mToogle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.register:
                startActivity(new Intent(ViewSubjectActivity.this,RegisterActivity.class));

                break;
            case R.id.change_pword:
                startActivity(new Intent(ViewSubjectActivity.this,EditProfileActivity.class));

                break;

            case R.id.logout:
                final SharedPreferences sharedPreferences =getSharedPreferences("UserInfo",MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefLoginState),"loggedout");
                editor.apply();
                startActivity(new Intent(ViewSubjectActivity.this,LoginPageActivity.class));
                finish();
                Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                break;



            case R.id.selectsubjects:
                startActivity(new Intent(ViewSubjectActivity.this,ListSpinnerActivity.class));
                break;

            case R.id.ocr:
                startActivity(new Intent(ViewSubjectActivity.this,OCRAcitivity.class));
                break;


//            case R.id.uploadimage:
//                startActivity(new Intent(ViewSubjectActivity.this,ImageViewActivity.class));
//                break;

            case R.id.pointpt:
                startActivity(new Intent(ViewSubjectActivity.this,PointsHPActivity.class));
                break;





        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item){
        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
