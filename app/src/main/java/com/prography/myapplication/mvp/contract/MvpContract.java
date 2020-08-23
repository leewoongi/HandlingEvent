package com.prography.myapplication.mvp.contract;

import android.app.Activity;

public interface MvpContract {
    /**
     * view와 presenter 인터페이스 구현
     */

    interface View {
        void setPosition(float x, float y);
    }

    interface Presenter {
        void setView(View view);
        void initModel(float x, float y);
        void changeVIew(float x, float y);
    }

}
