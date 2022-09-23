package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.AdapterSchedule;
import com.example.doantotnghiep.Adapters.AdapterSchedule2;
import com.example.doantotnghiep.Models.ViewSubject;
import com.example.doantotnghiep.R;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_SCHEDULE;

public class LvScheduleActivity extends AppCompatActivity {



    ListView listView;
    RecyclerView recyclerView;
    AdapterSchedule2 adapterSchedule2;

    ArrayList<ViewSubject> arrayList;
    //AdapterSchedule adapter;
    SharedPreferences sharedPreferences8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_schedule);
        getSupportActionBar().setTitle("Schedule");

       // listView=(ListView)findViewById(R.id.lvSchedule);
        recyclerView = findViewById(R.id.recycleview_sh);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        arrayList= new ArrayList<>();
        adapterSchedule2 = new AdapterSchedule2(getApplicationContext(),arrayList);
        recyclerView.setAdapter(adapterSchedule2);
        adapterSchedule2.notifyDataSetChanged();
        //adapter = new AdapterSchedule(this,R.layout.row_schedule, arrayList);
        //listView.setAdapter(adapter);

        getData();
    }

    private void getData() {
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                arrayList.clear();
//                for (int i = 0; i<response.length(); i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        arrayList.add(new ViewSubject(
//                                object.getString("tenmon"),
//                                object.getString("monhoc_id"),
//                                object.getString("tkb"),
//                                object.getString("sotinchi"),
//                                object.getString("gv_id")
//                        ));
//                    }catch (JSONException e){
//                        e.printStackTrace();
//                    }
//                }
//              //  adapter.notifyDataSetChanged();
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(LvScheduleActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
//                    }
//                })

        String url = "http://192.168.1.193/studentpoint/get_all_task.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, URL_SCHEDULE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("response",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray jsonArray = jsonObject.getJSONArray("monhocs");

                            int totallvsche = jsonArray.length();
                            if (totallvsche > 0) {
                                arrayList.clear();

                            for (int i = 0; i < totallvsche; i++) {
                                JSONObject scheduoject = jsonArray.getJSONObject(i);
                                String TENMON = scheduoject.getString("tenmon");
                                String MONHOC_ID = scheduoject.getString("monhoc_id");
                                String TKB = scheduoject.getString("tkb");
                                String SOTINCHI = scheduoject.getString("sotinchi");
                                String GV_ID = scheduoject.getString("gv_id");
                                String LICH=scheduoject.getString("lich");

                                ViewSubject viewSubject = new ViewSubject(TENMON, MONHOC_ID, TKB, SOTINCHI, GV_ID,LICH);
                                arrayList.add(viewSubject);
                            }
                            adapterSchedule2.notifyDataSetChanged();
                        }else{
                         //   Toast.makeText(LvScheduleActivity.this, "No tasks added yet", Toast.LENGTH_SHORT).show();
                        }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();

                sharedPreferences8 = getSharedPreferences("UserInfo8", Context.MODE_PRIVATE);

                String gv_id= sharedPreferences8.getString(getResources().getString(R.string.prefLoginState),"");

                String gv_idspace=gv_id.replaceAll("\\s", "");

                Log.d("gv_id",gv_idspace);

                map.put("gv_id",gv_idspace);

                return map;
            }
        };
        queue.add(request);
    }


}
