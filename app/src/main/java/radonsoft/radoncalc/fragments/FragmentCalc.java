package radonsoft.radoncalc.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class FragmentCalc extends Fragment {
    MainActivity ma = new MainActivity();
    private View mRootView;
    private Button mButton, dButton, fButton, eButton, gButton, jButton, hButton;
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
    Integer Tumbler = 0;
    Integer TumblerTochka = 0;
    Integer signchangeallow = 0;
    BigDecimal OperateA;
    BigDecimal OperateB;
    BigDecimal Result, signchange, Equal;
    Integer Ressult;
    String Proverka;
    String historyBody;
    String historyname;
    String saveTextViewValue = "";
    String saveAddictionTextViewValue = "";
    String Equalone;
    String EqualTwo;
    String historyResult;
    String texxx;

    TextView textView;
    TextView texxtView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Calculator");
        mRootView = inflater.inflate(R.layout.fragment_fragment_calc, container, false);

        mButton = (Button) mRootView.findViewById(R.id.button);
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
        final TextView radDeg = (TextView) mRootView.findViewById(R.id.textView4);
        mButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        vButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        bButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        cButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        dButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        eButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        fButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        gButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        jButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        hButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        TochkaButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        RavnoButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        signButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        sbrosButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        sinusButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        cosButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        tanButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        percentButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        piButton.setTypeface(Typeface.createFromAsset(getContext().getResources().getAssets() ,"robotolight.ttf"));
        textView.setText(saveTextViewValue);
        texxtView.setText(saveAddictionTextViewValue);
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
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "1");
                texxtView.setText(texxx + "1");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "2");
                texxtView.setText(texxx + "2");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "3");
                texxtView.setText(texxx + "3");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "4");
                texxtView.setText(texxx + "4");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "5");
                texxtView.setText(texxx + "5");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "6");
                texxtView.setText(texxx + "6");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "7");
                texxtView.setText(texxx + "7");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "8");
                texxtView.setText(texxx + "8");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        jButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "9");
                texxtView.setText(texxx + "9");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
            }
        });
        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texxt = String.valueOf(textView.getText());
                String texxx = String.valueOf(texxtView.getText());
                textView.setText(texxt + "0");
                texxtView.setText(texxx + "0");
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                saveTextViewValue = "";
                saveAddictionTextViewValue = "";
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
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                            break;
                    }
                }
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                            break;
                    }
                }
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                            break;
                    }
                }
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                            texxx = String.valueOf(texxtView.getText());
                        OperateB = new BigDecimal(String.valueOf(texxx));
                        texxtView.setText("");
                        Result = OperateA.divide(OperateB, 30, BigDecimal.ROUND_HALF_EVEN);
                        if (Result.floatValue() % 1 == 0) {
                            //целое
                            Ressult = Result.intValue();
                            textView.setText(String.valueOf(Ressult));
                            texxtView.setText(String.valueOf(Ressult));
                            TumblerTochka = 0;
                        } else {
                            textView.setText(String.valueOf(Result));
                            texxtView.setText(String.valueOf(Result));
                            String text = String.valueOf(texxtView.getText());
                            if (text.charAt(text.length() - 1) == '0') {
                                do {
                                    texxtView.setText(text.substring(0, text.length() - 1));
                                    text = String.valueOf(texxtView.getText());
                                }
                                while (text.charAt(text.length()-1) == '0');
                                textView.setText(text);
                            }
                            TumblerTochka = 1;
                        }
                        Tumbler = 0;
                            signchangeallow = 0;
                            break;
                    }
                }
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                            texxx = String.valueOf(texxtView.getText());
                            OperateB =  new BigDecimal(String.valueOf(texxx));
                            Integer OperateBPow = OperateB.intValue();
                            texxtView.setText("");
                            Result =  OperateA.pow(OperateBPow);
                            textView.setText(String.valueOf(Result));
                            texxtView.setText(String.valueOf(Result));
                            Tumbler = 0;
                            TumblerTochka = 0;
                            signchangeallow = 0;
                            break;
                    }
                }
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = texxtView.getText().toString();
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
                            texxx = String.valueOf(texxtView.getText());
                            OperateB = new BigDecimal(String.valueOf(texxx));
                            // For History
                            historyBody = textView.getText().toString();
                            historyname = "Division";
                            ma.pageOneCounter = ma.pageOneCounter + 1;
                            //For History End
                            texxtView.setText("");
                            Result = OperateA.divide(OperateB, 25, BigDecimal.ROUND_CEILING);
                            Equal = Result.setScale(0, BigDecimal.ROUND_HALF_EVEN);
                            if (Result.equals(Equal)) {
                                //целое
                                textView.setText(Result.toString());
                                texxtView.setText(Result.toString());
                                TumblerTochka = 0;
                            } else {
                                textView.setText(Result.toString());
                                texxtView.setText(Result.toString());
                                String text = String.valueOf(texxtView.getText());
                                if (text.charAt(text.length() - 1) == '0') {
                                    do {
                                        texxtView.setText(text.substring(0, text.length() - 1));
                                        text = String.valueOf(texxtView.getText());
                                    }
                                    while (text.charAt(text.length() - 1) == '0');
                                    if (text.charAt(text.length() - 1) == '.') {
                                            texxtView.setText(text.substring(0, text.length() - 1));
                                            text = String.valueOf(texxtView.getText());
                                        }
                                    textView.setText(text);
                                }
                                TumblerTochka = 1;
                            }
                            String forDivisionHistory = textView.getText().toString();
                            Result = new BigDecimal(String.valueOf(forDivisionHistory));
                            historyResult = Result.toString();
                            Tumbler = 0;
                            signchangeallow = 0;
                            break;
                        case 5:
                            texxx = String.valueOf(texxtView.getText());
                            Integer signpower = 0;
                            OperateB = new BigDecimal(String.valueOf(texxx));
                            Equal = OperateB.setScale(0, BigDecimal.ROUND_HALF_EVEN);
                            // For History
                            historyBody = textView.getText().toString();
                            historyname = "Exponentiation";
                            ma.pageOneCounter = ma.pageOneCounter + 1;
                            //For History End
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
                            break;
                    }
                    textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
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
                saveTextViewValue = textView.getText().toString();
                saveAddictionTextViewValue = saveTextViewValue;
            }
        });
        return mRootView;
    }

    public void addiction(){
        String texxx = String.valueOf(texxtView.getText());
        OperateB = new BigDecimal(String.valueOf(texxx));
        // For History
        historyBody = textView.getText().toString();
        historyname = "Addition";
        ma.pageOneCounter = ma.pageOneCounter + 1;
        //For History End
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
        texxx = String.valueOf(texxtView.getText());
        OperateB = new BigDecimal(String.valueOf(texxx));
        // For History
        historyBody = textView.getText().toString();
        historyname = "Subtraction";
        ma.pageOneCounter = ma.pageOneCounter + 1;
        //For History End
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
        texxx = String.valueOf(texxtView.getText());
        OperateB = new BigDecimal(String.valueOf(texxx));
        // For History
        historyBody = textView.getText().toString();
        historyname = "Multiplication";
        ma.pageOneCounter = ma.pageOneCounter + 1;
        //For History End
        texxtView.setText("");
        Result = OperateA.multiply(OperateB);
        Equal = Result;
        Equal.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        if (Result.equals(Equal)) {
            //целое
            textView.setText(String.valueOf(Ressult));
            texxtView.setText(String.valueOf(Ressult));
            TumblerTochka = 0;
        } else {
            textView.setText(String.valueOf(Result));
            texxtView.setText(String.valueOf(Result));
            TumblerTochka = 1;
        }
        historyResult = Result.toString();
        textView.setText(Result.toString());
        texxtView.setText(Result.toString());
        Tumbler = 0;
        signchangeallow = 0;
    }
}