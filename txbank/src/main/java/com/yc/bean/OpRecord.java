package com.yc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description: OPRecord
 * Author: heyv
 * Time: 2023 2023/8/3 9:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OpRecord {
    private  int id;
    private int accountid;
    private double opmoney;
    private String optime;
    private OpType opType;
    private Integer transferid;
}
