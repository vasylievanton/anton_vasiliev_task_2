package com.task2.vasilyevanton.task_2.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.task2.vasilyevanton.task_2.R;
import com.task2.vasilyevanton.task_2.data.AppealsData;

import java.util.List;

public class AppealsListAdapter extends ArrayAdapter<AppealsData> {


    protected List<AppealsData> mDataList;
    private Activity activity;
    private Integer mLayout;

    public AppealsListAdapter(Activity context, Integer mLayout, List<AppealsData> dataList) {
        super(context, mLayout, dataList);

        this.activity = context;
        this.mLayout = mLayout;
        this.mDataList = dataList;
    }

    @Override
    public View getView(final int position, View mConvertView, ViewGroup parent) {

        ViewHolder mHolder;
        if (mConvertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            mConvertView = inflater.inflate(this.mLayout, null, false);
            mHolder = new ViewHolder();
            mHolder.itemLL = (LinearLayout) mConvertView.findViewById(R.id.appeals_ll);
            mHolder.addressTV = (TextView) mConvertView.findViewById(R.id.address_tv);
            mHolder.dateTV = (TextView) mConvertView.findViewById(R.id.date_tv);
            mHolder.termTV = (TextView) mConvertView.findViewById(R.id.term_tv);
            mHolder.idImage = (ImageView) mConvertView.findViewById(R.id.image_id);
            mHolder.idTV = (TextView) mConvertView.findViewById(R.id.id_tv);
            mHolder.likesTV = (TextView) mConvertView.findViewById(R.id.likes_tv);
            mConvertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) mConvertView.getTag();
        }
        mHolder.likesTV.setText(mDataList.get(position).getmItemLikes());
        mHolder.idTV.setText(mDataList.get(position).getmItemId());
        mHolder.addressTV.setText(mDataList.get(position).getmItemAddress());
        mHolder.dateTV.setText(mDataList.get(position).getmItemRegisterDate());
        mHolder.termTV.setText(mDataList.get(position).getmItemDeadlineDate());
        return mConvertView;
    }

    static class ViewHolder {
        public LinearLayout itemLL;
        public ImageView idImage;
        public TextView idTV, addressTV, dateTV, termTV, likesTV;
    }

}