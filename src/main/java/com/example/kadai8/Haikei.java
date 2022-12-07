package com.example.kadai8;

import android.graphics.Bitmap;

public class Haikei {
    int posXback;
    int posYback;
    int posXmove;
    Bitmap bitmap;
    public Haikei(int posXback,int posYback,Bitmap bitmap){
        this.posXback=posXback;
        this.posYback=posYback;
        this.bitmap=bitmap;
        this.posXmove = 5;
    }
}
