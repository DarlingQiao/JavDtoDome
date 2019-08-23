package com.smarteye.utils.common.dto.camera;


import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 类实现描述：汽车离开回包
 *
 */

@Data
public class CarLeaveRes extends BaseResponseData {
    private String voiceCode;//语音编号
    private String carOrder; // 停车订单号
}
