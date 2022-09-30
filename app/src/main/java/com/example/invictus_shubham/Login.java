package com.example.invictus_shubham;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button createaccountBtn,LoginBtn;
    EditText user_email,password;
    FirebaseAuth Authenication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Authenication = FirebaseAuth.getInstance();

        createaccountBtn = findViewById(R.id.register_button_new);
        createaccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(getApplicationContext(),Registeration.class);
                startActivity(intent);
            }
        });

         user_email = findViewById(R.id.Login_email);
         password = findViewById(R.id.Login_password);
         LoginBtn = findViewById(R.id.login_button);

         LoginBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // check if user has entered valid credentials

                 if(user_email.getText().toString().isEmpty()){
                     user_email.setError("Enter valid email address!");
                     return;
                 }
                 if(!user_email.getText().toString().contains("ves.ac.in")){
                     user_email.setError("Please VES email address!!");
                     return;
                 }
                 if(password.getText().toString().isEmpty()){
                     password.setError("Please enter valid password!");
                     return;
                 }


                 //check the crendential with firebase
                 
                 Authenication.signInWithEmailAndPassword(user_email.getText().toString(),password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                     @Override
                     public void onSuccess(AuthResult authResult) {

                         startActivity(new Intent(getApplicationContext(),Dashboard.class));

                        //login is successfull!!
                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         Toast.makeText(Login.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                     }
                 });


             }
         });

    }
        // Below code automatically logins in user if he has logged in before.
    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Dashboard.class));
        }
    }
}