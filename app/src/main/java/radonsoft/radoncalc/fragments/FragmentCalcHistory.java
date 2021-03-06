package radonsoft.radoncalc.fragments;

import android.animation.Animator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import radonsoft.radoncalc.Helpers.ClearAnimation;
import radonsoft.radoncalc.Helpers.Global;
import radonsoft.radoncalc.Helpers.TabPagerAdapter;
import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class FragmentCalcHistory extends Fragment {

    private View mRootView;
    MainActivity ma = new MainActivity();
    TextView pageOneFirstCellName;
    TextView pageOneFirstCellBody;
    TextView pageOneFirstCellResult;

    Animator hFragClearAnim;

    public static TextView defaultTextview;
    public static LinearLayout firstCell;
    public static LinearLayout secondCell;
    public static LinearLayout thirdCell;
    public static LinearLayout fourthCell;
    public static LinearLayout fifthCell;

    public static TextView defaultTextViewOne;
    public static LinearLayout pagetwofirstCell;
    public static LinearLayout pagetwosecondCell;
    public static LinearLayout pagetwothirdCell;
    public static LinearLayout pagetwofourthCell;
    public static LinearLayout pagetwofifthCell;

    public static TextView defaultTextViewTwo;
    public static RelativeLayout pageThreefirstCell;
    public static RelativeLayout pageThreesecondCell;
    public static RelativeLayout pageThreethirdCell;
    public static RelativeLayout pageThreefourthCell;
    public static RelativeLayout pageThreefifthCell;

    FrameLayout clearBackground;

    public FragmentCalcHistory() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ma.pages = 2;
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.history_title));
        mRootView = inflater.inflate(R.layout.fragment_fragment_calc_history, container, false);
        ViewPager viewPager = (ViewPager) mRootView.findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) mRootView.findViewById(R.id.tabLayout);
        ArrayList<View> pages = new ArrayList<>();
        View pageone = inflater.inflate(R.layout.first_history_layout, null);
        View pagetwo = inflater.inflate(R.layout.second_history_layout, null);
        View pagethree = inflater.inflate(R.layout.fourth_history_layout, null);
        pages.add(pageone);
        pages.add(pagetwo);
        pages.add(pagethree);
        viewPager.setAdapter(new TabPagerAdapter(pages));
        tabLayout.setupWithViewPager(viewPager);

        clearBackground = (FrameLayout) mRootView.findViewById(R.id.circularAnimationBackground);
        defaultTextview = (TextView) pageone.findViewById(R.id.textView28);
        // First Page
        firstCell = (LinearLayout) pageone.findViewById(R.id.cellone);
        secondCell = (LinearLayout) pageone.findViewById(R.id.celltwo);
        thirdCell = (LinearLayout) pageone.findViewById(R.id.cellthree);
        fourthCell = (LinearLayout) pageone.findViewById(R.id.cellfour);
        fifthCell = (LinearLayout) pageone.findViewById(R.id.cellfive);

        pageOneFirstCellName = (TextView) pageone.findViewById(R.id.textView13);
        pageOneFirstCellBody = (TextView) pageone.findViewById(R.id.textView14);
        pageOneFirstCellResult = (TextView) pageone.findViewById(R.id.textView15);

        final TextView pageOneSecondCellName = (TextView) pageone.findViewById(R.id.textView16);
        final TextView pageOneSecondCellBody = (TextView) pageone.findViewById(R.id.textView17);
        final TextView pageOneSecondCellResult = (TextView) pageone.findViewById(R.id.textView18);

        final TextView pageOneThirdCellName = (TextView) pageone.findViewById(R.id.textView19);
        final TextView pageOneThirdCellBody = (TextView) pageone.findViewById(R.id.textView20);
        final TextView pageOneThirdCellResult = (TextView) pageone.findViewById(R.id.textView21);

        final TextView pageOneFourthCellName = (TextView) pageone.findViewById(R.id.textView22);
        final TextView pageOneFourthCellBody = (TextView) pageone.findViewById(R.id.textView23);
        final TextView pageOneFourthCellResult = (TextView) pageone.findViewById(R.id.textView24);

        final TextView pageOneFifthCellName = (TextView) pageone.findViewById(R.id.textView25);
        final TextView pageOneFifthCellBody = (TextView) pageone.findViewById(R.id.textView26);
        final TextView pageOneFifthCellResult = (TextView) pageone.findViewById(R.id.textView27);

        // Second Page
        pagetwofirstCell = (LinearLayout) pagetwo.findViewById(R.id.cellone);
        pagetwosecondCell = (LinearLayout) pagetwo.findViewById(R.id.celltwo);
        pagetwothirdCell = (LinearLayout) pagetwo.findViewById(R.id.cellthree);
        pagetwofourthCell = (LinearLayout) pagetwo.findViewById(R.id.cellfour);
        pagetwofifthCell = (LinearLayout) pagetwo.findViewById(R.id.cellfive);
        defaultTextViewOne = (TextView) pagetwo.findViewById(R.id.textView28);

        final TextView pageTwoFirstCellName = (TextView) pagetwo.findViewById(R.id.textView29);
        final TextView pageTwoFirstCellBodyOne = (TextView) pagetwo.findViewById(R.id.textView30);
        final TextView pageTwoFirstCellBodyTwo = (TextView) pagetwo.findViewById(R.id.textView31);
        final TextView pageTwoFirstCellBodyThree = (TextView) pagetwo.findViewById(R.id.textView32);
        final TextView pageTwoFirstCellBodyEnd = (TextView) pagetwo.findViewById(R.id.textView33);

        final TextView pageTwoSecondCellName = (TextView) pagetwo.findViewById(R.id.textView2);
        final TextView pageTwoSecondCellBodyOne = (TextView) pagetwo.findViewById(R.id.textView34);
        final TextView pageTwoSecondCellBodyTwo = (TextView) pagetwo.findViewById(R.id.textView35);
        final TextView pageTwoSecondCellBodyThree = (TextView) pagetwo.findViewById(R.id.textView36);
        final TextView pageTwoSecondCellBodyEnd = (TextView) pagetwo.findViewById(R.id.textView37);

        final TextView pageTwoThirdCellName = (TextView) pagetwo.findViewById(R.id.textView38);
        final TextView pageTwoThirdCellBodyOne = (TextView) pagetwo.findViewById(R.id.textView39);
        final TextView pageTwoThirdCellBodyTwo = (TextView) pagetwo.findViewById(R.id.textView40);
        final TextView pageTwoThirdCellBodyThree = (TextView) pagetwo.findViewById(R.id.textView41);
        final TextView pageTwoThirdCellBodyEnd = (TextView) pagetwo.findViewById(R.id.textView42);

        final TextView pageTwoFourthCellName = (TextView) pagetwo.findViewById(R.id.textView43);
        final TextView pageTwoFourthCellBodyOne = (TextView) pagetwo.findViewById(R.id.textView44);
        final TextView pageTwoFourthCellBodyTwo = (TextView) pagetwo.findViewById(R.id.textView45);
        final TextView pageTwoFourthCellBodyThree = (TextView) pagetwo.findViewById(R.id.textView46);
        final TextView pageTwoFourthCellBodyEnd = (TextView) pagetwo.findViewById(R.id.textView47);

        final TextView pageTwoFifthCellName = (TextView) pagetwo.findViewById(R.id.textView48);
        final TextView pageTwoFifthCellBodyOne = (TextView) pagetwo.findViewById(R.id.textView49);
        final TextView pageTwoFifthCellBodyTwo = (TextView) pagetwo.findViewById(R.id.textView50);
        final TextView pageTwoFifthCellBodyThree = (TextView) pagetwo.findViewById(R.id.textView51);
        final TextView pageTwoFifthCellBodyEnd = (TextView) pagetwo.findViewById(R.id.textView52);

        // Third page
        pageThreefirstCell = (RelativeLayout) pagethree.findViewById(R.id.cellone);
        pageThreesecondCell = (RelativeLayout) pagethree.findViewById(R.id.celltwo);
        pageThreethirdCell = (RelativeLayout) pagethree.findViewById(R.id.cellthree);
        pageThreefourthCell = (RelativeLayout) pagethree.findViewById(R.id.cellfour);
        pageThreefifthCell = (RelativeLayout) pagethree.findViewById(R.id.cellfive);
        defaultTextViewTwo = (TextView) pagethree.findViewById(R.id.defaultText);

        final TextView pageThreeFirstCellInput = (TextView) pagethree.findViewById(R.id.textView57);
        final TextView pageThreeFirstCellOutput = (TextView) pagethree.findViewById(R.id.textView61);
        final TextView pageThreeSecondCellInput = (TextView) pagethree.findViewById(R.id.textView12);
        final TextView pageThreeSecondCellOutput = (TextView) pagethree.findViewById(R.id.textView62);
        final TextView pageThreeThirdCellInput = (TextView) pagethree.findViewById(R.id.textView64);
        final TextView pageThreeThirdCellOutput = (TextView) pagethree.findViewById(R.id.textView65);
        final TextView pageThreeFourthCellInput = (TextView) pagethree.findViewById(R.id.textView67);
        final TextView pageThreeFourthCellOutput = (TextView) pagethree.findViewById(R.id.textView68);
        final TextView pageThreeFifthCellInput = (TextView) pagethree.findViewById(R.id.textView70);
        final TextView pageThreeFifthCellOutput = (TextView) pagethree.findViewById(R.id.textView71);

        String operation = getString(R.string.history_operation);
        String result = getString(R.string.history_result);

        setPageVisibility(defaultTextview, firstCell, secondCell, thirdCell, fourthCell, fifthCell, ma.pageOneCounter);
        setPageVisibility(defaultTextViewOne, pagetwofirstCell, pagetwosecondCell, pagetwothirdCell, pagetwofourthCell, pagetwofifthCell, ma.pageTwoCounter);
        setPageVisibility(defaultTextViewTwo, pageThreefirstCell, pageThreesecondCell, pageThreethirdCell, pageThreefourthCell, pageThreefifthCell, Global.pageThreeCounter );
        //FirstPage
        //First Cell making full
        pageOneFirstCellName.setText(operation + " " +  Global.pageOnefirstCellhistoryName);
        pageOneFirstCellBody.setText(Global.pageOnefirstCellhistoryBody);
        pageOneFirstCellResult.setText(result + " " + Global.pageOnefirstCellhistoryResult);
        //Second Cell making full
        pageOneSecondCellName.setText(operation +" " + Global.pageOneSecondCellhistoryName);
        pageOneSecondCellBody.setText(Global.pageOneSecondCellhistoryBody);
        pageOneSecondCellResult.setText(result + " " + Global.pageOneSecondCellhistoryResult);
        //Third cell making full
        pageOneThirdCellName.setText(operation +" " + Global.pageOneThirdCellhistoryName);
        pageOneThirdCellBody.setText(Global.pageOneThirdCellhistoryBody);
        pageOneThirdCellResult.setText(result + " " + Global.pageOneThirdCellhistoryResult);
        //Fourth cell making full
        pageOneFourthCellName.setText(operation +" " + Global.pageOneFourthCellhistoryName);
        pageOneFourthCellBody.setText(Global.pageOneFourthCellhistoryBody);
        pageOneFourthCellResult.setText(result + " " + Global.pageOneFourthCellhistoryResult);
        //Fifth cell making full
        pageOneFifthCellName.setText(operation +" " + Global.pageOneFifthCellhistoryName);
        pageOneFifthCellBody.setText(Global.pageOneFifthCellhistoryBody);
        pageOneFifthCellResult.setText(result + " " + Global.pageOneFifthCellhistoryResult);
        //Second Page
        // First Cell making full
        pageTwoFirstCellName.setText(Global.pageTwoFirstCellHistoryName);
        pageTwoFirstCellBodyOne.setText(Global.pageTwoFirstCellHistoryBodyone);
        pageTwoFirstCellBodyTwo.setText(Global.pageTwoFirstCellHistoryBodytwo);
        pageTwoFirstCellBodyThree.setText(Global.pageTwoFirstCellHistoryBodythree);
        pageTwoFirstCellBodyEnd.setText(Global.pageTwoFirstCellHistoryBodyend);
        // Second Cell making full
        pageTwoSecondCellName.setText(Global.pageTwoSecondCellHistoryName);
        pageTwoSecondCellBodyOne.setText(Global.pageTwoSecondCellHistoryBodyone);
        pageTwoSecondCellBodyTwo.setText(Global.pageTwoSecondCellHistoryBodytwo);
        pageTwoSecondCellBodyThree.setText(Global.pageTwoSecondCellHistoryBodythree);
        pageTwoSecondCellBodyEnd.setText(Global.pageTwoSecondCellHistoryBodyend);
        // Third Cell making full
        pageTwoThirdCellName.setText(Global.pageTwoThirdCellHistoryName);
        pageTwoThirdCellBodyOne.setText(Global.pageTwoThirdCellHistoryBodyone);
        pageTwoThirdCellBodyTwo.setText(Global.pageTwoThirdCellHistoryBodytwo);
        pageTwoThirdCellBodyThree.setText(Global.pageTwoThirdCellHistoryBodythree);
        pageTwoThirdCellBodyEnd.setText(Global.pageTwoThirdCellHistoryBodyend);
        //Fourth cell making full
        pageTwoFourthCellName.setText(Global.pageTwoFourthCellHistoryName);
        pageTwoFourthCellBodyOne.setText(Global.pageTwoFourthCellHistoryBodyone);
        pageTwoFourthCellBodyTwo.setText(Global.pageTwoFourthCellHistoryBodytwo);
        pageTwoFourthCellBodyThree.setText(Global.pageTwoFourthCellHistoryBodythree);
        pageTwoFourthCellBodyEnd.setText(Global.pageTwoFourthCellHistoryBodyend);
        // Fifth cell making full
        pageTwoFifthCellName.setText(Global.pageTwoFifthCellHistoryName);
        pageTwoFifthCellBodyOne.setText(Global.pageTwoFifthCellHistoryBodyone);
        pageTwoFifthCellBodyTwo.setText(Global.pageTwoFifthCellHistoryBodytwo);
        pageTwoFifthCellBodyThree.setText(Global.pageTwoFifthCellHistoryBodythree);
        pageTwoFifthCellBodyEnd.setText(Global.pageTwoFifthCellHistoryBodyend);
        // Third page
        pageThreeFirstCellInput.setText(Global.pageThreefirstCellhistoryInput + ", " + Global.pageThreefirstCellhistoryInputName);
        pageThreeFirstCellOutput.setText(Global.pageThreefirstCellhistoryOutput + ", " + Global.pageThreefirstCellhistoryOutputName);
        pageThreeSecondCellInput.setText(Global.pageThreeSecondCellhistoryInput + ", " + Global.pageThreeSecondCellhistoryInputName);
        pageThreeSecondCellOutput.setText(Global.pageThreeSecondCellhistoryOutput + ", " + Global.pageThreeSecondCellhistoryOutputName);
        pageThreeThirdCellInput.setText(Global.pageThreeThirdCellhistoryInput + ", " + Global.pageThreeThirdCellhistoryInputName);
        pageThreeThirdCellOutput.setText(Global.pageThreeThirdCellhistoryOutput + ", " + Global.pageThreeThirdCellhistoryOutputName);
        pageThreeFourthCellInput.setText(Global.pageThreeFourthCellhistoryInput + ", " + Global.pageThreeFourthCellhistoryInputName);
        pageThreeFourthCellOutput.setText(Global.pageThreeFourthCellhistoryOutput + ", " + Global.pageThreeFourthCellhistoryOutputName);
        pageThreeFifthCellInput.setText(Global.pageThreeFifthCellhistoryInput + ", " + Global.pageThreeFifthCellhistoryInputName);
        pageThreeFifthCellOutput.setText(Global.pageThreeFifthCellhistoryOutput + ", " + Global.pageThreeFifthCellhistoryOutputName);

        //Checking Result
        //First Cell
        if (Global.pageTwoFirstCellHistoryBodyend.equals(getString(R.string.q_equations_no_solution))) {
            pageTwoFirstCellBodyTwo.setVisibility(View.GONE);
            pageTwoFirstCellBodyThree.setVisibility(View.GONE);
        }
        //Second Cell
        if (Global.pageTwoSecondCellHistoryBodyend.equals(getString(R.string.q_equations_no_solution))) {
            pageTwoSecondCellBodyTwo.setVisibility(View.GONE);
            pageTwoSecondCellBodyThree.setVisibility(View.GONE);
        }
        // Third Cell
        if (Global.pageTwoThirdCellHistoryBodyend.equals(getString(R.string.q_equations_no_solution))) {
            pageTwoThirdCellBodyTwo.setVisibility(View.GONE);
            pageTwoThirdCellBodyThree.setVisibility(View.GONE);
        }
        // Fourth cell
        if (Global.pageTwoFourthCellHistoryBodyend.equals(getString(R.string.q_equations_no_solution))) {
            pageTwoFourthCellBodyTwo.setVisibility(View.GONE);
            pageTwoFourthCellBodyThree.setVisibility(View.GONE);
        }
        // Fifth cell
        if (Global.pageTwoFifthCellHistoryBodyend.equals(getString(R.string.q_equations_no_solution))) {
            pageTwoFifthCellBodyTwo.setVisibility(View.GONE);
            pageTwoFifthCellBodyThree.setVisibility(View.GONE);
        }
        //Checking Result #2
        if (Global.pageTwoFirstCellHistoryBodyend.equals(getString(R.string.q_equations_no_second_solution))) {
            pageTwoFirstCellBodyEnd.setVisibility(View.GONE);
        }
        //Second Cell
        if (Global.pageTwoSecondCellHistoryBodyend.equals(getString(R.string.q_equations_no_second_solution))) {
            pageTwoSecondCellBodyEnd.setVisibility(View.GONE);
        }
        // Third Cell
        if (Global.pageTwoThirdCellHistoryBodyend.equals(getString(R.string.q_equations_no_second_solution))) {
            pageTwoThirdCellBodyEnd.setVisibility(View.GONE);
        }
        if (Global.pageTwoFourthCellHistoryBodyend.equals(getString(R.string.q_equations_no_second_solution))) {
            pageTwoFourthCellBodyEnd.setVisibility(View.GONE);
        }
        if (Global.pageTwoFifthCellHistoryBodyend.equals(getString(R.string.q_equations_no_second_solution))) {
            pageTwoFifthCellBodyEnd.setVisibility(View.GONE);
        }

        // code for return values
        returnCalcResult(firstCell, 1);
        returnCalcResult(secondCell, 2);
        returnCalcResult(thirdCell, 3);
        returnCalcResult(fourthCell, 4);
        returnCalcResult(fifthCell, 5);

        return mRootView;
    }

    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.history_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.action_clear_history): {
                clearHistory();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void clearHistory() {
        Snackbar.make(mRootView, getString(R.string.snackbar_text_deleted), Snackbar.LENGTH_SHORT).show();
        // TODO: Delete items here
        clearAnimation();
    }

    public void clearAnimation() {
        if (Build.VERSION.SDK_INT >= 21) {
            ClearAnimation historyFragmentClrAnim = new ClearAnimation();
            historyFragmentClrAnim.clrAnimBackground = clearBackground;
            historyFragmentClrAnim.clrAnimName = hFragClearAnim;
            historyFragmentClrAnim.createClrAnim(2000, 500, 0, 0);
        }
        else {
            clearBackground.startAnimation(ma.fadein);
            clearBackground.startAnimation(ma.fadeout);
            clearFirstPage();
            clearSecondPage();
        }
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
    public void returnCalcResult(View cell, final int cellNum){
        cell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (cellNum){
                    case 1:
                        ma.saveTextViewValue = Global.pageOnefirstCellhistoryResult;
                        ma.saveAddictionTextViewValue = Global.pageOnefirstCellhistoryResult;
                        ma.saveTumbler = 0;
                        break;
                    case 2:
                        ma.saveTextViewValue = Global.pageOneSecondCellhistoryResult;
                        ma.saveAddictionTextViewValue = Global.pageOneSecondCellhistoryResult;
                        ma.saveTumbler = 0;
                        break;
                    case 3:
                        ma.saveTextViewValue = Global.pageOneThirdCellhistoryResult;
                        ma.saveAddictionTextViewValue = Global.pageOneThirdCellhistoryResult;
                        ma.saveTumbler = 0;
                        break;
                    case 4:
                        ma.saveTextViewValue = Global.pageOneFourthCellhistoryResult;
                        ma.saveAddictionTextViewValue = Global.pageOneFourthCellhistoryResult;
                        ma.saveTumbler = 0;
                        break;
                    case 5:
                        ma.saveTextViewValue = Global.pageOneFifthCellhistoryResult;
                        ma.saveAddictionTextViewValue = Global.pageOneFifthCellhistoryResult;
                        ma.saveTumbler = 0;
                        break;
                }
                showDialogMessage(getString(R.string.history_return_value));
            }
        });
    }

    public static void clearFirstPage() {
        defaultTextview.setVisibility(View.VISIBLE);
        firstCell.setVisibility(View.GONE);
        secondCell.setVisibility(View.GONE);
        thirdCell.setVisibility(View.GONE);
        fourthCell.setVisibility(View.GONE);
        fifthCell.setVisibility(View.GONE);
    }
    public static void clearSecondPage() {
        defaultTextViewOne.setVisibility(View.VISIBLE);
        pagetwofirstCell.setVisibility(View.GONE);
        pagetwosecondCell.setVisibility(View.GONE);
        pagetwothirdCell.setVisibility(View.GONE);
        pagetwofourthCell.setVisibility(View.GONE);
        pagetwofifthCell.setVisibility(View.GONE);
    }
    public static void clearThirdPage() {
        defaultTextViewTwo.setVisibility(View.VISIBLE);
        pageThreefirstCell.setVisibility(View.GONE);
        pageThreesecondCell.setVisibility(View.GONE);
        pageThreethirdCell.setVisibility(View.GONE);
        pageThreefourthCell.setVisibility(View.GONE);
        pageThreefifthCell.setVisibility(View.GONE);
    }

    public void setPageVisibility(View defaultView, View cellone, View celltwo, View cellthree, View cellfour, View cellfive, int counter){
        switch (counter) {
            case 0:
                break;
            case 1:
                defaultView.setVisibility(View.GONE);
                cellone.setVisibility(View.VISIBLE);
                break;
            case 2:
                defaultView.setVisibility(View.GONE);
                cellone.setVisibility(View.VISIBLE);
                celltwo.setVisibility(View.VISIBLE);
                break;
            case 3:
                defaultView.setVisibility(View.GONE);
                cellone.setVisibility(View.VISIBLE);
                celltwo.setVisibility(View.VISIBLE);
                cellthree.setVisibility(View.VISIBLE);
                break;
            case 4:
                defaultView.setVisibility(View.GONE);
                cellone.setVisibility(View.VISIBLE);
                celltwo.setVisibility(View.VISIBLE);
                cellthree.setVisibility(View.VISIBLE);
                cellfour.setVisibility(View.VISIBLE);
                break;
            default:
                defaultView.setVisibility(View.GONE);
                cellone.setVisibility(View.VISIBLE);
                celltwo.setVisibility(View.VISIBLE);
                cellthree.setVisibility(View.VISIBLE);
                cellfour.setVisibility(View.VISIBLE);
                cellfive.setVisibility(View.VISIBLE);
                break;
        }
    }

}


