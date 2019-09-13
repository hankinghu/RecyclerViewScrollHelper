package com.example.asus.recyclerviewhelper.libs;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created time 16:27.
 *
 * @author huhanjun
 * @since 2019/9/12
 */
class EndSnapHelperDelegator extends SnapHelperDelegator {

  /**
   * Constructor
   *
   * @param snapCount the number of items to scroll over
   */
  EndSnapHelperDelegator(int snapCount) {
    super(snapCount);
  }

  @Override
  int getDistance(RecyclerView.LayoutManager layoutManager, View targetView,
                  OrientationHelper helper) {
    final int childEnd = getChildPosition(targetView, helper);
    final int containerEnd = getContainerPosition(layoutManager, helper);
    return childEnd - containerEnd;
  }

  @Override
  int getContainerPosition(RecyclerView.LayoutManager layoutManager,
                           OrientationHelper helper) {
    return layoutManager.getClipToPadding() ? helper.getStartAfterPadding() + helper.getTotalSpace()
        : helper.getEnd() - helper.getEndPadding();
  }

  @Override
  int getChildPosition(View targetView, OrientationHelper helper) {
    return helper.getDecoratedStart(targetView) + helper.getDecoratedMeasurement(targetView);
  }

  @Override
  boolean shouldSkipTarget(View targetView, RecyclerView.LayoutManager layoutManager,
                           OrientationHelper helper, boolean forwardDirection) {
    return forwardDirection ? getDistance(layoutManager, targetView, helper) < 0
        : getDistance(layoutManager, targetView, helper) > 0;
  }
}
