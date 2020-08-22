package com.prography.myapplication.mvp.contract.presenter;

import com.prography.myapplication.R;
import com.prography.myapplication.mvp.contract.MvpContract;
import com.prography.myapplication.mvp.model.MvpViewXY;

public class Presenter implements MvpContract.Presenter {
    private MvpContract.View view;
    private MvpViewXY viewXY = new MvpViewXY();

    @Override
    public void setView(MvpContract.View view) {
        this.view = view;
    }

    @Override
    public void onClick(int id) {
        float changeX;
        float changeY;
        switch (id){
            case R.id.leftTop :
                changeX = viewXY.getViewX()-30;
                changeY = viewXY.getViewY()-30;

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.top :
                changeX = viewXY.getViewX();
                changeY = viewXY.getViewY()-30;

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.rightTop :
                changeX = viewXY.getViewX()+30;
                changeY = viewXY.getViewY()-30;

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.left:
                changeX = viewXY.getViewX()-30;
                changeY = viewXY.getViewY();

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.right:
                changeX = viewXY.getViewX()+30;
                changeY = viewXY.getViewY();

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.leftBottom :
                changeX = viewXY.getViewX()-30;
                changeY = viewXY.getViewY()+30;

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.bottom:
                changeX = viewXY.getViewX();
                changeY = viewXY.getViewY()+30;

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            case R.id.rightBottom:
                changeX = viewXY.getViewX()+30;
                changeY = viewXY.getViewY()+30;

                view.setPosition(changeX, changeY);
                viewXY.updateXY(changeX, changeY);
                break;

            default:
                break;
        }
    }
}
