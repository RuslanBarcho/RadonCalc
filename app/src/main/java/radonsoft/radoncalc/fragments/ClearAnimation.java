package radonsoft.radoncalc.fragments;

import android.animation.Animator;
import android.app.Fragment;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

import radonsoft.radoncalc.MainActivity;

/**
 * Created by Ruslan Barcho on 11.07.2016.
 */
public class ClearAnimation {
    public Animator clrAnimName;
    public FrameLayout clrAnimBackground;
    MainActivity ma = new MainActivity();

    public void createClrAnim(int clrAnimSize, int clrAnimSpeed, int cx, int cy) {
        if (Build.VERSION.SDK_INT >= 21) {
            // get the center for the clipping circle


            // get the final radius for the clipping circle
            int finalRadius = clrAnimBackground.getHeight() + clrAnimSize;
            clrAnimName = ViewAnimationUtils.createCircularReveal(clrAnimBackground, cx, cy, 0, finalRadius);
            clrAnimName.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    clrAnimBackground.setVisibility(View.VISIBLE);
                    clrAnimBackground.startAnimation(ma.fadein);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    clrAnimBackground.startAnimation(ma.fadeout);
                    clrAnimBackground.setVisibility(View.GONE);
                    switch (ma.pages) {
                        case 2:
                            FragmentCalcHistory.clearFirstPage();
                            FragmentCalcHistory.clearSecondPage();
                            clearHistoryVariables();
                            break;
                        case 4:
                            converter.clearInOutWindows();
                            break;
                        default:

                            break;
                    }
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            clrAnimName.setDuration(clrAnimSpeed);
            clrAnimName.start();
        }
    }
    public void clearHistoryVariables() {
        //First Page
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
        //Second Page
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
    }
}
