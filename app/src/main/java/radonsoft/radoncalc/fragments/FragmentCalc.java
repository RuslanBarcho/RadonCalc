package radonsoft.radoncalc.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import java.math.BigDecimal;
import radonsoft.radoncalc.DatabaseHelper;
import radonsoft.radoncalc.Helpers.BigDecimalMathOperations;
import radonsoft.radoncalc.Helpers.Global;
import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;
import android.view.HapticFeedbackConstants;

public class FragmentCalc extends Fragment {
    MainActivity ma = new MainActivity();
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
    private Button delButton;
    private Button signButton;
    private Button PlusButton, MinusButton, dotButton, MultiplyButton, DivButton, powButton;
    private Button equalButton;
    private Button sinButton;
    private Button cosButton;
    private Button tanButton;
    private Button percentButton;
    private Button piButton;
    private Button rootButton;

    Integer Tumbler = 0;
    Integer signpower = 0;

    BigDecimal OperateA;
    BigDecimal OperateB;
    BigDecimal Result, Equal;

    String Proverka;
    String historyBody;
    String historyname;
    String saveTextViewValue = "";
    String saveAddictionTextViewValue = "";
    String historyResult;
    String fractionString;
    String emptyStringTest;

    int charTest;
    int testOnsSignsFinal;
    int trigonometryFunctions;

    TextView textView;
    TextView texxtView;
    TextView radDeg;

    HorizontalScrollView inputScroll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.calculator_title));
        setHasOptionsMenu(true);
        mRootView = inflater.inflate(R.layout.fragment_fragment_calc, container, false);

        oneButton = (Button) mRootView.findViewById(R.id.button);
        twoButton = (Button) mRootView.findViewById(R.id.button2);
        threeButton = (Button) mRootView.findViewById(R.id.button3);
        fourButton = (Button) mRootView.findViewById(R.id.button4);
        fiveButton = (Button) mRootView.findViewById(R.id.button5);
        sixButton = (Button) mRootView.findViewById(R.id.button6);
        sevenButton = (Button) mRootView.findViewById(R.id.button7);
        eightButton = (Button) mRootView.findViewById(R.id.button8);
        nineButton = (Button) mRootView.findViewById(R.id.button9);
        zeroButton = (Button) mRootView.findViewById(R.id.button12);

        powButton = (Button) mRootView.findViewById(R.id.button19);
        dotButton = (Button) mRootView.findViewById(R.id.button10);
        MinusButton = (Button) mRootView.findViewById(R.id.button15);
        PlusButton = (Button) mRootView.findViewById(R.id.button14);
        equalButton = (Button) mRootView.findViewById(R.id.button13);
        MultiplyButton = (Button) mRootView.findViewById(R.id.button16);
        DivButton = (Button) mRootView.findViewById(R.id.button17);
        signButton = (Button) mRootView.findViewById(R.id.button23);
        delButton = (Button) mRootView.findViewById(R.id.button11);
        sinButton = (Button) mRootView.findViewById(R.id.button24);
        cosButton = (Button) mRootView.findViewById(R.id.button25);
        tanButton = (Button) mRootView.findViewById(R.id.button26);
        percentButton = (Button) mRootView.findViewById(R.id.button27);
        piButton = (Button) mRootView.findViewById(R.id.button28);
        textView = (TextView) mRootView.findViewById(R.id.textView);
        texxtView = (TextView) mRootView.findViewById(R.id.textView3);
        radDeg = (TextView) mRootView.findViewById(R.id.textView4);
        rootButton = (Button) mRootView.findViewById(R.id.button18);

        inputScroll = (HorizontalScrollView) mRootView.findViewById(R.id.horizontalScrollView);

        setFont(oneButton, "robotolight.ttf");
        setFont(twoButton, "robotolight.ttf");
        setFont(threeButton, "robotolight.ttf");
        setFont(fourButton, "robotolight.ttf");
        setFont(fiveButton, "robotolight.ttf");
        setFont(sixButton, "robotolight.ttf");
        setFont(sevenButton, "robotolight.ttf");
        setFont(eightButton, "robotolight.ttf");
        setFont(nineButton, "robotolight.ttf");
        setFont(zeroButton, "robotolight.ttf");
        setFont(dotButton, "robotolight.ttf");
        setFont(equalButton, "robotolight.ttf");
        setFont(signButton, "robotolight.ttf");
        setFont(delButton, "robotolight.ttf");
        setFont(sinButton, "robotolight.ttf");
        setFont(cosButton, "robotolight.ttf");
        setFont(tanButton, "robotolight.ttf");
        setFont(percentButton, "robotolight.ttf");
        setFont(piButton, "robotolight.ttf");
        textView.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));

        textView.setText(ma.saveTextViewValue);
        texxtView.setText(ma.saveAddictionTextViewValue);
        Tumbler = ma.saveTumbler;
        OperateA = ma.saveOperateA;
        ma.pages = 0;
        radDeg.setText(Global.saveDegreeStatus);

        activateBuiltInKeyboard();

        radDeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String degreeChecker = radDeg.getText().toString();
                if (degreeChecker.equals("RAD")) {
                    radDeg.setText("DEG");
                } else {
                    radDeg.setText("RAD");
                }
                saveFragmentValues();
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(dotButton);
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());

                if (Proverka.equals("")|Proverka.equals("-")) {
                    textView.setText(texxt + "0.");
                    texxtView.setText(texxx + "0.");
                }
                else
                {
                    if (Proverka.contains(".")) {

                    }
                    else {
                        textView.setText(texxt + ".");
                        texxtView.setText(texxx + ".");
                    }
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                Proverka = String.valueOf(textView.getText());
                if (Proverka.equals(""))
                {

                }
                else {
                    String texxt = String.valueOf(textView.getText());
                    String texxx = String.valueOf(texxtView.getText());
                    if (texxtView.getText().toString().equals("")){
                        textView.setText(Proverka.substring(0, Proverka.length() -1));
                        texxtView.setText(Proverka.substring(0, Proverka.length() -1));
                        Tumbler = 0;
                    }
                    else {
                        testInputOnSigns(texxt);
                        if (testOnsSignsFinal == 0){
                            Tumbler = 0;
                            textView.setText(texxt.substring(0, texxt.length() -1));
                            texxtView.setText(texxx.substring(0, texxx.length() -1));
                        }
                        else{
                            textView.setText(texxt.substring(0, texxt.length() -1));
                            texxtView.setText(texxx.substring(0, texxx.length() -1));
                        }
                    }
                }
                saveFragmentValues();
                scrollInputToEnd();
                textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            }
        });

        delButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                eraseAllData();
                return true;
            }
        });

        sinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(sinButton);
                turnOnVibration();
                emptyStringTest = String.valueOf(texxtView.getText());
                trigonometryFunctions = 1;
                if (emptyStringTest.equals("")|emptyStringTest.equals("-"))
                {
                    // here will be error message
                }
                else {
                    solveTrigonometryFunctions();
                }
                saveFragmentValues();
            }
        });

        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(percentButton);
                turnOnVibration();
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka.equals("")|Proverka.equals("-"))
                {

                }
                else {
                    switch (Tumbler) {
                        case 0:
                            OperateA =  new BigDecimal(String.valueOf(texxtView.getText().toString()));
                            textView.setText(textView.getText().toString() + "%");
                            texxtView.setText("");
                            Tumbler = 6;
                            break;
                        default:
                            returnPercent();
                            OperateA =  new BigDecimal(String.valueOf(textView.getText().toString()));
                            textView.setText(textView.getText() + "%");
                            texxtView.setText("");
                            Tumbler = 6;
                            break;
                    }
                }
            }
        });

        piButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                showDialogMessage("Coming soon!");
            }
        });

        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(cosButton);
                turnOnVibration();
                emptyStringTest = String.valueOf(texxtView.getText());
                trigonometryFunctions = 2;
                if (emptyStringTest.equals("")|emptyStringTest.equals("-"))
                {
                    // here will be error message
                }
                else {
                    solveTrigonometryFunctions();
                }
                saveFragmentValues();
            }
        });

        tanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(tanButton);
                turnOnVibration();
                emptyStringTest = String.valueOf(texxtView.getText());
                trigonometryFunctions = 3;
                if (emptyStringTest.equals("")|emptyStringTest.equals("-"))
                {
                    // here will be error message
                }
                else {
                    solveTrigonometryFunctions();
                }
                saveFragmentValues();
            }
        });

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(signButton);
                turnOnVibration();
                Proverka = String.valueOf(texxtView.getText());
                String forInputTest = String.valueOf(textView.getText());
                if (Proverka.equals("")|Proverka.equals("-"))
                {

                }
                else {
                    testInputOnSigns(forInputTest);
                    if (testOnsSignsFinal == 1){
                        if (textView.getText().toString().contains("-")& Tumbler == 0) {
                            String changeToPlus = textView.getText().toString();
                            textView.setText(changeToPlus.substring(1, changeToPlus.length()));
                            texxtView.setText(changeToPlus.substring(1, changeToPlus.length()));
                        }
                    }
                    else {
                        textView.setText("-" + textView.getText());
                        texxtView.setText("-" + texxtView.getText());
                    }
                }
                saveFragmentValues();
            }
        });
        PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(PlusButton);
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka.equals("")|Proverka.equals("-"))
                {

                }
                else {
                    switch (Tumbler) {
                        case 0:
                        OperateA =  new BigDecimal(String.valueOf(texxx));
                        textView.setText(texxt + "+");
                        texxtView.setText("");
                        Tumbler = 1;
                            break;
                        default:
                            equalation();
                            OperateA =  new BigDecimal(String.valueOf(textView.getText().toString()));
                            textView.setText(textView.getText() + "+");
                            texxtView.setText("");
                            Tumbler = 1;
                            break;
                    }
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(MinusButton);
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                switch (Proverka){
                    case "":
                        if (Tumbler == 0) {
                            textView.setText(texxt + "-");
                            texxtView.setText(texxx + "-");
                        }
                        else{

                        }
                        break;
                    case "-":

                        break;
                    default:
                        switch (Tumbler) {
                            case 0:
                                OperateA =  new BigDecimal(String.valueOf(texxx));
                                textView.setText(texxt + "-");
                                texxtView.setText("");
                                Tumbler = 2;
                                break;
                            default:
                                equalation();
                                OperateA =  new BigDecimal(String.valueOf(textView.getText().toString()));
                                textView.setText(textView.getText() + "-");
                                texxtView.setText("");
                                Tumbler = 2;
                                break;
                        }
                        break;
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        MultiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(MultiplyButton);
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka.equals("")|Proverka.equals("-"))
                {

                }
                else {
                    switch(Tumbler) {
                        case 0:
                            OperateA =  new BigDecimal(String.valueOf(texxx));
                            textView.setText(texxt + "×");
                            texxtView.setText("");
                            Tumbler = 3;
                            break;
                        default:
                            equalation();
                            OperateA =  new BigDecimal(String.valueOf(textView.getText().toString()));
                            textView.setText(textView.getText() + "×");
                            texxtView.setText("");
                            Tumbler = 3;
                            break;
                    }
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        DivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(DivButton);
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka.equals("")|Proverka.equals("-"))
                {

                }
                else {
                    switch(Tumbler) {
                        case 0:
                        OperateA =  new BigDecimal(String.valueOf(texxx));
                        textView.setText(texxt + "÷");
                        texxtView.setText("");
                        Tumbler = 4;
                            break;
                        default:
                            try {
                                equalation();
                                OperateA =  new BigDecimal(String.valueOf(textView.getText().toString()));
                                textView.setText(textView.getText() + "÷");
                                texxtView.setText("");
                                Tumbler = 4;
                            }
                            catch (NumberFormatException e){

                            }
                            break;
                    }
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });

        powButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(powButton);
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka.equals("")|Proverka.equals("-"))
                {

                }
                else {
                    switch (Tumbler) {
                        case 0:
                            OperateA =  new BigDecimal(String.valueOf(texxx));
                            textView.setText(texxt + "^");
                            texxtView.setText("");
                            Tumbler = 5;
                            break;
                        default:
                            equalation();
                            OperateA =  new BigDecimal(String.valueOf(textView.getText().toString()));
                            textView.setText(textView.getText() + "^");
                            texxtView.setText("");
                            Tumbler = 5;
                            break;
                    }
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });

        rootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(rootButton);
                turnOnVibration();
                testInputOnSigns(textView.getText().toString());
                BigDecimal checkHugeMaxValue = new BigDecimal(Double.MAX_VALUE);
                if (testOnsSignsFinal == 1 | textView.getText().toString().equals("")){

                }
                else {
                    OperateA = new BigDecimal(String.valueOf(textView.getText()));
                    BigDecimal checkHugeValueInput = OperateA;
                    if (checkHugeValueInput.compareTo(checkHugeMaxValue) == -1) {
                        Result = sqrt(OperateA, 20);
                        removeZerosFromFraction(Result);
                        loadHistoryContent(getString(R.string.history_evolution));
                        textView.setText(String.valueOf(Result));
                        texxtView.setText(String.valueOf(Result));
                        historyResult = String.valueOf(Result);
                        writeOperationToHistory();
                    }
                }
                saveFragmentValues();
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.turnVibrationOn(equalButton);
                turnOnVibration();
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka.equals("")) {
                    textView.setText("");
                    texxtView.setText("");
                    saveTextViewValue = "";
                    saveAddictionTextViewValue = "";
                    Tumbler = 0;
                } else {
                    equalation();
                }
                saveFragmentValues();
            }
        });
        return mRootView;
    }
    private static final BigDecimal TWO = BigDecimal.valueOf(2);
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, BigDecimal.ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return x1;
    }
    public void equalation(){
        boolean divnull = false;
        switch (Tumbler) {
            case 0:

                break;
            case 1:
                addiction();
                break;
            case 2:
                subtraction();
                break;
            case 3:
                multiplication();
                break;
            case 4:
                try{
                    division();
                } catch (ArithmeticException e) {
                    showDialogMessage(getString(R.string.calculator_Illegal_operation));
                    eraseAllData();
                    divnull = true;
                }
                break;
            case 5:
                exponentiate();
                break;
            case 6:
                returnPercent();
                break;
        }
        textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        if (divnull) {

        }
        else {
            writeOperationToHistory();
        }
        scrollInputToBegin();
    }
    public void writeOperationToHistory(){
        switch (ma.pageOneCounter) {
            case 0:

                break;
            case 1:
                Global.pageOnefirstCellhistoryBody = historyBody;
                Global.pageOnefirstCellhistoryName = historyname;
                Global.pageOnefirstCellhistoryResult = historyResult;
                break;
            case 2:
                //Transfer to next cell
                Global.pageOneSecondCellhistoryBody = Global.pageOnefirstCellhistoryBody;
                Global.pageOneSecondCellhistoryName = Global.pageOnefirstCellhistoryName;
                Global.pageOneSecondCellhistoryResult = Global.pageOnefirstCellhistoryResult;
                //Make the first cell full
                Global.pageOnefirstCellhistoryBody = historyBody;
                Global.pageOnefirstCellhistoryName = historyname;
                Global.pageOnefirstCellhistoryResult = historyResult;
                break;
            case 3:
                //Transfer to next cell
                Global.pageOneThirdCellhistoryBody = Global.pageOneSecondCellhistoryBody;
                Global.pageOneThirdCellhistoryName = Global.pageOneSecondCellhistoryName;
                Global.pageOneThirdCellhistoryResult = Global.pageOneSecondCellhistoryResult;

                Global.pageOneSecondCellhistoryBody = Global.pageOnefirstCellhistoryBody;
                Global.pageOneSecondCellhistoryName = Global.pageOnefirstCellhistoryName;
                Global.pageOneSecondCellhistoryResult = Global.pageOnefirstCellhistoryResult;
                //Make the first cell full
                Global.pageOnefirstCellhistoryBody = historyBody;
                Global.pageOnefirstCellhistoryName = historyname;
                Global.pageOnefirstCellhistoryResult = historyResult;
                break;
            case 4:
                //Transfer to next cell
                Global.pageOneFourthCellhistoryBody = Global.pageOneThirdCellhistoryBody;
                Global.pageOneFourthCellhistoryName = Global.pageOneThirdCellhistoryName;
                Global.pageOneFourthCellhistoryResult = Global.pageOneThirdCellhistoryResult;

                Global.pageOneThirdCellhistoryBody = Global.pageOneSecondCellhistoryBody;
                Global.pageOneThirdCellhistoryName = Global.pageOneSecondCellhistoryName;
                Global.pageOneThirdCellhistoryResult = Global.pageOneSecondCellhistoryResult;

                Global.pageOneSecondCellhistoryBody = Global.pageOnefirstCellhistoryBody;
                Global.pageOneSecondCellhistoryName = Global.pageOnefirstCellhistoryName;
                Global.pageOneSecondCellhistoryResult = Global.pageOnefirstCellhistoryResult;
                //Make the first cell full
                Global.pageOnefirstCellhistoryBody = historyBody;
                Global.pageOnefirstCellhistoryName = historyname;
                Global.pageOnefirstCellhistoryResult = historyResult;
                break;
            default:
                //Transfer to next cell
                Global.pageOneFifthCellhistoryBody = Global.pageOneFourthCellhistoryBody;
                Global.pageOneFifthCellhistoryName = Global.pageOneFourthCellhistoryName;
                Global.pageOneFifthCellhistoryResult = Global.pageOneFourthCellhistoryResult;

                Global.pageOneFourthCellhistoryBody = Global.pageOneThirdCellhistoryBody;
                Global.pageOneFourthCellhistoryName = Global.pageOneThirdCellhistoryName;
                Global.pageOneFourthCellhistoryResult = Global.pageOneThirdCellhistoryResult;

                Global.pageOneThirdCellhistoryBody = Global.pageOneSecondCellhistoryBody;
                Global.pageOneThirdCellhistoryName = Global.pageOneSecondCellhistoryName;
                Global.pageOneThirdCellhistoryResult = Global.pageOneSecondCellhistoryResult;

                Global.pageOneSecondCellhistoryBody = Global.pageOnefirstCellhistoryBody;
                Global.pageOneSecondCellhistoryName = Global.pageOnefirstCellhistoryName;
                Global.pageOneSecondCellhistoryResult = Global.pageOnefirstCellhistoryResult;
                //Make the first cell full
                Global.pageOnefirstCellhistoryBody = historyBody;
                Global.pageOnefirstCellhistoryName = historyname;
                Global.pageOnefirstCellhistoryResult = historyResult;
                break;
        }
    }

    public void setFont(Button toChange, String style){
        toChange.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,style));
    }
    public void trigFunctionReturn(){
        OperateA = new BigDecimal(String.valueOf(texxtView.getText()));
        switch (trigonometryFunctions){
            case 1:
                Result = BigDecimalMathOperations.sin(OperateA, radDeg.getText().toString());
                break;
            case 2:
                Result = BigDecimalMathOperations.cos(OperateA, radDeg.getText().toString());
                break;
            case 3:
                Result = BigDecimalMathOperations.tan(OperateA, radDeg.getText().toString());
                break;
        }
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
    }
    public void solveTrigonometryFunctions(){
        String forInputTest = String.valueOf(textView.getText());
        BigDecimal checkHugeMaxValue = new BigDecimal(Double.MAX_VALUE);
        BigDecimal checkHugeMinValue = new BigDecimal(-999999999);
        testInputOnSigns(forInputTest);
        if (testOnsSignsFinal == 1){
            if (textView.getText().toString().contains("-")& Tumbler == 0) {
                BigDecimal checkHugeValueInput = new BigDecimal(forInputTest);
                if (checkHugeValueInput.compareTo(checkHugeMinValue) == 1) {
                    trigFunctionReturn();
                }
                else{
                    showDialogMessage(getString(R.string.calculator_Illegal_operation));
                }
            }
        }
        else {
            BigDecimal checkHugeValueInput = new BigDecimal(forInputTest);
            if (checkHugeValueInput.compareTo(checkHugeMaxValue) == -1) {
                trigFunctionReturn();
            }
            else{
                showDialogMessage(getString(R.string.calculator_Illegal_operation));
            }
        }
    }
    public void saveFragmentValues(){
        ma.saveTextViewValue = textView.getText().toString();
        ma.saveAddictionTextViewValue = texxtView.getText().toString();
        ma.saveOperateA = OperateA;
        ma.saveTumbler = Tumbler;
        Global.saveDegreeStatus = radDeg.getText().toString();
    }
    public void removeZerosFromFraction(BigDecimal ToRemove){
        String ZeroRemoval = String.valueOf(ToRemove);
        if (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '0') {
            do {
                ZeroRemoval = (ZeroRemoval.substring(0, ZeroRemoval.length() - 1));
            }
            while (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '0');
            if (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '.') {
                ZeroRemoval = (ZeroRemoval.substring(0, ZeroRemoval.length() - 1));
            }
            Result = new BigDecimal(String.valueOf(ZeroRemoval));
        }
    }
    public void endlessFractionsProcess(BigDecimal fraction){
        fractionString = String.valueOf(fraction);
        int fractionStringCounter = 1;
        charTest = 1;
        do {
            fractionString = fractionString.substring(1, fractionString.length());
        }
        while (fractionString.charAt(0) != '.');
        fractionString = fractionString.substring(1, fractionString.length());
        if (fractionString.charAt(0) == '0') {
            do {
                fractionStringCounter = fractionStringCounter +1;
                fractionString = fractionString.substring(1, fractionString.length());
            }
            while (fractionString.charAt(0) == '0');

            if (fractionStringCounter >=45)
            {
                Result = Result.setScale(0, BigDecimal.ROUND_HALF_EVEN);
            }
        }
    }
    public void eraseAllData(){
        textView.setText("");
        texxtView.setText("");
        Tumbler = 0;
        ma.saveTextViewValue = "";
        ma.saveAddictionTextViewValue = "";
        textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
    }

    public void loadOperateB(){
        OperateB = new BigDecimal(String.valueOf(texxtView.getText()));
    }

    public void loadHistoryContent(String title) {
        historyBody = textView.getText().toString();
        historyname = title;
        ma.pageOneCounter = ma.pageOneCounter + 1;
    }
    public void addiction(){
        loadOperateB();
        loadHistoryContent(getString(R.string.history_addiction));
        texxtView.setText("");
        Result = OperateA.add(OperateB);
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
    }
    public void subtraction(){
        loadOperateB();
        loadHistoryContent(getString(R.string.history_subtraction));
        texxtView.setText("");
        Result = OperateA.subtract(OperateB);
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
    }
    public void multiplication(){
        loadOperateB();
        loadHistoryContent(getString(R.string.history_multiplication));
        texxtView.setText("");
        Result = OperateA.multiply(OperateB);
        Equal = Result.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        if (Result.equals(Equal)){

        }
        else {
            removeZerosFromFraction(Result);
        }
        if (Result.equals(Equal)) {
            //целое
        } else {
            endlessFractionsProcess(Result);
        }
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
    }
    public void division(){
        loadOperateB();
        BigDecimal testZero = OperateA.divide(OperateB, 50, BigDecimal.ROUND_CEILING);
        loadHistoryContent(getString(R.string.history_division));
        texxtView.setText("");
        Result = OperateA.divide(OperateB, 50, BigDecimal.ROUND_CEILING);
        Equal = Result.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        if (Result.equals(Equal)){

        }
        else {
            removeZerosFromFraction(Result);
        }
        if (Result.equals(Equal)) {
            //целое
            textView.setText(Result.toString());
            texxtView.setText(Result.toString());
        } else {
            textView.setText(Result.toString());
            texxtView.setText(Result.toString());
        }
        String forDivisionHistory = textView.getText().toString();
        Result = new BigDecimal(String.valueOf(forDivisionHistory));
        historyResult = Result.toString();
        Tumbler = 0;
    }
    public void exponentiate(){
        loadOperateB();
        Equal = OperateB.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        loadHistoryContent(getString(R.string.history_exponentiation));
        // Test operate B on parity
        BigDecimal OperateBParityTwo = new BigDecimal(2);
        BigDecimal OperateBParityOne = OperateB.divide(OperateBParityTwo);
        BigDecimal OperateBParityThree = OperateBParityOne.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        // End testing
        //Test OperateA on sign
        if (OperateA.signum() == -1)
        {
            BigDecimal minusone = new BigDecimal(-1);
            OperateA = OperateA.multiply(minusone);
            if (OperateBParityOne.equals(OperateBParityThree))
            {
                signpower = 0;
            }
            else
            {
                signpower = 1;
            }
        }
        if (OperateB.equals(Equal))
        {
            Integer OperateBPow = OperateB.intValue();
            texxtView.setText("");
            Result = OperateA.pow(OperateBPow);
        }
        else
        {
            double OperateApow = OperateA.doubleValue();
            double OperateBpow = OperateB.doubleValue();
            double resultPow = Math.pow(OperateApow, OperateBpow);
            Result = new BigDecimal(resultPow);
        }
        if (signpower == 1)
        {
            BigDecimal minusone = new BigDecimal(-1);
            Result = Result.multiply(minusone);
        }
        textView.setText(String.valueOf(Result));
        texxtView.setText(String.valueOf(Result));
        historyResult = Result.toString();
        Tumbler = 0;
        signpower = 0;
    }

    public void returnPercent(){
        loadOperateB();
        loadHistoryContent(getString(R.string.history_percent));
        Result = OperateB.divide(new BigDecimal(100)).multiply(OperateA);
        textView.setText(String.valueOf(Result));
        texxtView.setText(String.valueOf(Result));
        historyResult = Result.toString();
        Tumbler = 0;
    }
    public void testInputOnSigns(String toTest){
        if (toTest.contains("+") | toTest.contains("÷") |
                toTest.contains("-") | toTest.contains("×") |
                toTest.contains("^") | toTest.contains("%")){
            testOnsSignsFinal = 1;
        }
        else {
            testOnsSignsFinal = 0;
        }
    }
    public void scrollInputToEnd(){
        inputScroll.scrollTo(999999999, 0);

    }
    public void scrollInputToBegin(){
        inputScroll.scrollTo(-999999999, 0);
    }

    public void activateBuiltInKeyboard(){
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "1");
                texxtView.setText(texxx + "1");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "2");
                texxtView.setText(texxx + "2");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "3");
                texxtView.setText(texxx + "3");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "4");
                texxtView.setText(texxx + "4");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "5");
                texxtView.setText(texxx + "5");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "6");
                texxtView.setText(texxx + "6");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "7");
                texxtView.setText(texxx + "7");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "8");
                texxtView.setText(texxx + "8");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "9");
                texxtView.setText(texxx + "9");
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnVibration();
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                switch (texxx){
                    case "0":
                        break;
                    default:
                        textView.setText(texxt + "0");
                        texxtView.setText(texxx + "0");
                }
                saveFragmentValues();
                scrollInputToEnd();
            }
        });
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
                        Global.sqrEquationsExportToA = textView.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_q_equations));
                        break;
                    case 1:
                        ma.show = 0;
                        Global.sqrEquationsExport = 1;
                        Global.sqrEquationsExportCheckB = 1;
                        Global.sqrEquationsExportToB = textView.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_q_equations));
                        break;
                    case 2:
                        ma.show = 0;
                        Global.sqrEquationsExport = 1;
                        Global.sqrEquationsExportCheckC = 1;
                        Global.sqrEquationsExportToC = textView.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_q_equations));
                        break;
                }
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

    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_converterSender): {
                testInputOnSigns(textView.getText().toString());
                if (textView.getText().toString().equals("-")||textView.getText().toString().equals("")){
                    showDialogMessage(getString(R.string.calculator_Illegal_operation));
                }
                else {
                    if (testOnsSignsFinal == 1) {
                        if (textView.getText().toString().contains("-") & Tumbler == 0) {
                            ma.saveConverterValue = texxtView.getText().toString();
                            showDialogMessage(getString(R.string.calculator_sent_to_converter));
                        }
                        else {
                            showDialogMessage(getString(R.string.calculator_Illegal_operation));
                        }
                    } else {
                        ma.saveConverterValue = texxtView.getText().toString();
                        showDialogMessage(getString(R.string.calculator_sent_to_converter));
                    }
                }
                return true;
            }
            case (R.id.action_equationsSender):
                testInputOnSigns(textView.getText().toString());
                if (textView.getText().toString().equals("-")||textView.getText().toString().equals("")){
                    showDialogMessage(getString(R.string.calculator_Illegal_operation));
                }
                else {
                    if (testOnsSignsFinal == 1) {
                        if (textView.getText().toString().contains("-") & Tumbler == 0) {
                            squareEquationExport();
                        }
                        else{
                            showDialogMessage(getString(R.string.calculator_Illegal_operation));
                        }
                    } else {
                        squareEquationExport();
                    }
                }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onResume() {
        super.onResume();
        radDeg.setText(Global.saveDegreeStatus);
    }
}