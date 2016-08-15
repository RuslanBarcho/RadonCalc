package radonsoft.radoncalc.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import radonsoft.radoncalc.Helpers.Global;
import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class settings extends Fragment {

    private View mRootView;
    private FrameLayout settingsAbout;
    private FrameLayout settingsAngle;
    private FrameLayout settingsHaptic;
    private TextView settingsAngleStat;
    private Switch vibrationSwitch;
    MainActivity ma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_settings, container, false);
        ma = new MainActivity();
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.settings_title));
        ma.pages = 3;
        settingsAbout = (FrameLayout) mRootView.findViewById(R.id.settingsAbout);
        settingsAngle = (FrameLayout) mRootView.findViewById(R.id.settingsAngle);
        settingsHaptic = (FrameLayout) mRootView.findViewById(R.id.settingsHaptic);
        settingsAngleStat = (TextView) mRootView.findViewById(R.id.settingsAngleStat);
        vibrationSwitch = (Switch) mRootView.findViewById(R.id.switchVibration);
        if (Global.vibrationSwitcher){
            vibrationSwitch.setChecked(true);
        }
        settingsAngleStat.setText(Global.saveDegreeStatus);
        settingsAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutWindow();
            }
        });

        settingsAngle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String degreeChecker = settingsAngleStat.getText().toString();
                if (degreeChecker.equals("RAD")) {
                    settingsAngleStat.setText("DEG");
                } else {
                    settingsAngleStat.setText("RAD");
                }
                Global.saveDegreeStatus = settingsAngleStat.getText().toString();
            }
        });

        settingsHaptic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.vibrationSwitcher){
                    vibrationSwitch.setChecked(false);
                    Global.vibrationSwitcher = false;
                }
                else {
                    vibrationSwitch.setChecked(true);
                    Global.vibrationSwitcher = true;
                }
            }
        });

        vibrationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Global.vibrationSwitcher = true;
                } else {
                    Global.vibrationSwitcher = false;
                }
            }
        });

        return mRootView;
    }

    private void showAboutWindow(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ErrorDialogTheme);
        builder.setTitle(R.string.settings_about);
        builder.setMessage(R.string.settings_about_window);
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