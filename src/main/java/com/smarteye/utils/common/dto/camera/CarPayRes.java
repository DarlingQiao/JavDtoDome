package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 类实现描述：支付响应
 * yinjie 2018/11/5 16:48
 */
@Data
public class CarPayRes extends BaseResponseData
{
    private String totalPrice; // 累计需要缴费金额
    private String priceImgUrl; // 需要支付的二维码图片地址
    private Long payExpiryDate;//二维码有效时间(秒)
    // 冗余设计-------为优化用户体验做准备
    private String carOrder; // 停车订单号
    private Long startTime; // 计费开始时间
    private Long keepTime; // 累计时长
    private Double price; // 单价
}
