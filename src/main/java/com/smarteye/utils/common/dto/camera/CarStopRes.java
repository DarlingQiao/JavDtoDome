package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 类实现描述：汽车停稳响应
 * yinjie 2018/11/5 16:48
 */
@Data
public class CarStopRes extends BaseResponseData
{
    private String carOrder; // 停车订单号
    private String voiceCode;//语音编号

    // ----------------- 冗余设计, 为将来生成订单为异步操作时做准备
    private String parkCode; // 泊位编号
    private String carId; // 车牌号
    private Long startTime; // 计费开始时间

}
