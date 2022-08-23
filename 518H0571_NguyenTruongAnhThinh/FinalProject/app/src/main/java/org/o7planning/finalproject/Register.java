package org.o7planning.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button register;
    private  Button turnback;
    DatabaseHandle databaseHandle;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        register = findViewById(R.id.confirm);
        turnback = findViewById(R.id.goback);
        databaseHandle = new DatabaseHandle(Register.this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = username.getText().toString();
                String pa = password.getText().toString();
                if (!us.isEmpty()&&!pa.isEmpty()){
                    if (databaseHandle.addUser(us, pa)){
                        username.setText("");
                        password.setText("");
                        Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        turnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}