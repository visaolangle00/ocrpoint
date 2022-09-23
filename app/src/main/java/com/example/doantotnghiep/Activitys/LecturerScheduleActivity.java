package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LecturerScheduleActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences8;
    private Button parse;
    private TextView result;
    private RequestQueue rQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_schedule);

        getSupportActionBar().setTitle("Schedule");

        result = findViewById(R.id.tvResult);

        rQueue = Volley.newRequestQueue(this);

        jsonParse();

    }

        private void jsonParse(){


            String url = "http://192.168.1.193/DOANTOTNGHIEPNEWS/view_schedule.php";

          //  String url = "http://192.168.1.193/DOANTOTNGHIEP/view_schedule.php";

            //String url ="https://api.npoint.io/de933673e66207b73960";

            StringRequest request = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.d("response",response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);

                                JSONArray jsonArray = jsonObject.getJSONArray("thoikhoabieus");
                                for(int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject cities = jsonArray.getJSONObject(i);
                                    //   int userId = cities.getInt("cid");
                                    String tenmon=cities.getString("TenMon");
                                    String type = cities.getString("TKB");

                                    result.append("\t\t"+tenmon+ "\n\n " + String.valueOf(type) + "\n\n");
                                    //  result.append(type + "\n " + String.valueOf(type) + "\n\n");
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
            }

                    ;

            rQueue.add(request);


    }
}
