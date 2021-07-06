package com.antzuhl.sharks.constant;

/**
 * @author AntzUhl
 * @date 2021/7/6 1:56 下午
 * @description 文章状态
 **/
public enum PostStatus {

    /**
     * Published status.
     */
    PUBLISHED(0),

    /**
     * Draft status.
     */
    DRAFT(1),

    /**
     * Recycle status.
     */
    RECYCLE(2),

    /**
     * Intimate status
     */
    INTIMATE(3);

    private final int value;

    PostStatus(int v) {
        this.value = v;
    }

}
