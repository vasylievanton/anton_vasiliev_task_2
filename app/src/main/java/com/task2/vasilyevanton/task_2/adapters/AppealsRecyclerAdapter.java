package com.task2.vasilyevanton.task_2.adapters;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.task2.vasilyevanton.task_2.R;
import com.task2.vasilyevanton.task_2.activities.TaskActivity;
import com.task2.vasilyevanton.task_2.data.AppealsData;

import java.util.List;

public class AppealsRecyclerAdapter extends RecyclerView.Adapter<AppealsRecyclerAdapter.ListViewHolder> {

    private List<AppealsData> mDataList;
    private Activity activity;


    public AppealsRecyclerAdapter(Activity context, List<AppealsData> mDataList) {
        this.activity = context;
        this.mDataList = mDataList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder mHolder, int position) {

        mHolder.idTV.setText(mDataList.get(position).getmItemId());
        mHolder.addressTV.setText(mDataList.get(position).getmItemAddress());
        mHolder.dateTV.setText(mDataList.get(position).getmItemRegisterDate());
        mHolder.termTV.setText(mDataList.get(position).getmItemDeadlineDate());
        mHolder.likesTV.setText(mDataList.get(position).getmItemLikes());
        mHolder.itemRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, TaskActivity.class);
                intent.putExtra("title", mDataList.get(mHolder.getAdapterPosition()).getItemName());
                intent.putExtra("status", mDataList.get(mHolder.getAdapterPosition()).getmItemStatus());
                intent.putExtra("creation_date", mDataList.get(mHolder.getAdapterPosition()).getmItemCreationDate());
                intent.putExtra("register_date", mDataList.get(mHolder.getAdapterPosition()).getmItemRegisterDate());
                intent.putExtra("deadline_date", mDataList.get(mHolder.getAdapterPosition()).getmItemDeadlineDate());
                intent.putExtra("executor",mDataList.get(mHolder.getAdapterPosition()).getmItemExecutor());
                intent.putExtra("description", mDataList.get(mHolder.getAdapterPosition()).getmItemId());
                intent.putExtra("images", mDataList.get(mHolder.getAdapterPosition()).getItemImageRef());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView mRecyclerView) {
        super.onAttachedToRecyclerView(mRecyclerView);
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView idImage;
        private TextView idTV, addressTV, dateTV, termTV, likesTV;
        private LinearLayout itemRV;

        public ListViewHolder(View itemView) {
            super(itemView);
            likesTV = (TextView) itemView.findViewById(R.id.likes_tv);
            itemRV = (LinearLayout) itemView.findViewById(R.id.appeals_ll);
            addressTV = (TextView) itemView.findViewById(R.id.address_tv);
            dateTV = (TextView) itemView.findViewById(R.id.date_tv);
            termTV = (TextView) itemView.findViewById(R.id.term_tv);
            idImage = (ImageView) itemView.findViewById(R.id.image_id);
            idTV = (TextView) itemView.findViewById(R.id.id_tv);
        }
    }
}
