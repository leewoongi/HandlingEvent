package com.prography.myapplication.mvp.contract.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.prography.myapplication.R;
import com.prography.myapplication.mvp.contract.MvpContract;
import com.prography.myapplication.mvp.contract.presenter.Presenter;
import com.prography.myapplication.util.Util;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class MvpActivity extends AppCompatActivity implements MvpContract.View, View.OnClickListener, View.OnTouchListener{

    private MvpContract.Presenter presenter;
    private View view;
    private ConstraintLayout parentView;

    private float touchX;
    private float touchY;
    private float parentWidth;
    private float ParentHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 모델과 상관없는 ui는 뷰에서 처리
        Util.noStatusBar(this);

        presenter = new Presenter();
        presenter.setView(MvpActivity.this);

        //초기화
        initialized();

        view.setOnTouchListener(this);
    }

    private void initialized() {
        view = findViewById(R.id.view);
        parentView = findViewById(R.id.touchView);

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
            case R.id.leftTop :
                presenter.changeVIew(-30, -30);
                break;

            case R.id.top :
                presenter.changeVIew(0, -30);
                break;

            case R.id.rightTop :
                presenter.changeVIew(30, -30);
                break;

            case R.id.left:
                presenter.changeVIew(-30, 0);
                break;

            case R.id.right:
                presenter.changeVIew(30, 0);
                break;

            case R.id.leftBottom :
                presenter.changeVIew(-30, 30);
                break;

            case R.id.bottom:
                presenter.changeVIew(0, 30);
                break;

            case R.id.rightBottom:
                presenter.changeVIew(30, 30);
                break;

            default:
                break;
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch(action) {
            case ACTION_DOWN:
                // 터치 뷰 안에 클릭된 곳의 좌표
                touchX = event.getX();
                touchY = event.getY();
                break;

            case ACTION_MOVE:

                // 드래그 하는곳의 좌표 값을 받아오면서 맨 처음 뷰를 터치한 좌표값 만큼 빼줘 얼만큼 이동했는지 체크
                // 이동한 좌표값을 맨 처음 뷰의 시작점 좌표 값에 더해 줌
                float moveX = event.getX() - touchX;
                float moveY = event.getY() - touchY;

                presenter.changeVIew(moveX,  moveY);
                break;

            default:
                break;
        }
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        parentWidth = parentView.getWidth();
        ParentHeight = parentView.getHeight();

        presenter.initModel(parentWidth/2 , ParentHeight/2);
    }

    @Override
    public void setPosition(float x, float y) {
        view.setX(x);
        view.setY(y);
    }
}
