package com.drop.it.model;

import android.content.Context;

import com.drop.it.network.listener.IApiListener;
import com.drop.it.object.ContactDetails;

/**
 * Created by hadas on 30/05/2017.
 */

public interface IContactModel {

    void updateContactDetails(Context context, ContactDetails contactDetails,
                              IApiListener listener);
}
