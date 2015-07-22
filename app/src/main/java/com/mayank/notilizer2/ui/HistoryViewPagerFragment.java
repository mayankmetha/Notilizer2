package com.mayank.notilizer2.ui;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayank.notilizer2.R;

public class HistoryViewPagerFragment extends Fragment {
    private HistoryDailyFragment dailyFrag;
    private HistoryWeeklyFragment weeklyFrag;
    private HistoryMonthlyFragment monthlyFrag;

    public HistoryViewPagerFragment() {
        dailyFrag = new HistoryDailyFragment();
        weeklyFrag = new HistoryWeeklyFragment();
        monthlyFrag = new HistoryMonthlyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        final int DEFAULT_SELECTED_INDICATOR_COLOR=R.color.Gold;
        if (actionBar.getTabCount() != 3) {
            ActionBar.TabListener tabListener = new ActionBar.TabListener() {
                @Override
                public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                    //setCurrentItem(tab.getPosition());
                    int position = tab.getPosition();
                    if (position == 0) {
                        fragmentTransaction.replace(R.id.frame_layout, dailyFrag);
                    } else if (position == 1) {
                        fragmentTransaction.replace(R.id.frame_layout, weeklyFrag);
                    } else if (position == 2) {
                        fragmentTransaction.replace(R.id.frame_layout, monthlyFrag);
                    }
                }

                @Override
                public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                    // No special actions.
                }

                @Override
                public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                    // User selected the already selected tab. In this case do nothing.
                }
            };
            ActionBar.Tab tabDaily = actionBar.newTab().setText(R.string.history_daily).setTabListener(tabListener);
            ActionBar.Tab tabWeekly = actionBar.newTab().setText(R.string.history_weekly).setTabListener(tabListener);
            ActionBar.Tab tabMonthly = actionBar.newTab().setText(R.string.history_monthly).setTabListener(tabListener);

            actionBar.removeAllTabs();
            actionBar.addTab(tabDaily);
            actionBar.addTab(tabWeekly);
            actionBar.addTab(tabMonthly);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_history_viewpager, container, false);
    }


}
