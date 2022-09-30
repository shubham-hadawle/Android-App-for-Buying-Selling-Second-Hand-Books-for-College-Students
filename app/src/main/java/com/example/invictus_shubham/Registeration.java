package com.example.invictus_shubham;

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

public class Registeration extends AppCompatActivity {
    EditText registerFullname,registerEmailid,registerPassword,registerConpassword;
    Button register_user_new,gotologin;
    FirebaseAuth Authentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        registerFullname = findViewById(R.id.register_Fullname);
        registerEmailid = findViewById(R.id.register_Emailid);
        registerPassword = findViewById(R.id.set_password);
        registerConpassword = findViewById(R.id.set_con_password);
        register_user_new = findViewById(R.id.register_button_new);
        gotologin = findViewById(R.id.go_to_login);

        Authentication = FirebaseAuth.getInstance();

        register_user_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // actionlistener to extract data when the register button is clicked
                String fullname = registerFullname.getText().toString();
                String email = registerEmailid.getText().toString();
                String password = registerPassword.getText().toString();
                String conpassword = registerConpassword.getText().toString();

                if(fullname.isEmpty()){
                    registerFullname.setError("Full name is required!!");
                    return;
                }
                if(email.isEmpty()){
                    registerEmailid.setError("Email id is required!!");
                    return;
                }
                if(!email.contains("@ves.ac.in")){
                    registerEmailid.setError(("Enter only Ves email id!! "));
                    return;
                }


                if(password.isEmpty()){
                    registerPassword.setError("Password is required!!");
                    return;
                }

                if(!password.equals(conpassword)){
                    registerConpassword.setError("Passwords don't match, try again!!");
                    return;
                }
                //Data entered is validated
                Toast.makeText(Registeration.this,"Welcome aboard!! "+fullname,Toast.LENGTH_SHORT).show();

                //Below code adds user credentials to firebase.

                Authentication.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        //Send user to next required page.....i.e buy or sell page.Currently I'm sending him/her to dashboard.

                            {
                                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                startActivity(intent);
                            }



                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Registeration.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        gotologin = findViewById(R.id.go_to_login);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}