package org.o7planning.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private Button taketest;
    private Button infoupdate;
    private Button infoscore;
    private Button logout;
    private TextView nameshow;
    String userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        taketest = findViewById(R.id.taketest);
        infoupdate = findViewById(R.id.info);
        infoscore = findViewById(R.id.button);
        logout = findViewById(R.id.logout);
        nameshow = findViewById(R.id.namein);
        Intent i = getIntent();
        userData = i.getExtras().getString("userData","");
        nameshow.setText("Xin chào, "+userData);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        infoupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateintent();
            }
        });
        taketest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTaketest();
            }
        });
        infoscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUserScore();
            }
        });
    }
    public void updateintent(){
        Intent UpdateIntent = new Intent(this, UpdateUser.class);
        String userData1 = userData;
        UpdateIntent.putExtra("userData1", userData1);
        startActivity(UpdateIntent);
    }

    public void setTaketest(){
        Intent TaketestIntent = new Intent(this, taketest.class);
        String userData2 = userData;
        TaketestIntent.putExtra("userData2", userData2);
        startActivity(TaketestIntent);
    }

    public void setUserScore(){
        Intent ScoreIntent = new Intent(this, user_history.class);
        startActivity(ScoreIntent);
    }
}