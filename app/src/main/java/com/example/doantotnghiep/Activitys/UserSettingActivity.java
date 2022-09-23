package com.example.doantotnghiep.Activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.doantotnghiep.Models.MySingleton;
import com.example.doantotnghiep.R;
import com.google.android.material.navigation.NavigationView;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_USERSETTING;

public class UserSettingActivity extends AppCompatActivity {

    MaterialEditText userName,userEmail,userNumber;
    TextView userId;
    Button updateInfo;
    SharedPreferences sharedPreferences,sharedPreferences1,sharedPreferences2,sharedPreferences5,sharedPreferences7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        NavigationView navigationView =(NavigationView)findViewById(R.id.navigation_view);
       // navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setTitle("Update Info");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences =getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        sharedPreferences1 =getSharedPreferences("UserInfo1", Context.MODE_PRIVATE);
        sharedPreferences2 =getSharedPreferences("UserInfo2", Context.MODE_PRIVATE);
        sharedPreferences5 =getSharedPreferences("UserInfo5", Context.MODE_PRIVATE);
        sharedPreferences7 =getSharedPreferences("UserInfo7", Context.MODE_PRIVATE);

        final String loginStatus= sharedPreferences.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus1= sharedPreferences1.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus2= sharedPreferences2.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus5= sharedPreferences5.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus7= sharedPreferences7.getString(getResources().getString(R.string.prefLoginState),"");

        userId=findViewById(R.id.user_id);
        userId.setText(loginStatus1);

        userName =findViewById(R.id.user_name);
       userName.setText(loginStatus5);

        userEmail =findViewById(R.id.user_email);
        userEmail.setText(loginStatus2);

        userNumber=findViewById(R.id.user_number);
       userNumber.setText(loginStatus7);

        updateInfo =findViewById(R.id.update_info);
        updateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtName = userName.getText().toString();
                String txtEmail = userEmail.getText().toString();
                String txtNumber =userNumber.getText().toString();

                if(TextUtils.isEmpty(txtName)||TextUtils.isEmpty(txtEmail)){
                    Toast.makeText(UserSettingActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }else{
                    if(!isConnected(UserSettingActivity.this)) buildDialog(UserSettingActivity.this).show();
                    else{
                        userinfo(txtName,txtEmail,txtNumber,loginStatus1);
                    }
                }
            }
        });

//        View hView = navigationView.getHeaderView(0);
//        TextView user_email=(TextView)hView.findViewById(R.id.user_email);
//        TextView user_id=(TextView)hView.findViewById(R.id.user_id);
//        TextView user_name=(TextView)hView.findViewById(R.id.user_name);
//
//        user_id.setText(loginStatus7);
//        user_name.setText(loginStatus5);
//        user_email.setText(loginStatus2);






    }
// day la ham update nha chua co ham get ve

    private void userinfo(final String txtName, final String txtEmail, final String txtNumber, final String loginStatus1) {
        final ProgressDialog progressDialog =new ProgressDialog(UserSettingActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Updating...");
        progressDialog.show();

        String uRl="http://192.168.1.193/studentpoint/business-info.php";

        //String uRl="http://192.168.1.193//DOANTOTNGHIEP/business-info.php";


        StringRequest request = new StringRequest(Request.Method.POST, URL_USERSETTING, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Information Update")) {
                    progressDialog.dismiss();

                    final SharedPreferences sharedPreferences2 = getSharedPreferences("UserInfo2", MODE_PRIVATE);
                    final SharedPreferences sharedPreferences5 = getSharedPreferences("UserInfo5", MODE_PRIVATE);
                    final SharedPreferences sharedPreferences7 = getSharedPreferences("UserInfo7", MODE_PRIVATE);

                    SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                    SharedPreferences.Editor editor5 = sharedPreferences5.edit();
                    SharedPreferences.Editor editor7 = sharedPreferences7.edit();






                    //C2


//
//                    String gv_email= sharedPreferences2.getString(getResources().getString(R.string.prefLoginState),"");
//
//                    String gv_emailspace=gv_email.replaceAll("\\s", "");
//
//                    userEmail.setText(gv_emailspace);
//
//
//                    String gv_tentaikhoan= sharedPreferences5.getString(getResources().getString(R.string.prefLoginState),"");
//
//                    String gv_tentaikhoanspace =gv_tentaikhoan.replaceAll("\\s", "");
//
//                    userName.setText(gv_tentaikhoanspace);
//
//                    String gv_id2= sharedPreferences7.getString(getResources().getString(R.string.prefLoginState),"");
//
//                    String gv_idspace=gv_id2.replaceAll("\\s", "");
//
//                    userEmail.setText(gv_idspace);





                   editor2.putString(getResources().getString(R.string.prefLoginState), txtEmail);

                    Log.d("email", String.valueOf(editor2.putString(getResources().getString(R.string.prefLoginState), txtEmail)));
                    //Log.d("email",txtEmail);
                    editor5.putString(getResources().getString(R.string.prefLoginState), txtName);
                    Log.d("name",txtName);
                  editor7.putString(getResources().getString(R.string.prefLoginState), txtNumber);
                    Log.d("number",txtNumber);
                   editor2.apply();
                   editor5.apply();
                   editor7.apply();

                    Toast.makeText(UserSettingActivity.this, "Information Update", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UserSettingActivity.this, UserSettingActivity.class));
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(UserSettingActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(UserSettingActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("user_name",txtName);
                param.put("user_email",txtEmail);
                param.put("user_number",txtNumber);
                param.put("empid",loginStatus1);

                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(300000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(UserSettingActivity.this).addToRequestQueue(request);

    }


    private boolean isConnected(UserSettingActivity context) {
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

    public androidx.appcompat.app.AlertDialog.Builder buildDialog (UserSettingActivity c){
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
