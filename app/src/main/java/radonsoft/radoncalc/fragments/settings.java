package radonsoft.radoncalc.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class settings extends Fragment {

    private View mRootView;
    private FrameLayout settingsAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_settings, container, false);
        MainActivity ma = new MainActivity();
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.settings_title));
        ma.pages = 3;
        settingsAbout = (FrameLayout) mRootView.findViewById(R.id.settingsAbout);

        settingsAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutWindow();
            }
        });

        return mRootView;
    }

    private void showAboutWindow(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ErrorDialogTheme);
        builder.setTitle("About");
        builder.setMessage("Some text about the best calc in the world");
        builder.setPositiveButton(R.string.calculator_button_ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
