package org.o7planning.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateUser extends AppCompatActivity {
    private TextView userid;
    private EditText name;
    private EditText age;
    private RadioGroup rg;
    private RadioButton male;
    private RadioButton female;
    private Button back;
    private Button update;
    DatabaseHandle databaseHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        userid = findViewById(R.id.userid);

        name = findViewById(R.id.nameshow);
        age = findViewById(R.id.ageshow);
        rg = findViewById(R.id.rg);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        Intent i = getIntent();
        final String userData = i.getExtras().getString("userData1","");
        userid.setText(userData);
        back = findViewById(R.id.back);
        update = findViewById(R.id.update);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        databaseHandle = new DatabaseHandle(UpdateUser.this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt( age.getText().toString());
                if (!name.getText().toString().isEmpty()&& !(null == num) &&!doonsex().isEmpty()){
                    if (databaseHandle.addInfo(userData, name.getText().toString(), num, doonsex())){
                        name.setText("");
                        age.setText("");
                        rg.clearCheck();
                        Toast.makeText(UpdateUser.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public String doonsex() {
        int sex = rg.getCheckedRadioButtonId();
        RadioButton radioButtonSex = (RadioButton) this.findViewById(sex);
        String sxe = radioButtonSex.getText().toString();
        return sxe;
    }
}