package com.example.asus.recyclerviewhelper.libs;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;



/**
 * Created time 16:24.
 *
 * @author huhanjun
 * @since 2019/9/12
 */
public class MultiSnapRecyclerViewHelper {

    private MultiSnapHelper multiSnapHelper;

    private MultiSnapRecyclerViewHelper(final Builder builder) {

        multiSnapHelper = new MultiSnapHelper(builder.mGravity, builder.mSnapCount, new LinearSmoothScroller(builder.mContext) {

            @Override
            protected void onTargetFound(View targetView, RecyclerView.State state,
                                         Action action) {
                int[] snapDistances =
                        multiSnapHelper.calculateDistanceToFinalSnap(getLayoutManager(), targetView);
                final int dx = snapDistances[0];
                final int dy = snapDistances[1];
                final int time = calculateTimeForDeceleration(Math.max(Math.abs(dx), Math.abs(dy)));
                if (time > 0) {
                    action.update(dx, dy, time, mDecelerateInterpolator);
                }
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return builder.mMillisecondsPerInch / displayMetrics.densityDpi;
            }
        });
    }

    /**
     * @param recyclerView recyclerView
     */
    public void attachToRecyclerView(RecyclerView recyclerView) {
        multiSnapHelper.attachToRecyclerView(recyclerView);
    }

    public static class Builder {
        private SnapGravity mGravity=SnapGravity.CENTER;
        private int mSnapCount=1;
        private float mMillisecondsPerInch=20;
        private Context mContext;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setGraVity(SnapGravity gravity) {
            mGravity = gravity;
            return this;
        }

        public Builder setSnapCount(int snapCount) {
            mSnapCount = snapCount;
            return this;
        }

        public Builder setMilliSecondsPerInch(float millisecondsPerInch) {
            mMillisecondsPerInch = millisecondsPerInch;
            return this;
        }

        public MultiSnapRecyclerViewHelper build() {
            return new MultiSnapRecyclerViewHelper(this);
        }

    }

}
