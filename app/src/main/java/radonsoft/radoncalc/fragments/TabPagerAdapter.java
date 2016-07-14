package radonsoft.radoncalc.fragments;

import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Ruslan Barcho on 19.06.2016.
 */
public class TabPagerAdapter extends PagerAdapter {
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Calculator";
            case 1:
                return "Equations";
            case 2:
                return "Converter";
            case 3:
                return "Trigonometry";
            default:
                return "Kokos";
        }
    }
    List<View> pages = null;

    public TabPagerAdapter(List<View> pages) {
        this.pages = pages;
    }


    @Override
    public Object instantiateItem(View collection, int position) {
        View v = pages.get(position);
        ((ViewPager) collection).addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }
}