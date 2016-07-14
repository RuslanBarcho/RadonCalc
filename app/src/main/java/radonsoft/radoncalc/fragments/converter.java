package radonsoft.radoncalc.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class converter extends Fragment {
    private View mRootView;

    private TextView inputWindow;
    private TextView outputWindow;

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

    private String chooseValue;
    private String firstMeasure;
    private String secondMeasure;


    String[] length = {"Centimeter", "Meter", "Kilometer"};
    String[] weight = {"Gram", "Kilogram", "Ton"};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity ma = new MainActivity();
        mRootView = inflater.inflate(R.layout.fragment_converter, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Unit Converter");

        inputWindow = (TextView) mRootView.findViewById(R.id.textView6);
        outputWindow = (TextView) mRootView.findViewById(R.id.textView8);

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

        spinner1 = (Spinner) mRootView.findViewById(R.id.spinner2);
        spinner2 = (Spinner) mRootView.findViewById(R.id.spinner);

        addItemsOnSpinner(length, spinner1, 1);
        addItemsOnSpinner(length, spinner2, 2);
        chooseValue = "Length";

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showValueChooseDialog();
            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "1");
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "2");
            }
        });


        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConverterSolver solver = new ConverterSolver();
                solver.valueID = chooseValue;
                solver.measureOneID = firstMeasure;
                solver.measureTwoID = secondMeasure;
                solver.inputValue = new BigDecimal(inputWindow.getText().toString());
                solver.convert();
                outputWindow.setText(solver.exportDataToConverter);
            }
        });

        return mRootView;
    }

    public void setFont(Button toChange, String style){
        toChange.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,style));
    }

    public void addItemsOnSpinner(final String[] toAdd, Spinner toAddIn, final int spinnerID){
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, toAdd);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        toAddIn.setAdapter(dataAdapter);
        toAddIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                switch (spinnerID){
                    case 1:
                        firstMeasure = toAdd[selectedItemPosition];
                        break;
                    case 2:
                        secondMeasure = toAdd[selectedItemPosition];
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void showValueChooseDialog(){
        final String[] valuesNames = {"Length", "Weight", "Speed"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose value");
        builder.setItems(valuesNames, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chooseValue = valuesNames[which];
                switch (chooseValue){
                    case "Length":
                        addItemsOnSpinner(length, spinner1, 1);
                        addItemsOnSpinner(length, spinner2, 2);
                        break;
                    case "Weight":
                        addItemsOnSpinner(weight, spinner1, 1);
                        addItemsOnSpinner(weight, spinner2, 2);
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
