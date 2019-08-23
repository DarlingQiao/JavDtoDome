package com.smarteye.utils.common.dto.camera;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 类实现描述：发起支付
 * yinjie 2018/11/5 16:48
 */
@Data
public class CarPayReq extends BaseDTO
{
    private String carOrder; // 停车订单号
    private String payMode;//支付方式

    public static transient String pay_mode_wx = "wxpay";//微信支付
    public static transient String pay_mode_ali = "alipay";//支付宝支付
}
