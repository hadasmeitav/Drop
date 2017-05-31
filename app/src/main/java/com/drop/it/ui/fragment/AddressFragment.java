package com.drop.it.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.drop.it.R;
import com.drop.it.utils.Consts;
import com.drop.it.ui.activity.MainActivity;

/**
 * Created by hadas on 30/05/2017.
 */

public class AddressFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_address, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.next_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //TODO check input validity

        TextInputLayout addressLayout = (TextInputLayout) getView().findViewById(R.id.address_layout);
        addressLayout.setError(null);

        EditText editText = (EditText) getView().findViewById(R.id.address);
        if (TextUtils.isEmpty(editText.getText())) {
            addressLayout.setError("address can't be empty");
            return;
        }

        BagsFragment bagsFragment = new BagsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Consts.ADDRESS, editText.getText().toString());
        bagsFragment.setArguments(bundle);

        ((MainActivity) getActivity()).openFragment(bagsFragment);
    }
}
