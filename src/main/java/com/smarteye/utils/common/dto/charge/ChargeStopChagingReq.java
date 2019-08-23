package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 平台控制停止充电
 */

@Data
public class ChargeStopChagingReq extends BaseDTO {
    private String carOrder;
}
