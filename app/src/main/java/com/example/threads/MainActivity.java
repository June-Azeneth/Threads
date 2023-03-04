package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private volatile boolean stopThread = false;
    Handler mainHandler = new Handler();
    ImageView comPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comPic = findViewById(R.id.commPic);

        CommRunnable comRun = new CommRunnable(11);
        new Thread(comRun).start();

    }

    private void stop(){
        stopThread = true;
    }

    class CommRunnable implements Runnable{
        int seconds;

        CommRunnable(int seconds){
            this.seconds = seconds;
        }
        @Override
        public void run(){
            for(int i =0;i<seconds;i++){
                if(stopThread){
                    return;
                }
                if(i == 2){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic2);
                        }
                    });
                }
                if(i == 4){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic3);
                        }
                    });
                }
                if(i == 6){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic4);
                        }
                    });
                }
                if(i == 8){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic5);
                        }
                    });
                }
                if(i == 10){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic6);
                        }
                    });
                }
                Log.d("Thread","Start Thread: " + i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}