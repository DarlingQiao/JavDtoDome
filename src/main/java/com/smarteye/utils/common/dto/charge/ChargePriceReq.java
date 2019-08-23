package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 金额计算
 */

@Data
public class ChargePriceReq extends BaseDTO {
    private String carOrder;
    private float energy;//充电电量
}
