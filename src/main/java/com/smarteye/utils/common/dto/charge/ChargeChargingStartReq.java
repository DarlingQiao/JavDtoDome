package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 充电开始事件  在充电枪开始工作时触发，通知平台
 */

@Data
public class ChargeChargingStartReq extends BaseDTO {
    private String carOrder;
    private boolean ok;//开始充电成功失败 true:成功  false:失败
    private Long startTime;//开始时间
    private String gunId;//充电枪id
}
