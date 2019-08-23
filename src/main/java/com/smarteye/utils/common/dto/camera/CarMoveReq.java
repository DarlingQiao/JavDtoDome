package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 车辆驶入事件
 *
 */

@Data
public class CarMoveReq extends BaseDTO {
    private String parkCode;    // 泊位编号
    private String carId;       // 车牌号
    private Long startTime;     // 驶入时间
}
