package com.smarteye.utils.common.dto.charge.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChargeInfo implements Serializable {
    private String carOrder;
    private String gunId;
    private Long endTime;
    private float energy;//电量
    //private long keepTime;
}
