package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.os.SetEnableBase;
import lombok.Data;

/**
 * 设置个人热点
 */

@Data
public class SetPersonalHotspotEnableReq extends SetEnableBase {
    private String ssid;        //热点名字
    private String password;    //热点密码不小于8位
    private String security;    //热点加密方式（看类PersonalHotspot）
}
