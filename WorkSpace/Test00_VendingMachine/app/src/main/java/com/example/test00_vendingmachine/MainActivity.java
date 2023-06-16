package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_cola, tv_cider, tv_fanta, tv_soda, tv_money;
    EditText edt_money;
    Button btn_cola, btn_cider, btn_fanta, btn_soda, btn_money, btn_change, btn_admin;
    int inputMoney = 0; // 사용자가 입금한 금액
    int colaCnt, ciderCnt, fantaCnt, sodaCnt; // 음료 수량
    int uCola, uCider, uFanta, uSoda; // 사용자가 구매한 음료 수량
    int colaPrice, ciderPrice, fantaPrice, sodaPrice; // 음료 가격

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_cola = findViewById(R.id.tv_cola);
        tv_cider = findViewById(R.id.tv_cider);
        tv_fanta = findViewById(R.id.tv_fanta);
        tv_soda = findViewById(R.id.tv_soda);
        tv_money = findViewById(R.id.tv_money);
        edt_money = findViewById(R.id.edt_money);
        btn_cola = findViewById(R.id.btn_cola);
        btn_cider = findViewById(R.id.btn_cider);
        btn_fanta = findViewById(R.id.btn_fanta);
        btn_soda = findViewById(R.id.btn_soda);
        btn_money = findViewById(R.id.btn_money);
        btn_change = findViewById(R.id.btn_change);
        btn_admin = findViewById(R.id.btn_admin);

        btn_cola.setOnClickListener(this);
        btn_cider.setOnClickListener(this);
        btn_fanta.setOnClickListener(this);
        btn_soda.setOnClickListener(this);
        btn_money.setOnClickListener(this);
        btn_change.setOnClickListener(this);
        btn_admin.setOnClickListener(this);

        ArrayList<DrinkDTO> drinkList = new ArrayList<>();
        drinkList.add(new DrinkDTO("콜라", 800, 10));
        drinkList.add(new DrinkDTO("사이다", 800, 10));
        drinkList.add(new DrinkDTO("환타", 700, 0));
        drinkList.add(new DrinkDTO("데미소다", 700, 10));

        colaCnt = drinkList.get(0).getCnt();
        ciderCnt = drinkList.get(1).getCnt();
        fantaCnt = drinkList.get(2).getCnt();
        sodaCnt = drinkList.get(3).getCnt();

        colaPrice = drinkList.get(0).getPrice();
        ciderPrice = drinkList.get(1).getPrice();
        fantaPrice = drinkList.get(2).getPrice();
        sodaPrice = drinkList.get(3).getPrice();

        tv_cola.setText("수량: " + colaCnt + "개");
        tv_cider.setText("수량: " + ciderCnt + "개");
        tv_fanta.setText("수량: " + fantaCnt + "개");
        tv_soda.setText("수량: " + sodaCnt + "개");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_cola) {
            if (colaCnt != 0 && colaCnt > 0 && inputMoney >= colaPrice) {
                inputMoney -= colaPrice;
                colaCnt--;
                uCola++;
                tv_money.setText("잔액: " + inputMoney + "원");
                tv_cola.setText("수량: " + colaCnt + "개");
            } else if (colaCnt == 0 || colaCnt < 0) {
                Toast.makeText(this, "재고가 없습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_cider) {
            if (ciderCnt != 0 && ciderCnt > 0 && inputMoney >= ciderPrice) {
                inputMoney -= ciderPrice;
                ciderCnt--;
                uCider++;
                tv_money.setText("잔액: " + inputMoney + "원");
                tv_cider.setText("수량: " + ciderCnt + "개");
            } else if (ciderCnt == 0 || ciderCnt < 0) {
                Toast.makeText(this, "재고가 없습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_fanta) {
            if (fantaCnt != 0 && fantaCnt > 0 && inputMoney >= fantaPrice) {
                inputMoney -= fantaPrice;
                fantaCnt--;
                uFanta++;
                tv_money.setText("잔액: " + inputMoney + "원");
                tv_fanta.setText("수량: " + fantaCnt + "개");
            } else if (fantaCnt == 0 || fantaCnt < 0) {
                Toast.makeText(this, "재고가 없습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_soda) {
            if (sodaCnt != 0 && sodaCnt > 0 && inputMoney >= sodaPrice) {
                inputMoney -= sodaPrice;
                sodaCnt--;
                uSoda++;
                tv_money.setText("잔액: " + inputMoney + "원");
                tv_soda.setText("수량: " + sodaCnt + "개");
            } else if (sodaCnt == 0 || sodaCnt < 0) {
                Toast.makeText(this, "재고가 없습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_money) {
            try {
                if (Integer.parseInt(edt_money.getText().toString()) % 10 == 0) {
                    inputMoney += Integer.parseInt(edt_money.getText().toString());
                    tv_money.setText("잔액: " + inputMoney + "원");
                } else {
                    Toast.makeText(this, "현금만 넣어주세요.", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Toast.makeText(this, "숫자만 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_change) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("change", inputMoney);
            intent.putExtra("buycola", uCola);
            intent.putExtra("buycider", uCider);
            intent.putExtra("buyfanta", uFanta);
            intent.putExtra("buysoda", uSoda);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.putExtra("cola", colaCnt);
            intent.putExtra("cider", ciderCnt);
            intent.putExtra("fanta", fantaCnt);
            intent.putExtra("soda", sodaCnt);
            startActivity(intent);
        }
    }
}