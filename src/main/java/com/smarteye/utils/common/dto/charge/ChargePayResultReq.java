package com.smarteye.utils.common.dto.charge;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 预支付的结果
 */

@Data
public class ChargePayResultReq extends BaseDTO {
    private String carOrder; // 停车订单号
    private String payResult;//支付结果
    private String voiceCode;//语音编号
    private String payMsg;//(成功，支付失败、余额不足用于ui显示)

    public static transient String pay_succ = "1";//支付完成
    public static transient String pay_not = "2";//支付失败
}
