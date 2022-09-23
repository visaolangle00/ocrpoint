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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

import static com.example.doantotnghiep.Utils.Url.URL_EDITPROFILE;

public class EditProfileActivity extends AppCompatActivity {

    MaterialEditText oldPassword,newPassword;
    Button updatePassword;
    SharedPreferences sharedPreferences,sharedPreferences1,sharedPreferences2,sharedPreferences5,sharedPreferences6;
    TextView profileName, profileEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getSupportActionBar().setTitle("Update Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        oldPassword =findViewById(R.id.profile_old_password);
        newPassword =findViewById(R.id.profile_new_password);

        sharedPreferences =getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        sharedPreferences1 =getSharedPreferences("UserInfo1", Context.MODE_PRIVATE);
        sharedPreferences2 =getSharedPreferences("UserInfo2", Context.MODE_PRIVATE);
        sharedPreferences5 =getSharedPreferences("UserInfo5", Context.MODE_PRIVATE);
        sharedPreferences6 =getSharedPreferences("UserInfo6", Context.MODE_PRIVATE);

        final String loginStatus= sharedPreferences.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus1= sharedPreferences1.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus2= sharedPreferences2.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus5= sharedPreferences5.getString(getResources().getString(R.string.prefLoginState),"");
        final String loginStatus6= sharedPreferences6.getString(getResources().getString(R.string.prefLoginState),"");

        profileName =findViewById(R.id.profile_name);
        profileName.setText(loginStatus5);

        profileEmail =findViewById(R.id.profile_email);
        profileEmail.setText(loginStatus2);

        updatePassword=findViewById(R.id.update);


        updatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtOld = oldPassword.getText().toString();
                String txtNew = newPassword.getText().toString();
                if(TextUtils.isEmpty(txtOld)||TextUtils.isEmpty(txtNew)){
                    Toast.makeText(EditProfileActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }else{
                    if(txtOld.equals(txtNew)){
                        Toast.makeText(EditProfileActivity.this, "You already on this password", Toast.LENGTH_SHORT).show();
                    }else{
                        if(txtOld.equals(loginStatus6)) {
                            if (!isConnected(EditProfileActivity.this))  buildDialog(EditProfileActivity.this).show();
                            else {
                                password(txtOld, txtNew, loginStatus1);
                                closeKeyboard();
                            }
                        }
                        else{
                            Toast.makeText(EditProfileActivity.this, "Old Password not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }

    private void password(final String txtOld, final String txtNew, final String loginStatus1) {
        final ProgressDialog progressDialog =new ProgressDialog(EditProfileActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Updating...");
        progressDialog.show();

        //String uRl="http://192.168.1.193/studentpoint/business-pword.php";


       // String uRl="http://192.168.1.193/DOANTOTNGHIEP/business-pword.php";

        final StringRequest request =new StringRequest(Request.Method.POST, URL_EDITPROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Editable", "replace: " + response);
                if (response.equals("PasswordChanged")) {
                    progressDialog.dismiss();

                    final SharedPreferences sharedPreferences6 = getSharedPreferences("UserInfo6", MODE_PRIVATE);
                    SharedPreferences.Editor editor6 = sharedPreferences6.edit();
                    editor6.putString(getResources().getString(R.string.prefLoginState), txtNew);
                    editor6.apply();
                    Toast.makeText(EditProfileActivity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditProfileActivity.this, EditProfileActivity.class));
                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(EditProfileActivity.this, response, Toast.LENGTH_SHORT).show();
                }


//                 C2
//                if (response.equals("Oldpasswordnotmatch")) {
//
//                    progressDialog.dismiss();
//                    Toast.makeText(EditProfile.this, response, Toast.LENGTH_SHORT).show();
//
//
//
//
//                }
//                else {
//                    progressDialog.dismiss();
//
//                    final SharedPreferences sharedPreferences6 = getSharedPreferences("UserInfo6", MODE_PRIVATE);
//                    SharedPreferences.Editor editor6 = sharedPreferences6.edit();
//                    editor6.putString(getResources().getString(R.string.prefLoginState), txtNew);
//                    editor6.apply();
//                    Toast.makeText(EditProfile.this, "Password Updated", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(EditProfile.this, EditProfile.class));
//                }










            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(EditProfileActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        )
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param =new HashMap<>();
                param.put("old_pword",txtOld);
                param.put("new_pword",txtNew);
                param.put("empid",loginStatus1);
                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(300000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(EditProfileActivity.this).addToRequestQueue(request);

    }

    private boolean isConnected(EditProfileActivity context) {
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

    public androidx.appcompat.app.AlertDialog.Builder buildDialog (EditProfileActivity c){
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
