package com.smarteye.utils.common.dto.bluetooth;

import com.smarteye.utils.common.dto.BaseResponseData;
import com.smarteye.utils.common.dto.bluetooth.struct.BluetoothDevice;
import lombok.Data;

import java.util.List;

/**
 * 获取蓝牙信息回包
 */

@Data
public class GetBluetoothInfoRes extends BaseResponseData {
    private String status;      //本机蓝牙状态
    private String name;        //本机蓝牙名字
    private String scanMode;    //本机蓝牙扫描模式
    private List<BluetoothDevice> searchList; //扫描连表
    private List<BluetoothDevice> matchedList; //匹配连表
    //本机蓝牙状态
    public static transient String st_on = "ON";
    public static transient String st_off = "OFF";
    public static transient String st_turn_on = "TURNING_ON";
    public static transient String st_turn_off = "TURNING_OFF";
    public static transient String st_scanning = "SCANNING";
    public static transient String st_nodevice = "NO_DEVICE";
    public static transient String st_unknowwn = "UNKNOWN";
    //扫描模式
    public static transient String scan_connect_discover = "CONNECTABLE_DISCOVERABLE";
    public static transient String scan_connect = "CONNECTABLE";
    public static transient String scan_none = "NONE";
}
