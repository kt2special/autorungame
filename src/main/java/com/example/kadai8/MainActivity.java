package com.example.kadai8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.os.Handler;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Stage stage;
    Point point;
    MediaPlayer mediaPlayer=new MediaPlayer();
    MediaPlayer button=new MediaPlayer();
    TextView tv1;
    TextView tv2;
    Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        button=MediaPlayer.create(this,R.raw.button);
        mediaPlayer=MediaPlayer.create(this,R.raw.mix2);
        mediaPlayer.setVolume(0.3f,0.3f);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    public void start(View vi){
        button.start();
        mediaPlayer.stop();
        setContentView(R.layout.activity_main);
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        point = new Point();
        display.getRealSize(point);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        stage = findViewById(R.id.stage);
        stage.setMainact(this);
        stage.setDisp(point.x, point.y);
        stage.settext1(tv1);
        stage.settext2(tv2);
        stage.move();
        button.stop();
        button.release();
        mediaPlayer.release();
    }
    public void endScreen(){
        setContentView(R.layout.title);
        button=MediaPlayer.create(this,R.raw.button);
        mediaPlayer=MediaPlayer.create(this,R.raw.mix2);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
}
