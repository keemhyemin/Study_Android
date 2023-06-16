package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edt_id, edt_pw;
    Button btn_login;
    String id, pw;
    int colaCnt, ciderCnt, fantaCnt, sodaCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(v -> {
            id = edt_id.getText().toString();
            pw = edt_pw.getText().toString();
            if (id.equals("admin") && pw.equals("admin1234")) {
                colaCnt = intent.getIntExtra("cola", -1);
                ciderCnt = intent.getIntExtra("cider", -1);
                fantaCnt = intent.getIntExtra("fanta", -1);
                sodaCnt = intent.getIntExtra("soda", -1);

                Intent adintent = new Intent(LoginActivity.this, AdminActivity.class);
                adintent.putExtra("colacnt", colaCnt);
                adintent.putExtra("cidercnt", ciderCnt);
                adintent.putExtra("fantacnt", fantaCnt);
                adintent.putExtra("sodacnt", sodaCnt);
                startActivity(adintent);
            } else {
                Toast.makeText(this, "아이디 또는 비밀번호 틀림", Toast.LENGTH_SHORT).show();
            }
        });


    }
}