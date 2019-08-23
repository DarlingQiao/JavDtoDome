package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 平台下发开始充电
 */

@Data
public class ChargeStartChagingReq extends BaseDTO {
    private String carOrder;
}
