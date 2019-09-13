package com.example.asus.recyclerviewhelper.libs;

/**
 * Created time 16:27.
 *
 * @author huhanjun
 * @since 2019/9/12
 */
public interface OnSnapListener {

  /**
   * Called when RecyclerView is snapped
   *
   * @param position snapped position
   */
  void snapped(int position);
}
