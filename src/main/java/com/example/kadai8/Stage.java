package com.example.kadai8;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Stage<bit> extends View  {
    MainActivity mainActivity;
    MediaPlayer gagan;
    MediaPlayer goal;
    MediaPlayer goal2;
    MediaPlayer jumpse;
    MediaPlayer dash;
    MediaPlayer no1;
    MediaPlayer mix;
    TextView tv1;;
    TextView tv2;;
    long stime,tim;
    String st;
    Bitmap bitmap;
    Bitmap bitmap1;
    Bitmap bitmap2;
    Bitmap bitmap3;
    Bitmap bitmap4;
    Bitmap bitmap5;
    Bitmap bitmap6;
    Bitmap bitmap7;
    Bitmap bitmap8;
    Bitmap bitmap9;
    Bitmap bitmap10;
    Bitmap bitmap11;
    Bitmap bitmap12;
    Bitmap bitmap13;
    Bitmap bitmap14;
    Bitmap bitmap15;
    Bitmap bitmap16;
    Bitmap bitmap17;
    Bitmap bitmap18;
    Bitmap bitmap19;
    Bitmap bitmap20;
    Bitmap bitmapA[]=new Bitmap[5];
    float posX;
    float posY;
    float posX2;
    float posY2;
    float posX3;
    float posY3;
    float posXup;
    float posYup;
    float startX;
    float startY;
    float posXgoal;
    float posYgoal;
    float posXback;
    float noX;
    float noY;
    float downX;
    float downY;
    float sunX;
    float sunY;
    float maxjump;
    boolean down;
    boolean jumping;
    boolean kasoku;
    boolean gensoku;
    boolean time;
    boolean timerget;
    Paint paint;
    int width;
    int height;
    int dy;
    int dx;
    int dx2;
    int dy2;
    int i;
    int j;
    int t;
    int s;
    int u;
    Thread thread;
    Thread thread1;
    Thread thread2;
    Handler handler;
    ArrayList<Haikei> list;
    int count, period;
    SimpleDateFormat dataFormat;
    public Stage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.run2);
        bitmap1 = Bitmap.createScaledBitmap(bitmap1, 300, 300, true);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.run3);
        bitmap2 = Bitmap.createScaledBitmap(bitmap2, 300, 300, true);
        bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.jump1);
        bitmap3 = Bitmap.createScaledBitmap(bitmap3, 300, 300, true);
        bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.brock1);
        bitmap4 = Bitmap.createScaledBitmap(bitmap4, 500, 30, true);
        bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.up);
        bitmap5 = Bitmap.createScaledBitmap(bitmap5, 200, 200, true);
        bitmap6 = BitmapFactory.decodeResource(getResources(), R.drawable.back1);
        bitmap6 = Bitmap.createScaledBitmap(bitmap6, 300, 400, true);
        bitmap7 = BitmapFactory.decodeResource(getResources(), R.drawable.kumo1);
        bitmap7 = Bitmap.createScaledBitmap(bitmap7, 250, 150, true);
        bitmap8 = BitmapFactory.decodeResource(getResources(), R.drawable.goal);
        bitmap8 = Bitmap.createScaledBitmap(bitmap8, 800, 900, true);
        bitmap9 = BitmapFactory.decodeResource(getResources(), R.drawable.goal2);
        bitmap9 = Bitmap.createScaledBitmap(bitmap9, 1900, 1200, true);
        bitmap10 = BitmapFactory.decodeResource(getResources(), R.drawable.no1);
        bitmap10 = Bitmap.createScaledBitmap(bitmap10, 1000, 1800, true);
        bitmap11 = BitmapFactory.decodeResource(getResources(), R.drawable.no2);
        bitmap11 = Bitmap.createScaledBitmap(bitmap11, 1000, 1800, true);
        bitmap12 = BitmapFactory.decodeResource(getResources(), R.drawable.no3);
        bitmap12 = Bitmap.createScaledBitmap(bitmap12, 1000, 1800, true);
        bitmap13 = BitmapFactory.decodeResource(getResources(), R.drawable.start);
        bitmap13 = Bitmap.createScaledBitmap(bitmap13, 800, 900, true);
        bitmap14 = BitmapFactory.decodeResource(getResources(), R.drawable.brock1);
        bitmap14 = Bitmap.createScaledBitmap(bitmap14, 400, 320, true);
        bitmap15 = BitmapFactory.decodeResource(getResources(), R.drawable.go);
        bitmap15 = Bitmap.createScaledBitmap(bitmap15, 1000, 1800, true);
        bitmap16 = BitmapFactory.decodeResource(getResources(), R.drawable.down);
        bitmap16 = Bitmap.createScaledBitmap(bitmap16, 200, 200, true);
        bitmap17 = BitmapFactory.decodeResource(getResources(), R.drawable.run5);
        bitmap17 = Bitmap.createScaledBitmap(bitmap17, 300, 300, true);
        bitmap18 = BitmapFactory.decodeResource(getResources(), R.drawable.run6);
        bitmap18 = Bitmap.createScaledBitmap(bitmap18, 300, 300, true);
        bitmap19 = BitmapFactory.decodeResource(getResources(), R.drawable.taiki);
        bitmap19 = Bitmap.createScaledBitmap(bitmap19, 350, 390, true);
        bitmap20 = BitmapFactory.decodeResource(getResources(), R.drawable.sun2);
        bitmap20 = Bitmap.createScaledBitmap(bitmap20, 300, 300, true);
        posX = 10;
        posY = 800;
        posX2 = 1400;
        posY2 = 700;
        posX3 = 2400;
        posY3 = 800;
        posXup=2100;
        posYup=100;
        posXgoal=-30;
        posYgoal=300;
        startX=0;
        startY=200;
        sunX=1500;
        sunY=50;
        noX=2000;
        noY=0;
        downX=2800;
        downY=420;
        maxjump=posY-600;
        dy=0;
        dx=8;
        dx2=50;
        dy2=10;
        down=true;
        jumping=false;
        kasoku=false;
        gensoku=false;
        time=true;
        timerget=true;
        u=0;
        paint = new Paint();
        bitmap=bitmap1;
        handler=new Handler();
        list=new ArrayList<>();
        list.add(new Haikei(20600,200,bitmap8));
        list.add(new Haikei(400,720,bitmap6));
        list.add(new Haikei(1600,700,bitmap6));
        list.add(new Haikei(3400,720,bitmap6));
        list.add(new Haikei(7000,700,bitmap6));
        list.add(new Haikei(8600,700,bitmap6));
        list.add(new Haikei(9000,700,bitmap6));
        list.add(new Haikei(12500,700,bitmap6));
        list.add(new Haikei(14500,700,bitmap6));
        list.add(new Haikei(16600,700,bitmap6));
        list.add(new Haikei(21000,700,bitmap6));
        list.add(new Haikei(800,280,bitmap7));
        list.add(new Haikei(2100,270,bitmap7));
        list.add(new Haikei(3800,280,bitmap7));
        list.add(new Haikei(6000,270,bitmap7));
        list.add(new Haikei(8200,260,bitmap7));
        list.add(new Haikei(10800,260,bitmap7));
        list.add(new Haikei(12000,230,bitmap7));
        list.add(new Haikei(14600,270,bitmap7));
        list.add(new Haikei(17100,260,bitmap7));
        list.add(new Haikei(18600,230,bitmap7));
        list.add(new Haikei(19000,270,bitmap7));
        list.add(new Haikei(21300,230,bitmap7));
        bitmapA[0]=bitmap12;
        bitmapA[1]=bitmap11;
        bitmapA[2]=bitmap10;
        bitmapA[3]=bitmap15;
        bitmapA[4]=bitmap16;
        t=0;
        s=0;
        count = 0;
        period = 100;
        jumpse = MediaPlayer.create(context.getApplicationContext(), R.raw.jump05);
        jumpse.setVolume(0.10f,0.10f);
        gagan = MediaPlayer.create(context.getApplicationContext(), R.raw.down);
        gagan.setVolume(0.10f,0.10f);
        goal = MediaPlayer.create(context.getApplicationContext(), R.raw.goal);
        goal.setVolume(0.10f,0.10f);
        goal2 = MediaPlayer.create(context.getApplicationContext(), R.raw.jump11);
        goal2.setVolume(0.10f,0.10f);
        dash = MediaPlayer.create(context.getApplicationContext(), R.raw.dash);
        dash.setVolume(0.50f,0.50f);
        no1 = MediaPlayer.create(context.getApplicationContext(), R.raw.kaisi);
        no1.setVolume(0.20f,0.20f);
        mix = MediaPlayer.create(context.getApplicationContext(), R.raw.mix);
        mix.setVolume(2.0f,2.0f);
        dataFormat = new SimpleDateFormat("mm:ss.SS", Locale.JAPAN);
    }
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap20, sunX, sunY, paint);
        for(j=0;j<list.size();j++){
            canvas.drawBitmap(list.get(j).bitmap,
                    posXback=list.get(j).posXback,
                    list.get(j).posYback,paint);
        }
        if(startX>=-800){
            canvas.drawBitmap(bitmap13, startX, startY, paint);
        }
        if(list.get(0).posXback>=1900){
            canvas.drawBitmap(bitmap4, posX2, posY2, paint);
        }
        if(list.get(0).posXback>=1300){
            canvas.drawBitmap(bitmap4, posX2, posY2, paint);
            canvas.drawBitmap(bitmap14, posX3, posY3, paint);
            canvas.drawBitmap(bitmap5, posXup, posYup, paint);
            canvas.drawBitmap(bitmapA[4], downX, downY, paint);
        }
        if(posX>=100){
            canvas.drawBitmap(bitmap9, posXgoal, posYgoal, paint);
            goal.start();
            mix.stop();
            goal2.start();
        }
        canvas.drawBitmap(bitmapA[t], noX, noY, paint);
        canvas.drawBitmap(bitmap, posX, posY, paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(posX<=100){
                    if(jumping==false){
                        jumpse.start();
                        dy=-1;
                    }
                }
                break;
        }
        return  false;
    }
    public void move() {
        tv2.setText(dataFormat.format(0));
        bitmap=bitmap19;
        tv1.setTextSize(40);
        tv1.setTextColor(Color.BLACK);
        tv1.setText("画面タッチでジャンプ");
        thread=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    tv1.setText("");
                    no1.start();
                    while(t<=3){
                        noX=2000;
                        while(noX>=-900){
                            sleep(10);
                            noX-=40;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    invalidate();
                                }
                            });
                        }
                        t++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mix.start();
                stime=System.currentTimeMillis();
                timer();
                while(list.get(0).posXback>=100) {
                    try {
                        sleep(10);
                        u++;
                        if(u>=5800){
                            list.get(0).posXback=-2000;
                            posX=2600;
                        }
                        if(list.get(0).posXback<=1900){
                            posX2=5000;
                        }
                        if(posX+200>=posXup && posX<=posXup+20 &&
                                posY+300<=posYup+250  ) {
                            gensoku=false;
                            kasoku=true;
                            itemget();
                        }
                        if(posX+200>=downX && posX<=downX+20 &&
                                posY+300>=downY+250 && posY<=downY) {
                            kasoku=false;
                            gensoku=true;
                            itemget();
                        }
                            if(posX+280>=posX3 && posX<=posX3+380 && posY>=posY3
                                    && posY+280<=posY3+300 ){
                                dx=0;
                                for (i = 0; i < list.size(); i++) {
                                    list.get(i).posXback-=dx;
                                }
                            }
                        if(dx==0){
                            if(posX+280>=posX3 && posX<=posX3+380 && posY+280<posY3){
                                dx=8;
                            }
                        }
                        for (i = 0; i < list.size(); i++) {
                            list.get(i).posXback-=dx;
                        }
                        posX2 -= dx;
                        posX3-=dx;
                        posXup-= dx;
                        downX-=dx;
                        startX -= dx;
                        if (posX3 <= -600) { posX3=1800;}
                        if(posXup<=-600){posXup=2400;}
                        if(posX2<=-600){posX2=1800;}
                        if (downX<=-600){downX=2000;}
                            switch (dy) {
                            case 0:
                                if(bitmap==bitmap1) {
                                    bitmap = bitmap2;
                                }
                                else{
                                    bitmap=bitmap1;
                                }
                                if (posY + 300 >= posY2 && posY + 300 <= posY2 + 50 && posX > posX2 + 480) {
                                    dy = 1;
                                }
                                if(posY+300>=posY3 && posY+300<=posY3+50 && posX>posX3+380){
                                    dy=1;
                                }
                                break;
                            case 1:
                                fall();
                                break;
                            case -1:
                                up();
                                break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            invalidate();
                            if(tim>=60000){
                                try {
                                    dx=0;
                                    gameover();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
                while(posX<2500){
                    try {
                        if(dy!=0){
                            posY+=dx2;
                        }
                        if (posY>=780){
                            dy=0;
                            dy2=0;
                        }
                        sleep(100);
                        if(posX>=200){
                            if(bitmap==bitmap17){
                                bitmap=bitmap18;
                            }
                            else{
                                bitmap=bitmap17;
                            }
                        }
                        posX+=dx2;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            invalidate();
                        }
                    });
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gagan.stop();
                        goal.stop();
                        goal2.stop();
                        jumpse.stop();
                        dash.stop();
                        no1.stop();
                        mix.stop();
                        mainActivity.endScreen();
                    }
                });
            }
        };
        thread.start();
    }
    public void up(){
        jumping=true;
        bitmap=bitmap3;
        posY-=dy2;
        if(posY<=maxjump){
            dy=1;
        }
    }
    public void fall(){
        jumping=true;
            posY+=dy2;
        if(posX+280>=posX3 && posY+300>posY3 && posX+280<posX3+15 ){
            dx=0;
            for (i = 0; i < list.size(); i++) {
                list.get(i).posXback-=dx;
            }
        }
        if(posY+280>=posY2 && posX<=posX2+480 && posX+300>=posX2 && posY+280<posY2+20){
                maxjump=posY-600;
                dy=0;
                jumping=false;
                bitmap=bitmap1;
            }
            if(posY>=800){
                maxjump=posY-600;
                dy=0;
                jumping=false;
                bitmap=bitmap1;
            }
        if(posY+280>=posY3 && posX<=posX3+380 && posX+300>=posX3 && posY+280<posY3+20){
            maxjump=posY-600;
            dy=0;
            jumping=false;
            bitmap=bitmap1;
        }
    }
    public void itemget(){
        thread1=new Thread(){
            @Override
            public void run() {
                if (kasoku==true){
                    dash.start();
                    posXup=3500;
                    dx=13;
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dx=8;
                    kasoku=false;
                }
                if (gensoku==true){
                    gagan.start();
                    downX=3500;
                    dx=4;
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dx=8;
                    gensoku=false;
                }
            }
        };
        thread1.start();
    }
    public void setDisp(int x, int y) { this.width = x;this.height = y; }
    public void settext1(TextView tv1){ this.tv1=tv1; }
    public void settext2(TextView tv2){ this.tv2=tv2; }
    public void setMainact(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }
    public void gameover() throws InterruptedException {
        dx=0;
        gagan.stop();
        goal.stop();
        goal2.stop();
        jumpse.stop();
        dash.stop();
        no1.stop();
        mix.stop();
        setBackgroundColor(Color.BLACK);
        tv1.setTextColor(Color.RED);
        tv1.setTextSize(100);
        tv1.setText("GAME OVER");
    }
    public void timer(){
        thread2=new Thread(){
            @Override
            public void run() {
                while(tim<=60000){
                    try {
                        sleep(50);
                        tim=System.currentTimeMillis()-stime;
                        tv2.setText(dataFormat.format(tim));
                        if(posX>=100){
                            break;
                        }
                        if(tim>=55000){
                            tv2.setTextColor(Color.RED);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tv2.setTextColor(Color.RED);
            }
        };
        thread2.start();
    }
}