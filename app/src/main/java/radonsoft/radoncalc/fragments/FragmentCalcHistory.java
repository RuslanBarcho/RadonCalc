package radonsoft.radoncalc.fragments;

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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

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
    TextView defaultTextview;

    LinearLayout firstCell;
    LinearLayout secondCell;
    LinearLayout thirdCell;
    LinearLayout fourthCell;
    LinearLayout fifthCell;

    TextView defaultTextViewOne;
    LinearLayout pagetwofirstCell;
    LinearLayout pagetwosecondCell;
    LinearLayout pagetwothirdCell;
    LinearLayout pagetwofourthCell;
    LinearLayout pagetwofifthCell;

    public FragmentCalcHistory() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ma.pages = 2;
        ((MainActivity) getActivity()).setActionBarTitle("History");
        mRootView = inflater.inflate(R.layout.fragment_fragment_calc_history, container, false);
        Button delButton = (Button) mRootView.findViewById(R.id.button22);
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
        pages.add(pagefour);
        viewPager.setAdapter(new TabPagerAdapter(pages));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(ICONS[0]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
        tabLayout.getTabAt(2).setIcon(ICONS[2]);
        tabLayout.getTabAt(3).setIcon(ICONS[2]);

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
        //First Cell making full
        pageOneFirstCellName.setText("Operation: " + ma.pageOnefirstCellhistoryName);
        pageOneFirstCellBody.setText(ma.pageOnefirstCellhistoryBody);
        pageOneFirstCellResult.setText("Result: " + ma.pageOnefirstCellhistoryResult);
        //Second Cell making full
        pageOneSecondCellName.setText("Operation: " + ma.pageOneSecondCellhistoryName);
        pageOneSecondCellBody.setText(ma.pageOneSecondCellhistoryBody);
        pageOneSecondCellResult.setText("Result: " + ma.pageOneSecondCellhistoryResult);
        //Third cell making full
        pageOneThirdCellName.setText("Operation: " + ma.pageOneThirdCellhistoryName);
        pageOneThirdCellBody.setText(ma.pageOneThirdCellhistoryBody);
        pageOneThirdCellResult.setText("Result: " + ma.pageOneThirdCellhistoryResult);
        //Fourth cell making full
        pageOneFourthCellName.setText("Operation: " + ma.pageOneFourthCellhistoryName);
        pageOneFourthCellBody.setText(ma.pageOneFourthCellhistoryBody);
        pageOneFourthCellResult.setText("Result: " + ma.pageOneFourthCellhistoryResult);
        //Fifth cell making full
        pageOneFifthCellName.setText("Operation: " + ma.pageOneFifthCellhistoryName);
        pageOneFifthCellBody.setText(ma.pageOneFifthCellhistoryBody);
        pageOneFifthCellResult.setText("Result: " + ma.pageOneFifthCellhistoryResult);


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
        pageTwoFirstCellName.setText(ma.pageTwoFirstCellHistoryName);
        pageTwoFirstCellBodyOne.setText(ma.pageTwoFirstCellHistoryBodyone);
        pageTwoFirstCellBodyTwo.setText(ma.pageTwoFirstCellHistoryBodytwo);
        pageTwoFirstCellBodyThree.setText(ma.pageTwoFirstCellHistoryBodythree);
        pageTwoFirstCellBodyEnd.setText(ma.pageTwoFirstCellHistoryBodyend);
        // Second Cell making full
        pageTwoSecondCellName.setText(ma.pageTwoSecondCellHistoryName);
        pageTwoSecondCellBodyOne.setText(ma.pageTwoSecondCellHistoryBodyone);
        pageTwoSecondCellBodyTwo.setText(ma.pageTwoSecondCellHistoryBodytwo);
        pageTwoSecondCellBodyThree.setText(ma.pageTwoSecondCellHistoryBodythree);
        pageTwoSecondCellBodyEnd.setText(ma.pageTwoSecondCellHistoryBodyend);
        // Third Cell making full
        pageTwoThirdCellName.setText(ma.pageTwoThirdCellHistoryName);
        pageTwoThirdCellBodyOne.setText(ma.pageTwoThirdCellHistoryBodyone);
        pageTwoThirdCellBodyTwo.setText(ma.pageTwoThirdCellHistoryBodytwo);
        pageTwoThirdCellBodyThree.setText(ma.pageTwoThirdCellHistoryBodythree);
        pageTwoThirdCellBodyEnd.setText(ma.pageTwoThirdCellHistoryBodyend);
        //Checking Result
        //First Cell
        if (ma.pageTwoFirstCellHistoryBodyend.equals(ma.historyWriterChecker)) {
            pageTwoFirstCellBodyTwo.setVisibility(View.GONE);
            pageTwoFirstCellBodyThree.setVisibility(View.GONE);
        }
        //Second Cell
        if (ma.pageTwoSecondCellHistoryBodyend.equals(ma.historyWriterChecker)) {
            pageTwoSecondCellBodyTwo.setVisibility(View.GONE);
            pageTwoSecondCellBodyThree.setVisibility(View.GONE);
        }
        // Third Cell
        if (ma.pageTwoThirdCellHistoryBodyend.equals(ma.historyWriterChecker)) {
            pageTwoThirdCellBodyTwo.setVisibility(View.GONE);
            pageTwoThirdCellBodyThree.setVisibility(View.GONE);
        }
        //Checking Result #2
        if (ma.pageTwoFirstCellHistoryBodyend.equals("No second solution")) {
            pageTwoFirstCellBodyEnd.setVisibility(View.GONE);
        }
        //Second Cell
        if (ma.pageTwoSecondCellHistoryBodyend.equals("No second solution")) {
            pageTwoSecondCellBodyEnd.setVisibility(View.GONE);
        }
        // Third Cell
        if (ma.pageTwoThirdCellHistoryBodyend.equals("No second solution")) {
            pageTwoThirdCellBodyEnd.setVisibility(View.GONE);
        }
        // Fourth page
        final TextView textviewtestone = (TextView) pagefour.findViewById(R.id.textView12);
        textviewtestone.setText("Тест2");

        //del button
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //First Page

                //Second Page
                //Removing Cells

                //Variables Clear
                ma.pageTwoFirstCellHistoryName = "";
                ma.pageTwoFirstCellHistoryBodyone = "";
                ma.pageTwoFirstCellHistoryBodytwo = "";
                ma.pageTwoFirstCellHistoryBodythree = "";
                ma.pageTwoFirstCellHistoryBodyend = "";
                // Counters Reset
                ma.pageTwoCounter = 0;
                ma.historyWriteToogle = 0;
                //Return default text
                defaultTextViewOne.setVisibility(View.VISIBLE);
            }
        });
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
        clearFirstPage();
        clearSecondPage();
    }
    public void clearFirstPage() {
        // Variables Clear
        ma.pageOneFifthCellhistoryBody = "";
        ma.pageOneFifthCellhistoryName = "";
        ma.pageOneFifthCellhistoryResult = "";

        ma.pageOneFourthCellhistoryBody = "";
        ma.pageOneFourthCellhistoryName = "";
        ma.pageOneFourthCellhistoryResult = "";

        ma.pageOneThirdCellhistoryBody = "";
        ma.pageOneThirdCellhistoryName = "";
        ma.pageOneThirdCellhistoryResult = "";

        ma.pageOneSecondCellhistoryBody = "";
        ma.pageOneSecondCellhistoryName = "";
        ma.pageOneSecondCellhistoryResult = "";

        ma.pageOnefirstCellhistoryBody = "";
        ma.pageOnefirstCellhistoryName = "";
        ma.pageOnefirstCellhistoryResult = "";
        //Counter Reset
        ma.pageOneCounter = 0;
        //Return default text
        defaultTextview.setVisibility(View.VISIBLE);
        firstCell.setVisibility(View.GONE);
        secondCell.setVisibility(View.GONE);
        thirdCell.setVisibility(View.GONE);
        fourthCell.setVisibility(View.GONE);
        fifthCell.setVisibility(View.GONE);
    }
    public void clearSecondPage() {
        //Variables Clear
        ma.pageTwoFirstCellHistoryName = "";
        ma.pageTwoFirstCellHistoryBodyone = "";
        ma.pageTwoFirstCellHistoryBodytwo = "";
        ma.pageTwoFirstCellHistoryBodythree = "";
        ma.pageTwoFirstCellHistoryBodyend = "";

        ma.pageTwoSecondCellHistoryName = "";
        ma.pageTwoSecondCellHistoryBodyone = "";
        ma.pageTwoSecondCellHistoryBodytwo = "";
        ma.pageTwoSecondCellHistoryBodythree = "";
        ma.pageTwoSecondCellHistoryBodyend = "";

        ma.pageTwoThirdCellHistoryName = "";
        ma.pageTwoThirdCellHistoryBodyone = "";
        ma.pageTwoThirdCellHistoryBodytwo = "";
        ma.pageTwoThirdCellHistoryBodythree = "";
        ma.pageTwoThirdCellHistoryBodyend = "";
        // Counters Reset
        ma.pageTwoCounter = 0;
        ma.historyWriteToogle = 0;
        //Return default text
        defaultTextViewOne.setVisibility(View.VISIBLE);
        //remove cells
        pagetwofirstCell.setVisibility(View.GONE);
        pagetwosecondCell.setVisibility(View.GONE);
        pagetwothirdCell.setVisibility(View.GONE);
        pagetwofourthCell.setVisibility(View.GONE);
        pagetwofifthCell.setVisibility(View.GONE);
    }

}


