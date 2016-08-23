package radonsoft.radoncalc.Helpers;

import android.animation.Animator;
import android.app.Fragment;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.fragments.FragmentCalcHistory;
import radonsoft.radoncalc.fragments.converter;

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
                            FragmentCalcHistory.clearThirdPage();
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
        Global.pageOneFifthCellhistoryBody = "";
        Global.pageOneFifthCellhistoryName = "";
        Global.pageOneFifthCellhistoryResult = "";

        Global.pageOneFourthCellhistoryBody = "";
        Global.pageOneFourthCellhistoryName = "";
        Global.pageOneFourthCellhistoryResult = "";

        Global.pageOneThirdCellhistoryBody = "";
        Global.pageOneThirdCellhistoryName = "";
        Global.pageOneThirdCellhistoryResult = "";

        Global.pageOneSecondCellhistoryBody = "";
        Global.pageOneSecondCellhistoryName = "";
        Global.pageOneSecondCellhistoryResult = "";

        Global.pageOnefirstCellhistoryBody = "";
        Global.pageOnefirstCellhistoryName = "";
        Global.pageOnefirstCellhistoryResult = "";
        //Counter Reset
        ma.pageOneCounter = 0;
        //Second Page
        //Variables Clear
        Global.pageTwoFirstCellHistoryName = "";
        Global.pageTwoFirstCellHistoryBodyone = "";
        Global.pageTwoFirstCellHistoryBodytwo = "";
        Global.pageTwoFirstCellHistoryBodythree = "";
        Global.pageTwoFirstCellHistoryBodyend = "";

        Global.pageTwoSecondCellHistoryName = "";
        Global.pageTwoSecondCellHistoryBodyone = "";
        Global.pageTwoSecondCellHistoryBodytwo = "";
        Global.pageTwoSecondCellHistoryBodythree = "";
        Global.pageTwoSecondCellHistoryBodyend = "";

        Global.pageTwoThirdCellHistoryName = "";
        Global.pageTwoThirdCellHistoryBodyone = "";
        Global.pageTwoThirdCellHistoryBodytwo = "";
        Global.pageTwoThirdCellHistoryBodythree = "";
        Global.pageTwoThirdCellHistoryBodyend = "";
        // Counters Reset
        ma.pageTwoCounter = 0;
        ma.historyWriteToogle = 0;
        //Return default text

        ma.pageThreeCounter = 0;
    }
}
