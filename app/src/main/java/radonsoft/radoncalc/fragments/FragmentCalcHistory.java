package radonsoft.radoncalc.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MenuRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;
import android.support.v4.view.PagerAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentCalcHistory extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter viewPagerAdapter;
    private View mRootView;
    MainActivity ma = new MainActivity();
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
        final int[] ICONS = new int[] {
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

        final TextView defaultTextview = (TextView)pageone.findViewById(R.id.textView28);
        // First Page
        final TextView pageOneFirstCellName = (TextView)pageone.findViewById(R.id.textView13);
        final TextView pageOneFirstCellBody = (TextView)pageone.findViewById(R.id.textView14);
        final TextView pageOneFirstCellResult = (TextView)pageone.findViewById(R.id.textView15);
        final TextView pageOneFirstCellSeparator = (TextView)pageone.findViewById(R.id.textView53);

        final TextView pageOneSecondCellName = (TextView)pageone.findViewById(R.id.textView16);
        final TextView pageOneSecondCellBody = (TextView)pageone.findViewById(R.id.textView17);
        final TextView pageOneSecondCellResult = (TextView)pageone.findViewById(R.id.textView18);
        final TextView pageOneSecondCellSeparator = (TextView)pageone.findViewById(R.id.textView54);

        final TextView pageOneThirdCellName = (TextView)pageone.findViewById(R.id.textView19);
        final TextView pageOneThirdCellBody = (TextView)pageone.findViewById(R.id.textView20);
        final TextView pageOneThirdCellResult = (TextView)pageone.findViewById(R.id.textView21);
        final TextView pageOneThirdCellSeparator = (TextView)pageone.findViewById(R.id.textView55);

        final TextView pageOneFourthCellName = (TextView)pageone.findViewById(R.id.textView22);
        final TextView pageOneFourthCellBody = (TextView)pageone.findViewById(R.id.textView23);
        final TextView pageOneFourthCellResult = (TextView)pageone.findViewById(R.id.textView24);
        final TextView pageOneFourthCellSeparator = (TextView)pageone.findViewById(R.id.textView56);

        final TextView pageOneFifthCellName = (TextView)pageone.findViewById(R.id.textView25);
        final TextView pageOneFifthCellBody = (TextView)pageone.findViewById(R.id.textView26);
        final TextView pageOneFifthCellResult = (TextView)pageone.findViewById(R.id.textView27);

        // Second Page
        final TextView defaultTextViewOne = (TextView)pagetwo.findViewById(R.id.textView28);

        final TextView pageTwoFirstCellName = (TextView)pagetwo.findViewById(R.id.textView29);
        final TextView pageTwoFirstCellBodyOne = (TextView)pagetwo.findViewById(R.id.textView30);
        final TextView pageTwoFirstCellBodyTwo = (TextView)pagetwo.findViewById(R.id.textView31);
        final TextView pageTwoFirstCellBodyThree = (TextView)pagetwo.findViewById(R.id.textView32);
        final TextView pageTwoFirstCellBodyEnd = (TextView)pagetwo.findViewById(R.id.textView33);

        final TextView pageTwoSecondCellName = (TextView)pagetwo.findViewById(R.id.textView2);
        final TextView pageTwoSecondCellBodyOne = (TextView)pagetwo.findViewById(R.id.textView34);
        final TextView pageTwoSecondCellBodyTwo = (TextView)pagetwo.findViewById(R.id.textView35);
        final TextView pageTwoSecondCellBodyThree = (TextView)pagetwo.findViewById(R.id.textView36);
        final TextView pageTwoSecondCellBodyEnd = (TextView)pagetwo.findViewById(R.id.textView37);

        final TextView pageTwoThirdCellName = (TextView)pagetwo.findViewById(R.id.textView38);
        final TextView pageTwoThirdCellBodyOne = (TextView)pagetwo.findViewById(R.id.textView39);
        final TextView pageTwoThirdCellBodyTwo = (TextView)pagetwo.findViewById(R.id.textView40);
        final TextView pageTwoThirdCellBodyThree = (TextView)pagetwo.findViewById(R.id.textView41);
        final TextView pageTwoThirdCellBodyEnd = (TextView)pagetwo.findViewById(R.id.textView42);

        switch (ma.pageOneCounter) {
            case 0:

                break;
            case 1:
                defaultTextview.setVisibility(View.GONE);
                pageOneFirstCellName.setVisibility(View.VISIBLE);
                pageOneFirstCellBody.setVisibility(View.VISIBLE);
                pageOneFirstCellResult.setVisibility(View.VISIBLE);
                break;
            case 2:
                defaultTextview.setVisibility(View.GONE);
                pageOneFirstCellName.setVisibility(View.VISIBLE);
                pageOneFirstCellBody.setVisibility(View.VISIBLE);
                pageOneFirstCellResult.setVisibility(View.VISIBLE);

                pageOneSecondCellName.setVisibility(View.VISIBLE);
                pageOneSecondCellBody.setVisibility(View.VISIBLE);
                pageOneSecondCellResult.setVisibility(View.VISIBLE);
                break;
            case 3:
                defaultTextview.setVisibility(View.GONE);
                pageOneFirstCellName.setVisibility(View.VISIBLE);
                pageOneFirstCellBody.setVisibility(View.VISIBLE);
                pageOneFirstCellResult.setVisibility(View.VISIBLE);

                pageOneSecondCellName.setVisibility(View.VISIBLE);
                pageOneSecondCellBody.setVisibility(View.VISIBLE);
                pageOneSecondCellResult.setVisibility(View.VISIBLE);

                pageOneThirdCellName.setVisibility(View.VISIBLE);
                pageOneThirdCellBody.setVisibility(View.VISIBLE);
                pageOneThirdCellResult.setVisibility(View.VISIBLE);
                break;
            case 4:
                defaultTextview.setVisibility(View.GONE);
                pageOneFirstCellName.setVisibility(View.VISIBLE);
                pageOneFirstCellBody.setVisibility(View.VISIBLE);
                pageOneFirstCellResult.setVisibility(View.VISIBLE);

                pageOneSecondCellName.setVisibility(View.VISIBLE);
                pageOneSecondCellBody.setVisibility(View.VISIBLE);
                pageOneSecondCellResult.setVisibility(View.VISIBLE);

                pageOneThirdCellName.setVisibility(View.VISIBLE);
                pageOneThirdCellBody.setVisibility(View.VISIBLE);
                pageOneThirdCellResult.setVisibility(View.VISIBLE);

                pageOneFourthCellName.setVisibility(View.VISIBLE);
                pageOneFourthCellBody.setVisibility(View.VISIBLE);
                pageOneFourthCellResult.setVisibility(View.VISIBLE);
                break;
            default:
                defaultTextview.setVisibility(View.GONE);
                pageOneFirstCellName.setVisibility(View.VISIBLE);
                pageOneFirstCellBody.setVisibility(View.VISIBLE);
                pageOneFirstCellResult.setVisibility(View.VISIBLE);

                pageOneSecondCellName.setVisibility(View.VISIBLE);
                pageOneSecondCellBody.setVisibility(View.VISIBLE);
                pageOneSecondCellResult.setVisibility(View.VISIBLE);

                pageOneThirdCellName.setVisibility(View.VISIBLE);
                pageOneThirdCellBody.setVisibility(View.VISIBLE);
                pageOneThirdCellResult.setVisibility(View.VISIBLE);

                pageOneFourthCellName.setVisibility(View.VISIBLE);
                pageOneFourthCellBody.setVisibility(View.VISIBLE);
                pageOneFourthCellResult.setVisibility(View.VISIBLE);

                pageOneFifthCellName.setVisibility(View.VISIBLE);
                pageOneFifthCellBody.setVisibility(View.VISIBLE);
                pageOneFifthCellResult.setVisibility(View.VISIBLE);
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
        switch (ma.pageTwoCounter)
        {
            case 0:
                break;
            case 1:
                defaultTextViewOne.setVisibility(View.GONE);
                pageTwoFirstCellName.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyOne.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyTwo.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyThree.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyEnd.setVisibility(View.VISIBLE);

                break;
            case 2:
                defaultTextViewOne.setVisibility(View.GONE);
                pageTwoFirstCellName.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyOne.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyTwo.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyThree.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyEnd.setVisibility(View.VISIBLE);

                pageTwoSecondCellName.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyOne.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyTwo.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyThree.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyEnd.setVisibility(View.VISIBLE);
                break;
            default:
                defaultTextViewOne.setVisibility(View.GONE);
                pageTwoFirstCellName.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyOne.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyTwo.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyThree.setVisibility(View.VISIBLE);
                pageTwoFirstCellBodyEnd.setVisibility(View.VISIBLE);

                pageTwoSecondCellName.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyOne.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyTwo.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyThree.setVisibility(View.VISIBLE);
                pageTwoSecondCellBodyEnd.setVisibility(View.VISIBLE);

                pageTwoThirdCellName.setVisibility(View.VISIBLE);
                pageTwoThirdCellBodyOne.setVisibility(View.VISIBLE);
                pageTwoThirdCellBodyTwo.setVisibility(View.VISIBLE);
                pageTwoThirdCellBodyThree.setVisibility(View.VISIBLE);
                pageTwoThirdCellBodyEnd.setVisibility(View.VISIBLE);
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
        //Cheking Result
        //First Cell
        if (ma.pageTwoFirstCellHistoryBodyend.equals(ma.historyWriterChecker))
        {
            pageTwoFirstCellBodyTwo.setVisibility(View.GONE);
            pageTwoFirstCellBodyThree.setVisibility(View.GONE);
        }
        //Second Cell
        if (ma.pageTwoSecondCellHistoryBodyend.equals(ma.historyWriterChecker))
        {
            pageTwoSecondCellBodyTwo.setVisibility(View.GONE);
            pageTwoSecondCellBodyThree.setVisibility(View.GONE);
        }
        // Third Cell
        if (ma.pageTwoThirdCellHistoryBodyend.equals(ma.historyWriterChecker))
        {
            pageTwoThirdCellBodyTwo.setVisibility(View.GONE);
            pageTwoThirdCellBodyThree.setVisibility(View.GONE);
        }
        // Fourth page
        final TextView textviewtestone = (TextView) pagefour.findViewById(R.id.textView12);
        textviewtestone.setText("Тест2");

        //del button
        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //First Page
                //Removing Cells
                pageOneFirstCellName.setVisibility(View.GONE);
                pageOneFirstCellBody.setVisibility(View.GONE);
                pageOneFirstCellResult.setVisibility(View.GONE);
                pageOneFirstCellSeparator.setVisibility(View.GONE);

                pageOneSecondCellName.setVisibility(View.GONE);
                pageOneSecondCellBody.setVisibility(View.GONE);
                pageOneSecondCellResult.setVisibility(View.GONE);
                pageOneSecondCellSeparator.setVisibility(View.GONE);

                pageOneThirdCellName.setVisibility(View.GONE);
                pageOneThirdCellBody.setVisibility(View.GONE);
                pageOneThirdCellResult.setVisibility(View.GONE);
                pageOneThirdCellSeparator.setVisibility(View.GONE);

                pageOneFourthCellName.setVisibility(View.GONE);
                pageOneFourthCellBody.setVisibility(View.GONE);
                pageOneFourthCellResult.setVisibility(View.GONE);
                pageOneFourthCellSeparator.setVisibility(View.GONE);

                pageOneFifthCellName.setVisibility(View.GONE);
                pageOneFifthCellBody.setVisibility(View.GONE);
                pageOneFifthCellResult.setVisibility(View.GONE);
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

                //Second Page
                //Removing Cells
                pageTwoFirstCellName.setVisibility(View.GONE);
                pageTwoFirstCellBodyOne.setVisibility(View.GONE);
                pageTwoFirstCellBodyTwo.setVisibility(View.GONE);
                pageTwoFirstCellBodyThree.setVisibility(View.GONE);
                pageTwoFirstCellBodyEnd.setVisibility(View.GONE);

                pageTwoSecondCellName.setVisibility(View.GONE);
                pageTwoSecondCellBodyOne.setVisibility(View.GONE);
                pageTwoSecondCellBodyTwo.setVisibility(View.GONE);
                pageTwoSecondCellBodyThree.setVisibility(View.GONE);
                pageTwoSecondCellBodyEnd.setVisibility(View.GONE);
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
}


