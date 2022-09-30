package com.example.invictus_shubham;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class UploadingPhoto extends AppCompatActivity {

    ImageView imageView;
    Button SelectBtn, ProfilePageBtn;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading_photo);

        //VIEWS
        imageView = findViewById(R.id.UploadedImage);
        SelectBtn = findViewById(R.id.SelectImageButton);
        ProfilePageBtn = findViewById(R.id.btnMoveToProfile);

        SelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Checking Runtime Permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //Permission not given. Request for one.
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //Pop-up
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        //Permission has been granted
                        pickImageFromGallery();
                    }
                } else {
                    //System OS is less than Marshmallow
                    pickImageFromGallery();
                }

            }
        });

        ProfilePageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UploadingPhoto.this, ProfilePage.class);
                startActivity(intent);
            }
        });
    }

    void pickImageFromGallery() {
        //Intent to pick up the Image
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    //Permission was granted
                    pickImageFromGallery();
                } else {
                    //Permission was denied
                    Toast.makeText(this, "Permission has been Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            //Set the Image to ImageView
            imageView.setImageURI(data.getData());
        }
    }
}