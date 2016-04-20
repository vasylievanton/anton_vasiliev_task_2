package com.task2.vasilyevanton.task_2.utils;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ScrollDetectingListView extends ListView {
    public ScrollDetectingListView(Context context) {
        super(context);
    }

    public ScrollDetectingListView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    public ScrollDetectingListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //we need this protected method for scroll detection
    public int getVerticalScrollOffset() {
        return computeVerticalScrollOffset();
    }
}
