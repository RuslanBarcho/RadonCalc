package radonsoft.radoncalc.fragments;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

import radonsoft.radoncalc.Helpers.ClearAnimation;
import radonsoft.radoncalc.Helpers.Global;
import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class FragmentQuadraticEquations extends Fragment {
    MainActivity ma = new MainActivity();

    BigDecimal a;
    BigDecimal b;
    BigDecimal c;
    BigDecimal d;
    BigDecimal sqrtd;
    BigDecimal sqrtdfloat;
    BigDecimal xOne;
    BigDecimal xTwo;
    double sqrtdouble;
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

    Animator equationsClearAnimName;

    FrameLayout backgroundAnim;

    // Views
    private View mRootView;

    private Button btnCalculate;
    private Button btnClear;

    private TextView tvDiscr;
    private TextView tvDiscrRoot;
    private TextView tvX1;
    private TextView txX2;

    public  EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;

    private RelativeLayout resultLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.q_equations_title));
        mRootView = inflater.inflate(R.layout.fragment_quadratic_equations, container, false);
        btnCalculate = (Button) mRootView.findViewById(R.id.btnCalculate);
        btnClear = (Button) mRootView.findViewById(R.id.btnClear);
        editTextA = (EditText) mRootView.findViewById(R.id.editTextA);
        editTextB = (EditText) mRootView.findViewById(R.id.editTextB);
        editTextC = (EditText) mRootView.findViewById(R.id.editTextC);
        tvDiscr = (TextView) mRootView.findViewById(R.id.textViewDiscr);
        tvDiscrRoot = (TextView) mRootView.findViewById(R.id.textViewDiscrRoot);
        tvX1 = (TextView) mRootView.findViewById(R.id.textViewX1);
        txX2 = (TextView) mRootView.findViewById(R.id.textViewX2);
        resultLayout = (RelativeLayout) mRootView.findViewById(R.id.relativeLayout2);
        tvDiscr.setText(ma.saveDValue);
        tvDiscrRoot.setText(ma.saveSqrtDValue);
        tvX1.setText(ma.savexOneValue);
        txX2.setText(ma.savexTwoValue);
        editTextA.setText(ma.saveTextviewA);
        editTextB.setText(ma.saveTextviewB);
        editTextC.setText(ma.saveTextviewC);

        backgroundAnim = (FrameLayout) mRootView.findViewById(R.id.clrAnimBkg);

        ma.pages = 1;
        switch (ma.show) {
            case 0:
                resultLayout.setVisibility(View.GONE);
                tvDiscr.setVisibility(View.GONE);
                tvDiscrRoot.setVisibility(View.GONE);
                tvX1.setVisibility(View.GONE);
                txX2.setVisibility(View.GONE);
                break;
            case 1:
                resultLayout.setVisibility(View.VISIBLE);
                tvDiscr.setVisibility(View.VISIBLE);
                tvDiscrRoot.setVisibility(View.VISIBLE);
                tvX1.setVisibility(View.VISIBLE);
                txX2.setVisibility(View.VISIBLE);
                break;
            case 2:
                resultLayout.setVisibility(View.VISIBLE);
                tvDiscr.setVisibility(View.VISIBLE);
                tvDiscrRoot.setVisibility(View.VISIBLE);
                tvX1.setVisibility(View.GONE);
                txX2.setVisibility(View.GONE);
                break;
            case 3:
                resultLayout.setVisibility(View.VISIBLE);
                tvDiscr.setVisibility(View.VISIBLE);
                tvDiscrRoot.setVisibility(View.VISIBLE);
                tvX1.setVisibility(View.VISIBLE);
                txX2.setVisibility(View.GONE);
                break;
        }
        editTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ma.saveTextviewA = editTextA.getText().toString();
            }
        });
        editTextB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ma.saveTextviewB = editTextB.getText().toString();
            }
        });
        editTextC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ma.saveTextviewC = editTextC.getText().toString();
            }
        });
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDiscr.setText("Discr");
                tvDiscrRoot.setText("√Discr");
                tvX1.setText("X1");
                txX2.setText("X2");
                resultLayout.setVisibility(View.GONE);
                String strA = editTextA.getText().toString();
                String strB = editTextB.getText().toString();
                String strC = editTextC.getText().toString();

                if (strA.equals("") || strA.equals("0") || strB.equals("") || strC.equals("")) {
                    toogle = 1;
                } else {
                    a = new BigDecimal(String.valueOf(strA));
                    b = new BigDecimal(String.valueOf(strB));
                    c = new BigDecimal(String.valueOf(strC));
                }

                switch (toogle) {
                    case 1:
                        historyWriteLocal = 0;
                        break;
                    case 0:
                        if (Build.VERSION.SDK_INT >= 21) {
                            // get the center for the clipping circle
                            int cx = 0;
                            int cy = 0;

                            // get the final radius for the clipping circle
                            int finalRadius = Math.max(resultLayout.getWidth(), resultLayout.getHeight())+ 1500;

                            // create the animator for this view (the start radius is zero)
                            Animator animShow = ViewAnimationUtils.createCircularReveal(resultLayout, cx, cy, 0, finalRadius);

                            // make the view visible and start the animation
                            animShow.addListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(Animator animator) {
                                    calculate(a, b, c);
                                    resultLayout.setVisibility(View.VISIBLE);
                                }

                                @Override
                                public void onAnimationEnd(Animator animator) {

                                }

                                @Override
                                public void onAnimationCancel(Animator animator) {

                                }

                                @Override
                                public void onAnimationRepeat(Animator animator) {

                                }
                            });
                            animShow.start();
                        } else {
                            resultLayout.setVisibility(View.VISIBLE);
                            calculate(a, b, c);
                        }
                        break;
                }
                toogle = 0;
                toogleDiscr = 0;
                switch (historyWriteLocal) {
                    case 1:
                        // for history
                        ma.pageTwoCounter = ma.pageTwoCounter + 1;
                        historyA = a.toString();
                        if (FragmentQuadraticEquations.this.b.signum() == -1) {
                            historyB = "-" + FragmentQuadraticEquations.this.b.toString();
                        } else {
                            historyB = "+" + FragmentQuadraticEquations.this.b.toString();
                        }
                        if (FragmentQuadraticEquations.this.c.signum() == -1) {
                            historyC = "-" + FragmentQuadraticEquations.this.c.toString();
                        } else {
                            historyC = "+" + FragmentQuadraticEquations.this.c.toString();
                        }
                        historyDiscr = tvDiscr.getText().toString();
                        historySqrtDiscr = tvDiscrRoot.getText().toString();
                        historyXone = tvX1.getText().toString();
                        historyXtwo = txX2.getText().toString();
                        historyTitle = historyA + "X^2" + historyB + "X" + historyC + "=0";
                        if (ma.historyWriteToogle == 1) {
                            historyXtwo = getString(R.string.q_equations_no_solution);
                        }
                        writeToHistory();
                        break;
                    case 0:
                        break;
                }
                ma.saveDValue = tvDiscr.getText().toString();
                ma.saveSqrtDValue = tvDiscrRoot.getText().toString();
                ma.savexOneValue = tvX1.getText().toString();
                ma.savexTwoValue = txX2.getText().toString();
            }

        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mRootView, getString(R.string.snackbar_text_deleted), Snackbar.LENGTH_SHORT).show();
                editTextA.setText("");
                editTextB.setText("");
                editTextC.setText("");
                historyWriteLocal = 0;
                ma.show = 0;
                if (Build.VERSION.SDK_INT >= 21) {
                    // get the center for the clipping circle
                    int cx = 0;
                    int cy = 0;

                    // get the initial radius for the clipping circle
                    int initialRadius = Math.max(resultLayout.getWidth(), resultLayout.getHeight());

                    // create the animation (the final radius is zero)
                    Animator animHide =
                            ViewAnimationUtils.createCircularReveal(resultLayout, cx, cy, initialRadius, 0);

                    // make the view invisible when the animation is done
                    animHide.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            resultLayout.setVisibility(View.GONE);
                            tvDiscr.setText("Discr");
                            tvDiscrRoot.setText("Sqrt discr");
                            tvX1.setText("X1");
                            txX2.setText("X2");
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                    // start the animation
                    animHide.start();
                    equationsClrAnim();

                } else {
                    resultLayout.setVisibility(View.GONE);
                    tvDiscr.setText("Discr");
                    tvDiscrRoot.setText("Sqrt discr");
                    tvX1.setText("X1");
                    txX2.setText("X2");
                }
            }
        });
        return mRootView;
    }

    @Override
        public void onResume() {
        if (Global.sqrEquationsExport == 1){
            if (Global.sqrEquationsExportCheckA == 1) {
                editTextA.setText(Global.sqrEquationsExportToA);
                Global.sqrEquationsExportCheckA = 0;
            }
            if (Global.sqrEquationsExportCheckB == 1) {
                editTextB.setText(Global.sqrEquationsExportToB);
                Global.sqrEquationsExportCheckB = 0;
            }
            if (Global.sqrEquationsExportCheckC == 1) {
                editTextC.setText(Global.sqrEquationsExportToC);
                Global.sqrEquationsExportCheckC = 0;
            }
                Global.sqrEquationsExport = 0;
        }
        super.onResume();
    }
    public void writeToHistory(){
        switch (ma.pageTwoCounter) {
            case 0:

                break;
            case 1:
                Global.pageTwoFirstCellHistoryName = historyTitle;
                Global.pageTwoFirstCellHistoryBodyone = historyDiscr;
                Global.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                Global.pageTwoFirstCellHistoryBodythree = historyXone;
                Global.pageTwoFirstCellHistoryBodyend = historyXtwo;
                break;
            case 2:
                Global.pageTwoSecondCellHistoryName = Global.pageTwoFirstCellHistoryName;
                Global.pageTwoSecondCellHistoryBodyone = Global.pageTwoFirstCellHistoryBodyone;
                Global.pageTwoSecondCellHistoryBodytwo = Global.pageTwoFirstCellHistoryBodytwo;
                Global.pageTwoSecondCellHistoryBodythree = Global.pageTwoFirstCellHistoryBodythree;
                Global.pageTwoSecondCellHistoryBodyend = Global.pageTwoFirstCellHistoryBodyend;

                Global.pageTwoFirstCellHistoryName = historyTitle;
                Global.pageTwoFirstCellHistoryBodyone = historyDiscr;
                Global.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                Global.pageTwoFirstCellHistoryBodythree = historyXone;
                Global.pageTwoFirstCellHistoryBodyend = historyXtwo;
                break;
            case 3:
                Global.pageTwoThirdCellHistoryName = Global.pageTwoSecondCellHistoryName;
                Global.pageTwoThirdCellHistoryBodyone = Global.pageTwoSecondCellHistoryBodyone;
                Global.pageTwoThirdCellHistoryBodytwo = Global.pageTwoSecondCellHistoryBodytwo;
                Global.pageTwoThirdCellHistoryBodythree = Global.pageTwoSecondCellHistoryBodythree;
                Global.pageTwoThirdCellHistoryBodyend = Global.pageTwoSecondCellHistoryBodyend;

                Global.pageTwoSecondCellHistoryName = Global.pageTwoFirstCellHistoryName;
                Global.pageTwoSecondCellHistoryBodyone = Global.pageTwoFirstCellHistoryBodyone;
                Global.pageTwoSecondCellHistoryBodytwo = Global.pageTwoFirstCellHistoryBodytwo;
                Global.pageTwoSecondCellHistoryBodythree = Global.pageTwoFirstCellHistoryBodythree;
                Global.pageTwoSecondCellHistoryBodyend = Global.pageTwoFirstCellHistoryBodyend;

                Global.pageTwoFirstCellHistoryName = historyTitle;
                Global.pageTwoFirstCellHistoryBodyone = historyDiscr;
                Global.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                Global.pageTwoFirstCellHistoryBodythree = historyXone;
                Global.pageTwoFirstCellHistoryBodyend = historyXtwo;
                break;
            default:
                Global.pageTwoFourthCellHistoryName = Global.pageTwoThirdCellHistoryName;
                Global.pageTwoFourthCellHistoryBodyone = Global.pageTwoThirdCellHistoryBodyone;
                Global.pageTwoFourthCellHistoryBodytwo = Global.pageTwoThirdCellHistoryBodytwo;
                Global.pageTwoFourthCellHistoryBodythree = Global.pageTwoThirdCellHistoryBodythree;
                Global.pageTwoFourthCellHistoryBodyend = Global.pageTwoThirdCellHistoryBodyend;

                Global.pageTwoThirdCellHistoryName = Global.pageTwoSecondCellHistoryName;
                Global.pageTwoThirdCellHistoryBodyone = Global.pageTwoSecondCellHistoryBodyone;
                Global.pageTwoThirdCellHistoryBodytwo = Global.pageTwoSecondCellHistoryBodytwo;
                Global.pageTwoThirdCellHistoryBodythree = Global.pageTwoSecondCellHistoryBodythree;
                Global.pageTwoThirdCellHistoryBodyend = Global.pageTwoSecondCellHistoryBodyend;

                Global.pageTwoSecondCellHistoryName = Global.pageTwoFirstCellHistoryName;
                Global.pageTwoSecondCellHistoryBodyone = Global.pageTwoFirstCellHistoryBodyone;
                Global.pageTwoSecondCellHistoryBodytwo = Global.pageTwoFirstCellHistoryBodytwo;
                Global.pageTwoSecondCellHistoryBodythree = Global.pageTwoFirstCellHistoryBodythree;
                Global.pageTwoSecondCellHistoryBodyend = Global.pageTwoFirstCellHistoryBodyend;

                Global.pageTwoFirstCellHistoryName = historyTitle;
                Global.pageTwoFirstCellHistoryBodyone = historyDiscr;
                Global.pageTwoFirstCellHistoryBodytwo = historySqrtDiscr;
                Global.pageTwoFirstCellHistoryBodythree = historyXone;
                Global.pageTwoFirstCellHistoryBodyend = historyXtwo;
                break;
        }
    }

    private void calculate(BigDecimal a, BigDecimal b, BigDecimal c) {
        historyWriteLocal = 1;
        d = (b.multiply(b)).subtract((a.multiply(c)).multiply(new BigDecimal(4)));
        tvDiscr.setText("Discr = " + String.valueOf(d));
        if (d.signum() == -1) {
            toogleDiscr = 1;
        }
        if (d.signum() == 0) {
            toogleDiscr = 2;
        }
        BigDecimal divTwo = new BigDecimal(2);
        switch (toogleDiscr) {
            case 0:
                double discr = d.doubleValue();
                sqrtdouble = Math.sqrt(discr);
                sqrtd = new BigDecimal(sqrtdouble);
                if (sqrtd.floatValue() % 1 == 0) {
                    int sqrtdint = sqrtd.intValue();
                    tvDiscrRoot.setText("√Discr = " + sqrtdint);
                } else {
                    sqrtdfloat = sqrtd.setScale(5, BigDecimal.ROUND_HALF_EVEN);
                    tvDiscrRoot.setText("√Discr = " + sqrtdfloat);
                }
                xOne = (((b.subtract(b)).subtract(b)).add(sqrtd)).divide(divTwo.multiply(a), 6, RoundingMode.HALF_EVEN);
                xTwo = (((b.subtract(b)).subtract(b)).subtract(sqrtd)).divide(divTwo.multiply(a), 6, RoundingMode.HALF_EVEN);
                tvX1.setText("X1 = " + String.valueOf(xOne));
                txX2.setText("X2 = " + String.valueOf(xTwo));
                tvDiscr.setVisibility(View.VISIBLE);
                tvDiscrRoot.setVisibility(View.VISIBLE);
                tvX1.setVisibility(View.VISIBLE);
                txX2.setVisibility(View.VISIBLE);
                ma.show = 1;
                ma.historyWriteToogle = 0;
                break;
            case 1:
                ma.historyWriteToogle = 1;
                tvDiscrRoot.setText(getString(R.string.q_equations_no_solution));
                tvDiscr.setVisibility(View.VISIBLE);
                tvDiscrRoot.setVisibility(View.VISIBLE);
                tvX1.setVisibility(View.GONE);
                txX2.setVisibility(View.GONE);
                ma.show = 2;
                break;
            case 2:
                discr = d.doubleValue();
                sqrtdouble = Math.sqrt(discr);
                sqrtd = new BigDecimal(sqrtdouble);
                if (sqrtd.floatValue() % 1 == 0) {
                    int sqrtdint = sqrtd.intValue();
                    tvDiscrRoot.setText("√Discr = " + sqrtdint);
                } else {
                    sqrtdfloat = sqrtd.setScale(5, BigDecimal.ROUND_HALF_EVEN);
                    tvDiscrRoot.setText("√Discr = " + sqrtdfloat);
                }
                xOne = (((b.subtract(b)).subtract(b)).add(sqrtd)).divide(divTwo.multiply(a), 6, RoundingMode.HALF_UP);
                tvX1.setText("X = " + String.valueOf(xOne));
                txX2.setText(getString(R.string.q_equations_no_second_solution));
                tvDiscr.setVisibility(View.VISIBLE);
                tvDiscrRoot.setVisibility(View.VISIBLE);
                tvX1.setVisibility(View.VISIBLE);
                txX2.setVisibility(View.GONE);
                ma.show = 3;
                ma.historyWriteToogle = 0;
                break;
        }
    }
    public void equationsClrAnim() {
        ClearAnimation equationsClearAnimation = new ClearAnimation();
        equationsClearAnimation.clrAnimName = equationsClearAnimName;
        equationsClearAnimation.clrAnimBackground = backgroundAnim;
        equationsClearAnimation.createClrAnim(2000,500, 0, 0);
    }
}

