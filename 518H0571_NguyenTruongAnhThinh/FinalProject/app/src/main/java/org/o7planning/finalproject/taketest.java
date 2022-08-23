package org.o7planning.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class taketest extends AppCompatActivity {
    private Button bt;
    private Button ielts;
    private Button toeic;
    private String userData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taketest);
        bt = findViewById(R.id.bt);
        ielts = findViewById(R.id.ielts);
        toeic = findViewById(R.id.toeic);
        Intent i = getIntent();
        userData = i.getExtras().getString("userData2","");
        ielts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ieltsintent();
            }
        });
        toeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toeicintent();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void Ieltsintent(){
        Intent IeltsIntent = new Intent(this, ielts_test.class);
        String userData1 = userData;
        IeltsIntent.putExtra("userData1", userData1);
        startActivity(IeltsIntent);
    }

    public void Toeicintent(){
        Intent ToeicIntent = new Intent(this, toeic_test.class);
        String userData1 = userData;
        ToeicIntent.putExtra("userData1", userData1);
        startActivity(ToeicIntent);
    }
}