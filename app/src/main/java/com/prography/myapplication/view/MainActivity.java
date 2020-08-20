package com.prography.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.prography.myapplication.R;
import com.prography.myapplication.util.Util;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private View view;
    private View touchView;
    private float touchX;
    private float touchY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.noStatusBar(this, R.layout.activity_main);

        Initialized();

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 뷰의 부모의 넓이, 높이 (touchView)
                int touchViewWidth = ((ViewGroup)v.getParent()).getWidth();
                int touchViewHeight = ((ViewGroup)v.getParent()).getHeight();

                //뷰의 넓이
                int viewWidth = v.getWidth();
                int viewHeight = v.getHeight();

                int action = event.getAction();

                // 전체화면에서 뷰의 시작점
                float curX = v.getX();
                float curY = v.getY();

                // 전체화면에서 뷰의 절대 좌표
                float absX = event.getRawX();
                float absY = event.getRawY();

                switch(action) {
                    case ACTION_DOWN :
                        // 터치 뷰 안에 클릭된 곳의 좌표
                        touchX = event.getX();
                        touchY = event.getY();

                        System.out.println("현재좌표" + touchX +"," + touchY);
                        System.out.println("전체화면에서 뷰의 시작점" + curX +","+curY);
                        System.out.println("전체화면에서 뷰의 좌표(절대 좌표)" + absX +","+absY);
                        break;

                    case ACTION_UP:
                        if(v.getX() < 0){
                            v.setX(0);
                        }else if(v.getX() + viewWidth > touchViewWidth){
                            v.setX(touchViewWidth - viewWidth);
                        }

                        if(v.getY() < 0){
                            v.setY(0);
                        }else if(v.getY() + viewHeight > touchViewHeight){
                            v.setY(touchViewHeight - viewHeight);
                        }
                    case ACTION_MOVE:
                        // 드래그 하는곳의 좌표 값을 받아오면서 맨 처음 뷰를 터치한 좌표값 만큼 빼줘 얼만큼 이동했는지 체크
                        // 이동한 좌표값을 맨 처음 뷰의 시작점 좌표 값에 더해 줌
                        float moveX = event.getX() - touchX;
                        float moveY = event.getY() - touchY;
                        v.setX(curX + moveX);
                        v.setY(curY + moveY);
                }
                return true;
            }
        });
    }


    private void Initialized() {

        touchView = findViewById(R.id.touchView);
        view = findViewById(R.id.view);

        findViewById(R.id.leftTop).setOnClickListener(this);
        findViewById(R.id.top).setOnClickListener(this);
        findViewById(R.id.rightTop).setOnClickListener(this);
        findViewById(R.id.left).setOnClickListener(this);
        findViewById(R.id.click).setOnClickListener(this);
        findViewById(R.id.right).setOnClickListener(this);
        findViewById(R.id.leftBottom).setOnClickListener(this);
        findViewById(R.id.bottom).setOnClickListener(this);
        findViewById(R.id.rightBottom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id){

            
        }
    }
}