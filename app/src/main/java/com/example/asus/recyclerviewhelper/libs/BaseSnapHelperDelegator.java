package com.example.asus.recyclerviewhelper.libs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created time 16:27.
 *
 * @author huhanjun
 * @since 2019/9/12
 */

abstract class BaseSnapHelperDelegator {

    /**
     * delegate method of
     * {@link MultiSnapHelper#calculateDistanceToFinalSnap(RecyclerView.LayoutManager, View)}
     *
     * @return the distance to the gravitated snap position
     */
    abstract int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager,
                                                @NonNull View targetView);

    /**
     * delegate method of {@link MultiSnapHelper#findSnapView(RecyclerView.LayoutManager)}
     *
     * @return the view to snap when RecyclerView is in the idle state
     */
    abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    /**
     * delegate method of
     * {@link MultiSnapHelper#findTargetSnapPosition(RecyclerView.LayoutManager, int, int)}
     *
     * @return the view to snap when RecyclerView is fling
     */
    abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX,
                                        int velocityY);

    /**
     * set a listener to return a position of the snapped view
     *
     * @param listener {@link OnSnapListener}
     */
    abstract void setListener(OnSnapListener listener);
}

