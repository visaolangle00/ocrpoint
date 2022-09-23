package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.http.Url;

import static com.example.doantotnghiep.Utils.Url.URL_ADD;
import static com.example.doantotnghiep.Utils.Url.URL_SELLOPID;
import static com.example.doantotnghiep.Utils.Url.URL_SELSVID;

public class AddCrudActivity extends AppCompatActivity {

  // String url= "http://192.168.1.193/studentpoint/insert_diem.php";
   TextView Diem_Gk, sv_idad, lop_idad;
   Button Them, Huy;

   TextView edtsvidad;

  // TextView edtlopidad;

   List<String>cityList=  new ArrayList<String>();
    List<String>cityList1=  new ArrayList<String>();


    String url= "http://192.168.1.193/studentpoint/selectsv_id.php";


    String url1= "http://192.168.1.193/studentpoint/selectsv_lopid.php";


   public static String citySelected;

   public static String citySelected1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crud);

        getSupportActionBar().setTitle("Add Points");

        spinnersvid();

        spinnerlopid();



//        final RequestQueue requestQueue= Volley.newRequestQueue(this);
//
//        Spinner spinner =(Spinner)findViewById(R.id.spinnertext1);
//        final ArrayAdapter spinnerAdapter =new ArrayAdapter(this,R.layout.dropdown_item,cityList);
//        spinner.setAdapter(spinnerAdapter);
//
//        edtsvidad=findViewById(R.id.edtsvidad);

//       try{
//           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//               @Override
//               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                   String citySelected = parent.getItemAtPosition(position).toString();
//
//                   Toast.makeText(AddCrudActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();
//
//                   edtsvidad.setText(citySelected);
//
//               }
//
//               @Override
//               public void onNothingSelected(AdapterView<?> parent) {
//
//               }
//           }
//
//
//           );
//       }
//       catch(Exception e){
//           Log.e("spinner",e.getMessage());}
//
//
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//               // arrayList.clear();
//                for (int i = 0; i<response.length(); i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        cityList.add(object.getString("sv_id"));
//                    }catch (JSONException e){
//                        e.printStackTrace();
//                    }
//                }
//             //   adapter.notifyDataSetChanged();
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(AddCrudActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        requestQueue.add(jsonArrayRequest);

//        try{spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//                                                  @Override
//                                                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                                                      //populateList(parent.getItemAtPosition(position).toString(),requestQueue);
//                                                      String citySelected = parent.getItemAtPosition(position).toString();
//                                                      //    Toast.makeText("", "City : " + citySelected, Toast.LENGTH_LONG).show();
//                                                      //   Toast.makeText(MainActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();
//
//                                                      edtsvidad.setText(citySelected);
//
//
//
//
//                                                  }
//
//                                                  @Override
//                                                  public void onNothingSelected(AdapterView<?> parent) {
//
//                                                  }
//                                              }
//
//
//        );}
//        catch(Exception e){
//            Log.e("spinner",e.getMessage());}
//
//
//
//        JsonObjectRequest jsonSpinnerObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//
//                    JSONArray jsonArray = response.getJSONArray("lophocphan");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject city = jsonArray.getJSONObject(i);
//
//                        cityList.add(city.getString("sv_id"));
//
//
//                        //cityList.add(new City(city.getInt("cid"),city.getString("cname")));
//
//                 //       Toast.makeText(AddCrudActivity.this, "", Toast.LENGTH_SHORT).show();
//                    }
//                    spinnerAdapter.notifyDataSetChanged();
//
//                }catch(JSONException jex)
//                {
//                    jex.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                Log.e("VOLLEY","ERROR in response"+error.getMessage());
//            }
//        });
//        requestQueue.add(jsonSpinnerObjectRequest);


//        private void spinnersvid() {
//            final RequestQueue requestQueue= Volley.newRequestQueue(this);
//
//            Spinner spinner =(Spinner)findViewById(R.id.spinnertext1);
//            final ArrayAdapter spinnerAdapter =new ArrayAdapter(this,R.layout.dropdown_item,cityList);
//            spinner.setAdapter(spinnerAdapter);
//
//            edtsvidad=findViewById(R.id.edtsvidad);

//       try{
//           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//               @Override
//               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                   String citySelected = parent.getItemAtPosition(position).toString();
//
//                   Toast.makeText(AddCrudActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();
//
//                   edtsvidad.setText(citySelected);
//
//               }
//
//               @Override
//               public void onNothingSelected(AdapterView<?> parent) {
//
//               }
//           }
//
//
//           );
//       }
//       catch(Exception e){
//           Log.e("spinner",e.getMessage());}
//
//
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//               // arrayList.clear();
//                for (int i = 0; i<response.length(); i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        cityList.add(object.getString("sv_id"));
//                    }catch (JSONException e){
//                        e.printStackTrace();
//                    }
//                }
//             //   adapter.notifyDataSetChanged();
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(AddCrudActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        requestQueue.add(jsonArrayRequest);

//            try{spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//                                                      @Override
//                                                      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                                                          //populateList(parent.getItemAtPosition(position).toString(),requestQueue);
//                                                          String citySelected = parent.getItemAtPosition(position).toString();
//                                                          //    Toast.makeText("", "City : " + citySelected, Toast.LENGTH_LONG).show();
//                                                          //   Toast.makeText(MainActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();
//
//                                                          edtsvidad.setText(citySelected);
//
//
//
//
//                                                      }
//
//                                                      @Override
//                                                      public void onNothingSelected(AdapterView<?> parent) {
//
//                                                      }
//                                                  }
//
//
//            );}
//            catch(Exception e){
//                Log.e("spinner",e.getMessage());}
//
//
//
//            JsonObjectRequest jsonSpinnerObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
//                    try {
//
//                        JSONArray jsonArray = response.getJSONArray("lophocphan");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject city = jsonArray.getJSONObject(i);
//
//                            cityList.add(city.getString("sv_id"));
//
//
//                            //cityList.add(new City(city.getInt("cid"),city.getString("cname")));
//
//                            //       Toast.makeText(AddCrudActivity.this, "", Toast.LENGTH_SHORT).show();
//                        }
//                        spinnerAdapter.notifyDataSetChanged();
//
//                    }catch(JSONException jex)
//                    {
//                        jex.printStackTrace();
//                    }
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                    Log.e("VOLLEY","ERROR in response"+error.getMessage());
//                }
//            });
//            requestQueue.add(jsonSpinnerObjectRequest);
//        }








        anhxa();

        final EditText editText =findViewById(R.id.edtDiemad);
        editText.setFilters(new InputFilter[]{new MinMaxFilter("0","10")});

        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diem010=Diem_Gk.getText().toString();
                if(TextUtils.isEmpty(diem010)){
                    Toast.makeText(AddCrudActivity.this,"All field requied",Toast.LENGTH_SHORT).show();
                }else{
                    ThemSinhVien(URL_ADD);
                }
            }
        });




        /*
        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemSinhVien(url);
            }
        });

         */




        Huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void ThemSinhVien(String URL_ADD) {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_ADD, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                if(response.trim().equals("dacodiemroinhe")){
//                    Toast.makeText(AddCrudActivity.this, "dacodiemroinhe", Toast.LENGTH_SHORT).show();
//                   // startActivity(new Intent(AddCrudActivity.this, MainActivity.class));
//                }else {
//                    if(response.trim().equals("insertthanhcong")){
//                        Toast.makeText(AddCrudActivity.this, "insertthanhcong", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(AddCrudActivity.this, "insertsai", Toast.LENGTH_SHORT).show();
//                    }
//
//                }

                if(response.trim().equals("dacodiemroinhe")){
                    Toast.makeText(AddCrudActivity.this, "Data already available", Toast.LENGTH_SHORT).show();
                }else{
                    if(response.trim().equals("insertthanhcong")){
                        Toast.makeText(AddCrudActivity.this, " Insert successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AddCrudActivity.this, "Insert Wrong", Toast.LENGTH_SHORT).show();
                    }
                }





            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Xảy ra lỗi
                        Toast.makeText(AddCrudActivity.this, " An error occurred", Toast.LENGTH_SHORT).show();
                        Log.d("AAA", "Err!\n" + error.toString());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();



                param.put("diem_gk",Diem_Gk.getText().toString().trim());
              //  param.put("sv_id", sv_idad.getText().toString().trim());


                param.put("sv_id", citySelected.toString().trim());
           //     param.put("lop_id", lop_idad.getText().toString().trim());

                param.put("lop_id", citySelected1.toString().trim());



                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void anhxa(){
        Diem_Gk=(EditText)findViewById(R.id.edtDiemad);
     //   sv_idad=(TextView)findViewById(R.id.edtsvidad);
      //  lop_idad=(TextView)findViewById(R.id.edtlopidad);
        Them = (Button) findViewById(R.id.btnadd);
        Huy = (Button) findViewById(R.id.btncancel);

    }


    public  void spinnersvid() {
        final RequestQueue requestQueue= Volley.newRequestQueue(this);

        Spinner spinner =(Spinner)findViewById(R.id.spinnertext1);
        final ArrayAdapter spinnerAdapter =new ArrayAdapter(this,R.layout.dropdown_item,cityList);
        spinner.setAdapter(spinnerAdapter);

        //edtsvidad=findViewById(R.id.edtsvidad);

//       try{
//           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//               @Override
//               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                   String citySelected = parent.getItemAtPosition(position).toString();
//
//                   Toast.makeText(AddCrudActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();
//
//                   edtsvidad.setText(citySelected);
//
//               }
//
//               @Override
//               public void onNothingSelected(AdapterView<?> parent) {
//
//               }
//           }
//
//
//           );
//       }
//       catch(Exception e){
//           Log.e("spinner",e.getMessage());}
//
//
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//               // arrayList.clear();
//                for (int i = 0; i<response.length(); i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        cityList.add(object.getString("sv_id"));
//                    }catch (JSONException e){
//                        e.printStackTrace();
//                    }
//                }
//             //   adapter.notifyDataSetChanged();
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(AddCrudActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        requestQueue.add(jsonArrayRequest);

        try{spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                                  @Override
                                                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                      //populateList(parent.getItemAtPosition(position).toString(),requestQueue);
                                               // String citySelected = parent.getItemAtPosition(position).toString();

                                                 citySelected=parent.getItemAtPosition(position).toString();


                                                      //    Toast.makeText("", "City : " + citySelected, Toast.LENGTH_LONG).show();
                                                      //   Toast.makeText(MainActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();

                                           //           edtsvidad.setText(citySelected);




                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {

                                                  }
                                              }


        );}
        catch(Exception e){
            Log.e("spinner",e.getMessage());}



        JsonObjectRequest jsonSpinnerObjectRequest=new JsonObjectRequest(Request.Method.GET,URL_SELSVID,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("lophocphan");
                    Set<String> setA= new HashSet<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject city = jsonArray.getJSONObject(i);
                        setA.add(city.getString("sv_id"));



                        //cityList.add(city.getString("sv_id"));


                        //cityList.add(new City(city.getInt("cid"),city.getString("cname")));

                        //       Toast.makeText(AddCrudActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                    cityList.addAll(setA);

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
    }

    private void spinnerlopid() {
        final RequestQueue requestQueue= Volley.newRequestQueue(this);

        Spinner spinner1 =(Spinner)findViewById(R.id.spinnertext2);
        final ArrayAdapter spinnerAdapter =new ArrayAdapter(this,R.layout.dropdown_item,cityList1);
        spinner1.setAdapter(spinnerAdapter);

      //  edtlopidad=findViewById(R.id.edtlopidad);

//       try{
//           spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//               @Override
//               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                   String citySelected = parent.getItemAtPosition(position).toString();
//
//                   Toast.makeText(AddCrudActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();
//
//                   edtsvidad.setText(citySelected);
//
//               }
//
//               @Override
//               public void onNothingSelected(AdapterView<?> parent) {
//
//               }
//           }
//
//
//           );
//       }
//       catch(Exception e){
//           Log.e("spinner",e.getMessage());}
//
//
//
//
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//               // arrayList.clear();
//                for (int i = 0; i<response.length(); i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        cityList.add(object.getString("sv_id"));
//                    }catch (JSONException e){
//                        e.printStackTrace();
//                    }
//                }
//             //   adapter.notifyDataSetChanged();
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(AddCrudActivity.this, "FALSE", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        requestQueue.add(jsonArrayRequest);

        try{spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                                  @Override
                                                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                      //populateList(parent.getItemAtPosition(position).toString(),requestQueue);
                                                      citySelected1= parent.getItemAtPosition(position).toString();
                                                      //    Toast.makeText("", "City : " + citySelected, Toast.LENGTH_LONG).show();
                                                      //   Toast.makeText(MainActivity.this, ""+citySelected, Toast.LENGTH_SHORT).show();

                                                  //    edtlopidad.setText(citySelected1);




                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {

                                                  }
                                              }


        );}
        catch(Exception e){
            Log.e("spinner",e.getMessage());}



        JsonObjectRequest jsonSpinnerObjectRequest=new JsonObjectRequest(Request.Method.GET,URL_SELLOPID,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {



                    JSONArray jsonArray = response.getJSONArray("lophocphan");
                    Set<String> setB= new HashSet<>();
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject city1 = jsonArray.getJSONObject(i);

                      //  cityList1.add(city.getString("lop_id"));

                        setB.add(city1.getString("lop_id"));




                        //cityList.add(new City(city.getInt("cid"),city.getString("cname")));

                        //       Toast.makeText(AddCrudActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                    cityList1.addAll(setB);
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
    }






}
