package com.smarteye.utils.common.dto.charge;


import com.smarteye.utils.common.dto.charge.struct.ChargeInfo;
import lombok.Data;

/**
 * 停止充电事件 在时长或费用用完时触发，通知平台，并结束计费
 */

@Data
public class ChargeChargingStopReq extends ChargeInfo {
    private String pltCode;
}
