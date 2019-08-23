package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class Gps implements Serializable {
    private String status;//状态
    private Double y;//经度
    private Double x;//纬度
    private Double z;//海拔
    private String address;//位置（xx省xx街道...）
    //状态
    public static transient String st_on = "ON";//开
    public static transient String st_off = "OFF";//关
    public static transient String st_unknown = "UNKNOWN";//未知
}
