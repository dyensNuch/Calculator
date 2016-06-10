package com.example.nuch_nb.calculator_unittest;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Nuch-NB on 9/6/2559.
 */
//ทำตามเว็บเลย
@RunWith(AndroidJUnit4.class)
//เราจะทำ tes  ต้องบอกว่า เทสแบบ instrument
//9ต้อง extend class แม่ ActivityInstrumentationTestCase2
    public class MainActivityInstrumentTest  extends ActivityInstrumentationTestCase2 {

    //สร้าง activity ขึ้นมา
    @Rule
    //กินข้าว
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class,true,false);

    public MainActivityInstrumentTest() {
        super(null);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }
//หาไปก่อนนะครับ


    @Test
    //10+20=30
    //ทีนี้การ run instrument test ต้องอาศัย emulator ครับ ต้อง run ขึ้นมาก่อน
    public void shouldAddTenWithTwentyWasThirty()
    {
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
        // Type text and then press the button.
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.clearText(), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.typeText("10"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.typeText("20"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbPlus))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());

        // Check that the text was changed.
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("30.00")));
    }

    //ได้แล้วครับ อันนี้คือเราเทสแล้วเห็น interface ไปด้วย
    @Test
    //10+80=30
    //ทีนี้การ run instrument test ต้องอาศัย emulator ครับ ต้อง run ขึ้นมาก่อน
    public void shouldplusof10and80was90()
    {
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
        // Type text and then press the button.
        //onView อ้างถึง view ที่กำลังแสดงที่หน้าจอ
        //ViewMatchers เอาไว้ตรวจหาสิ่งที่เราต้องการบน view
        //withId คือ จับวิว ที่ชื่อตามที่ระบุ
        //ViewAction คือ จะให้มันทำกอะไรกับview หลัก ๆ ก็มี cleartext() typetext click
        //closesoftkeyboard คือ สั่งให้มันไม่ต้องแสดง keboard ขึ้นมาครับ


        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.clearText(), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.typeText("10"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.typeText("80"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbPlus))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());

        // Check that the text was changed.
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("90.00")));
    }

    @Test
    public void shouldMinus4with1was3(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.replaceText("4"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.replaceText("1"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbMinus))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("3.00")));
    }


    @Test
    public void shouldMinus10with3was7(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.replaceText("10"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.replaceText("3"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbMinus))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("7.00")));
    }

    @Test
    public void shouldMulti11with2was22(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.replaceText("11"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.replaceText("2"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbMulti))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("22.00")));
    }

    @Test
    public void shouldMulti0with2was0(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.replaceText("0"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.replaceText("2"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbMulti))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("0.00")));
    }

    @Test
    public void shouldDevide0with2was0(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.replaceText("0"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.replaceText("2"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbDevide))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("0.00")));
    }

    @Test
    public void shouldDevide1with0wasErrorMessage(){
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        Espresso.onView(ViewMatchers.withId(R.id.edtNumber1))
                .perform(ViewActions.replaceText("1"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.edtNumber2))
                .perform(ViewActions.replaceText("0"), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.rbDevide))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.btCal)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edtRes))
                .check(ViewAssertions.matches(ViewMatchers.withText("Error ตัวหารเป็น0")));
    }
//เรายังสามารถเทสหลายๆ อย่างพร้อมกันทีเดียวนะครับ
    //ทีนี้ลองเทสให่้ครบทุกอันดูครับ

    //เก่งเมื่อกี้ดูไม่ทันที่มันขึ้น No Test ตอนแรกง่ะ ต้องไปแก้ setup อะไร
    //ต้องใส่ทุก project ที่ต้องการทำ instrument test ? s iniy[ครับ ครั้งหน้าเราก็แค่ copy  gradle ไปวาง
    //ถ้าเป็นอีกตัวนึงที่ชื่อ Mock ก็ต้องทำแบบนี้เหรอถ้าจะทำ instrument test ก็ต้องทำแบบนี้ครับ
    //เห็นความแตกต่างของการเทส สองแบบมั้ยครัะบ unit test ด้วย robolectric กับ instrument test ด้วย espresso
    //จริงๆ ผลที่ได้มันเหมือนกันครับ แต่ถ้าเรามั่นใจแล้วว่า robolectric น่าจะเทสเรื่องนี้แล้วเราก็อาจจะไม่ต้องทำ testซ้ำ
    //espresso เอาไว้เทสอย่างอื่นที่ robolectric ไม่สามารถเทสได้ เ่ชนการ call api แล้วรอ response เป็นต้น

    //ลองเขียนดูครับ เพื่อความเข้าใจ ok ka aj.


}



