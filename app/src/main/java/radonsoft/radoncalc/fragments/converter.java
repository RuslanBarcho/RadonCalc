package radonsoft.radoncalc.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class converter extends Fragment {
    private View mRootView;

    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button dotButton;
    private Button equalButton;
    private Button delButton;
    private ImageButton setButton;
    private Button signButton;

    private Spinner spinner1;
    private Spinner spinner2;

    final int MENU_TYPE_LENGTH = 1;
    final int MENU_COLOR_WEIGHT = 2;

    String[] length = {"Centimeter", "Meter", "Kilometer"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_converter, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Unit Converter");

        oneButton = (Button) mRootView.findViewById(R.id.button20);
        twoButton = (Button) mRootView.findViewById(R.id.button21);
        threeButton = (Button) mRootView.findViewById(R.id.button22);
        fourButton = (Button) mRootView.findViewById(R.id.button31);
        fiveButton = (Button) mRootView.findViewById(R.id.button30);
        sixButton = (Button) mRootView.findViewById(R.id.button29);
        sevenButton = (Button) mRootView.findViewById(R.id.button32);
        eightButton = (Button) mRootView.findViewById(R.id.button33);
        nineButton = (Button) mRootView.findViewById(R.id.button34);
        dotButton = (Button) mRootView.findViewById(R.id.button35);
        zeroButton = (Button) mRootView.findViewById(R.id.button36);
        signButton = (Button) mRootView.findViewById(R.id.button37);
        delButton = (Button) mRootView.findViewById(R.id.button38);
        setButton = (ImageButton) mRootView.findViewById(R.id.button39);
        equalButton = (Button) mRootView.findViewById(R.id.button41);

        registerForContextMenu(setButton);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        setFont(oneButton, "robotolight.ttf");
        setFont(twoButton, "robotolight.ttf");
        setFont(threeButton, "robotolight.ttf");
        setFont(fourButton, "robotolight.ttf");
        setFont(fiveButton, "robotolight.ttf");
        setFont(sixButton, "robotolight.ttf");
        setFont(sevenButton, "robotolight.ttf");
        setFont(eightButton, "robotolight.ttf");
        setFont(nineButton, "robotolight.ttf");
        setFont(dotButton, "robotolight.ttf");
        setFont(zeroButton, "robotolight.ttf");
        setFont(signButton, "robotolight.ttf");
        setFont(delButton, "robotolight.ttf");
        setFont(equalButton, "robotolight.ttf");

        spinner1 = (Spinner) mRootView.findViewById(R.id.spinner);
        spinner2 = (Spinner) mRootView.findViewById(R.id.spinner2);

        addItemsOnSpinner(length, spinner1);
        addItemsOnSpinner(length, spinner2);



        return mRootView;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.button39:
                menu.add(0, MENU_TYPE_LENGTH, 0, "Length");
                menu.add(0, MENU_COLOR_WEIGHT, 0, "Weigth");
                break;
        }
    }
    public void setFont(Button toChange, String style){
        toChange.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,style));
    }
    public void addItemsOnSpinner(String[] toAdd, Spinner toAddIn){

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, toAdd);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        toAddIn.setAdapter(dataAdapter);

    }
}
