package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;


/**
 * 平台下发开始充电回包
 */
@Data
public class ChargeStartChagingRes extends BaseResponseData {
    private String carOrder;
    private boolean ok;//开始充电成功失败 true:成功  false:失败
    private Long startTime;//开始时间
    private String gunId;//充电枪id
}
