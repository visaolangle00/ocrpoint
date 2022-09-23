package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
import com.example.doantotnghiep.Adapters.CrudAdapter;
import com.example.doantotnghiep.Adapters.CrudAdapter2;
import com.example.doantotnghiep.Models.CrudStudentPoints;
import com.example.doantotnghiep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_DEL;
import static com.example.doantotnghiep.Utils.Url.URL_GETSD;

public class LvCrudPointsActivity extends AppCompatActivity {

    String url = "http://192.168.1.193/studentpoint/getsv.php";

    String urldel = "http://192.168.1.193/studentpoint/delete.php";


    //String url = "http://192.168.1.193/DOANTOTNGHIEP/getsv.php";

    //String urldel = "http://192.168.1.193/DOANTOTNGHIEP/delete.php";

    //ListView listView;
    ArrayList<CrudStudentPoints> arrayList;
    //CrudAdapter adapter;
    CrudAdapter2 adapter2;
    RecyclerView recyclerView;
    LayoutAnimationController layoutAnimationController;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_crud_points);

        getSupportActionBar().setTitle("Student Score List");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_left);


       // listView =(ListView)findViewById(R.id.lvSinhVien);
        recyclerView = findViewById(R.id.recycleview_points);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        //adapter= new CrudAdapter(this,R.layout.listcrud_pointst,arrayList);
       // listView.setAdapter(adapter);
        adapter2 = new CrudAdapter2(this,arrayList);
        recyclerView.setAdapter(adapter2);
        recyclerView.setLayoutAnimation(layoutAnimationController);

        getData(url);

    }

    private void getData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL_GETSD, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                arrayList.clear();
                Log.d("test", response.toString()+"..............");
                for (int i = 0; i<response.length(); i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        int diemtemp = -1;
                        if(object.isNull("diem_gk")){

                            diemtemp = -1;
                        }else {
                            diemtemp = object.getInt("diem_gk");
                        }



                        arrayList.add(new CrudStudentPoints(
                                object.getInt("id"),

                                //  object.isNull("Diem") ? null: object.getInt("Diem"),
                                diemtemp,
                                object.getString("sv_id"),
                                object.getString("lop_id")


                        ));
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                adapter2.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LvCrudPointsActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonArrayRequest);
    }

    public void deleteStudent(final int id){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DEL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(LvCrudPointsActivity.this, " Delete successful", Toast.LENGTH_SHORT).show();
                    getData(url);
                }else{
                    Toast.makeText(LvCrudPointsActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LvCrudPointsActivity.this, "An Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("id", String.valueOf(id));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_student, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.btnSearch){
//            startActivity(new Intent(ListViewCrudActivity.this, SearchCrudActivity.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.add_student_points, menu);
    return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btnAdd){
            startActivity(new Intent(LvCrudPointsActivity.this, AddCrudActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }



}
