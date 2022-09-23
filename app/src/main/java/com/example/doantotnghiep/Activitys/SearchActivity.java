package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.AdapterSearchStudent;
import com.example.doantotnghiep.Models.Student_Pt;
import com.example.doantotnghiep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.doantotnghiep.Utils.Url.URL_SEARCH;

public class SearchActivity extends AppCompatActivity {

    EditText TENSVET;
    RecyclerView rvList;
    AdapterSearchStudent adapterSearchStudent;
    List<Student_Pt> student_ptList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setTitle("Search Name");

        TENSVET = findViewById(R.id.ettensv_st);



        TENSVET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                   Fitter(s.toString());
            }
        });

        rvList=findViewById(R.id.rvListta);
        rvList.setLayoutManager(new GridLayoutManager(this,1));
        student_ptList=new ArrayList<>();

        getDataSearch();

        adapterSearchStudent=new AdapterSearchStudent(SearchActivity.this,student_ptList);
        rvList.setAdapter(adapterSearchStudent);
        adapterSearchStudent.notifyDataSetChanged();

    }

    public void getDataSearch() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SEARCH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("Fitter");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                student_ptList.add(
                                        new Student_Pt(
                                                jsonObject1.getString("masv"),
                                                jsonObject1.getString("tensv"),
                                                jsonObject1.getString("sv_id"),
                                                jsonObject1.getString("lopql")


                                        )
                                );
                            }

                            adapterSearchStudent = new AdapterSearchStudent(SearchActivity.this, student_ptList);
                            rvList.setAdapter(adapterSearchStudent);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );

        requestQueue.add(stringRequest);
    }

    public void Fitter(String text) {
        ArrayList<Student_Pt> fittername = new ArrayList<>();

        for(Student_Pt namesv_id : student_ptList) {
            if(namesv_id.getTensv_pt().toLowerCase().contains(text.toLowerCase())) {
                fittername.add(namesv_id);
             //   Log.d("fitter", String.valueOf(fittername.add(name)));
            }
        }


       // adapterSearchStudent.Fitter(fittername);
        adapterSearchStudent = new AdapterSearchStudent(SearchActivity.this, fittername);
        rvList.setAdapter(adapterSearchStudent);
    }


}
