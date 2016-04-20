package com.task2.vasilyevanton.task_2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;

import com.task2.vasilyevanton.task_2.R;
import com.task2.vasilyevanton.task_2.activities.TaskActivity;
import com.task2.vasilyevanton.task_2.adapters.AppealsListAdapter;
import com.task2.vasilyevanton.task_2.adapters.AppealsRecyclerAdapter;
import com.task2.vasilyevanton.task_2.data.AppealsData;
import com.task2.vasilyevanton.task_2.utils.ScrollDetectingListView;

import java.util.ArrayList;
import java.util.List;

public class AppealsFragment extends Fragment implements View.OnClickListener {
    private static final int AT_WORK = 0;
    private static final int DONE = 1;
    private static final int PENDING_EXECUTION = 2;
    private FloatingActionButton fab;
    private List<AppealsData> mAtWorkData;
    private List<AppealsData> mDoneData;
    private List<AppealsData> mPendingExecData;
    private int mImagesId[] = {R.drawable.carbon, R.drawable.example, R.drawable.carbon, R.drawable.model, R.drawable.example, R.drawable.model, R.drawable.example, R.drawable.model, R.drawable.example, R.drawable.carbon, R.drawable.example};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.appeals_screen, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        dataInit();
        fragmentInit(view);
        setRetainInstance(true);
    }

    private void fragmentInit(View view) {
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mViewPager.setOffscreenPageLimit(3);
        TabLayout mSlidingTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        mSlidingTabLayout.setupWithViewPager(mViewPager);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab: {
                Toast.makeText(getContext(), "Floating Action Button", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;
        }
    }

    private void dataInit() {
        mAtWorkData = new ArrayList<>();
        mDoneData = new ArrayList<>();
        mPendingExecData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AppealsData mTestData = new AppealsData();
            mTestData.setmItemAddress("Вул. Вадима Гетьмана, 42");
            mTestData.setmItemCreationDate("13 Квітня 2016");
            mTestData.setmItemExecTerm("14 днів");
            mTestData.setmItemRegisterDate("13 Квітня 2016");
            mTestData.setmItemDescription("Відкритий люк");
            mTestData.setmItemExecutor("Днепропетровск");
            mTestData.setmItemId("Демонтаж інших об’єктів, що входять до переліку мал...");
            mTestData.setmItemStatus("В роботі");
            mTestData.setmItemLikes("10");
            mTestData.setItemImageRef(mImagesId);
            mAtWorkData.add(mTestData);
            mDoneData.add(mTestData);
            mPendingExecData.add(mTestData);
        }
    }

    // Adapter
    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }
        /**
         * Return true if the value returned from is the same object as the View
         * added to the ViewPager.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case AT_WORK:
                    return getActivity().getString(R.string.at_work);
                case DONE:
                    return getActivity().getString(R.string.done);
                case PENDING_EXECUTION:
                    return getActivity().getString(R.string.pending_execution);
            }
            return null;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = null;
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            switch (position) {
                case AT_WORK:
                    view = getActivity().getLayoutInflater().inflate(R.layout.rv_pager_item, container, false);
                    RecyclerView mAtWorkRV = (RecyclerView) view.findViewById(R.id.rv);
                    mAtWorkRV.setLayoutManager(mLayoutManager);
                    mAtWorkRV.setAdapter(new AppealsRecyclerAdapter(getActivity(), mAtWorkData));
                    mAtWorkRV.hasFixedSize();
                    break;
                case DONE: {
                    view = getActivity().getLayoutInflater().inflate(R.layout.rv_pager_item, container, false);
                    RecyclerView mDoneRV = (RecyclerView) view.findViewById(R.id.rv);
                    mDoneRV.setLayoutManager(mLayoutManager);
                    mDoneRV.setAdapter(new AppealsRecyclerAdapter(getActivity(), mDoneData));
                    mDoneRV.hasFixedSize();
                    break;
                }

                case PENDING_EXECUTION: {
                    view = getActivity().getLayoutInflater().inflate(R.layout.list_pager_item, container, false);

                    final ScrollDetectingListView mPendingExecItemList = (ScrollDetectingListView) view.findViewById(R.id.appeals_list);

                    mPendingExecItemList.setOnScrollListener(new AbsListView.OnScrollListener() {

                        private int mInitialScroll = 0;

                        @Override
                        public void onScrollStateChanged(AbsListView view, int scrollState) {
                        }

                        @Override
                        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                            int scrolledOffset = mPendingExecItemList.getVerticalScrollOffset();
                            if (scrolledOffset != mInitialScroll) {
                                //if scroll position changed
                                boolean scrollUp = (scrolledOffset - mInitialScroll) < 0;
                                mInitialScroll = scrolledOffset;
                                if (scrollUp) {
                                    fab.show();
                                } else {
                                    fab.hide();
                                }
                            }
                        }
                    });

                    final AppealsListAdapter mPendingExecAdapter = new AppealsListAdapter(getActivity(), R.layout.item_list, mPendingExecData);
                    mPendingExecItemList.setAdapter(mPendingExecAdapter);
                    mPendingExecItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), TaskActivity.class);
                            intent.putExtra("title", mPendingExecData.get(position).getItemName());
                            intent.putExtra("status", mPendingExecData.get(position).getmItemStatus());
                            intent.putExtra("creation_date", mPendingExecData.get(position).getmItemCreationDate());
                            intent.putExtra("register_date", mPendingExecData.get(position).getmItemRegisterDate());
                            intent.putExtra("deadline_date", mPendingExecData.get(position).getmItemDeadlineDate());
                            intent.putExtra("executor",mPendingExecData.get(position).getmItemExecutor());
                            intent.putExtra("description", mPendingExecData.get(position).getmItemId());
                            intent.putExtra("images", mPendingExecData.get(position).getItemImageRef());
                            startActivity(intent);
                        }
                    });
                    break;
                }
            }
            // Add the newly created View to the ViewPager
            container.addView(view);
            // Return the View
            return view;
        }

        /**
         * Destroy the item from the ViewPager. In our case this is simply
         * removing the View.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
