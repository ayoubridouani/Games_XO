package com.example.anonsurf.xo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private static TextView tv1,tv2,tv3;
    private static int turn = 1;
    static int success[][] = {{0,0,0},{0,0,0},{0,0,0}};
    private static int user_1=0;
    private static int user_2=0;
    private static int tie=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get All Buutons From XML
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        tv1 = findViewById(R.id.result_1);
        tv2 = findViewById(R.id.result_2);
        tv3 = findViewById(R.id.result_3);

        //Make Listeners for All buttons
        btn1.setOnClickListener(new ListenClick(0,0));
        btn2.setOnClickListener(new ListenClick(0,1));
        btn3.setOnClickListener(new ListenClick(0,2));
        btn4.setOnClickListener(new ListenClick(1,0));
        btn5.setOnClickListener(new ListenClick(1,1));
        btn6.setOnClickListener(new ListenClick(1,2));
        btn7.setOnClickListener(new ListenClick(2,0));
        btn8.setOnClickListener(new ListenClick(2,1));
        btn9.setOnClickListener(new ListenClick(2,2));
    }

    public static void reset(View view){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                MainActivity.success[i][j]=0;
            }
        }
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }

    //when someone won, all buttons get disabled
    public static void finishGames(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);

        if(MainActivity.turn == 2) MainActivity.user_1++;
        else if(MainActivity.turn == 1) MainActivity.user_2++;
        else MainActivity.tie++;

        tv1.setText(Integer.toString(user_1));
        tv2.setText(Integer.toString(tie));
        tv3.setText(Integer.toString(user_2));

    }

    //to change Color
    public static void setBtn1(View view) {
        btn1.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn2(View view) {
        btn2.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn3(View view) {
        btn3.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn4(View view) {
        btn4.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn5(View view) {
        btn5.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn6(View view) {
        btn6.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn7(View view) {
        btn7.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn8(View view) {
        btn8.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    public static void setBtn9(View view) {
        btn9.setTextColor(view.getResources().getColor(R.color.yellow));
    }

    //getter-setter for Turn
    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turn) {
        MainActivity.turn = turn;
    }

}