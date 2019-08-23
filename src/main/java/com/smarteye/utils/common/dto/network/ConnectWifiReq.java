package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 *连接某个wifi
 */

@Data
public class ConnectWifiReq extends BaseDTO {
    private String ssid;        //wifi名字
    private String password;    //wifi密码大于8
    private String security;    //安全加密方式

    //加密方式
    public static transient String security_ess = "ESS";
    public static transient String security_wpa = "WPA";
    public static transient String security_wpa2 = "WPA2";
    public static transient String security_wep = "WEP";
}
