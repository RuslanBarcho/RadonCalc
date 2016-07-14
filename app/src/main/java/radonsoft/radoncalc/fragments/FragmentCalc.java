package radonsoft.radoncalc.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class FragmentCalc extends Fragment {
    MainActivity ma = new MainActivity();
    private View mRootView;
    private Button oneButton, dButton, fButton, eButton, gButton, jButton, hButton;
    private Button vButton;
    private Button bButton;
    private Button cButton;
    private Button sbrosButton, signButton;
    private Button PlusButton, MinusButton, TochkaButton, MultiplyButton, DivButton, powButton;
    private Button RavnoButton;
    private Button sinusButton;
    private Button cosButton;
    private Button tanButton;
    private Button percentButton;
    private Button piButton;
    private Button rootButton;

    Integer Tumbler = 0;
    Integer TumblerTochka = 0;
    Integer signchangeallow = 0;
    Integer signpower = 0;

    BigDecimal OperateA;
    BigDecimal OperateB;
    BigDecimal Result, signchange, Equal;

    String Proverka;
    String historyBody;
    String historyname;
    String saveTextViewValue = "";
    String saveAddictionTextViewValue = "";
    String Equalone;
    String EqualTwo;
    String historyResult;
    String fractionString;

    int charTest;

    TextView textView;
    TextView texxtView;
    TextView radDeg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Calculator");
        setHasOptionsMenu(true);
        mRootView = inflater.inflate(R.layout.fragment_fragment_calc, container, false);

        oneButton = (Button) mRootView.findViewById(R.id.button);
        vButton = (Button) mRootView.findViewById(R.id.button2);
        bButton = (Button) mRootView.findViewById(R.id.button3);
        cButton = (Button) mRootView.findViewById(R.id.button4);
        dButton = (Button) mRootView.findViewById(R.id.button5);
        fButton = (Button) mRootView.findViewById(R.id.button6);
        eButton = (Button) mRootView.findViewById(R.id.button7);
        gButton = (Button) mRootView.findViewById(R.id.button8);
        jButton = (Button) mRootView.findViewById(R.id.button9);
        hButton = (Button) mRootView.findViewById(R.id.button12);

        powButton = (Button) mRootView.findViewById(R.id.button19);
        TochkaButton = (Button) mRootView.findViewById(R.id.button10);
        MinusButton = (Button) mRootView.findViewById(R.id.button15);
        PlusButton = (Button) mRootView.findViewById(R.id.button14);
        RavnoButton = (Button) mRootView.findViewById(R.id.button13);
        MultiplyButton = (Button) mRootView.findViewById(R.id.button16);
        DivButton = (Button) mRootView.findViewById(R.id.button17);
        signButton = (Button) mRootView.findViewById(R.id.button23);
        sbrosButton = (Button) mRootView.findViewById(R.id.button11);
        sinusButton = (Button) mRootView.findViewById(R.id.button24);
        cosButton = (Button) mRootView.findViewById(R.id.button25);
        tanButton = (Button) mRootView.findViewById(R.id.button26);
        percentButton = (Button) mRootView.findViewById(R.id.button27);
        piButton = (Button) mRootView.findViewById(R.id.button28);
        textView = (TextView) mRootView.findViewById(R.id.textView);
        texxtView = (TextView) mRootView.findViewById(R.id.textView3);
        radDeg = (TextView) mRootView.findViewById(R.id.textView4);
        rootButton = (Button) mRootView.findViewById(R.id.button18);

        setFont(oneButton, "robotolight.ttf");
        setFont(vButton, "robotolight.ttf");
        setFont(bButton, "robotolight.ttf");
        setFont(cButton, "robotolight.ttf");
        setFont(dButton, "robotolight.ttf");
        setFont(eButton, "robotolight.ttf");
        setFont(fButton, "robotolight.ttf");
        setFont(gButton, "robotolight.ttf");
        setFont(jButton, "robotolight.ttf");
        setFont(hButton, "robotolight.ttf");
        setFont(TochkaButton, "robotolight.ttf");
        setFont(RavnoButton, "robotolight.ttf");
        setFont(signButton, "robotolight.ttf");
        setFont(sbrosButton, "robotolight.ttf");
        setFont(sinusButton, "robotolight.ttf");
        setFont(cosButton, "robotolight.ttf");
        setFont(tanButton, "robotolight.ttf");
        setFont(percentButton, "robotolight.ttf");
        setFont(piButton, "robotolight.ttf");

        textView.setText(ma.saveTextViewValue);
        texxtView.setText(ma.saveAddictionTextViewValue);
        ma.pages = 0;
        radDeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String degreeChecker = radDeg.getText().toString();
                if (degreeChecker.equals("RAD")) {
                    radDeg.setText("DEG");
                } else {
                    radDeg.setText("RAD");
                }
            }
        });
        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "1");
                texxtView.setText(texxx + "1");
                saveFragmentValues();
            }
        });
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "2");
                texxtView.setText(texxx + "2");
                saveFragmentValues();
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "3");
                texxtView.setText(texxx + "3");
                saveFragmentValues();
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "4");
                texxtView.setText(texxx + "4");
                saveFragmentValues();
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "5");
                texxtView.setText(texxx + "5");
                saveFragmentValues();
            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "6");
                texxtView.setText(texxx + "6");
                saveFragmentValues();
            }
        });
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "7");
                texxtView.setText(texxx + "7");
                saveFragmentValues();
            }
        });
        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "8");
                texxtView.setText(texxx + "8");
                saveFragmentValues();
            }
        });
        jButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "9");
                texxtView.setText(texxx + "9");
                saveFragmentValues();
            }
        });
        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "0");
                texxtView.setText(texxx + "0");
                saveFragmentValues();
            }
        });
        TochkaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());

                if (Proverka == "")
                {
                    textView.setText(texxt + "0.");
                    texxtView.setText(texxx + "0.");
                    TumblerTochka = 1;
                }
                else
                {
                    if (TumblerTochka == 0)
                    {
                        textView.setText(texxt + ".");
                        texxtView.setText(texxx + ".");
                        TumblerTochka = 1;
                    }
                    else
                    {

                    }
                }
                saveFragmentValues();
            }
        });
        sbrosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                texxtView.setText("");
                Tumbler = 0;
                TumblerTochka = 0;
                signchangeallow = 0;
                ma.saveTextViewValue = "";
                ma.saveAddictionTextViewValue = "";
                textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            }
        });
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "")
                {

                }
                else {
                    switch (signchangeallow) {
                        case 0:
                            String texxx = String.valueOf(texxtView.getText());
                            signchange = new BigDecimal(String.valueOf(texxx));
                            BigDecimal minusone = new BigDecimal(-1);
                            signchange = signchange.multiply(minusone);
                            texxtView.setText(String.valueOf(signchange));
                            textView.setText(String.valueOf(signchange));
                    }
                }
                saveFragmentValues();
            }
        });
        PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "")
                {

                }
                else {
                    switch (Tumbler) {
                        case 0:
                        OperateA =  new BigDecimal(String.valueOf(texxx));
                        textView.setText(texxt + "+");
                        texxtView.setText("");
                        Tumbler = 1;
                        TumblerTochka = 0;
                        signchangeallow = 1;
                            break;
                        case 1:
                            addiction();
                            writeOperationToHistory();
                            break;
                    }
                }
                saveFragmentValues();
            }
        });
        MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "")
                {

                }
                else {
                    switch (Tumbler) {
                        case 0:
                        OperateA =  new BigDecimal(String.valueOf(texxx));
                        textView.setText(texxt + "-");
                        texxtView.setText("");
                        Tumbler = 2;
                        TumblerTochka = 0;
                            signchangeallow = 1;
                            break;
                        case 2:
                            subtraction();
                            writeOperationToHistory();
                            break;
                    }
                }
                saveFragmentValues();
            }
        });
        MultiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "")
                {

                }
                else {
                    switch(Tumbler) {
                        case 0:
                        OperateA =  new BigDecimal(String.valueOf(texxx));
                        textView.setText(texxt + "×");
                        texxtView.setText("");
                        Tumbler = 3;
                        TumblerTochka = 0;
                            signchangeallow = 1;
                            break;
                        case 3:
                            multiplication();
                            writeOperationToHistory();
                            break;
                    }
                }
                saveFragmentValues();
            }
        });
        DivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "")
                {

                }
                else {
                    switch(Tumbler) {
                        case 0:
                        OperateA =  new BigDecimal(String.valueOf(texxx));
                        textView.setText(texxt + "÷");
                        texxtView.setText("");
                        Tumbler = 4;
                        TumblerTochka = 0;
                            signchangeallow = 1;
                            break;
                        case 4:
                            division();
                            writeOperationToHistory();
                            break;
                    }
                }
                saveFragmentValues();
            }
        });

        powButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "")
                {

                }
                else {
                    switch (Tumbler) {
                        case 0:
                            OperateA =  new BigDecimal(String.valueOf(texxx));
                            textView.setText(texxt + "^");
                            texxtView.setText("");
                            Tumbler = 5;
                            TumblerTochka = 0;
                            signchangeallow = 1;
                            break;
                        case 5:
                            exponentiate();
                            writeOperationToHistory();
                            break;
                    }
                }
                saveFragmentValues();
            }
        });

        rootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperateA =  new BigDecimal(String.valueOf(textView.getText()));
                Result = sqrt(OperateA, 25);
                removeZerosFromFraction(Result);
                loadHistoryContent("Evolution");
                textView.setText(String.valueOf(Result));
                texxtView.setText(String.valueOf(Result));
                historyResult = String.valueOf(Result);
                writeOperationToHistory();
            }
        });

        RavnoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Proverka = String.valueOf(texxtView.getText());
                if (Proverka == "") {
                    textView.setText("");
                    texxtView.setText("");
                    saveTextViewValue = "";
                    saveAddictionTextViewValue = "";
                    Tumbler = 0;
                    TumblerTochka = 0;
                } else {
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
                            division();
                            break;
                        case 5:
                            exponentiate();
                            break;
                    }
                    textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
                    writeOperationToHistory();
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

    public void writeOperationToHistory(){
        switch (ma.pageOneCounter) {
            case 0:

                break;
            case 1:
                ma.pageOnefirstCellhistoryBody = historyBody;
                ma.pageOnefirstCellhistoryName = historyname;
                ma.pageOnefirstCellhistoryResult = historyResult;
                break;
            case 2:
                //Transfer to next cell
                ma.pageOneSecondCellhistoryBody = ma.pageOnefirstCellhistoryBody;
                ma.pageOneSecondCellhistoryName = ma.pageOnefirstCellhistoryName;
                ma.pageOneSecondCellhistoryResult = ma.pageOnefirstCellhistoryResult;
                //Make the first cell full
                ma.pageOnefirstCellhistoryBody = historyBody;
                ma.pageOnefirstCellhistoryName = historyname;
                ma.pageOnefirstCellhistoryResult = historyResult;
                break;
            case 3:
                //Transfer to next cell
                ma.pageOneThirdCellhistoryBody = ma.pageOneSecondCellhistoryBody;
                ma.pageOneThirdCellhistoryName = ma.pageOneSecondCellhistoryName;
                ma.pageOneThirdCellhistoryResult = ma.pageOneSecondCellhistoryResult;

                ma.pageOneSecondCellhistoryBody = ma.pageOnefirstCellhistoryBody;
                ma.pageOneSecondCellhistoryName = ma.pageOnefirstCellhistoryName;
                ma.pageOneSecondCellhistoryResult = ma.pageOnefirstCellhistoryResult;
                //Make the first cell full
                ma.pageOnefirstCellhistoryBody = historyBody;
                ma.pageOnefirstCellhistoryName = historyname;
                ma.pageOnefirstCellhistoryResult = historyResult;
                break;
            case 4:
                //Transfer to next cell
                ma.pageOneFourthCellhistoryBody = ma.pageOneThirdCellhistoryBody;
                ma.pageOneFourthCellhistoryName = ma.pageOneThirdCellhistoryName;
                ma.pageOneFourthCellhistoryResult = ma.pageOneThirdCellhistoryResult;

                ma.pageOneThirdCellhistoryBody = ma.pageOneSecondCellhistoryBody;
                ma.pageOneThirdCellhistoryName = ma.pageOneSecondCellhistoryName;
                ma.pageOneThirdCellhistoryResult = ma.pageOneSecondCellhistoryResult;

                ma.pageOneSecondCellhistoryBody = ma.pageOnefirstCellhistoryBody;
                ma.pageOneSecondCellhistoryName = ma.pageOnefirstCellhistoryName;
                ma.pageOneSecondCellhistoryResult = ma.pageOnefirstCellhistoryResult;
                //Make the first cell full
                ma.pageOnefirstCellhistoryBody = historyBody;
                ma.pageOnefirstCellhistoryName = historyname;
                ma.pageOnefirstCellhistoryResult = historyResult;
                break;
            default:
                //Transfer to next cell
                ma.pageOneFifthCellhistoryBody = ma.pageOneFourthCellhistoryBody;
                ma.pageOneFifthCellhistoryName = ma.pageOneFourthCellhistoryName;
                ma.pageOneFifthCellhistoryResult = ma.pageOneFourthCellhistoryResult;

                ma.pageOneFourthCellhistoryBody = ma.pageOneThirdCellhistoryBody;
                ma.pageOneFourthCellhistoryName = ma.pageOneThirdCellhistoryName;
                ma.pageOneFourthCellhistoryResult = ma.pageOneThirdCellhistoryResult;

                ma.pageOneThirdCellhistoryBody = ma.pageOneSecondCellhistoryBody;
                ma.pageOneThirdCellhistoryName = ma.pageOneSecondCellhistoryName;
                ma.pageOneThirdCellhistoryResult = ma.pageOneSecondCellhistoryResult;

                ma.pageOneSecondCellhistoryBody = ma.pageOnefirstCellhistoryBody;
                ma.pageOneSecondCellhistoryName = ma.pageOnefirstCellhistoryName;
                ma.pageOneSecondCellhistoryResult = ma.pageOnefirstCellhistoryResult;
                //Make the first cell full
                ma.pageOnefirstCellhistoryBody = historyBody;
                ma.pageOnefirstCellhistoryName = historyname;
                ma.pageOnefirstCellhistoryResult = historyResult;
                break;
        }
    }

    public void setFont(Button toChange, String style){
        toChange.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,style));
    }

    public void saveFragmentValues(){
        ma.saveTextViewValue = textView.getText().toString();
        ma.saveAddictionTextViewValue = texxtView.getText().toString();
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
        loadHistoryContent("Addiction");
        texxtView.setText("");
        Result = OperateA.add(OperateB);
        Equal = Result;
        Equal.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        if (Result.equals(Equal)) {
            //целое
            TumblerTochka = 0;
        } else {
            TumblerTochka = 1;
        }
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
        signchangeallow = 0;
    }

    public void subtraction(){
        loadOperateB();
        loadHistoryContent("Subtraction");
        texxtView.setText("");
        Result = OperateA.subtract(OperateB);
        Equal = Result.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        Equalone = Result.toString();
        EqualTwo = Equal.toString();
        if (Equalone.equals(EqualTwo)) {
            //целое
            TumblerTochka = 0;
        } else {
            TumblerTochka = 1;
        }
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
        signchangeallow = 0;
    }

    public void multiplication(){
        loadOperateB();
        loadHistoryContent("Multiplication");
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
            TumblerTochka = 0;
        } else {
            endlessFractionsProcess(Result);
            TumblerTochka = 1;
        }
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
        signchangeallow = 0;
    }

    public void division(){
        loadOperateB();
        loadHistoryContent("Division");
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
            TumblerTochka = 0;
        } else {
            textView.setText(Result.toString());
            texxtView.setText(Result.toString());
            TumblerTochka = 1;
        }
        String forDivisionHistory = textView.getText().toString();
        Result = new BigDecimal(String.valueOf(forDivisionHistory));
        historyResult = Result.toString();
        Tumbler = 0;
        signchangeallow = 0;
    }

    public void exponentiate(){
        loadOperateB();
        Equal = OperateB.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        loadHistoryContent("Exponentiation");
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
        TumblerTochka = 0;
        signchangeallow = 0;
        signpower = 0;
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
                ma.saveConverterValue = String.valueOf(Result);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}