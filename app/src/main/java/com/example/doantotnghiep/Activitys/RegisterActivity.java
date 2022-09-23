package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import static com.example.doantotnghiep.Utils.Url.URL_REG;

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText userId, userName, email,password,mobile;
    RadioGroup radioGroup;
    Button register;
    CheckBox accessOne, accessTwo;
    String abc, def;
    SharedPreferences sharedPreferences1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Registration Form");
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        sharedPreferences1 =getSharedPreferences("UserInfo1", Context.MODE_PRIVATE);

        final String loginStatus1= sharedPreferences1.getString(getResources().getString(R.string.prefLoginState),"");

        userId =findViewById(R.id.emp_Id);
        userName =findViewById(R.id.username);
        email =findViewById(R.id.email);
        password=findViewById(R.id.password);
        mobile=findViewById(R.id.mobile);
        radioGroup=findViewById(R.id.radiogp);
        accessOne=findViewById(R.id.accessOne);
        accessTwo=findViewById(R.id.accessTwo);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUserId = userId.getText().toString();
                String txtUserName = userName.getText().toString();
                String txtEmail = email.getText().toString();
                String txtPassword =password.getText().toString();
                String txtMobile =mobile.getText().toString();

                if(TextUtils.isEmpty(txtUserId)||TextUtils.isEmpty(txtUserName)||TextUtils.isEmpty(txtEmail)
                        ||TextUtils.isEmpty(txtPassword)||TextUtils.isEmpty(txtMobile)){
                    Toast.makeText(RegisterActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }else{
                    int genderId =radioGroup.getCheckedRadioButtonId();
                    RadioButton selected_Gender =radioGroup.findViewById(genderId);
                    if(selected_Gender==null){
                        Toast.makeText(RegisterActivity.this, "Select gender Please", Toast.LENGTH_SHORT).show();
                    }else{
                        if(!isConnected(RegisterActivity.this)) buildDialog(RegisterActivity.this).show();
                        else{
                            String selectGender = selected_Gender.getText().toString();
                            registerNewAcount(txtUserId,txtUserName,txtEmail,txtPassword,txtMobile,selectGender);
                            closeKeyboard();
                        }
                    }
                }
            }


            // 96,visaotheem,tenlagi@gmail.com,linhnhi12,01222333,Male

            private void registerNewAcount(final String txtUserId, final String txtUserName, final String txtEmail, final String txtPassword, final String txtMobile, final String selectGender) {
                final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.setCancelable(true);
                progressDialog.setIndeterminate(false);
                progressDialog.setTitle("Registering New Account");
                progressDialog.show();



                String uRI ="http://192.168.1.193/studentpoint/business-register.php";

               //String uRI ="http://192.168.1.193/DOANTOTNGHIEPNEWS/business-register.php";



                StringRequest request = new StringRequest(Request.Method.POST, URL_REG, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("Successfully Registered")) {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();

                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> param = new HashMap<>();
                        if(accessOne.isChecked()){
                            abc="Yes1";
                        }else{
                            abc="No1";
                        }
                        if(accessTwo.isChecked()){
                            def ="Yes2";
                        }else{
                            def ="No2";
                        }


                        param.put("txtRegisterBy", loginStatus1);
                        param.put("txtUserId", txtUserId);
                        param.put("txtUserName", txtUserName);
                        param.put("txtEmail", txtEmail);
                        param.put("txtPassword", txtPassword);
                        param.put("txtMobile", txtMobile);
                        param.put("selectGender", selectGender);
                        param.put("txtStatus1", abc);
                        param.put("txtStatus2", def);
                        return param;


                    }
                };

                request.setRetryPolicy(new DefaultRetryPolicy(300000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                MySingleton.getInstance(RegisterActivity.this).addToRequestQueue(request);

            }


        });
    }



    private boolean isConnected(RegisterActivity context) {
        ConnectivityManager cm =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert  cm!=null;
        NetworkInfo netinfo= cm.getActiveNetworkInfo();

        if(netinfo!=null && netinfo.isConnectedOrConnecting()){
            android.net.NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if(mobile!=null && mobile.isConnectedOrConnecting() || (wifi!=null && wifi.isConnectedOrConnecting())) return true;
            else return false;

        } else
            return false;
    }



    public androidx.appcompat.app.AlertDialog.Builder buildDialog (RegisterActivity c){
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

    private void closeKeyboard(){
        View view =this.getCurrentFocus();
        if(view !=null){
            InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
