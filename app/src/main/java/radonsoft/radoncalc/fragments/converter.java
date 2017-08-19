package radonsoft.radoncalc.fragments;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.math.BigDecimal;

import radonsoft.radoncalc.Helpers.ClearAnimation;
import radonsoft.radoncalc.Helpers.ConverterSolver;
import radonsoft.radoncalc.Helpers.Global;
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

    public static int firstMeasureInt;
    public static int secondMeasureInt;
    public static int valueIDInt;

    MainActivity ma;

    private FrameLayout animBackground;
    Animator convertFragClearAnim;

    String[] length = {"Millimeter","Centimeter", "Meter", "Kilometer", "Foot", "Inch"};
    String[] weight = {"Gram", "Kilogram", "Ton"};
    String[] speed = {"Ms","Kph","Mph","Knots"};
    String[] numsys = {"Decimal", "Binary"};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ma = new MainActivity();
        ma.pages = 4;
        mRootView = inflater.inflate(R.layout.fragment_converter, container, false);
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.converter_title));

        setHasOptionsMenu(true);

        length = getResources().getStringArray(R.array.converter_length_values);
        weight = getResources().getStringArray(R.array.converter_weight_values);
        speed = getResources().getStringArray(R.array.converter_speed_values);
        numsys = getResources().getStringArray(R.array.converter_numsys_values);

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

        setFontForViewElements();
        inputWindow.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        outputWindow.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));

        spinner1 = (Spinner) mRootView.findViewById(R.id.spinner2);
        spinner2 = (Spinner) mRootView.findViewById(R.id.spinner);

        valueIDInt = ma.valueIDPos;

        inputWindow.setText(ma.saveConverterValue);
        outputWindow.setText(ma.saveOutputConverterValue);

        switch (valueIDInt){
            case 0:
                addItemsOnSpinner(length, spinner1, 1);
                addItemsOnSpinner(length, spinner2, 2);
                break;
            case 1:
                addItemsOnSpinner(weight, spinner1, 1);
                addItemsOnSpinner(weight, spinner2, 2);
                break;
            case 2:
                addItemsOnSpinner(speed, spinner1, 1);
                addItemsOnSpinner(speed, spinner2, 2);
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
                Global.turnVibrationOn(setButton);
                turnOnVibration();
                showValueChooseDialog();
            }
        });

        activateBuiltInKeyboard();

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(equalButton);
                turnOnVibration();
                Global.pageThreeCounter = Global.pageThreeCounter + 1;
                writeToHistory();
            }
        });

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                if (inputWindow.getText().toString().contains("-")){
                    inputWindow.setText(inputWindow.getText().toString().substring(1));
                }
                else {
                    inputWindow.setText("-" + inputWindow.getText().toString());
                }
                makeConvertation();
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(delButton);
                turnOnVibration();
                String del = inputWindow.getText().toString();
                switch (del){
                    case "":

                        break;
                    case "-":
                        del = del.substring(0, del.length() -1 );
                        inputWindow.setText(del);
                        outputWindow.setText("");
                        break;
                    default:
                        del = del.substring(0, del.length() -1 );
                        inputWindow.setText(del);
                        outputWindow.setText("");
                        makeConvertation();
                        break;
                }
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
                Global.turnVibrationOn(dotButton);
                turnOnVibration();
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

    public void showDialogMessage(String toShow){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ErrorDialogTheme);
        builder.setTitle(toShow);
        builder.setPositiveButton(R.string.calculator_button_ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void makeConvertation(){
        if (inputWindow.getText().toString().equals("") |inputWindow.getText().toString().equals("-")){

        }
        else {
            ConverterSolver solver = new ConverterSolver();
            solver.inputValue = new BigDecimal(inputWindow.getText().toString());
            solver.convert();
            outputWindow.setText(solver.exportDataToConverter);
            removeZerosFromFraction(new BigDecimal(String.valueOf(outputWindow.getText())));
            saveConverterValues();
        }
    }

    public void removeZerosFromFraction(BigDecimal ToRemove){
        BigDecimal toRemoveChecker = ToRemove.setScale(0, BigDecimal.ROUND_DOWN);
        if (ToRemove.equals(toRemoveChecker)){

        }
        else {
            String ZeroRemoval = String.valueOf(ToRemove);
            if (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '0') {
                do {
                    ZeroRemoval = (ZeroRemoval.substring(0, ZeroRemoval.length() - 1));
                }
                while (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '0');
                if (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '.') {
                    ZeroRemoval = (ZeroRemoval.substring(0, ZeroRemoval.length() - 1));
                }
                outputWindow.setText(ZeroRemoval);
            }
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
                        firstMeasureInt = selectedItemPosition;
                        saveConverterValues();
                        break;
                    case 2:
                        secondMeasureInt = selectedItemPosition;
                        saveConverterValues();
                        break;
                }
                makeConvertation();
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void showValueChooseDialog(){
        final String[] valuesNames = {getString(R.string.converter_length),
                getString(R.string.converter_weight), getString(R.string.converter_speed), getString(R.string.converter_numsys)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.converter_dialog_title));
        builder.setItems(valuesNames, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valueIDInt = which;
                saveLocal = inputWindow.getText().toString();
                inputWindow.setText("");
                switch (valueIDInt){
                    case 0:
                        addItemsOnSpinner(length, spinner1, 1);
                        addItemsOnSpinner(length, spinner2, 2);
                        firstMeasureInt = 0;
                        secondMeasureInt = 0;
                        break;
                    case 1:
                        inputWindow.setText("");
                        addItemsOnSpinner(weight, spinner1, 1);
                        addItemsOnSpinner(weight, spinner2, 2);
                        firstMeasureInt = 0;
                        secondMeasureInt = 0;
                        break;
                    case 2:
                        inputWindow.setText("");
                        addItemsOnSpinner(speed, spinner1, 1);
                        addItemsOnSpinner(speed, spinner2, 2);
                        firstMeasureInt = 0;
                        secondMeasureInt = 0;
                        break;
                    case 3:
                        inputWindow.setText("");
                        addItemsOnSpinner(numsys, spinner1, 1);
                        addItemsOnSpinner(numsys, spinner2, 2);
                        firstMeasureInt = 0;
                        secondMeasureInt = 0;
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
            historyFragmentClrAnim.createClrAnim(2300, 400, 0, 0);
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
        ma.chooseValue = chooseValue;
        ma.valueIDPos = valueIDInt;
    }

    public void activateBuiltInKeyboard() {
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(oneButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "1");
                makeConvertation();
                saveConverterValues();
            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(twoButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "2");
                makeConvertation();
                saveConverterValues();
            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(threeButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "3");
                makeConvertation();
                saveConverterValues();
            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(fourButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "4");
                makeConvertation();
                saveConverterValues();
            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(fiveButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "5");
                makeConvertation();
                saveConverterValues();
            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(sixButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "6");
                makeConvertation();
                saveConverterValues();
            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(sevenButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "7");
                makeConvertation();
                saveConverterValues();
            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(eightButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "8");
                makeConvertation();
                saveConverterValues();
            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(nineButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "9");
                makeConvertation();
                saveConverterValues();
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(zeroButton);
                turnOnVibration();
                inputWindow.setText(inputWindow.getText() + "0");
                makeConvertation();
                saveConverterValues();
            }
        });
    }

    public void setFontForViewElements(){
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
    }

    public void squareEquationExport(){
        final String[] chooseEquationID = {getString(R.string.calculator_set_a), getString(R.string.calculator_set_b), getString(R.string.calculator_set_c)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getString(R.string.calculator_choose_parameter));
        builder.setItems(chooseEquationID, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    //TODO: change edittext in equations fragment
                    case 0:
                        ma.show = 0;
                        Global.sqrEquationsExport = 1;
                        Global.sqrEquationsExportCheckA = 1;
                        Global.sqrEquationsExportToA = outputWindow.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_q_equations));
                        break;
                    case 1:
                        ma.show = 0;
                        Global.sqrEquationsExport = 1;
                        Global.sqrEquationsExportCheckB = 1;
                        Global.sqrEquationsExportToB = outputWindow.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_q_equations));
                        break;
                    case 2:
                        ma.show = 0;
                        Global.sqrEquationsExport = 1;
                        Global.sqrEquationsExportCheckC = 1;
                        Global.sqrEquationsExportToC = outputWindow.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_q_equations));
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void showErrorMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ErrorDialogTheme);
        builder.setTitle(R.string.calculator_Illegal_operation);
        builder.setPositiveButton(R.string.calculator_button_ok,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void turnOnVibration() {
        if (Global.vibrationSwitcher) {
            Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(40);
        }
    }

    public void writeToHistory(){
        switch (Global.pageThreeCounter){
            case 0:

                break;
            case 1:
                Global.pageThreefirstCellhistoryInput = inputWindow.getText().toString();
                Global.pageThreefirstCellhistoryInputName = spinner1.getSelectedItem().toString();
                Global.pageThreefirstCellhistoryOutput = outputWindow.getText().toString();
                Global.pageThreefirstCellhistoryOutputName = spinner2.getSelectedItem().toString();
                break;
            case 2:
                Global.pageThreeSecondCellhistoryInput = Global.pageThreefirstCellhistoryInput;
                Global.pageThreeSecondCellhistoryInputName = Global.pageThreefirstCellhistoryInputName;
                Global.pageThreeSecondCellhistoryOutput = Global.pageThreefirstCellhistoryOutput;
                Global.pageThreeSecondCellhistoryOutputName = Global.pageThreefirstCellhistoryOutputName;
                Global.pageThreefirstCellhistoryInput = inputWindow.getText().toString();
                Global.pageThreefirstCellhistoryInputName = spinner1.getSelectedItem().toString();
                Global.pageThreefirstCellhistoryOutput = outputWindow.getText().toString();
                Global.pageThreefirstCellhistoryOutputName = spinner2.getSelectedItem().toString();
                break;
            case 3:
                Global.pageThreeThirdCellhistoryInput = Global.pageThreeSecondCellhistoryInput;
                Global.pageThreeThirdCellhistoryOutput = Global.pageThreeSecondCellhistoryOutput;
                Global.pageThreeThirdCellhistoryInputName = Global.pageThreeSecondCellhistoryInputName;
                Global.pageThreeThirdCellhistoryOutputName = Global.pageThreeSecondCellhistoryOutputName;

                Global.pageThreeSecondCellhistoryInput = Global.pageThreefirstCellhistoryInput;
                Global.pageThreeSecondCellhistoryInputName = Global.pageThreefirstCellhistoryInputName;
                Global.pageThreeSecondCellhistoryOutput = Global.pageThreefirstCellhistoryOutput;
                Global.pageThreeSecondCellhistoryOutputName = Global.pageThreefirstCellhistoryOutputName;

                Global.pageThreefirstCellhistoryInput = inputWindow.getText().toString();
                Global.pageThreefirstCellhistoryInputName = spinner1.getSelectedItem().toString();
                Global.pageThreefirstCellhistoryOutput = outputWindow.getText().toString();
                Global.pageThreefirstCellhistoryOutputName = spinner2.getSelectedItem().toString();
                break;
            case 4:
                Global.pageThreeFourthCellhistoryInput = Global.pageThreeThirdCellhistoryInput;
                Global.pageThreeFourthCellhistoryOutput = Global.pageThreeThirdCellhistoryOutput;
                Global.pageThreeFourthCellhistoryInputName = Global.pageThreeThirdCellhistoryInputName;
                Global.pageThreeFourthCellhistoryOutputName = Global.pageThreeThirdCellhistoryOutputName;

                Global.pageThreeThirdCellhistoryInput = Global.pageThreeSecondCellhistoryInput;
                Global.pageThreeThirdCellhistoryOutput = Global.pageThreeSecondCellhistoryOutput;
                Global.pageThreeThirdCellhistoryInputName = Global.pageThreeSecondCellhistoryInputName;
                Global.pageThreeThirdCellhistoryOutputName = Global.pageThreeSecondCellhistoryOutputName;

                Global.pageThreeSecondCellhistoryInput = Global.pageThreefirstCellhistoryInput;
                Global.pageThreeSecondCellhistoryInputName = Global.pageThreefirstCellhistoryInputName;
                Global.pageThreeSecondCellhistoryOutput = Global.pageThreefirstCellhistoryOutput;
                Global.pageThreeSecondCellhistoryOutputName = Global.pageThreefirstCellhistoryOutputName;

                Global.pageThreefirstCellhistoryInput = inputWindow.getText().toString();
                Global.pageThreefirstCellhistoryInputName = spinner1.getSelectedItem().toString();
                Global.pageThreefirstCellhistoryOutput = outputWindow.getText().toString();
                Global.pageThreefirstCellhistoryOutputName = spinner2.getSelectedItem().toString();
                break;
            default:
                Global.pageThreeFifthCellhistoryInput = Global.pageThreeFourthCellhistoryInput;
                Global.pageThreeFifthCellhistoryOutput = Global.pageThreeFourthCellhistoryOutput;
                Global.pageThreeFifthCellhistoryInputName = Global.pageThreeFourthCellhistoryInputName;
                Global.pageThreeFifthCellhistoryOutputName = Global.pageThreeFourthCellhistoryOutputName;

                Global.pageThreeFourthCellhistoryInput = Global.pageThreeThirdCellhistoryInput;
                Global.pageThreeFourthCellhistoryOutput = Global.pageThreeThirdCellhistoryOutput;
                Global.pageThreeFourthCellhistoryInputName = Global.pageThreeThirdCellhistoryInputName;
                Global.pageThreeFourthCellhistoryOutputName = Global.pageThreeThirdCellhistoryOutputName;

                Global.pageThreeThirdCellhistoryInput = Global.pageThreeSecondCellhistoryInput;
                Global.pageThreeThirdCellhistoryOutput = Global.pageThreeSecondCellhistoryOutput;
                Global.pageThreeThirdCellhistoryInputName = Global.pageThreeSecondCellhistoryInputName;
                Global.pageThreeThirdCellhistoryOutputName = Global.pageThreeSecondCellhistoryOutputName;

                Global.pageThreeSecondCellhistoryInput = Global.pageThreefirstCellhistoryInput;
                Global.pageThreeSecondCellhistoryInputName = Global.pageThreefirstCellhistoryInputName;
                Global.pageThreeSecondCellhistoryOutput = Global.pageThreefirstCellhistoryOutput;
                Global.pageThreeSecondCellhistoryOutputName = Global.pageThreefirstCellhistoryOutputName;

                Global.pageThreefirstCellhistoryInput = inputWindow.getText().toString();
                Global.pageThreefirstCellhistoryInputName = spinner1.getSelectedItem().toString();
                Global.pageThreefirstCellhistoryOutput = outputWindow.getText().toString();
                Global.pageThreefirstCellhistoryOutputName = spinner2.getSelectedItem().toString();
                break;
        }
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
                if (outputWindow.getText().toString().equals("")){
                    showErrorMessage();
                }
                else {
                    ma.saveTextViewValue = outputWindow.getText().toString();
                    ma.saveAddictionTextViewValue = outputWindow.getText().toString();
                    ma.saveTumbler = 0;
                    showDialogMessage(getString(R.string.converter_sent_to_calculator));
                }
                return true;
            }
            case (R.id.action_equationsSend):
                if (outputWindow.getText().toString().equals("")){
                    showErrorMessage();
                }
                else {
                    squareEquationExport();
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
