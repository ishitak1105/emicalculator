package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Button;
import android.view.View;
import android.text.TextUtils;



public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et= (EditText)findViewById(R.id.edit1) ;
        final TextView result=(TextView)findViewById(R.id.t);
        final Button btn1=(Button)findViewById(R.id.b2);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==btn1) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });
        final EditText et1= (EditText)findViewById(R.id.edit2) ;
        final EditText et2= (EditText)findViewById(R.id.edit3) ;
        btn=(Button) findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st1 = et.getText().toString();
                String st2 = et1.getText().toString();
                String st3 = et2.getText().toString();

                if (TextUtils.isEmpty(st1)) {
                    et.setError("Enter Loan Amount");
                    et.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(st3)) {
                    et2.setError("Enter Interest Rate");
                    et2.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(st2)) {
                    et1.setError("Enter Years");
                    et1.requestFocus();
                    return;
                }

                float p = Float.parseFloat(st1);
                float m = Float.parseFloat(st2);
                float i = Float.parseFloat(st3);
                float rate = (float) (i/(12*100));
                float power = (float) (Math.pow(1 + rate, m));
                float pri = (float) (p * 100000);
                float emi = (float) ((pri * rate * power) / (power - 1));
                result.setText(String.valueOf(emi));
            }
        });

    }


}
