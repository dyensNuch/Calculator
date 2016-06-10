package com.example.nuch_nb.calculator_unittest;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Nuch-NB on 8/6/2559.
 */

//เอาเรื่อง instrument test ก่อนละกันนะครับ ให้จบเป็น shortq เพื่อพี่นุชจะได้เข้าใจลำดับการเทส
    //ตอนนี้เราใช้ robolectric เทส โดย mock ข้อมูลขึ้นมาว่า ถ้าให้ข้อมูลอย่างนี้ ทำอย่างนี้ แล้วต้องได้อย่างนี้
    //AAA Arrange Act Assert
    //แต่ว่า ปัญหาคือ ความมั่นใจก็ไม่ 100% เพราะไม่เห็นหน้าจอว่า มันทำงานได้จริงป่าว เพราะ robolectric มันไป run บo jvm
    //แต่เราอยากเห็น บน Dvm (device  virtual machine หรือ simulator นั้นเอง)

    //ดังนั้นแล้ว เรราจะไปสร้าง test นี้กันครับ

    //ผมจะแนะนำให้รู้จุัก Esspresso นะครับ เพราะ robotrium นั้น.... ยังไม่เคยเล่น แต่ว่า.. มันเขียนง่ายกว่า espresso มาก
    //dก่อนใช้ ก็ต้อง add lib ครับ

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class MainActivity_Test {

    private ActivityController<MainActivity> controller;
    private MainActivity mainActivity;

    @Test
    public void shouldGetTrueWhenNumber1IsNotNull(){
        //สร้าง controller และเชื่อมเสมือนเป็น MainActivity
createActivity();
        EditText edtNumber1 = (EditText) mainActivity.findViewById(R.id.edtNumber1);


        assertTrue(edtNumber1.getText().toString()!="");
    }


    @Test
    public void shouldGetTrueWhenNumber2IsNotNull(){
        //สร้าง controller และเชื่อมเสมือนเป็น MainActivity
        createActivity();

        EditText edtNumber2 = (EditText) mainActivity  .findViewById(R.id.edtNumber2);

        assertTrue(edtNumber2.getText().toString()!="");
    }

    @Test
    public void shouldGetTrueWhenSelectOneCalculateType(){
        //สร้าง controller และเชื่อมเสมือนเป็น MainActivity
        createActivity();

        RadioGroup radioGroup = (RadioGroup) mainActivity.findViewById(R.id.rbgSign);
        int id = radioGroup.getCheckedRadioButtonId();

        assertTrue(id != -1);
    }

    private void createActivity() {
        controller = Robolectric.buildActivity(MainActivity.class);
        mainActivity = controller.create().get();
    }

    @Test
    public void  shouldGetTwoIfOnePlusOne(){
        createActivity();


        //หลังจากเราสร้าง activity เราก็สามารถุจะ get view ทั้งหมดมาใช้งานได้ครับ
        //อันนี้คือ เตรียมข้อมูลตาม test case
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        //ผมจะจำลองเหตุการณ์ว่า ผู้ใช้ key ข้อมูล 1 กับ 1
        number1.setText("1");
        number2.setText("1");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbPlus);
        rbplus.setChecked(true);

        //หลังจากจำลองข้อมูลครบแล้ว ทำ action ที่จะทดสอบ
        //หลังจากเตรียมครบแล้วเราก็ action ในจุดที่สนใจจะเทส
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);
        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        //ผ่านมั้ย ผ่านแล้ว  ลองอันอื่นดูครับ แล้วก็มาดูผล

        //แล้วก็ตรวขจสอบผลครับ
        //ตามจริงแล้ว ผมจะทำ smal step ให้นะ คือ resultview ก็ระบุไปเลย 2
        //อย่างนี้ก็ได้
        //แต่ผมลัดขั้นตอนให้ดูว่า เวลาเราเขียนเทสจริงๆ มันจะเป็นอย่างไร
        assertEquals("2.00",resultview.getText().toString());
    }
    @Test
    public void  shouldGetThreeIfOnePlustwo(){
        createActivity();
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        number1.setText("1");
        number2.setText("2");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbPlus);
        rbplus.setChecked(true);
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        assertEquals("3.00",resultview.getText().toString());
    }

    //เทสเรื่องเดียวกัน  คือ บวก แต่ว่าข้อมุลสำหรับเทสต่างกัน
    @Test
    public void  shouldGetThreeIffiveminustwo(){
        createActivity();
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        number1.setText("5");
        number2.setText("2");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbMinus);
        rbplus.setChecked(true);
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        assertEquals("3.00",resultview.getText().toString());
    }
//เขียนต่อเลยครับ
    //ถ้าเราทำอย่างนี้ เราจะมี test 2 ชุดเป็นอย่างน้อยเป็นการ re-check ไปในตัวว่า เราไม่ได้ hard code อะไรไว้ในโปรแกรมนะ
  //  2ชุดยังไง
    //เข้าใจละ เด๋วไปข้างนอกก่อนนะ แม่มา thank U. arjan keng.
    //85ับ ผม*จะกลับบ้านแล้วครับ ลองเทำเองดูนะครับ
@Test
public void  shouldGetfourIffiveminusone(){
    createActivity();
    EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
    EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
    number1.setText("5");
    number2.setText("1");
    RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbMinus);
    rbplus.setChecked(true);
    Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


    calculateButton.performClick();

    TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
    assertEquals("4.00",resultview.getText().toString());
}

//ตามนั้นครับ 55
    //คือทำเทสไป เขียนจริงไปเท่าที่ต้องใช้ ควบคู่ไปเลย? ใช่ครับ
    //เหมือนเรามี test case อยู่แล้วว่า ถ้าใส่ค่าอย่างนี้ แล้วกดปุ่มนั้น ต้องได้ค่านู่น
    //มันมีแค่นั้น
    //

    @Test
    public void  shouldGetfourIffourMultione(){
        createActivity();
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        number1.setText("4");
        number2.setText("1");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbMulti);
        rbplus.setChecked(true);
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        assertEquals("4.00",resultview.getText().toString());
    }

    @Test
    public void  shouldGetEightIffourMultitwo(){
        createActivity();
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        number1.setText("4");
        number2.setText("2");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbMulti);
        rbplus.setChecked(true);
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        assertEquals("8.00",resultview.getText().toString());
    }

    @Test
    public void  shouldGetTwoIffourDevidetwo(){
        createActivity();
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        number1.setText("4");
        number2.setText("2");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbDevide);
        rbplus.setChecked(true);
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        assertEquals("2.00",resultview.getText().toString());
    }

    @Test
    public void  shouldGet3point33IfTenDevideThree(){
        createActivity();
        EditText number1 = (EditText)mainActivity.findViewById(R.id.edtNumber1);
        EditText number2 = (EditText)mainActivity.findViewById(R.id.edtNumber2);
        number1.setText("10");
        number2.setText("3");
        RadioButton rbplus = (RadioButton) mainActivity.findViewById(R.id.rbDevide);
        rbplus.setChecked(true);
        Button calculateButton = (Button) mainActivity.findViewById(R.id.btCal);


        calculateButton.performClick();

        TextView resultview = (TextView) mainActivity.findViewById(R.id.edtRes);
        assertEquals("3.33",resultview.getText().toString());
        double i = 0.3;

    }
}
