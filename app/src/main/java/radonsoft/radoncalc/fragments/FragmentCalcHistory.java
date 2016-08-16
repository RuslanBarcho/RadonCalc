package radonsoft.radoncalc.fragments;

import android.animation.Animator;
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
import android.widget.TextView;

import java.util.ArrayList;

import radonsoft.radoncalc.Helpers.ClearAnimation;
import radonsoft.radoncalc.Helpers.Global;
import radonsoft.radoncalc.Helpers.TabPagerAdapter;
import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

public class FragmentCalcHistory extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter viewPagerAdapter;
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
        final int[] ICONS = new int[]{
                R.drawable.selectorone,
                R.drawable.selectortwo,
                R.drawable.selectorthree,
                R.drawable.selectorone,
        };
        ArrayList<View> pages = new ArrayList<>();
        View pageone = inflater.inflate(R.layout.first_history_layout, null);
        View pagetwo = inflater.inflate(R.layout.second_history_layout, null);
        View pagethree = inflater.inflate(R.layout.third_history_layout, null);
        View pagefour = inflater.inflate(R.layout.fourth_history_layout, null);
        pages.add(pageone);
        pages.add(pagetwo);
        pages.add(pagethree);
        //pages.add(pagefour);
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

        String operation = getString(R.string.history_operation);
        String result = getString(R.string.history_result);
        setFirstPageVisibility();
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

        // Second page
        switch (ma.pageTwoCounter) {
            case 0:
                break;
            case 1:
                defaultTextViewOne.setVisibility(View.GONE);
                pagetwofirstCell.setVisibility(View.VISIBLE);
                break;
            case 2:
                defaultTextViewOne.setVisibility(View.GONE);
                pagetwofirstCell.setVisibility(View.VISIBLE);
                pagetwosecondCell.setVisibility(View.VISIBLE);
                break;
            default:
                defaultTextViewOne.setVisibility(View.GONE);
                pagetwofirstCell.setVisibility(View.VISIBLE);
                pagetwosecondCell.setVisibility(View.VISIBLE);
                pagetwothirdCell.setVisibility(View.VISIBLE);
                break;
        }
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
        //Checking Result
        //First Cell
        if (Global.pageTwoFirstCellHistoryBodyend.equals(ma.historyWriterChecker)) {
            pageTwoFirstCellBodyTwo.setVisibility(View.GONE);
            pageTwoFirstCellBodyThree.setVisibility(View.GONE);
        }
        //Second Cell
        if (Global.pageTwoSecondCellHistoryBodyend.equals(ma.historyWriterChecker)) {
            pageTwoSecondCellBodyTwo.setVisibility(View.GONE);
            pageTwoSecondCellBodyThree.setVisibility(View.GONE);
        }
        // Third Cell
        if (Global.pageTwoThirdCellHistoryBodyend.equals(ma.historyWriterChecker)) {
            pageTwoThirdCellBodyTwo.setVisibility(View.GONE);
            pageTwoThirdCellBodyThree.setVisibility(View.GONE);
        }
        //Checking Result #2
        if (Global.pageTwoFirstCellHistoryBodyend.equals("No second solution")) {
            pageTwoFirstCellBodyEnd.setVisibility(View.GONE);
        }
        //Second Cell
        if (Global.pageTwoSecondCellHistoryBodyend.equals("No second solution")) {
            pageTwoSecondCellBodyEnd.setVisibility(View.GONE);
        }
        // Third Cell
        if (Global.pageTwoThirdCellHistoryBodyend.equals("No second solution")) {
            pageTwoThirdCellBodyEnd.setVisibility(View.GONE);
        }


        // Fourth page
        final TextView textviewtestone = (TextView) pagefour.findViewById(R.id.textView12);
        textviewtestone.setText("Тест2");

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

    public void setFirstPageVisibility(){
        switch (ma.pageOneCounter) {
            case 0:

                break;
            case 1:
                defaultTextview.setVisibility(View.GONE);
                firstCell.setVisibility(View.VISIBLE);
                break;
            case 2:
                defaultTextview.setVisibility(View.GONE);
                firstCell.setVisibility(View.VISIBLE);
                secondCell.setVisibility(View.VISIBLE);
                break;
            case 3:
                defaultTextview.setVisibility(View.GONE);
                firstCell.setVisibility(View.VISIBLE);
                secondCell.setVisibility(View.VISIBLE);
                thirdCell.setVisibility(View.VISIBLE);
                break;
            case 4:
                defaultTextview.setVisibility(View.GONE);
                firstCell.setVisibility(View.VISIBLE);
                secondCell.setVisibility(View.VISIBLE);
                thirdCell.setVisibility(View.VISIBLE);
                fourthCell.setVisibility(View.VISIBLE);
                break;
            default:
                defaultTextview.setVisibility(View.GONE);
                firstCell.setVisibility(View.VISIBLE);
                secondCell.setVisibility(View.VISIBLE);
                thirdCell.setVisibility(View.VISIBLE);
                fourthCell.setVisibility(View.VISIBLE);
                fifthCell.setVisibility(View.VISIBLE);
                break;
        }
    }

}


