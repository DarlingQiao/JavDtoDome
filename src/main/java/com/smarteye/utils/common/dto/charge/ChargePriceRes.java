package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 金额计算
 */
@Data
public class ChargePriceRes extends BaseResponseData {
    private long used;//已用金额
    private long pre;//预付金额
}
