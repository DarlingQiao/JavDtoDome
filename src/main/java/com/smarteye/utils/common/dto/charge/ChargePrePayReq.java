package com.smarteye.utils.common.dto.charge;


import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;


/**
 * 充电预付款
 */

@Data
public class ChargePrePayReq extends BaseDTO {
    private String carOrder;//停车的订单号（车停稳后后台返回）
    private String payMode;//支付方式
    private String chargeFeeMode;//选择的充电计算方式
    private long value;//选择的充电计算方式对应的数值（电量（度）、时间（秒）、金额（分））
    //支付方式
    public static transient String pay_mode_wx = "wxpay";//微信支付
    public static transient String pay_mode_ali = "alipay";//支付宝支付
    //选择的充电收费计算方式
    public static transient String charge_fee_mode_energy = "energy";//按电量
    public static transient String charge_fee_mode_time = "time";//按时间
    public static transient String charge_fee_mode_amount = "amount";//按金额
}
