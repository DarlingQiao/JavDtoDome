package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.charge.struct.ChargeInfo;
import lombok.Data;

/**
 * 平台控制停止充电回包
 */

@Data
public class ChargeStopChagingRes extends ChargeInfo {
    private int code;
    private String errMsg;
    private String pltCode;
}
