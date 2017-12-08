package jp.co.arkray.android.taratsek;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import jp.co.arkray.android.taratsek.Patient.DashboardFragment;
import jp.co.arkray.android.taratsek.Patient.ManageFragment;
import jp.co.arkray.android.taratsek.Patient.ReportsFragment;
import jp.co.arkray.android.taratsek.Patient.SettingsFragment;
import jp.co.arkray.android.taratsek.Utilities.AnimUtils;
import jp.co.arkray.android.taratsek.Utilities.ViewPagerAdapter;
import jp.co.arkray.android.taratsek.databinding.ActivityMainBinding;
import jp.co.arkray.android.taratsek.databinding.ItemTabButtonLayoutBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mBinding.container.setAdapter(mSectionsPagerAdapter);
        mBinding.layoutFabContainer.setVisibility(View.GONE);
        mBinding.layoutFabLabelContainer.setVisibility(View.GONE);
        AnimUtils.collapse(mBinding.layoutFabContainer);
        AnimUtils.collapse(mBinding.layoutFabLabelContainer);


        CustomViewpagerAdapter viewPagerAdapter = new CustomViewpagerAdapter(this, getSupportFragmentManager(), mBinding.tablayoutMenuNavigation);
        mBinding.container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBinding.tablayoutMenuNavigation));
        mBinding.tablayoutMenuNavigation.addOnTabSelectedListener(viewPagerAdapter.getTabSelectedListener(mBinding.container));

        viewPagerAdapter.addTab(new DashboardFragment(), "Dashboard", getResources().getDrawable(R.drawable.ic_dashboard_white_24dp));
        viewPagerAdapter.addTab(new ManageFragment(), "Manage", getResources().getDrawable(R.drawable.ic_assignment_white_24dp));
        viewPagerAdapter.addTab(new ReportsFragment(), "Reports", getResources().getDrawable(R.drawable.ic_assessment_white_24dp));
        viewPagerAdapter.addTab(new SettingsFragment(), "Settings", getResources().getDrawable(R.drawable.ic_settings_white_24dp));

        mBinding.container.setAdapter(viewPagerAdapter);

        mBinding.fab.setOnClickListener(this);
        mBinding.fabGlucose.setOnClickListener(this);
        mBinding.fabInsulin.setOnClickListener(this);
        mBinding.fabEvent.setOnClickListener(this);
        mBinding.fabMemo.setOnClickListener(this);
        mBinding.fabMedication.setOnClickListener(this);
        mBinding.fabMeal.setOnClickListener(this);
        mBinding.fabA1c.setOnClickListener(this);
        mBinding.fabNotification.setOnClickListener(this);
        mBinding.fabProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                if (mBinding.layoutFabContainer.getVisibility() == View.GONE) {
                    AnimUtils.expand(mBinding.layoutFabContainer);
                    AnimUtils.expand(mBinding.layoutFabLabelContainer);
                } else {
                    AnimUtils.collapse(mBinding.layoutFabContainer);
                    AnimUtils.collapse(mBinding.layoutFabLabelContainer);
                }
                break;
            default:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }

    public class CustomViewpagerAdapter extends ViewPagerAdapter implements TabLayout.OnTabSelectedListener {

        private Context mContext;
        private ArrayList<ItemTabButtonLayoutBinding> mTabBinding = new ArrayList<>();
        private TabLayout mTabLayout;
        private ViewPager mViewPager;


        public CustomViewpagerAdapter(Context context, FragmentManager fm, TabLayout tabLayout) {
            super(fm);
            this.mContext = context;
            this.mTabLayout = tabLayout;
        }

        public TabLayout.OnTabSelectedListener getTabSelectedListener(ViewPager viewPager){
            this.mViewPager = viewPager;
            return this;
        }

        public void addTab(Fragment fragment, String title, Drawable icon) {
            ItemTabButtonLayoutBinding temp = DataBindingUtil.inflate(
                    ((Activity) mContext).getLayoutInflater(),
                    R.layout.item_tab_button_layout,
                    mTabLayout,
                    false);

            temp.tvTabTitle.setText(title);
            temp.ivTabIcon.setImageDrawable(icon);
            mTabBinding.add(temp);
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(temp.getRoot()));
            addFragment(fragment,title);
        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            mViewPager.setCurrentItem(tab.getPosition());
            mTabBinding.get(tab.getPosition()).tvTabTitle.setVisibility(View.VISIBLE);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            mTabBinding.get(tab.getPosition()).tvTabTitle.setVisibility(View.GONE);
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }


    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return 3;
        }
    }
}
