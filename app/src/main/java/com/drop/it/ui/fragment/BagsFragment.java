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

public class BagsFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bags, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.done_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DropFragment dropFragment = new DropFragment();
        dropFragment.setArguments(getArguments());

        ((MainActivity) getActivity()).openFragment(dropFragment);
    }
}
