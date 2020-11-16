package com.example.recyclerviewtest;

/**
 * @author chenbin
 * @date 2020/11/14
 */
public interface OnHideClickListener {
    /**
     * 隐藏展开按钮的点击事件
     *
     * @param type
     * @param hide
     */
    default void onHideClick(int type, boolean hide) {
        // ...
    }
}
