package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.doantotnghiep.Models.MySingleton;
import com.example.doantotnghiep.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;

import static com.example.doantotnghiep.Utils.Url.URL_LOGIN;

public class LoginPageActivity extends AppCompatActivity {

    Button login;
    CheckBox loginState;
    SharedPreferences sharedPreferences,sharedPreferences1,sharedPreferences2,sharedPreferences3,sharedPreferences4,sharedPreferences5,sharedPreferences6,sharedPreferences7,sharedPreferences8;

    MaterialEditText email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Paper.init(getApplicationContext());

        getSupportActionBar().setTitle("Login Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        sharedPreferences =getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        sharedPreferences1 =getSharedPreferences("UserInfo1", Context.MODE_PRIVATE);
        sharedPreferences2 =getSharedPreferences("UserInfo2", Context.MODE_PRIVATE);
        sharedPreferences3 =getSharedPreferences("UserInfo3", Context.MODE_PRIVATE);
        sharedPreferences4 =getSharedPreferences("UserInfo4", Context.MODE_PRIVATE);
        sharedPreferences5 =getSharedPreferences("UserInfo5", Context.MODE_PRIVATE);
        sharedPreferences6 =getSharedPreferences("UserInfo6", Context.MODE_PRIVATE);
        sharedPreferences7 =getSharedPreferences("UserInfo7", Context.MODE_PRIVATE);
        sharedPreferences8 =getSharedPreferences("UserInfo8", Context.MODE_PRIVATE);

        email = findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginState =findViewById(R.id.checkbox);


//        if (Paper.book().read("email") != null){
//            email.setText(Paper.book().read("email")+"");
//
//        }
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail= email.getText().toString();
               // Paper.book().write("email",txtEmail);
                String txtPassword=password.getText().toString();
                if(TextUtils.isEmpty(txtEmail)||TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(LoginPageActivity.this, "All field requierd", Toast.LENGTH_SHORT).show();
                }else{
                    if(!isConnected(LoginPageActivity.this)) buildDiaLog(LoginPageActivity.this).show();
                    else{
                        login(txtEmail,txtPassword);
                    }
                }
            }
        });

        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.prefLoginState),"");
        if(loginStatus.equals("loggedin")){
           Intent homeIntent = new Intent(LoginPageActivity.this,ViewSubjectActivity.class);
            startActivity(homeIntent);
            finish();
        }



    }

    private void login(final String txtEmail, final String txtPassword) {
        final ProgressDialog progressDialog = new ProgressDialog(LoginPageActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Logging...");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String response1 = response.replaceAll("nulll", "");

                Log.d("response",response);
                if (response.equals(response1 + "nulll")) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginPageActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();





                    String GV_ID[] = response.split("1vv");
                    String UserId[]=GV_ID[1].split("aaa");






                   // 21vv123aaahuybc52@wru.vnbbbYes1cccYes2dddNguyen Thanheeetesttestfff1232134nulll

                    //GV_ID[0]=2 GV_ID[1]

                    //UserEmail1[0]=21vv123aaahuybc52@wru.vn
                    //21vv123

                    //21vv123aaahuybc52@wru.vnbbbYes1


                    String UserEmail1[]=response.split("bbb");
                    String UserEmail[]=UserEmail1[0].split("aaa");

                    String UserStatus11[]=response.split("ccc");
                    String UserStatus1[]=UserStatus11[0].split("bbb");

                    String UserStatus21[]=response.split("ddd");
                    String UserStatus2[]=UserStatus21[0].split("ccc");

                    String UserName1[]=response.split("eee");
                    String UserName[]=UserName1[0].split("ddd");

                    String UserPword1[]=response.split("fff");
                    String UserPword[]=UserPword1[0].split("eee");

                    String UserNumber1[]=response.split("fff");
                    String UserNumber[]=UserNumber1[1].split("null");

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    SharedPreferences.Editor editor3 = sharedPreferences3.edit();
                    SharedPreferences.Editor editor4 = sharedPreferences4.edit();
                    SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                    SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                    SharedPreferences.Editor editor7 = sharedPreferences7.edit();
                    SharedPreferences.Editor editor8 = sharedPreferences8.edit();

                    if(loginState.isChecked()){
                        editor.putString(getResources().getString(R.string.prefLoginState),"loggedin");
                        editor1.putString(getResources().getString(R.string.prefLoginState),UserId[0]);
                        editor2.putString(getResources().getString(R.string.prefLoginState),UserEmail[1]);
                        editor3.putString(getResources().getString(R.string.prefLoginState),UserStatus1[1]);
                        editor4.putString(getResources().getString(R.string.prefLoginState),UserStatus2[1]);
                        editor5.putString(getResources().getString(R.string.prefLoginState),UserName[1]);
                        editor6.putString(getResources().getString(R.string.prefLoginState),UserPword[1]);
                        editor7.putString(getResources().getString(R.string.prefLoginState),UserNumber[0]);
                        editor8.putString(getResources().getString(R.string.prefLoginState),GV_ID[0]);
                    }
                    else{
                        editor.putString(getResources().getString(R.string.prefLoginState),"loggedout");
                        editor1.putString(getResources().getString(R.string.prefLoginState),UserId[0]);
                        editor2.putString(getResources().getString(R.string.prefLoginState),UserEmail[1]);
                        editor3.putString(getResources().getString(R.string.prefLoginState),UserStatus1[1]);
                        editor4.putString(getResources().getString(R.string.prefLoginState),UserStatus2[1]);
                        editor5.putString(getResources().getString(R.string.prefLoginState),UserName[1]);
                        editor6.putString(getResources().getString(R.string.prefLoginState),UserPword[1]);
                        editor7.putString(getResources().getString(R.string.prefLoginState),UserNumber[0]);
                        editor8.putString(getResources().getString(R.string.prefLoginState),GV_ID[0]);
                    }
                    editor.apply();
                    editor1.apply();
                    editor2.apply();
                    editor3.apply();
                    editor4.apply();
                    editor5.apply();
                    editor6.apply();
                    editor7.apply();
                    editor8.apply();
                    // Intent homeIntent = new Intent(LoginPage.this, Profile.class);

                    Intent homeIntent = new Intent(LoginPageActivity.this, ViewSubjectActivity.class);

                    editor8.putString(getResources().getString(R.string.prefLoginState),GV_ID[0]);

                    startActivity(homeIntent);
                    finish();


                } else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginPageActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(LoginPageActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param=new HashMap<>();
                param.put("email",txtEmail);
                param.put("psw",txtPassword);
                return param;

            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(300000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(LoginPageActivity.this).addToRequestQueue(request);

    }


    private boolean isConnected(LoginPageActivity context) {
        ConnectivityManager cm =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert  cm!=null;
        NetworkInfo netinfo= cm.getActiveNetworkInfo();

        if(netinfo!=null && netinfo.isConnectedOrConnecting()){
            android.net.NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if(mobile!=null && mobile.isConnectedOrConnecting() || (wifi!=null && wifi.isConnectedOrConnecting())) return true;
            else return false;

        }
        return false;
    }

    public androidx.appcompat.app.AlertDialog.Builder buildDiaLog (LoginPageActivity c){
        androidx.appcompat.app.AlertDialog.Builder builder =new androidx.appcompat.app.AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        AlertDialog.Builder ok =builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        return builder;

    }

    public void Forgotpassword(View view) {


        startActivity(new Intent(LoginPageActivity.this,ForgotPasswordActivity.class));
        finish();
    }

}
