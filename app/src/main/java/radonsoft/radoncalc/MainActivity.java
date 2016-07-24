package radonsoft.radoncalc;

import android.os.Bundle;
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

import java.math.BigDecimal;

import radonsoft.radoncalc.fragments.FragmentCalc;
import radonsoft.radoncalc.fragments.FragmentCalcHistory;
import radonsoft.radoncalc.fragments.FragmentQuadraticEquations;
import radonsoft.radoncalc.fragments.HistoryFragment;
import radonsoft.radoncalc.fragments.converter;

public class MainActivity extends AppCompatActivity


        implements NavigationView.OnNavigationItemSelectedListener {
    public static int pages = 0;

    public static String titleCalc;
    public static String titleEquations;
    public static String titleConverter;

    // Operation History
    // Page One
    public static int pageOneCounter = 0;
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

    //Page Two
    public static int pageTwoCounter = 0;
    public static int historyWriteToogle = 0;
    public static String historyWriterChecker= "No Solution";
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
    //Animations
    public static Animation fadein;
    public static Animation fadeout;
    //save and send calculator values
    public static String saveTextViewValue;
    public static String saveAddictionTextViewValue;
    public static BigDecimal saveOperateA;
    public static int saveTumbler;
    public static String saveDegreeStatus = "RAD";

    //save and send converter value
    public static String saveConverterValue;
    public static String saveOutputConverterValue;
    public static int spinnerInputPos = 0;
    public static int spinnerOutputPos = 0;
    public static int valueIDPos = 0;
    public static String spinnerOutputPosString = "Centimeter";
    public static String spinnerInputPosString= "Centimeter";
    public static String chooseValue = "Length";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        ftrans.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
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

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

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
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        ftrans.commit();
        return true;
    }
}
