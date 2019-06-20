package com.hug.common.constant.enums.result;

/**
 * 显示方式
 *
 * @author: huangwh
 * @mail huangwh@txtws.com
 * @date: 2019-06-20 11:34
 */
public enum DisplayEnum {
    NONE(0),
    DISPLAY(1),
    ;

    private int value;

    DisplayEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
