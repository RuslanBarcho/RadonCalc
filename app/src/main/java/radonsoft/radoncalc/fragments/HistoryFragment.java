package radonsoft.radoncalc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import radonsoft.radoncalc.R;

public class HistoryFragment extends Fragment {
    private View mRootView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_quadratic_equations, container, false);

        return mRootView;
    }

}