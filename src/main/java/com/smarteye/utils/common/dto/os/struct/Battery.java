package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;
@Data
public class Battery implements Serializable {
    private double counter;         //电池总容量 mAh
    private String chargeStatus;    //充电状态    [CHARGING、DISCHARGING、FULL、NOT_CHARGING、UNKNOWN]
    private String healthStatus;    //电池健康状况[COLD、DEAD、GOOD、OVERHEAT、OVER_VOLTAGE、UNKNOWN、FAILURE]
    private boolean isCharging;     //是否充电中
    private int rate;               //当前电量百分比
    private String plugged;         //充电时的方式[AC、USB、WIRELESS、UNKNOWN]
    private float temperature;       //电池温度

    //充电状态
    public static transient String charge_charging = "CHARGING";        //充电中
    public static transient String charge_discharging = "DISCHARGING";  //断开充电中
    public static transient String charge_full = "FULL";                //充电中并且充满
    public static transient String charge_not_charging = "NOT_CHARGING";//未充电
    public static transient String charge_unknown = "UNKNOWN";          //未知
    //电池健康状况
    public static transient String health_cold = "COLD";            //低温
    public static transient String health_dead = "DEAD";            //毁坏
    public static transient String health_good = "GOOD";            //良好
    public static transient String health_overheat = "OVERHEAT";    //过热
    public static transient String health_over_vol = "OVER_VOLTAGE";//过压
    public static transient String health_unknown = "UNKNOWN";      //未知
    public static transient String health_failure = "FAILURE";      //获取失败
    //充电时的方式
    public static transient String plug_ac = "AC";                  //直流
    public static transient String plug_usb = "USB";                //获取失败
    public static transient String plug_wireless = "WIRELESS";      //获取失败
    public static transient String plug_unknown = "UNKNOWN";        //获取失败
}
