package com.drop.it.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.drop.it.presenter.ContactDetailsPresenter;
import com.drop.it.R;
import com.drop.it.object.ContactDetails;

/**
 * Created by hadas on 30/05/2017.
 */

public class ContactDetailsFragment extends BaseFragment implements View.OnClickListener {

    private TextInputLayout mNameLayout;
    private TextInputLayout mPhoneLayout;
    private TextInputLayout mEmailLayout;

    private EditText mNameEditText;
    private EditText mPhoneEditText;
    private EditText mEmailEditText;

    private ContactDetailsPresenter mContactDetailsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mContactDetailsPresenter = new ContactDetailsPresenter();

        mNameLayout = (TextInputLayout) view.findViewById(R.id.name_layout);
        mPhoneLayout = (TextInputLayout) view.findViewById(R.id.phone_layout);
        mEmailLayout = (TextInputLayout) view.findViewById(R.id.email_layout);

        mNameEditText = (EditText) view.findViewById(R.id.name);
        mPhoneEditText = (EditText) view.findViewById(R.id.phone);
        mEmailEditText = (EditText) view.findViewById(R.id.email);

        ContactDetails contactDetails = mContactDetailsPresenter.getContactDetails(getActivity());

        mNameEditText.setText(contactDetails.getName());
        mPhoneEditText.setText(contactDetails.getPhone());
        mEmailEditText.setText(contactDetails.getEmail());

        view.findViewById(R.id.submit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO reset error when there's a change in the text in edit text
        mNameLayout.setError(null);
        mPhoneLayout.setError(null);
        mEmailLayout.setError(null);

        if (mNameEditText.getText().length() == 0) {
            //TODO verify name is valid (at least x characters)
            mNameLayout.setError("name can't be blank");
            return;
        }

        if (mPhoneEditText.getText().length() == 0) {
            //TODO verify phone is valid (regex)
            mPhoneLayout.setError("phone can't be blank");
            return;
        }

        if (mEmailEditText.getText().length() == 0) {
            //TODO verify email is valid (regex)
            mEmailLayout.setError("email can't be blank");
            return;
        }

        //Input validity checks passed
        mContactDetailsPresenter.onSubmit(getActivity(), mNameEditText.getText().toString(),
                mPhoneEditText.getText().toString(), mEmailEditText.getText().toString());

        getActivity().onBackPressed();
    }
}
