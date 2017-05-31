package com.drop.it.ui;

import android.app.Application;

import com.drop.it.R;
import com.drop.it.utils.Consts;

/**
 * Created by hadas on 31/05/2017.
 */

public class DropApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Consts.Environment.setEnvironment(getResources().getBoolean(R.bool.is_production));
    }
}
