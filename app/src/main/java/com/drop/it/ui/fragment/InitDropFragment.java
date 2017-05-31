package com.drop.it.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.drop.it.R;
import com.drop.it.ui.activity.MainActivity;

/**
 * Created by hadas on 30/05/2017.
 */

public class InitDropFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.drop_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /**
         * TODO check if contact details are set, and if not open {@link ContactDetailsFragment}
         */
        ((MainActivity) getActivity()).openFragment(new AddressFragment());
    }
}
