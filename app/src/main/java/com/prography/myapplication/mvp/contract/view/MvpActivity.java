package com.prography.myapplication.mvp.contract.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.myapplication.R;
import com.prography.myapplication.mvp.contract.MvpContract;
import com.prography.myapplication.mvp.contract.presenter.Presenter;
import com.prography.myapplication.util.Util;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class MvpActivity extends AppCompatActivity implements MvpContract.View, View.OnClickListener{

    private MvpContract.Presenter presenter;
    private View view;
    private float touchX;
    private float touchY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter();
        presenter.setView(this);

        //초기화
        initialized();

    }

    private void initialized() {
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
        presenter.onClick(id);

    }

    @Override
    public void setPosition(float x, float y) {
        view.setX(x);
        view.setY(y);
    }
}
