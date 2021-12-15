package com.example.snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.snake.Constants;
import com.example.snake.R;
import com.example.snake.Grass;

import java.util.ArrayList;

public class GameView extends View {
    private Bitmap bmTile1;
    private Bitmap bmTile2;
//    private final Bitmap bmSnake;
    public static int sizeOfMap = 75* Constants.screenWidth/1080;
    private final int h = 12;
    private final int w = 12;
    private final ArrayList<Grass> arrGrass = new ArrayList<>();

    public GameView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        bmTile1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.tile);
        bmTile1 = Bitmap.createScaledBitmap(bmTile1, sizeOfMap, sizeOfMap, true);
        bmTile2 = BitmapFactory.decodeResource(this.getResources(),R.drawable.tile2);
        bmTile2 = Bitmap.createScaledBitmap(bmTile2, sizeOfMap, sizeOfMap, true);
        //left of here bmSnake = Bitmap.createdScaledBitmap(bmSnake,14 sizeOfMap, sizeOfMap, true);

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w;j++){
                if((i+j)%2 == 0){
                    arrGrass.add (new Grass(bmTile1,j*sizeOfMap + Constants.screenWidth/2-(w/2)*sizeOfMap,
                            i*sizeOfMap+100*Constants.screenHeight/1920, sizeOfMap,sizeOfMap));
                }//end of if statement
                else{
                    arrGrass.add(new Grass(bmTile2,j*sizeOfMap + Constants.screenWidth/2-(w/2)*sizeOfMap,
                            i*sizeOfMap+100*Constants.screenHeight/1920, sizeOfMap,sizeOfMap));
                }
            }//end of inner for loop
        }//end of outer for loop
    }//end of GameView method

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(0xFF1B602);
        for (int i = 0; i < arrGrass.size(); i++){
            canvas.drawBitmap(arrGrass.get(i).getBm(), arrGrass.get(i).getX(), arrGrass.get(i).getY(), null);
        }
       // snake.draw(canvas);
    }//end of class draw
}// end of class GameView