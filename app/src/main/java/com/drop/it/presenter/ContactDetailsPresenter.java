package com.drop.it.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.drop.it.model.ContactModel;
import com.drop.it.network.listener.IApiListener;
import com.drop.it.object.ContactDetails;

/**
 * Created by hadas on 30/05/2017.
 */

public class ContactDetailsPresenter extends BasePresenter {

    private ContactModel mContactModel;

    public void onSubmit(Context context, String name, String phone, String email) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        ContactDetails savedDetails = getContactDetails(context);
        ContactDetails newDetails = new ContactDetails(name, phone, email);
        if (savedDetails.equals(newDetails))
            return;

        prefs.edit().putString(KEY_CONTACT_NAME, newDetails.getName()).commit();
        prefs.edit().putString(KEY_CONTACT_PHONE, newDetails.getPhone()).commit();
        prefs.edit().putString(KEY_CONTACT_EMAIL, newDetails.getEmail()).commit();

        mContactModel = new ContactModel();
        mContactModel.updateContactDetails(context, newDetails, new IApiListener() {
            @Override
            public void onUpdateSuccessfully() {
                //In this case - do nothing.
            }

            @Override
            public void onUpdateError() {
                //TODO sync contact details again
            }
        });
    }
}
