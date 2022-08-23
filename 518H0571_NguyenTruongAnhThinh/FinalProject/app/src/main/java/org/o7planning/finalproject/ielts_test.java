package org.o7planning.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ielts_test extends AppCompatActivity {
    private TextView countime;
    private Button begin;
    private Button back2;
    private Button finish;
    private TextView warning;
    private CountDownTimer countDownTimer;
    private long time = 600000;
    private boolean timerunning;
    private ListView listView;
    private  RadioGroup radioGroup;
    private RadioButton radioButton;
    DatabaseHandle db;
    ArrayList<String> selectedStrings = new ArrayList<String>();
    private String userData;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts_test);
        countime = findViewById(R.id.counttime);
        begin = findViewById(R.id.begin);
        back2 = findViewById(R.id.back2);
        warning = findViewById(R.id.textView14);
        warning.setVisibility(View.INVISIBLE);
        finish = findViewById(R.id.finish);
        Intent i = getIntent();
        userData = i.getExtras().getString("userData1","");
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CountDownTimer(180000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        countime.setText(""+String.format("%d min, %d sec",
                                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                    }
                    public void onFinish() {
                        countime.setText("KẾT THÚC");
                        finish.performClick();
                        begin.setVisibility(View.VISIBLE);
                        finish.setVisibility(View.INVISIBLE);
                        warning.setVisibility(View.INVISIBLE);
                    }

                }.start();
                fillListview();
                begin.setVisibility(View.INVISIBLE);
                finish.setVisibility(View.VISIBLE);
                warning.setVisibility(View.VISIBLE);
            }
        });


        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void fillListview() {
        db = new DatabaseHandle(this);
        listView = findViewById(R.id.listview);
        final ArrayList<QuestList> questLists = db.getAllQues();
        final QuesAdapter myAdapter = new QuesAdapter(questLists, this);
        listView.setAdapter(myAdapter);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tran = null;
                String an = null;
                int child=listView.getChildCount();
                for(int i=0;i<child;i++) {
                    View rgg=listView.getChildAt(i);
                    radioGroup = (RadioGroup) rgg.findViewById(R.id.answer);
                    int selectedId=radioGroup.getCheckedRadioButtonId();
                    radioButton = (RadioButton) rgg.findViewById(selectedId);
                    an=radioButton.getText().toString();
                    QuestList qtu = questLists.get(i);
                    tran = qtu.getTran();
                    if (tran.equals(an)) {
                        score += 1;
                    }
                }
                db.addScore(userData, score, "Từ vựng");
                new AlertDialog.Builder(ielts_test.this)
                        .setTitle("Kết quả")
                        .setMessage("Số câu đúng: "+score+"/8")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                overridePendingTransition(0, 0);
                                startActivity(getIntent());
                                overridePendingTransition(0, 0);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                listView.setAdapter(null);
            }
        });
    }

}