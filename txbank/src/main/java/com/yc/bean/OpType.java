package com.yc.bean;

/**
 * Description: OpType
 * Author: heyv
 * Time: 2023 2023/8/3 9:26
 */
public enum OpType {
    WITHDRAM("withdrow", 1), DESPOSITE("describe",2), TRANSFER("transfer",3);

    private String key;
    private int value;

    OpType(String key, int value) {
        this.key=key;
        this.value=value;
    }

    public String getKey(){
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
