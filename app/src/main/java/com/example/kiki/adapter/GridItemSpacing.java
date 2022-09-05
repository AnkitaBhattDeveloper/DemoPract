package com.example.kiki.adapter;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridItemSpacing extends RecyclerView.ItemDecoration{
    int spanCount, spacing;
    Boolean includeEdge;

    public GridItemSpacing(int spanCount, int spacing, Boolean includeEdge)
    {
        this.spanCount = spanCount;
        this.spacing =- spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view) ;// item position
        int column = position % spanCount; // item column
        if (includeEdge) {
            outRect.left =
                    spacing - column * spacing / spanCount;// spacing - column  ((1f / spanCount) * spacing)
            outRect.right =
                    (column + 1) * spacing / spanCount; // (column + 1)  ((1f / spanCount) * spacing)
            if (position < spanCount) { // top edge

                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column  ((1f / spanCount) * spacing)
            outRect.right =
                    spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1)  ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}
