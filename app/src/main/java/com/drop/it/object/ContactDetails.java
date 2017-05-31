package com.drop.it.object;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hadas on 30/05/2017.
 */

public class ContactDetails {

    private String mName;
    private String mPhone;
    private String mEmail;

    public ContactDetails(String name, String phone, String email) {
        mName = name;
        mPhone = phone;
        mEmail = email;
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getEmail() {
        return mEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ContactDetails)) {
            return false;
        }

        ContactDetails details = (ContactDetails) o;

        return mName.equals(details.getName()) && mPhone.equals(details.getPhone()) &&
                mEmail.equals(details.getEmail());
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        try {
            object.put("name", mName);
            object.put("phone", mPhone);
            object.put("email", mEmail);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }
}
