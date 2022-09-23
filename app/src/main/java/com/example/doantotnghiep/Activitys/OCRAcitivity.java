package com.example.doantotnghiep.Activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.doantotnghiep.Models.StudentsPointsOCR;
import com.example.doantotnghiep.R;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.Element;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.paperdb.Paper;

import static com.example.doantotnghiep.Utils.Url.URL_OCR;

public class OCRAcitivity extends AppCompatActivity {

    private static final String TAG= "OCRActivity";
    private EditText ETMASVOCR;
    private EditText ETMALOPOCR;
    private EditText ETDIEMOCR;
    private ImageView IMGPREVIEW;

    String encodeImageString;


    Bitmap bitmap;

    private Button BTNOCR;

    private static final int IMAGE_PICK_GALLERY_CODE = 1000;
    private static final int IMAGE_PICK_CAMERA_CODE = 1001;

    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocracitivity);
        getSupportActionBar().setTitle("OCR");

        ActionBar actionBar =getSupportActionBar();


        actionBar.setSubtitle("Click+ button to insert image");
     //   Paper.init(getApplicationContext());


        ETMASVOCR = findViewById(R.id.et_masvocr);
        ETMALOPOCR =findViewById(R.id.et_malopocr);
        ETDIEMOCR=findViewById(R.id.et_diemgk);
        IMGPREVIEW=findViewById(R.id.iv_anh_chupocr);

        BTNOCR=findViewById(R.id.buttonocr);

        BTNOCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDataOCR();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainocr, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.add_image) {
            showImageImportDialog();
        }



        return super.onOptionsItemSelected(item);
    }

    private void showImageImportDialog() {
        String[] items = {" Camera", " Gallery"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Select Image");
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    pickCamera();
                }

                if (which == 1) {
                    pickGallery();
                }
            }
        });
        dialog.create().show();
    }

    private void pickGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE);


    }

    private void pickCamera() {
        //intent to take image from camera, it will also be save to storage to get high quality image
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "NewPic"); //title of picture
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image to text"); //description
        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, IMAGE_PICK_CAMERA_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
                if (requestCode == IMAGE_PICK_GALLERY_CODE) {
                    CropImage.activity(data.getData())
                            .setGuidelines(CropImageView.Guidelines.ON) //enable image guidelines
                            .start(this);
                }
                if (requestCode == IMAGE_PICK_CAMERA_CODE) {
                    CropImage.activity(imageUri)
                            .setGuidelines(CropImageView.Guidelines.ON) //enable image guidelines
                            .start(this);
                }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();


                IMGPREVIEW.setImageURI(resultUri);



               // Log.d("resultUri",resultUri.toString());



               // Log.d("ImageView", String.valueOf(resultUri));

                BitmapDrawable bitmapDrawable = (BitmapDrawable) IMGPREVIEW.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();


                Log.d("bitmap", String.valueOf(bitmap));

//                Uri filepath=data.getData();
//                try{
//
//                    InputStream inputStream=getContentResolver().openInputStream(resultUri);
//                    bitmap= BitmapFactory.decodeStream(inputStream);
//                    IMGPREVIEW.setImageBitmap(bitmap);
//                    encodeBitmapImage(bitmap);
//
//                    Log.d("hienthianh",bitmap.toString());
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                super.onActivityResult(requestCode, resultCode, data);

                TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();

                if (!textRecognizer.isOperational()) {
                    Toast.makeText(OCRAcitivity.this, "Error", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onActivityResult: error isOperational");
                } else {
                    // lay anh trong hinh
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                    SparseArray<TextBlock> items = textRecognizer.detect(frame);
                    // tra ve json {0=com.google.android.gms.vision.text.TextBlock@22a3156e}    i=items
                    Log.d(TAG, "onActivityResult: i " + items);
                    Log.d(TAG, "onActivityResult: it: " + items.size());
                    Log.d(TAG, "onActivityResult: items: " + items.toString());
                    List<String> strings = new ArrayList<>();
                    Log.d(TAG, "onActivityResult: strings " + strings.size());
                    List<String> list = new ArrayList<>();

                    //StringBuilder sb = new StringBuilder();    i=0;i<1;i++
                    for (int i = 0; i < items.size(); i++) {
                        TextBlock item = items.valueAt(i);
                        List<Line> lines = (List<Line>) item.getComponents();
                        //List<Line> lines=(List<Line>)item.get(i).getComponents();
                        Log.d(TAG, "onActivityResult: lines size: " + lines.size());
//                        for (Line line : lines) {
                        for (int j = 0; j < lines.size(); j++) {
                            Log.d(TAG, "onActivityResult: line value: " + lines.get(j).getValue());


                           list.add(lines.get(j).getValue());
                            List<Element> elements = (List<Element>) lines.get(j).getComponents();
                            for (Element element : elements) {
                                String word = element.getValue();
                                Log.d(TAG, "onActivityResult: word: " + word);
                                strings.add(word);
                            }
                        }
                       /* TextBlock myItem = items.valueAt(i);
                        sb.append(myItem.getValue());*/
//                        sb.append("\n");
                    }
                    Log.d(TAG, "onActivityResult: list size: " + list.size());
                    String[] sv = new String[10];
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            Log.d(TAG, "onActivityResult: s:" + list.get(i).split("\\:")[1]);
                            sv[i] = list.get(i).split("\\:")[1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                            Log.e(TAG, "ArrayIndexOutOfBoundsException: " + e.getMessage());
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(TAG, "Exception: " + e.getMessage());
                        }
                    }

                    StudentsPointsOCR sinhVien = new StudentsPointsOCR(sv[0], sv[1], sv[2]);
                    Log.d(TAG, "onActivityResult: sv: " + sinhVien.toString());
//                    etHoTen.setText(sinhVien.getHoTen());
//                    etLop.setText(sinhVien.getLop());
//                    etMSV.setText(sinhVien.getMsv());
//                    etMonHoc.setText(sinhVien.getMonHoc());
//                    etDiem.setText(sinhVien.getDiem());
                    ///////////////////////
                    Log.d(TAG,"onActivityResult gethoten "+ sinhVien.getSv_idocr());
                    Log.d(TAG,"onActivityResult getlop "+ sinhVien.getLop_idocr());
                    Log.d(TAG,"onActivityResult getdiem "+ sinhVien.getDiem_gk());




                    ETMASVOCR.setText(sinhVien.getSv_idocr());
                    ETMALOPOCR.setText(sinhVien.getLop_idocr());
                    ETDIEMOCR.setText(sinhVien.getDiem_gk());




                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                //error
                Log.e(TAG, "onActivityResult: error");
            }
        }
    }

//    private void encodeBitmapImage(Bitmap bitmap)
//    {
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
//        encodeImageString=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
//    }


    private void insertDataOCR() {// cai nay la insert data ma

        final String masvocr = ETMASVOCR.getText().toString();
        final String  malopocr =ETMALOPOCR.getText().toString().trim();
        final String diem_gk =ETDIEMOCR.getText().toString();
     //   if ( Paper.book().read(masvocr) == null )

        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");

            progressDialog.show();

            //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.193/testocr/insert.php",
            //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.193/ocrthem/insert.php",
            //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.193/diem_sinhvien/insert2.php",
            //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.193/OCRCUUT/insert.php",


            StringRequest request = new StringRequest(Request.Method.POST, URL_OCR,

                    //StringRequest request = new StringRequest(Request.Method.POST, "http://172.20.10.9/appocrchuan/insert.php",

                    //StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.1.193/diemstring/insert.php",

                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {



                            // if(("Updated").equals(response.toString())){





//                        if(response.equals("banthemthanhcong")){
//                            Toast.makeText(OCRAcitivity.this, "Update", Toast.LENGTH_SHORT).show();
//                            progressDialog.dismiss();
//                        }
//                        else {
//                            // Toast.makeText(MainActivity.this, "Loi roi", Toast.LENGTH_SHORT).show();
//
//                            Toast.makeText(getApplicationContext(),"Loi Roi",Toast.LENGTH_SHORT).show();
//
//                            progressDialog.dismiss();
//                        }
                            Log.d("hieu", response+"................");


                            if(response.contains("banthemthanhcong")){
                                Toast.makeText(OCRAcitivity.this, " You have successfully updated", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else{
                                Toast.makeText(OCRAcitivity.this, "You have updated the error or you have updated it once", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }











                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(OCRAcitivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();

                    // params.put("TenSV",tensv);
                    // params.put("MaLop",malop);
                    // params.put("MaSV",masv);
                    // params.put("TenMon",tenmon);
                    //    params.put("Diem",diem);

                    params.put("diem_gk",diem_gk);
                    params.put("lop_id",malopocr);
                    params.put("sv_id",masvocr);







                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(OCRAcitivity.this);
            requestQueue.add(request);
            //Paper.book().write(masvocr,1);
        }


//        else {
//            Toast.makeText(getApplicationContext(),"Ban da het luot up", Toast.LENGTH_LONG).show();
//        }




    }





}
