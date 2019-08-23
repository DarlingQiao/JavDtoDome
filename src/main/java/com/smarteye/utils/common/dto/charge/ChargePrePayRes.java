package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 充电预付回包
 */

@Data
public class ChargePrePayRes extends BaseResponseData {
    private long totalPrice; // 累计需要缴费金额（分）
    private String priceImgUrl; // 需要支付的二维码图片地址
    private long payExpiryDate;//二维码有效时间(秒)
    private String carOrder; // 停车订单号
    private long price; // 单价(分)
    private long time;  //可冲电的最大时间（秒）
}
