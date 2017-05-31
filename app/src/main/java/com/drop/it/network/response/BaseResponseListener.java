package com.drop.it.network.response;

import com.drop.it.network.listener.IRequestCallback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hadas on 30/05/2017.
 */

public class BaseResponseListener {

    protected IRequestCallback mListener;

    public BaseResponseListener(IRequestCallback responseListener) {
        mListener = responseListener;
    }

    protected void triggerErrorCallback() {
        if (mListener == null)
            return;

        mListener.onResultError();
    }

    protected void triggerSuccessCallback() {
        if (mListener == null)
            return;

        mListener.onResultSuccess();
    }

    public void onResponse(Object object) {
        try {
            int status_code = -1;
            if (object != null)
                try {
                    if (object instanceof Integer) {
                        status_code = ((Integer) object).intValue();
                    } else {
                        JSONObject jsonObject = object instanceof JSONObject ?
                                (JSONObject) object : new JSONObject(object.toString());
                        status_code = jsonObject.has("status_code") ? jsonObject.getInt("status_code") : -1;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            if (isSuccess(status_code)) {
                triggerSuccessCallback();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        triggerErrorCallback();
    }

    public boolean isSuccess(int statusCode) {
        return (statusCode == 200 || statusCode == 201 || statusCode == 204);
    }
}
