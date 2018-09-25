package com.sniper.music.home.mvp;

import android.support.annotation.NonNull;

import com.sniper.music.base.mvp.BasePresenter;

public class DefaultHomePresenter extends BasePresenter<HomePresenter.View> implements HomePresenter {

    public DefaultHomePresenter(@NonNull HomePresenter.View view) {
        super(view);
    }

    @Override
    public void destroy() {
        clearAllDisposables();
    }
}
