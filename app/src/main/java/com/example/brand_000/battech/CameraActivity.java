package com.example.brand_000.battech;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraActivity extends AppCompatActivity {
    Button cam,save;
    ImageView img;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        cam = (Button) findViewById(R.id.button);
        save = (Button) findViewById(R.id.save);
        img = (ImageView) findViewById(R.id.imageView);

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

                if(isSDPresent != true)
                {
                    Toast.makeText(CameraActivity.this,"NO SD CARD",Toast.LENGTH_LONG).show();

                }
                else {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //File picDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                    //String picName = getPicName();
                    //File imgFile = new File(picDir, picName);
                    //Uri picUri = Uri.fromFile(imgFile);
                    //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, picUri);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }

                }

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CameraActivity.this,"SAVED!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getPicName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "PIC" + timestamp + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(requestCode == REQUEST_IMAGE_CAPTURE) {
                 Bitmap camimg = (Bitmap) data.getExtras().get("data");
                 img.setImageBitmap(camimg);
            }
        }
    }
}



