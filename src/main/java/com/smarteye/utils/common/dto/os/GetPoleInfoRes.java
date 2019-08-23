package com.smarteye.utils.common.dto.os;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 获取桩的一些基础信息回包
 */
@Data
public class GetPoleInfoRes extends BaseResponseData {
    private String deviceId;        //设备id
    private String deviceFactory;   //设备厂家
    private String deviceModel;     //设备型号
    //private String deviceNumber;    //设备
    private long romTotal;          //存储总容量 kb
    private long romRemaining;      //存储剩余容量 kb
    private long romUsed;           //存储使用容量 kb
    private int romUsedRate;        //存储使用率
    private long ramTotal;          //运存总容量 kb
    private long ramRemaining;      //运存剩余容量 kb
    private long ramUsed;           //运存使用容量 kb
    private int ramUsedRate;        //运存使用率
    private String androidVersion;  //安卓版本
    private String cpuType;         //cpu型号
    private int batteryRate;        //电池电量百分比
    private double batteryCounter;  //电池容量
    private String sim1;            //sim1使用状态
    private String sim1IMEI;        //SIM1 IMEI码
    private String sim1Number;      //sim1电话号码
    private String sim1Operator;    //网络运营商
    private String sim2;
    private String sim2IMEI;
    private String sim2Number;
    private String sim2Operator;

    public double kb2mb(long count) {
        return formatDouble(count / 1024.0,2);
    }

    public double kb2gb(long count) {
        return formatDouble(count / (1024*1024.0),2);
    }

    public static double formatDouble(double d,int scale) {
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(d).setScale(scale, RoundingMode.UP);
        return bg.doubleValue();
    }
}
