package radonsoft.radoncalc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;

import radonsoft.radoncalc.Helpers.Global;
import radonsoft.radoncalc.fragments.FragmentCalc;
import radonsoft.radoncalc.fragments.FragmentCalcHistory;
import radonsoft.radoncalc.fragments.FragmentQuadraticEquations;
import radonsoft.radoncalc.fragments.HistoryFragment;
import radonsoft.radoncalc.fragments.converter;
import radonsoft.radoncalc.fragments.settings;

public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    public static int pages = 0;

    public static String titleCalc;
    public static String titleEquations;
    public static String titleConverter;

    // Operation History
    public static int pageOneCounter = 0;

    //Page Two
    public static int pageTwoCounter = 0;
    public static int historyWriteToogle = 0;
    public static String historyWriterChecker= "No Solution";

    //save data in quadratic equations
    public static String saveDValue;
    public static String saveSqrtDValue;
    public static String savexOneValue;
    public static String savexTwoValue;
    public static String saveTextviewA;
    public static String saveTextviewB;
    public static String saveTextviewC;
    public static int show;
    //Fragments
    FragmentCalc fragmentcalc;
    HistoryFragment fragmenthistory;
    FragmentCalcHistory fragmentCalcHistory;
    FragmentQuadraticEquations fragmentQuadraticEquations;
    converter fragmentConverter;
    settings settings;

    //Animations
    public static Animation fadein;
    public static Animation fadeout;
    //save and send calculator values
    public static String saveTextViewValue;
    public static String saveAddictionTextViewValue;
    public static BigDecimal saveOperateA;
    public static int saveTumbler;
    //public static String saveDegreeStatus = "RAD";

    //save and send converter value
    public static String saveConverterValue;
    public static String saveOutputConverterValue;
    public static int spinnerInputPos = 0;
    public static int spinnerOutputPos = 0;
    public static int valueIDPos = 0;
    public static String spinnerOutputPosString = "Centimeter";
    public static String spinnerInputPosString= "Centimeter";
    public static String chooseValue = "Length";

    SharedPreferences sp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        titleCalc = getString(R.string.calculator_title);
        titleEquations = getString(R.string.equations_title);
        titleConverter = getString(R.string.converter_title);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        fragmentcalc = new FragmentCalc();
        fragmenthistory = new HistoryFragment();
        fragmentQuadraticEquations = new FragmentQuadraticEquations();
        fragmentCalcHistory = new FragmentCalcHistory();
        fragmentConverter = new converter();
        settings = new settings();

        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        ftrans.replace(R.id.container, fragmentcalc);

        if (pages == 1) {
            ftrans.replace(R.id.container, fragmentQuadraticEquations);
        }
        if (pages == 2) {
            ftrans.replace(R.id.container, fragmentCalcHistory);
        }
        if (pages == 4){
            ftrans.replace(R.id.container, fragmentConverter);
        }
        if (pages == 3){
            ftrans.replace(R.id.container, settings);
        }
        ftrans.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void saveString(String title, String toSave){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(title, toSave).commit();
    }

    public void saveSharedPreferences(){
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("counter_one", pageOneCounter).commit();
        editor.putInt("counter_two", pageTwoCounter).commit();
        editor.putBoolean("vibrationSwitcher", Global.vibrationSwitcher).commit();

        saveString("saveDegreeStatus", Global.saveDegreeStatus);

        saveString("pageOnefirstCellhistoryName", Global.pageOnefirstCellhistoryName);
        saveString("pageOnefirstCellhistoryBody", Global.pageOnefirstCellhistoryBody);
        saveString("pageOnefirstCellhistoryResult", Global.pageOnefirstCellhistoryResult);

        saveString("pageOneSecondCellhistoryName", Global.pageOneSecondCellhistoryName);
        saveString("pageOneSecondCellhistoryBody", Global.pageOneSecondCellhistoryBody);
        saveString("pageOneSecondCellhistoryResult", Global.pageOneSecondCellhistoryResult);

        saveString("pageOneThirdCellhistoryName", Global.pageOneThirdCellhistoryName);
        saveString("pageOneThirdCellhistoryBody", Global.pageOneThirdCellhistoryBody);
        saveString("pageOneThirdCellhistoryResult", Global.pageOneThirdCellhistoryResult);

        saveString("pageOneFourthCellhistoryName", Global.pageOneFourthCellhistoryName);
        saveString("pageOneFourthCellhistoryBody", Global.pageOneFourthCellhistoryBody);
        saveString("pageOneFourthCellhistoryResult", Global.pageOneFourthCellhistoryResult);

        saveString("pageOneFifthCellhistoryName", Global.pageOneFifthCellhistoryName);
        saveString("pageOneFifthCellhistoryBody", Global.pageOneFifthCellhistoryBody);
        saveString("pageOneFifthCellhistoryResult", Global.pageOneFifthCellhistoryResult);

        saveString("pageTwoFirstCellHistoryName", Global.pageTwoFirstCellHistoryName);
        saveString("pageTwoFirstCellHistoryBodyone", Global.pageTwoFirstCellHistoryBodyone);
        saveString("pageTwoFirstCellHistoryBodytwo", Global.pageTwoFirstCellHistoryBodytwo);
        saveString("pageTwoFirstCellHistoryBodythree", Global.pageTwoFirstCellHistoryBodythree);
        saveString("pageTwoFirstCellHistoryBodyend", Global.pageTwoFirstCellHistoryBodyend);

        saveString("pageTwoSecondCellHistoryName", Global.pageTwoSecondCellHistoryName);
        saveString("pageTwoSecondCellHistoryBodyone", Global.pageTwoSecondCellHistoryBodyone);
        saveString("pageTwoSecondCellHistoryBodytwo", Global.pageTwoSecondCellHistoryBodytwo);
        saveString("pageTwoSecondCellHistoryBodythree", Global.pageTwoSecondCellHistoryBodythree);
        saveString("pageTwoSecondCellHistoryBodyend", Global.pageTwoSecondCellHistoryBodyend);

        saveString("pageTwoThirdCellHistoryName", Global.pageTwoThirdCellHistoryName);
        saveString("pageTwoThirdCellHistoryBodyone", Global.pageTwoThirdCellHistoryBodyone);
        saveString("pageTwoThirdCellHistoryBodytwo", Global.pageTwoThirdCellHistoryBodytwo);
        saveString("pageTwoThirdCellHistoryBodythree", Global.pageTwoThirdCellHistoryBodythree);
        saveString("pageTwoThirdCellHistoryBodyend", Global.pageTwoThirdCellHistoryBodyend);

        saveString("pageTwoFourthCellHistoryName", Global.pageTwoFourthCellHistoryName);
        saveString("pageTwoFourthCellHistoryBodyone", Global.pageTwoFourthCellHistoryBodyone);
        saveString("pageTwoFourthCellHistoryBodytwo", Global.pageTwoFourthCellHistoryBodytwo);
        saveString("pageTwoFourthCellHistoryBodythree", Global.pageTwoFourthCellHistoryBodythree);
        saveString("pageTwoFourthCellHistoryBodyend", Global.pageTwoFourthCellHistoryBodyend);

        saveString("pageTwoFifthCellHistoryName", Global.pageTwoFifthCellHistoryName);
        saveString("pageTwoFifthCellHistoryBodyone", Global.pageTwoFifthCellHistoryBodyone);
        saveString("pageTwoFifthCellHistoryBodytwo", Global.pageTwoFifthCellHistoryBodytwo);
        saveString("pageTwoFifthCellHistoryBodythree", Global.pageTwoFifthCellHistoryBodythree);
        saveString("pageTwoFifthCellHistoryBodyend", Global.pageTwoFifthCellHistoryBodyend);
    }

    public void returnSharedPreferences(){
        pageOneCounter = sp.getInt("counter_one", 0);
        pageTwoCounter = sp.getInt("counter_two", 0);

        Global.saveDegreeStatus = sp.getString("saveDegreeStatus", "RAD");
        Global.vibrationSwitcher = sp.getBoolean("vibrationSwitcher", false);

        Global.pageOnefirstCellhistoryName = sp.getString("pageOnefirstCellhistoryName", "");
        Global.pageOnefirstCellhistoryBody = sp.getString("pageOnefirstCellhistoryBody", "");
        Global.pageOnefirstCellhistoryResult = sp.getString("pageOnefirstCellhistoryResult", "");

        Global.pageOneSecondCellhistoryName = sp.getString("pageOneSecondCellhistoryName", "");
        Global.pageOneSecondCellhistoryBody = sp.getString("pageOneSecondCellhistoryBody", "");
        Global.pageOneSecondCellhistoryResult = sp.getString("pageOneSecondCellhistoryResult", "");

        Global.pageOneThirdCellhistoryName = sp.getString("pageOneThirdCellhistoryName", "");
        Global.pageOneThirdCellhistoryBody = sp.getString("pageOneThirdCellhistoryBody", "");
        Global.pageOneThirdCellhistoryResult = sp.getString("pageOneThirdCellhistoryResult", "");

        Global.pageOneFourthCellhistoryName = sp.getString("pageOneFourthCellhistoryName", "");
        Global.pageOneFourthCellhistoryBody = sp.getString("pageOneFourthCellhistoryBody", "");
        Global.pageOneFourthCellhistoryResult = sp.getString("pageOneFourthCellhistoryResult", "");

        Global.pageOneFifthCellhistoryName = sp.getString("pageOneFifthCellhistoryName", "");
        Global.pageOneFifthCellhistoryBody = sp.getString("pageOneFifthCellhistoryBody", "");
        Global.pageOneFifthCellhistoryResult = sp.getString("pageOneFifthCellhistoryResult", "");

        Global.pageTwoFirstCellHistoryName = sp.getString("pageTwoFirstCellHistoryName", "");
        Global.pageTwoFirstCellHistoryBodyone = sp.getString("pageTwoFirstCellHistoryBodyone", "");
        Global.pageTwoFirstCellHistoryBodytwo = sp.getString("pageTwoFirstCellHistoryBodytwo", "");
        Global.pageTwoFirstCellHistoryBodythree = sp.getString("pageTwoFirstCellHistoryBodythree", "");
        Global.pageTwoFirstCellHistoryBodyend = sp.getString("pageTwoFirstCellHistoryBodyend", "");

        Global.pageTwoSecondCellHistoryName = sp.getString("pageTwoSecondCellHistoryName", "");
        Global.pageTwoSecondCellHistoryBodyone = sp.getString("pageTwoSecondCellHistoryBodyone", "");
        Global.pageTwoSecondCellHistoryBodytwo = sp.getString("pageTwoSecondCellHistoryBodytwo", "");
        Global.pageTwoSecondCellHistoryBodythree = sp.getString("pageTwoSecondCellHistoryBodythree", "");
        Global.pageTwoSecondCellHistoryBodyend = sp.getString("pageTwoSecondCellHistoryBodyend", "");

        Global.pageTwoThirdCellHistoryName = sp.getString("pageTwoThirdCellHistoryName", "");
        Global.pageTwoThirdCellHistoryBodyone = sp.getString("pageTwoThirdCellHistoryBodyone", "");
        Global.pageTwoThirdCellHistoryBodytwo = sp.getString("pageTwoThirdCellHistoryBodytwo", "");
        Global.pageTwoThirdCellHistoryBodythree = sp.getString("pageTwoThirdCellHistoryBodythree", "");
        Global.pageTwoThirdCellHistoryBodyend = sp.getString("pageTwoThirdCellHistoryBodyend", "");

        Global.pageTwoFourthCellHistoryName = sp.getString("pageTwoFourthCellHistoryName", "");
        Global.pageTwoFourthCellHistoryBodyone = sp.getString("pageTwoFourthCellHistoryBodyone", "");
        Global.pageTwoFourthCellHistoryBodytwo = sp.getString("pageTwoFourthCellHistoryBodytwo", "");
        Global.pageTwoFourthCellHistoryBodythree = sp.getString("pageTwoFourthCellHistoryBodythree", "");
        Global.pageTwoFourthCellHistoryBodyend = sp.getString("pageTwoFourthCellHistoryBodyend", "");

        Global.pageTwoFifthCellHistoryName = sp.getString("pageTwoFifthCellHistoryName", "");
        Global.pageTwoFifthCellHistoryBodyone = sp.getString("pageTwoFifthCellHistoryBodyone", "");
        Global.pageTwoFifthCellHistoryBodytwo = sp.getString("pageTwoFifthCellHistoryBodytwo", "");
        Global.pageTwoFifthCellHistoryBodythree = sp.getString("pageTwoFifthCellHistoryBodythree", "");
        Global.pageTwoFifthCellHistoryBodyend = sp.getString("pageTwoFifthCellHistoryBodyend", "");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        if (id == R.id.nav_camera) {
            ftrans.replace(R.id.container, fragmentCalcHistory);
        } else if (id == R.id.nav_gallery) {
            ftrans.replace(R.id.container, fragmentcalc);
        } else if (id == R.id.nav_slideshow) {
            ftrans.replace(R.id.container, fragmentQuadraticEquations);
        } else if (id == R.id.nav_converter) {
            ftrans.replace(R.id.container, fragmentConverter);
        } else if (id == R.id.nav_settings) {
            ftrans.replace(R.id.container, settings);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        ftrans.commit();
        return true;
    }
    @Override
    protected void onStop() {
        super.onStop();
        saveSharedPreferences();
    }
    @Override
    protected void onPause(){
        super.onPause();
        saveSharedPreferences();
    }
    @Override
    protected void onStart() {
        super.onStart();
        returnSharedPreferences();
    }
}
