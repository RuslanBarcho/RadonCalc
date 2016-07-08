package radonsoft.radoncalc.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class FragmentQuadraticEquations extends Fragment{
    MainActivity ma = new MainActivity();
    private View mRootView;
    private Button equalButton;
    private Button deleteButton;
    BigDecimal a;
    BigDecimal b;
    BigDecimal c;
    BigDecimal d;
    BigDecimal four;
    BigDecimal sqrtd;
    BigDecimal sqrtdfloat;
    BigDecimal xOne;
    BigDecimal xTwo;
    double sqrtdouble;
    String Testone;
    int toogle = 0;
    int toogleDiscr = 0;
    int historyWriteLocal = 0;
    String historyTitle;
    String historyDiscr;
    String historySqrtDiscr;
    String historyXone;
    String historyXtwo;
    String historyA;
    String historyB;
    String historyC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle("Quadratic Equations");
        mRootView = inflater.inflate(R.layout.fragment_quadratic_equations, container, false);
        equalButton = (Button) mRootView.findViewById(R.id.button20);
        deleteButton = (Button) mRootView.findViewById(R.id.button21);
        final EditText fieldone = (EditText) mRootView.findViewById(R.id.editText);
        final EditText fieldtwo = (EditText) mRootView.findViewById(R.id.editText2);
        final EditText fieldthree = (EditText) mRootView.findViewById(R.id.editText3);
        final TextView textviewone = (TextView) mRootView.findViewById(R.id.textView8);
        final TextView textviewtwo = (TextView) mRootView.findViewById(R.id.textView9);
        final TextView textviewthree = (TextView) mRootView.findViewById(R.id.textView10);
        final TextView textviewfour = (TextView) mRootView.findViewById(R.id.textView11);
        final RelativeLayout resultWindow = (RelativeLayout) mRootView.findViewById(R.id.relativeLayout2);
        textviewone.setText(ma.saveDValue);
        textviewtwo.setText(ma.saveSqrtDValue);
        textviewthree.setText(ma.savexOneValue);
        textviewfour.setText(ma.savexTwoValue);
        fieldone.setText(ma.saveTextviewA);
        fieldtwo.setText(ma.saveTextviewB);
        fieldthree.setText(ma.saveTextviewC);
        ma.pages = 1;
        switch (ma.show)
        {
            case 0:
                resultWindow.setVisibility(View.GONE);
                textviewone.setVisibility(View.GONE);
                textviewtwo.setVisibility(View.GONE);
                textviewthree.setVisibility(View.GONE);
                textviewfour.setVisibility(View.GONE);
                break;
            case 1:
                resultWindow.setVisibility(View.VISIBLE);
                textviewone.setVisibility(View.VISIBLE);
                textviewtwo.setVisibility(View.VISIBLE);
                textviewthree.setVisibility(View.VISIBLE);
                textviewfour.setVisibility(View.VISIBLE);
                break;
            case 2:
                resultWindow.setVisibility(View.VISIBLE);
                textviewone.setVisibility(View.VISIBLE);
                textviewtwo.setVisibility(View.VISIBLE);
                textviewthree.setVisibility(View.GONE);
                textviewfour.setVisibility(View.GONE);
                break;
            case 3:
                resultWindow.setVisibility(View.VISIBLE);
                textviewone.setVisibility(View.VISIBLE);
                textviewtwo.setVisibility(View.VISIBLE);
                textviewthree.setVisibility(View.VISIBLE);
                textviewfour.setVisibility(View.GONE);
                break;
        }
        fieldone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ma.saveTextviewA = fieldone.getText().toString();
            }
        });
        fieldtwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ma.saveTextviewB = fieldtwo.getText().toString();
            }
        });
        fieldthree.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ma.saveTextviewC = fieldthree.getText().toString();
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textviewone.setText("Discr");
                textviewtwo.setText("Sqrt discr");
                textviewthree.setText("X1");
                textviewfour.setText("X2");
                Testone = fieldone.getText().toString();
                String Testtwo = fieldtwo.getText().toString();
                String Testthree = fieldthree.getText().toString();
                if (Testone.equals(""))
                {
                    toogle = 1;
                }
                if (Testone.equals("0"))
                {
                    toogle = 1;
                }
                if (Testtwo.equals(""))
                {
                    toogle = 1;
                }
                if (Testthree.equals(""))
                {
                    toogle = 1;
                }
                switch (toogle) {
                    case 1:
                        historyWriteLocal = 0;
                        break;
                    case 0:
                        historyWriteLocal = 1;
                        a = new BigDecimal(String.valueOf(Testone));
                        b = new BigDecimal(String.valueOf(Testtwo));
                        c = new BigDecimal(String.valueOf(Testthree));
                        four = new BigDecimal(4);
                        d = (b.multiply(b)).subtract((a.multiply(c)).multiply(four));
                        textviewone.setText("Discr = " + String.valueOf(d));
                        if (d.signum() == -1)
                        {
                            toogleDiscr = 1;
                        }
                        if (d.signum() == 0)
                        {
                            toogleDiscr = 2;
                        }
                        BigDecimal divTwo = new BigDecimal(2);
                        switch (toogleDiscr)
                        {
                            case 0:
                                double discr = d.doubleValue();
                                sqrtdouble = Math.sqrt(discr);
                                sqrtd = new BigDecimal(sqrtdouble);
                                if (sqrtd.floatValue() % 1 == 0)
                                {
                                    int sqrtdint = sqrtd.intValue();
                                    textviewtwo.setText("Sqrt discr = " + sqrtdint);
                                }
                                else
                                {
                                    sqrtdfloat = sqrtd.setScale(5, BigDecimal.ROUND_HALF_EVEN);
                                    textviewtwo.setText("Sqrt discr = " + sqrtdfloat);
                                }
                                xOne = (((b.subtract(b)).subtract(b)).add(sqrtd)).divide(divTwo.multiply(a), 6, RoundingMode.HALF_EVEN);
                                xTwo = (((b.subtract(b)).subtract(b)).subtract(sqrtd)).divide(divTwo.multiply(a), 6, RoundingMode.HALF_EVEN);
                                textviewthree.setText("X1 = " + String.valueOf(xOne));
                                textviewfour.setText("X2 = " + String.valueOf(xTwo));
                                resultWindow.setVisibility(View.VISIBLE);
                                textviewone.setVisibility(View.VISIBLE);
                                textviewtwo.setVisibility(View.VISIBLE);
                                textviewthree.setVisibility(View.VISIBLE);
                                textviewfour.setVisibility(View.VISIBLE);
                                ma.show = 1;
                                ma.historyWriteToogle = 0;
                                break;
                            case 1:
                                ma.historyWriteToogle = 1;
                                textviewtwo.setText("No solution");
                                resultWindow.setVisibility(View.VISIBLE);
                                textviewone.setVisibility(View.VISIBLE);
                                textviewtwo.setVisibility(View.VISIBLE);
                                textviewthree.setVisibility(View.GONE);
                                textviewfour.setVisibility(View.GONE);
                                ma.show = 2;
                                break;
                            case 2:
                                discr = d.doubleValue();
                                sqrtdouble = Math.sqrt(discr);
                                sqrtd = new BigDecimal(sqrtdouble);
                                if (sqrtd.floatValue() % 1 == 0)
                                {
                                    int sqrtdint = sqrtd.intValue();
                                    textviewtwo.setText("Sqrt discr = " + sqrtdint);
                                }
                                else
                                {
                                    sqrtdfloat = sqrtd.setScale(5, BigDecimal.ROUND_HALF_EVEN);
                                    textviewtwo.setText("Sqrt discr = " + sqrtdfloat);
                                }
                                xOne = (((b.subtract(b)).subtract(b)).add(sqrtd)).divide(divTwo.multiply(a), 6, RoundingMode.HALF_UP);
                                textviewthree.setText("X = " + String.valueOf(xOne));
                                textviewfour.setText("No second solution");
                                resultWindow.setVisibility(View.VISIBLE);
                                textviewone.setVisibility(View.VISIBLE);
                                textviewtwo.setVisibility(View.VISIBLE);
                                textviewthree.setVisibility(View.VISIBLE);
                                textviewfour.setVisibility(View.GONE);
                                ma.show = 3;
                                ma.historyWriteToogle = 0;
                                break;
                        }
                        break;
                }
                toogle = 0;
                toogleDiscr = 0;
                switch (historyWriteLocal)
                {
                    case 1:
                        // for history
                        ma.pageTwoCounter = ma.pageTwoCounter + 1;
                        historyA = a.toString();
                        if (b.signum() == -1)
                        {
                            historyB = "-" + b.toString();
                        }
                        else
                        {
                            historyB = "+" + b.toString();
                        }
                        if (c.signum() == -1)
                        {
                            historyC = "-" + c.toString();
                        }
                        else
                        {
                            historyC = "+" + c.toString();
                        }
                        historyDiscr = textviewone.getText().toString();
                        historySqrtDiscr = textviewtwo.getText().toString();
                        historyXone = textviewthree.getText().toString();
                        historyXtwo = textviewfour.getText().toString();
                        historyTitle = historyA + "X^2" + historyB + "X" + historyC;
                        if (ma.historyWriteToogle == 1)
                        {
                            historyXtwo = "No Solution";
                        }
                        switch (ma.pageTwoCounter)
                        {
                            case 0:

                                break;
                            case 1:
                                ma.pageTwoFirstCellHistoryName = historyTitle;
                                ma.pageTwoFirstCellHistoryBodyone = historyDiscr;
                                ma.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                                ma.pageTwoFirstCellHistoryBodythree = historyXone;
                                ma.pageTwoFirstCellHistoryBodyend = historyXtwo;
                                break;
                            case 2:
                                ma.pageTwoSecondCellHistoryName = ma.pageTwoFirstCellHistoryName;
                                ma.pageTwoSecondCellHistoryBodyone = ma.pageTwoFirstCellHistoryBodyone;
                                ma.pageTwoSecondCellHistoryBodytwo = ma.pageTwoFirstCellHistoryBodytwo;
                                ma.pageTwoSecondCellHistoryBodythree = ma.pageTwoFirstCellHistoryBodythree;
                                ma.pageTwoSecondCellHistoryBodyend = ma.pageTwoFirstCellHistoryBodyend;

                                ma.pageTwoFirstCellHistoryName = historyTitle;
                                ma.pageTwoFirstCellHistoryBodyone = historyDiscr;
                                ma.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                                ma.pageTwoFirstCellHistoryBodythree = historyXone;
                                ma.pageTwoFirstCellHistoryBodyend = historyXtwo;
                                break;
                            default:
                                ma.pageTwoThirdCellHistoryName = ma.pageTwoSecondCellHistoryName;
                                ma.pageTwoThirdCellHistoryBodyone = ma.pageTwoSecondCellHistoryBodyone;
                                ma.pageTwoThirdCellHistoryBodytwo = ma.pageTwoSecondCellHistoryBodytwo;
                                ma.pageTwoThirdCellHistoryBodythree = ma.pageTwoSecondCellHistoryBodythree;
                                ma.pageTwoThirdCellHistoryBodyend = ma.pageTwoSecondCellHistoryBodyend;

                                ma.pageTwoSecondCellHistoryName = ma.pageTwoFirstCellHistoryName;
                                ma.pageTwoSecondCellHistoryBodyone = ma.pageTwoFirstCellHistoryBodyone;
                                ma.pageTwoSecondCellHistoryBodytwo = ma.pageTwoFirstCellHistoryBodytwo;
                                ma.pageTwoSecondCellHistoryBodythree = ma.pageTwoFirstCellHistoryBodythree;
                                ma.pageTwoSecondCellHistoryBodyend = ma.pageTwoFirstCellHistoryBodyend;

                                ma.pageTwoFirstCellHistoryName = historyTitle;
                                ma.pageTwoFirstCellHistoryBodyone = historyDiscr;
                                ma.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                                ma.pageTwoFirstCellHistoryBodythree = historyXone;
                                ma.pageTwoFirstCellHistoryBodyend = historyXtwo;
                                break;
                        }
                        break;
                    case 0:
                        break;
                }
                ma.saveDValue = textviewone.getText().toString();
                ma.saveSqrtDValue = textviewtwo.getText().toString();
                ma.savexOneValue = textviewthree.getText().toString();
                ma.savexTwoValue = textviewfour.getText().toString();
            }

        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textviewone.setText("Discr");
                textviewtwo.setText("Sqrt discr");
                textviewthree.setText("X1");
                textviewfour.setText("X2");
                fieldone.setText("");
                fieldtwo.setText("");
                fieldthree.setText("");
                historyWriteLocal = 0;
                resultWindow.setVisibility(View.GONE);
                textviewone.setVisibility(View.GONE);
                textviewtwo.setVisibility(View.GONE);
                textviewthree.setVisibility(View.GONE);
                textviewfour.setVisibility(View.GONE);
                ma.show = 0;
            }
        });
        return mRootView;
    }
}

