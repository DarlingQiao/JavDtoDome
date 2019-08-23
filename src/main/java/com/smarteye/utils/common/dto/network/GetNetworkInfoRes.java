package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;


/**
 * 获取网络信息回包
 */
@Data
public class GetNetworkInfoRes extends BaseResponseData {
    public String status;       //网络状态
    public String type;         //网络类型
    public String name;         //连接的名字
    //private WifiInfo wifi;      //wifi信息
    //private PersonalHotspot personalHotspot;  //热点信息
    //网络状态
    public static transient String st_connected = "CONNECTED";
    public static transient String st_disconnected = "DISCONNECTED";
    public static transient String st_unknown = "UNKNOWN";
    //网络类型
    public static transient String type_wifi = "WIFI";
    public static transient String type_mobile = "MOBILE_NETWORK";
    public static transient String type_unknown = "UNKNOWN";
}
