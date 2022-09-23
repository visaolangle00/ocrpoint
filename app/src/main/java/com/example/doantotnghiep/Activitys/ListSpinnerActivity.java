package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Adapters.ListSpinnerAdapter;
import com.example.doantotnghiep.Models.MonHocIdSpinner;
import com.example.doantotnghiep.Models.Students;
import com.example.doantotnghiep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.doantotnghiep.Utils.Url.URL_SELECT;
import static com.example.doantotnghiep.Utils.Url.URL_SPINNER;

public class ListSpinnerActivity extends AppCompatActivity {


    private String spinner_url="http://192.168.1.193/studentpoint/spinner.php";
    private String select_url="http://192.168.1.193/studentpoint/select.php";



//    private String spinner_url="http://192.168.1.193/DOANTOTNGHIEP/spinner.php";
//    private String select_url="http://192.168.1.193/DOANTOTNGHIEP/select.php";

    List<MonHocIdSpinner> spinnerst =new ArrayList<MonHocIdSpinner>();
    List<String> select = new ArrayList<String>();
    ListSpinnerAdapter listAdapter;
    ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_spinner);

        getSupportActionBar().setTitle("Group class");

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        Spinner spinner =(Spinner)findViewById(R.id.spinner);
        final ArrayAdapter spinnerAdapter= new ArrayAdapter(this,R.layout.dropdown_item,select);
        spinner.setAdapter(spinnerAdapter);

        try{spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                populateList(parent.getItemAtPosition(position).toString(),requestQueue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}
        catch(Exception e){
            Log.e("spinner",e.getMessage());}
        JsonObjectRequest jsonSpinnerObjectRequest=new JsonObjectRequest(Request.Method.GET,URL_SELECT,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

              //  Set<String> set = new HashSet();

                try {

                    JSONArray jsonArray = response.getJSONArray("lophocphan");


                   Set<String> setA = new HashSet<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject group = jsonArray.getJSONObject(i);
                   //     Log.e("onResponseSpinner", group.getString("sv_id") + " " + group.getString("lopql"));
                       setA.add(group.getString("lop_id"));
                     //   select.add(group.getString("lopql"));
                        //cityList.add(new City(city.getInt("cid"),city.getString("cname")));
                    }
                   select.addAll(setA);





//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject group = jsonArray.getJSONObject(i);
//                        Log.e("onResponseSpinner", group.getString("mamon") + " " + group.getString("tenmon"));
//
//                        select.set(group.getString("mamon"));
//
//                       // select.add(group.getString("mamon"));
//                        //cityList.add(new City(city.getInt("cid"),city.getString("cname")));
//                    }
                    spinnerAdapter.notifyDataSetChanged();

                }catch(JSONException jex)
                {
                    jex.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("VOLLEY","ERROR in response"+error.getMessage());
            }
        });
        requestQueue.add(jsonSpinnerObjectRequest);
        ListView listView=(ListView)findViewById(R.id.listView);

        listAdapter = new ListSpinnerAdapter(this, spinnerst,requestQueue);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   Toast.makeText(getApplicationContext(), "Good Choice", Toast.LENGTH_SHORT).show();
            }
        });
        pDialog=new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        //final String selection="Lucknow";
    }

    private void populateList(final String selection, RequestQueue requestQueue) {
        JsonObjectRequest jsonListObjectRequest=new JsonObjectRequest(Request.Method.GET,URL_SPINNER,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (pDialog != null) {
                        pDialog.dismiss();
                        pDialog = null;
                    }
                    spinnerst.clear();
                    JSONArray jsonArray = response.getJSONArray("monhocs");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject rest = jsonArray.getJSONObject(i);

                        String SVIDSP=rest.getString("sv_id");

                        //String tenMon=rest.getString("tenmon");
                        String TENSVSP=rest.getString("monhoc_id");
                        String LOPQLSP=rest.getString("lop_id");
                        String DIEMGKSP=rest.getString("diem_gk");




                        //String url=rest.getString("url");
                        //Log.i("POST RESPONSE", rname +cname +url);
                        if(rest.getString("lop_id").compareTo(selection)==0)
                            spinnerst.add(new MonHocIdSpinner(SVIDSP,TENSVSP,LOPQLSP,DIEMGKSP));

                    }
                }catch(JSONException jex)
                {
                    jex.printStackTrace();
                }
                Log.i("LIST RESPONSE",spinnerst.size()+"");
                listAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("VOLLEY POST","ERROR in post response"+error.getMessage());
                if (pDialog != null) {
                    pDialog.dismiss();
                    pDialog = null;
                }
            }
        });
        requestQueue.add(jsonListObjectRequest);
    }
}
