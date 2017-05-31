package com.drop.it.model;

import android.content.Context;

import com.drop.it.network.Method;
import com.drop.it.network.listener.IApiListener;
import com.drop.it.network.request.DropBagsRequest;
import com.drop.it.object.ContactDetails;

/**
 * Created by hadas on 30/05/2017.
 */

public class DropBagsModel implements IDropBagsModel {

    @Override
    public void drop(Context context, ContactDetails contactDetails, String address,
                     IApiListener listener) {
        DropBagsRequest request = new DropBagsRequest(
                "http://api/drop_bags", Method.POST, contactDetails, address, listener);
        request.generateRequest(context);
    }
}
