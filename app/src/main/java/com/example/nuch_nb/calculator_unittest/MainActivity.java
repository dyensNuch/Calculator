package com.example.nuch_nb.calculator_unittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText number1;
    private EditText number2;
    private TextView resultview;
    private RadioButton rbPlus;
    private RadioButton rbMinus;
    private RadioButton rbMulti;
    private RadioButton rbDevide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myClick(View view) {

        bindWidget();
        double oneValue = Integer.parseInt(number1.getText().toString());
        double twoValue = Integer.parseInt(number2.getText().toString());
        double result = 0;

        double zeronumber = 0;
        String resultStr="";
        if(rbPlus.isChecked())
            result = oneValue + twoValue;
        else
        if(rbMinus.isChecked())
            result = oneValue - twoValue;
        else
        if(rbMulti.isChecked())
            result = oneValue * twoValue;
        else
        if (rbDevide.isChecked()){
            if (twoValue==zeronumber) resultStr = "Error ตัวหารเป็น0";
                else
                    result = oneValue / twoValue;
        }

        if (resultStr=="")
            resultStr = new DecimalFormat("#0.00").format(result);
        resultview.setText(resultStr);
    }

    private void bindWidget() {
        number1 = (EditText)this.findViewById(R.id.edtNumber1);
        number2 = (EditText)this.findViewById(R.id.edtNumber2);
        resultview = (TextView) this.findViewById(R.id.edtRes);

        rbPlus = (RadioButton) this.findViewById(R.id.rbPlus);
        rbMinus = (RadioButton) this.findViewById(R.id.rbMinus);
        rbMulti = (RadioButton) this.findViewById(R.id.rbMulti);
        rbDevide = (RadioButton) this.findViewById(R.id.rbDevide);
    }
    public void showHelloWorld() {
            number1 = (EditText)this.findViewById(R.id.edtNumber1);

        number1.setText("hello world");
        //อ้าว ผ่านบังคับใน xml ทำไมผ่าน เพรานั่นมันเป็นการ บังคับ keyboard ครับ
        //เอาล่ะ ลอง push
    }
}
