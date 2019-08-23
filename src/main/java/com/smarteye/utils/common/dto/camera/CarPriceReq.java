package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 类实现描述：汽车需要缴费信息
 * yinjie 2018/11/5 16:48
 */
@Data
public class CarPriceReq extends BaseDTO
{
    private String carOrder; // 停车订单号
    private Double totalPrice; // 累计需要缴费金额

    // ----冗余设计, 为桩不够智能时准备
    private String parkCode; // 泊位编号
    private String carId; // 车牌号
    //private Long startTime; // 计费开始时间
}
