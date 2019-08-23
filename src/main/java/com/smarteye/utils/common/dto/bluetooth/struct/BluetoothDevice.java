package com.smarteye.utils.common.dto.bluetooth.struct;

import lombok.Data;

import java.io.Serializable;

/**
 * 蓝牙设备信息
 */
@Data
public class BluetoothDevice implements Serializable {
    private String name;        //蓝牙名字
    private String mac;         //蓝牙地址
    private String type;        //蓝牙类型

    //蓝牙类型
    public static transient String type_classic = "CLASSIC";    //传统蓝牙
    public static transient String type_dual = "DUAL";          //双向蓝牙
    public static transient String type_le = "LE";              //低功耗蓝牙
    public static transient String type_unknown = "UNKNOWN";    //未知
}
