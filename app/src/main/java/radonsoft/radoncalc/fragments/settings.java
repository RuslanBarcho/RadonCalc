package radonsoft.radoncalc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class settings extends Fragment {

    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_settings, container, false);
        MainActivity ma = new MainActivity();
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.settings_title));
        ma.pages = 3;
        return mRootView;
    }

}
