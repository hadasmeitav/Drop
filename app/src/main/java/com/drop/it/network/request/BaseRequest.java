package com.drop.it.network.request;

import android.content.Context;

/**
 * Created by hadas on 30/05/2017.
 */

public abstract class BaseRequest {

    protected String mUrl;
    protected int mMethod;

    public BaseRequest(String url, int method) {
        mUrl = url;
        mMethod = method;
    }

    public abstract void generateRequest(Context context);
}
