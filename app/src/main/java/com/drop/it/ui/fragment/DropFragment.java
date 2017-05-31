package com.drop.it.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.drop.it.R;
import com.drop.it.network.listener.IApiListener;
import com.drop.it.presenter.DropBagsPresenter;
import com.drop.it.utils.Consts;

/**
 * Created by hadas on 30/05/2017.
 */

public class DropFragment extends BaseFragment implements View.OnClickListener {

    private ProgressBar mProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.done_button).setOnClickListener(this);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
    }

    @Override
    public void onClick(View v) {
        DropBagsPresenter presenter = new DropBagsPresenter();
        mProgressBar.setVisibility(View.VISIBLE);

        presenter.onSubmit(getActivity(), getArguments().getString(Consts.ADDRESS, null),
                new IApiListener() {
                    @Override
                    public void onUpdateSuccessfully() {
                        mProgressBar.setVisibility(View.GONE);

                        Toast.makeText(getActivity(), "Successfully dropped bags",
                                Toast.LENGTH_SHORT).show();

                        /**
                         * in real implementation : {@link com.drop.it.ui.activity.MainActivity}
                         * will do all the work regarding fragments.
                         */
                        FragmentManager manager = getActivity().getSupportFragmentManager();
                        manager.popBackStackImmediate();
                        manager.popBackStackImmediate();
                        manager.popBackStackImmediate();
                    }

                    @Override
                    public void onUpdateError() {
                        //TODO in reality, build retry mechanism for unsuccessful api requests
                        Toast.makeText(getActivity(), "Failed to drop bags",
                                Toast.LENGTH_SHORT).show();
                        mProgressBar.setVisibility(View.GONE);
                    }
                });
    }
}
