package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int active = 0;

    int[] filled = {2,2,2,2,2,2,2,2,2};

//    x->0
//    O->1
//    blank->2

    int[][] win = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameActive = true;
    public void pressBtn(View view){
        ImageView img = (ImageView)view;
        int pressed  = Integer.parseInt(img.getTag().toString());
        TextView turn = findViewById(R.id.turnStatus);

        if(filled[pressed]==2 && gameActive){
            filled[pressed] = active;
            img.setTranslationY(-1000f);
            if(active==0){
                active=1;
                img.setImageResource(R.drawable.cross);
                turn.setText("TURN OF O");
            }
            else if(active==1){
                active=0;
                img.setImageResource(R.drawable.zero);
                turn.setText("TURN OF X");
            }
        img.animate().translationYBy(1000f).setDuration(400);
        }

        for(int[] i:win){
            ImageView winCeleb = (ImageView)findViewById(R.id.imageView);
            if(filled[i[0]]==filled[i[1]] && filled[i[2]]==filled[i[1]] && filled[i[0]]!=2){
                gameActive=false;
                winCeleb.setImageResource(R.drawable.win);
                winCeleb.animate().rotation(360f).setDuration(1000);
                if(filled[i[0]]==0){turn.setText("X WON");}
                else if(filled[i[0]]==1){turn.setText("O WON");}
            }
        }
    }

    public void resetBtn(View view){
        active = 0;
        gameActive=true;
        ImageView winCeleb = (ImageView)findViewById(R.id.imageView);
        winCeleb.setImageResource(0);
        winCeleb.animate().rotation(360f).setDuration(1000);
        for(int i =0;i<9;i++){
            filled[i]=2;
        }
        TextView turn = findViewById(R.id.turnStatus);
        turn.setText("TURN OF X");

        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);

    }
}