package com.example.and07_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt_phone, edt_search, edt_message, edt_string, edt_number;
    Button btn_phone, btn_search, btn_message, btn_strsend, btn_numbersend, btn_dtosend, btn_listsend;

    final String TAG = "수명주기";
    // 현재는 onCreate 내부에서만 코드처리를 해도 무방함.
    // 추후에 여러 화면이나 Spring 연동 시 새로고침 등의 처리가 필요할 때는 수명주기가 있다는 것을 생각하고, 적절한 수명주기를 이용하자.

    // 안드로이드도 Spring과 마찬가지로 Debugging을 잘하면 오류찾는게 빠르다. (디버깅 모드를 한번씩 연습해보는 습관을 들이면 좋음)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        Intent intent = getIntent(); // 방금 LoginActivity에서 startActivity( 'intent' ) 사용된 intent를 가져옴 (내부에 넣어둔(putExtra) 데이터를 빼오기 위해서)

        String strValue = intent.getStringExtra("strkey");
        int intValue = intent.getIntExtra("intkey", -1);
        // name으로 값을 찾았을 때 없다면 , 기본값을 어떤 값으로 할건지(defaultValue)
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dtokey"); // 객체의 타입을 주고 강제로 바꾸는 것 ==> 역직렬화 ==> 내부에 있는 멤버를 사용하기위해 Serializable => dto

        Log.d(TAG, "onCreate: " + strValue);
        Log.d(TAG, "onCreate: " + intValue);
        Log.d(TAG, "onCreate: " + dto.getId());

        ArrayList<LoginDTO> dtoList = (ArrayList<LoginDTO>) intent.getSerializableExtra("dtolist");
        Log.d(TAG, "onCreate: " + dtoList.size());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");

        edt_phone = findViewById(R.id.edt_phone);
        edt_search = findViewById(R.id.edt_search);
        edt_message = findViewById(R.id.edt_message);
        edt_string = findViewById(R.id.edt_string);
        edt_number = findViewById(R.id.edt_number);
        btn_phone = findViewById(R.id.btn_phone);
        btn_search = findViewById(R.id.btn_search);
        btn_message = findViewById(R.id.btn_message);
        btn_strsend = findViewById(R.id.btn_strsend);
        btn_numbersend = findViewById(R.id.btn_numbersend);
        btn_dtosend = findViewById(R.id.btn_dtosend);
        btn_listsend = findViewById(R.id.btn_listsend);

        // lamda 인터페이스를 파라메터로 넘겨야할 때 함수로 메소드 지역만 만들어냄. this를 써보면 new와 함수형 lamda식을 알 수 있음
        // 주의사항. 람다식에서 인터페이스를 함수형으로 쓸 때 인터페이스 내부에는 메소드가 반드시 하나여야 함
        // 명시적 : activity => activity.class 이동 시 많이 사용.
        // 암시적, 묵시적 : activity => action(내가 없는 기능) 사용할 때 씀.
        btn_phone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:/" + edt_phone.getText().toString()));
            startActivity(intent);
        });

        btn_search.setOnClickListener(this);
        btn_message.setOnClickListener(this);
        btn_strsend.setOnClickListener(this);
        btn_numbersend.setOnClickListener(this);
        btn_dtosend.setOnClickListener(this);
        btn_listsend.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_search) {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, edt_search.getText().toString());
            startActivity(intent);
        }else if (v.getId() == R.id.btn_message) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-5678")));
            intent.putExtra("sms_body", edt_message.getText().toString());
            startActivity(intent);
            // 암시적 인텐트나 명시적 인텐트를 사용해서 통신 후 다시 결과를 받아와야하는 상황에 쓰는 것들이 있음. ActivityLauncher, startActivityForResult
            // 현재는 사용할 경우가 없기 때문에 pass
        } else if (v.getId() == R.id.btn_strsend) {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            intent.putExtra("mainstr", edt_string.getText().toString());
            startActivity(intent);
        } else if (v.getId() == R.id.btn_numbersend) {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            intent.putExtra("mainnum", Integer.parseInt(edt_number.getText().toString()));
            startActivity(intent);
        } else if (v.getId() == R.id.btn_dtosend) {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            intent.putExtra("khmlist", new KhmDTO(edt_string.getText().toString(), Integer.parseInt(edt_number.getText().toString())));
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            ArrayList<KhmDTO> khmDtoList = new ArrayList<>();
            khmDtoList.add(new KhmDTO(edt_string.getText().toString(), Integer.parseInt(edt_number.getText().toString())));
            intent.putExtra("khmdtolist", khmDtoList);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


}