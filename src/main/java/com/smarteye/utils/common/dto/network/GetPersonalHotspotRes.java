package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

@Data
public class GetPersonalHotspotRes extends BaseResponseData {
    private String status;      //热点状态
    private String ssid;        //热点名字
    private String password;    //热点密码
    private String security;    //热点加密方式

    //热点加密方式
    public static transient String security_ess = "ESS";//无密码
    public static transient String security_wpa = "WPA";
    public static transient String security_wpa2 = "WPA2";
    public static transient String security_invalid = "INVALID";//无效的
}
