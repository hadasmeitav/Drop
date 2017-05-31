package com.drop.it.model;

import android.content.Context;

import com.drop.it.network.listener.IApiListener;
import com.drop.it.network.Method;
import com.drop.it.network.request.UpdateContactDetailsRequest;
import com.drop.it.object.ContactDetails;

/**
 * Created by hadas on 30/05/2017.
 */

public class ContactModel implements IContactModel {

    @Override
    public void updateContactDetails(Context context, ContactDetails contactDetails,
                                     IApiListener listener) {
        UpdateContactDetailsRequest request = new UpdateContactDetailsRequest(
                "http://api/contact_details", Method.POST, contactDetails, listener);
        request.generateRequest(context);
    }
}
