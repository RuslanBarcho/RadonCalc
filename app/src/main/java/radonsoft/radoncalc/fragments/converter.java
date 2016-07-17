package radonsoft.radoncalc.fragments;

import android.animation.Animator;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
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

    public static TextView inputWindow;
    public static TextView outputWindow;

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
    private ImageButton equalButton;
    private Button delButton;
    private ImageButton setButton;
    private ImageButton exchangeSpinnerButton;
    private Button signButton;

    public static  Spinner spinner1;
    public static  Spinner spinner2;

    public static String chooseValue;
    public static String firstMeasure;
    public static String secondMeasure;
    private String saveLocal;

    MainActivity ma;

    private FrameLayout animBackground;
    Animator convertFragClearAnim;

    String[] length = {"Centimeter", "Meter", "Kilometer"};
    String[] weight = {"Gram", "Kilogram", "Ton"};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ma = new MainActivity();
        ma.pages = 4;
        mRootView = inflater.inflate(R.layout.fragment_converter, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("Unit Converter");

        setHasOptionsMenu(true);

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
        equalButton = (ImageButton) mRootView.findViewById(R.id.button41);
        exchangeSpinnerButton = (ImageButton) mRootView.findViewById(R.id.button40);

        animBackground = (FrameLayout) mRootView.findViewById(R.id.clearAnimbkg);

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

        spinner1 = (Spinner) mRootView.findViewById(R.id.spinner2);
        spinner2 = (Spinner) mRootView.findViewById(R.id.spinner);

        inputWindow.setText(ma.saveConverterValue);
        outputWindow.setText(ma.saveOutputConverterValue);
        chooseValue = ma.chooseValue;

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

        spinner1.setSelection(ma.spinnerInputPos);
        spinner2.setSelection(ma.spinnerOutputPos);
        firstMeasure = ma.spinnerInputPosString;
        secondMeasure = ma.spinnerOutputPosString;

        makeConvertation();

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showValueChooseDialog();
            }
        });

        activateBuiltInKeyboard();

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String del = inputWindow.getText().toString();
                if (del.equals("")){

                }
                else{
                    del = del.substring(0, del.length() -1 );
                    inputWindow.setText(del);
                    outputWindow.setText("");
                }
                makeConvertation();
                saveConverterValues();
            }
        });
        delButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                clearAnimation();
                saveConverterValues();
                return true;
            }
        });

        exchangeSpinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int exchangeinput = spinner1.getSelectedItemPosition();
                int exchangeoutput = spinner2.getSelectedItemPosition();
                spinner1.setSelection(exchangeoutput);
                spinner2.setSelection(exchangeinput);
                if (inputWindow.getText().toString().equals("")){

                }
                else {
                    makeConvertation();
                }
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputWindow.getText().toString().equals("")){
                    inputWindow.setText("0.");
                }
                if (inputWindow.getText().toString().contains(".")){
                    //nothing to do
                }
                else {
                    inputWindow.setText(inputWindow.getText()+".");
                }
                makeConvertation();
            }
        });

        return mRootView;
    }

    public void makeConvertation(){
        if (inputWindow.getText().toString().equals("")){

        }
        else {
            ConverterSolver solver = new ConverterSolver();
            solver.valueID = chooseValue;
            solver.measureOneID = firstMeasure;
            solver.measureTwoID = secondMeasure;
            solver.inputValue = new BigDecimal(inputWindow.getText().toString());
            solver.convert();
            outputWindow.setText(solver.exportDataToConverter);
            saveConverterValues();
        }
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
                        saveConverterValues();
                        break;
                    case 2:
                        secondMeasure = toAdd[selectedItemPosition];
                        saveConverterValues();
                        break;
                }
                makeConvertation();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                switch (spinnerID){
                    case 1:
                        firstMeasure = toAdd[1];
                        saveConverterValues();
                        break;
                    case 2:
                        secondMeasure = toAdd[1];
                        saveConverterValues();
                        break;
                }
                makeConvertation();
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
                saveLocal = inputWindow.getText().toString();
                switch (chooseValue){
                    case "Length":
                        inputWindow.setText("");
                        addItemsOnSpinner(length, spinner1, 1);
                        addItemsOnSpinner(length, spinner2, 2);
                        makeConvertation();
                        break;
                    case "Weight":
                        inputWindow.setText("");
                        addItemsOnSpinner(weight, spinner1, 1);
                        addItemsOnSpinner(weight, spinner2, 2);
                        makeConvertation();
                        break;
                }
                saveConverterValues();
                inputWindow.setText(saveLocal);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void clearAnimation() {
        if (Build.VERSION.SDK_INT >= 21) {
            ClearAnimation historyFragmentClrAnim = new ClearAnimation();
            historyFragmentClrAnim.clrAnimBackground = animBackground;
            historyFragmentClrAnim.clrAnimName = convertFragClearAnim;
            historyFragmentClrAnim.createClrAnim(1500, 300);
        }
        else {
            animBackground.startAnimation(ma.fadein);
            animBackground.startAnimation(ma.fadeout);
            inputWindow.setText("");
            outputWindow.setText("");
            saveConverterValues();
        }
    }

    public static void clearInOutWindows(){
        inputWindow.setText("");
        outputWindow.setText("");
        saveConverterValues();
    }

    public static void saveConverterValues(){
        MainActivity ma = new MainActivity();
        ma.saveConverterValue = inputWindow.getText().toString();
        ma.saveOutputConverterValue = outputWindow.getText().toString();
        ma.spinnerInputPos = spinner1.getSelectedItemPosition();
        ma.spinnerOutputPos = spinner2.getSelectedItemPosition();
        ma.spinnerInputPosString = firstMeasure;
        ma.spinnerOutputPosString = secondMeasure;
        ma.chooseValue = chooseValue;

    }

    public void activateBuiltInKeyboard() {
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "1");
                makeConvertation();
                saveConverterValues();
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "2");
                makeConvertation();
                saveConverterValues();
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "3");
                makeConvertation();
                saveConverterValues();
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "4");
                makeConvertation();
                saveConverterValues();
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "5");
                makeConvertation();
                saveConverterValues();
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "6");
                makeConvertation();
                saveConverterValues();
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "7");
                makeConvertation();
                saveConverterValues();
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "8");
                makeConvertation();
                saveConverterValues();
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "9");
                makeConvertation();
                saveConverterValues();
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputWindow.setText(inputWindow.getText() + "0");
                makeConvertation();
                saveConverterValues();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.converter_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_calculatorSend): {
                if (outputWindow.equals("")){

                }
                else {
                    ma.saveTextViewValue = outputWindow.getText().toString();
                    ma.saveAddictionTextViewValue = outputWindow.getText().toString();
                }
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
