package radonsoft.radoncalc.Helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Ruska on 25.07.2016.
 */
public class Global {
    //export to quadratic equations
    public static int sqrEquationsExport;
    public static int sqrEquationsExportCheckA;
    public static int sqrEquationsExportCheckB;
    public static int sqrEquationsExportCheckC;
    public static String sqrEquationsExportToA;
    public static String sqrEquationsExportToB;
    public static String sqrEquationsExportToC;
    //history writer
    // Page One
    // First Cell
    public static String pageOnefirstCellhistoryName = "A";
    public static String pageOnefirstCellhistoryBody = "B";
    public static String pageOnefirstCellhistoryResult = "C";
    // Second Cell
    public static String pageOneSecondCellhistoryName = "A";
    public static String pageOneSecondCellhistoryBody = "B";
    public static String pageOneSecondCellhistoryResult = "C";
    // Third Cell
    public static String pageOneThirdCellhistoryName = "A";
    public static String pageOneThirdCellhistoryBody = "B";
    public static String pageOneThirdCellhistoryResult = "C";
    // Fourth Cell
    public static String pageOneFourthCellhistoryName = "A";
    public static String pageOneFourthCellhistoryBody = "B";
    public static String pageOneFourthCellhistoryResult = "C";
    // Fifth Cell
    public static String pageOneFifthCellhistoryName = "A";
    public static String pageOneFifthCellhistoryBody = "B";
    public static String pageOneFifthCellhistoryResult = "C";


    // First cell
    public static String pageTwoFirstCellHistoryName = "A";
    public static String pageTwoFirstCellHistoryBodyone = "A";
    public static String pageTwoFirstCellHistoryBodytwo = "A";
    public static String pageTwoFirstCellHistoryBodythree = "A";
    public static String pageTwoFirstCellHistoryBodyend = "A";
    // Second Cell
    public static String pageTwoSecondCellHistoryName = "A";
    public static String pageTwoSecondCellHistoryBodyone = "A";
    public static String pageTwoSecondCellHistoryBodytwo = "A";
    public static String pageTwoSecondCellHistoryBodythree = "A";
    public static String pageTwoSecondCellHistoryBodyend = "A";
    // Third Cell
    public static String pageTwoThirdCellHistoryName = "A";
    public static String pageTwoThirdCellHistoryBodyone = "A";
    public static String pageTwoThirdCellHistoryBodytwo = "A";
    public static String pageTwoThirdCellHistoryBodythree = "A";
    public static String pageTwoThirdCellHistoryBodyend = "A";
    // Fourth cell
    public static String pageTwoFourthCellHistoryName = "A";
    public static String pageTwoFourthCellHistoryBodyone = "A";
    public static String pageTwoFourthCellHistoryBodytwo = "A";
    public static String pageTwoFourthCellHistoryBodythree = "A";
    public static String pageTwoFourthCellHistoryBodyend = "A";
    // Fifth cell
    public static String pageTwoFifthCellHistoryName = "A";
    public static String pageTwoFifthCellHistoryBodyone = "A";
    public static String pageTwoFifthCellHistoryBodytwo = "A";
    public static String pageTwoFifthCellHistoryBodythree = "A";
    public static String pageTwoFifthCellHistoryBodyend = "A";

    // First Cell
    public static String pageThreefirstCellhistoryInput = "A";
    public static String pageThreefirstCellhistoryInputName = "A";
    public static String pageThreefirstCellhistoryOutput = "C";
    public static String pageThreefirstCellhistoryOutputName = "C";
    // Second Cell
    public static String pageThreeSecondCellhistoryInput = "A";
    public static String pageThreeSecondCellhistoryInputName = "A";
    public static String pageThreeSecondCellhistoryOutput = "C";
    public static String pageThreeSecondCellhistoryOutputName = "C";
    // Third Cell
    public static String pageThreeThirdCellhistoryInput = "A";
    public static String pageThreeThirdCellhistoryInputName = "A";
    public static String pageThreeThirdCellhistoryOutput = "C";
    public static String pageThreeThirdCellhistoryOutputName = "C";
    // Fourth Cell
    public static String pageThreeFourthCellhistoryInput = "A";
    public static String pageThreeFourthCellhistoryInputName = "A";
    public static String pageThreeFourthCellhistoryOutput = "C";
    public static String pageThreeFourthCellhistoryOutputName = "C";
    // Fifth Cell
    public static String pageThreeFifthCellhistoryInput = "A";
    public static String pageThreeFifthCellhistoryInputName = "A";
    public static String pageThreeFifthCellhistoryOutput = "C";
    public static String pageThreeFifthCellhistoryOutputName = "C";

    public static int pageThreeCounter = 0;

    public static String saveDegreeStatus = "RAD";
    public static boolean vibrationSwitcher;
    //Global voids

    public static void turnVibrationOn(View button){
        if (vibrationSwitcher){
            //button.setHapticFeedbackEnabled(true);
            //button.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
    }
}
