package com.prography.myapplication.mvp.contract.presenter;

import android.app.Activity;

import com.prography.myapplication.R;
import com.prography.myapplication.mvp.contract.MvpContract;
import com.prography.myapplication.mvp.model.MvpViewXY;
import com.prography.myapplication.util.Util;

public class Presenter implements MvpContract.Presenter {
    private MvpContract.View view;
    private MvpViewXY viewXY;

    @Override
    public void setView(MvpContract.View view) {
        this.view = view;
    }

    @Override
    public void initModel(float x, float y) {
        viewXY = new MvpViewXY(x,y);
        view.setPosition(x,y);
    }

    @Override
    public void changeVIew(float x, float y) {
        float changeX = viewXY.getViewX() + x;
        float changeY = viewXY.getViewY() + y;

        viewXY.updateXY(changeX, changeY);
        view.setPosition(changeX, changeY);
    }


}
