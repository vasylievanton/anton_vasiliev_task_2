package com.task2.vasilyevanton.task_2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.task2.vasilyevanton.task_2.R;

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.ListViewHolder> {

    private static final float IMAGE_QUANTITY = 2;
    private static final float LAYOUT_MARGIN = 32;
    private float mWidth;
    private int[] mImagesResData;

    public PhotoRecyclerAdapter(int imagesRes[]) {
        this.mImagesResData = imagesRes;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_photo_item, parent, false);

        mWidth = parent.getResources().getDisplayMetrics().widthPixels;
        float displayDensity = parent.getResources().getDisplayMetrics().density;
        mWidth = ((mWidth - LAYOUT_MARGIN * displayDensity) / IMAGE_QUANTITY); // getting mImage width

        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {

        RecyclerView.LayoutParams containerParams = (RecyclerView.LayoutParams) holder.mContainerLayout.getLayoutParams();
        containerParams.width = (int) mWidth;
        containerParams.height = (int) (mWidth * 1.1);  // getting mImage height
        holder.mContainerLayout.setLayoutParams(containerParams);
        holder.mImage.setImageResource(mImagesResData[holder.getAdapterPosition()]);
        holder.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Photo_" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagesResData.length;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private LinearLayout mContainerLayout;

        public ListViewHolder(View itemView) {
            super(itemView);
            mContainerLayout = (LinearLayout) itemView.findViewById(R.id.container);
            mImage = (ImageView) itemView.findViewById(R.id.recycler_image);
        }
    }
}

