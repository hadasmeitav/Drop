package com.drop.it.network.request;

import android.content.Context;
import android.os.Handler;

import com.drop.it.network.listener.IApiListener;
import com.drop.it.network.listener.IRequestCallback;
import com.drop.it.network.response.BaseResponseListener;
import com.drop.it.object.ContactDetails;
import com.drop.it.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by hadas on 30/05/2017.
 * Pretty much the same class as {@link UpdateContactDetailsRequest}, but on 'reality' it won't be
 */

public class DropBagsRequest extends BaseRequest {

    private ContactDetails mContactDetails;
    private String mAddress;
    private IApiListener mDropBagsListener;

    public DropBagsRequest(String url, int method, ContactDetails contactDetails,
                           String address, IApiListener listener) {
        super(url, method);

        mContactDetails = contactDetails;
        mAddress = address;
        mDropBagsListener = listener;
    }

    @Override
    public void generateRequest(final Context context) {
        //'Mocking' http request by random number (0 or 1)
        //This 'mocks' http post request to the server

        /**
         * On real implementation, i would pass to volley an instance of {@link BaseResponseListener}
         * and the content of the request will be the object below
         */

        JSONObject object = new JSONObject();
        try {
            object.put("contact_details", mContactDetails.toJson());
            object.put("address", mAddress);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BaseResponseListener responseListener =
                        new BaseResponseListener(new IRequestCallback() {
                            @Override
                            public void onResultSuccess() {
                                mDropBagsListener.onUpdateSuccessfully();
                            }

                            @Override
                            public void onResultError() {
                                mDropBagsListener.onUpdateError();
                            }
                        });

                //rolling number(0 or 1) in order to mock success/failure
                responseListener.onResponse(Utils.loadJSONFromAsset(context,
                        new Random().nextInt(2) == 1));
            }
        }, 2000);
    }
}
