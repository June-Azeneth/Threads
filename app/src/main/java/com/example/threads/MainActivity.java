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

        CommRunnable comRun = new CommRunnable(13);
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
                if(i == 1){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic1);
                        }
                    });
                }
                if(i == 3){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic2);
                        }
                    });
                }
                if(i == 5){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic3);
                        }
                    });
                }
                if(i == 7){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic4);
                        }
                    });
                }
                if(i == 9){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic5);
                        }
                    });
                }
                if(i == 11){
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            comPic.setImageResource(R.drawable.pic6);
                        }
                    });
                }
                if(i == 12){
                   i = 0;
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