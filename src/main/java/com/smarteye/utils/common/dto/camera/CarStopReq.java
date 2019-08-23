package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 类实现描述：汽车停稳
 * yinjie 2018/11/5 16:48
 */
@Data
public class CarStopReq extends BaseDTO
{
    private String parkCode; // 泊位编号
    private String carId; // 车牌号
    private String carIdImg; // 车牌号图片
    private Long startTime; //停稳时间
}
