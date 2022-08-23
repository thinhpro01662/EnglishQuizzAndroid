package org.o7planning.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class user_history extends AppCompatActivity {

    private Button back;
    private ListView listviewscore;
    DatabaseHandle db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_history);
        back = findViewById(R.id.buttonback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listviewscore = findViewById(R.id.listviewscore);
        db = new DatabaseHandle(this);
        ArrayList<user_score_list> scoreLists = db.getAllScore();
        ScoreAdapter myAdapter = new ScoreAdapter(scoreLists, this);
        if (scoreLists!=null){
            listviewscore.setAdapter(myAdapter);
        }
    }
}