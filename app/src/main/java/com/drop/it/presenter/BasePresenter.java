package com.drop.it.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.drop.it.object.ContactDetails;

/**
 * Created by hadas on 30/05/2017.
 */

public class BasePresenter {

    protected static final String KEY_CONTACT_NAME = "om.drop.it.ui.utils.Preferences.contact_name";
    protected static final String KEY_CONTACT_PHONE = "om.drop.it.ui.utils.Preferences.contact_phone";
    protected static final String KEY_CONTACT_EMAIL = "om.drop.it.ui.utils.Preferences.contact_email";

    public ContactDetails getContactDetails(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return new ContactDetails(prefs.getString(KEY_CONTACT_NAME, ""),
                prefs.getString(KEY_CONTACT_PHONE, ""),
                prefs.getString(KEY_CONTACT_EMAIL, ""));
    }
}
