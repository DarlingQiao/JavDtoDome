package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 类实现描述：汽车离开
 * yinjie 2018/11/5 16:48
 */
@Data
public class CarLeaveReq extends BaseDTO
{
    private String carOrder;    // 停车订单号
    private String parkCode;    //泊位号
    private String carIdImg;    //车辆图片，base64加密数据
    private Long timeLeave;     //驶离时间
}
