package com.example.anonsurf.xo;

import android.view.View;
import android.widget.Button;

public class ListenClick implements View.OnClickListener{
    private int x,y;

    ListenClick(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void onClick(View view) {
        MainActivity.success[this.x][this.y] = MainActivity.getTurn();

        Button btn = (Button)view;
        btn.setTextColor(view.getResources().getColor(R.color.white));
        btn.setTextSize(50.0f);
        if(MainActivity.getTurn() == 1) btn.setText("x");
        else btn.setText("o");

        view.setEnabled(false);

        if(MainActivity.getTurn() == 1) MainActivity.setTurn(2);
        else MainActivity.setTurn(1);

        if(this.checkSuccess()){
            if(MainActivity.success[0][0]==5)  MainActivity.setBtn1(view);
            if(MainActivity.success[0][1]==5)  MainActivity.setBtn2(view);
            if(MainActivity.success[0][2]==5)  MainActivity.setBtn3(view);
            if(MainActivity.success[1][0]==5)  MainActivity.setBtn4(view);
            if(MainActivity.success[1][1]==5)  MainActivity.setBtn5(view);
            if(MainActivity.success[1][2]==5)  MainActivity.setBtn6(view);
            if(MainActivity.success[2][0]==5)  MainActivity.setBtn7(view);
            if(MainActivity.success[2][1]==5)  MainActivity.setBtn8(view);
            if(MainActivity.success[2][2]==5)  MainActivity.setBtn9(view);

            MainActivity.finishGames();
        }
    }

    public boolean checkSuccess(){
        //-------------------------
        if((MainActivity.success[0][0]==1 && MainActivity.success[0][1]==1 && MainActivity.success[0][2]==1) ||
                (MainActivity.success[0][0]==2 && MainActivity.success[0][1]==2 && MainActivity.success[0][2]==2)){
            MainActivity.success[0][0]=5;
            MainActivity.success[0][1]=5;
            MainActivity.success[0][2]=5;
            return true;
        }
        if((MainActivity.success[1][0]==1 && MainActivity.success[1][1]==1 && MainActivity.success[1][2]==1) ||
                (MainActivity.success[1][0]==2 && MainActivity.success[1][1]==2 && MainActivity.success[1][2]==2)){
            MainActivity.success[1][0]=5;
            MainActivity.success[1][1]=5;
            MainActivity.success[1][2]=5;
            return true;
        }
        if((MainActivity.success[2][0]==1 && MainActivity.success[2][1]==1 && MainActivity.success[2][2]==1) ||
                (MainActivity.success[2][0]==2 && MainActivity.success[2][1]==2 && MainActivity.success[2][2]==2)){
            MainActivity.success[2][0]=5;
            MainActivity.success[2][1]=5;
            MainActivity.success[2][2]=5;
            return true;
        }

        //-------------------------
        if((MainActivity.success[0][0]==1 && MainActivity.success[1][0]==1 && MainActivity.success[2][0]==1) ||
                (MainActivity.success[0][0]==2 && MainActivity.success[1][0]==2 && MainActivity.success[2][0]==2)){
            MainActivity.success[0][0]=5;
            MainActivity.success[1][0]=5;
            MainActivity.success[2][0]=5;
            return true;
        }
        if((MainActivity.success[0][1]==1 && MainActivity.success[1][1]==1 && MainActivity.success[2][1]==1) ||
                (MainActivity.success[0][1]==2 && MainActivity.success[1][1]==2 && MainActivity.success[2][1]==2)){
            MainActivity.success[0][1]=5;
            MainActivity.success[1][1]=5;
            MainActivity.success[2][1]=5;

            return true;
        }
        if((MainActivity.success[0][2]==1 && MainActivity.success[1][2]==1 && MainActivity.success[2][2]==1) ||
                (MainActivity.success[0][2]==2 && MainActivity.success[1][2]==2 && MainActivity.success[2][2]==2)){
            MainActivity.success[0][2]=5;
            MainActivity.success[1][2]=5;
            MainActivity.success[2][2]=5;
            return true;
        }

        //-------------------------
        if((MainActivity.success[0][0]==1 && MainActivity.success[1][1]==1 && MainActivity.success[2][2]==1) ||
                (MainActivity.success[0][0]==2 && MainActivity.success[1][1]==2 && MainActivity.success[2][2]==2)){
            MainActivity.success[0][0]=5;
            MainActivity.success[1][1]=5;
            MainActivity.success[2][2]=5;
            return true;
        }
        if((MainActivity.success[0][2]==1 && MainActivity.success[1][1]==1 && MainActivity.success[2][0]==1) ||
                (MainActivity.success[0][2]==2 && MainActivity.success[1][1]==2 && MainActivity.success[2][0]==2)){
            MainActivity.success[0][2]=5;
            MainActivity.success[1][1]=5;
            MainActivity.success[2][0]=5;
            return true;
        }

        //-------------------------
        int no_tie=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(MainActivity.success[i][j] == 0) {
                    no_tie=1;
                    break;
                }
            }
        }
        if(no_tie == 0) {
            MainActivity.setTurn(0);
            MainActivity.finishGames();
        }
        return false;
    }
}
