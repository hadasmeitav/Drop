package com.drop.it.presenter;

import android.content.Context;

import com.drop.it.model.DropBagsModel;
import com.drop.it.network.listener.IApiListener;

/**
 * Created by hadas on 30/05/2017.
 */

public class DropBagsPresenter extends BasePresenter {

    public void onSubmit(Context context, String address, IApiListener listener) {
        DropBagsModel model = new DropBagsModel();
        model.drop(context, getContactDetails(context), address, listener);
    }

}
