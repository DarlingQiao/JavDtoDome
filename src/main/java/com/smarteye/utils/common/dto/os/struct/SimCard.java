package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimCard implements Serializable {
    private String sim1status;  //状态
    private String sim1number;  //电话号码
    private String sim1imei;    //imei码
    private String sim1operator;//网络运营商

    private String sim2status;  //状态
    private String sim2number;  //电话号码
    private String sim2imei;    //imei码
    private String sim2operator;//网络运营商
    //状态
    public static transient String st_on = "ON";        //正常
    public static transient String st_off = "OFF";      //禁用
    public static transient String st_miss = "MISS";    //丢失
    public static transient String st_unknown = "UNKNOWN";//未知
    public static transient String st_fly = "FLY";      //飞行模式
}
