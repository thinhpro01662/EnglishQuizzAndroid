package org.o7planning.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class toeic_test extends AppCompatActivity {

    private TextView countime;
    private Button begin;
    private Button back2;
    private TextView warning;
    private Button finish;
    private CountDownTimer countDownTimer;
    private long time = 600000;
    private boolean timerunning;
    private ListView listView;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    DatabaseHandle db;
    ArrayList<String> selectedStrings = new ArrayList<String>();
    private String userData;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeic_test);
        countime = findViewById(R.id.counttime69);
        begin = findViewById(R.id.begin69);
        back2 = findViewById(R.id.back69);
        warning = findViewById(R.id.textView69);
        warning.setVisibility(View.INVISIBLE);
        finish = findViewById(R.id.finish69);
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
        listView = findViewById(R.id.listview69);
        final ArrayList<QuestList> questLists = db.getAllQues1();
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
                db.addScore(userData, score, "Ngữ pháp");
                new AlertDialog.Builder(toeic_test.this)
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