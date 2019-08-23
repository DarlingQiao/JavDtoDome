package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.network.struct.WifiConfigurationsInfo;
import com.smarteye.utils.common.dto.network.struct.WifiConnectInfo;
import com.smarteye.utils.common.dto.network.struct.WifiScanInfo;
import lombok.Data;

import java.util.List;

/**
 * 获取wifi信息回包
 */

@Data
public class GetWifiInfoRes extends BaseDTO {
    private String status;              //wifi状态
    private WifiConnectInfo connect;    //连接的wifi的信息
    private List<WifiScanInfo> scanList;//扫描的wifi信息连表
    private List<WifiConfigurationsInfo> configurationsList;//连接过的wifi的配置信息
    //wifi状态
    public static transient String st_disabling = "DISABLING";
    public static transient String st_disabled = "DISABLED";
    public static transient String st_enabling = "ENABLING";
    public static transient String st_enabled = "ENABLED";
    public static transient String st_connected = "CONNECTED";
    public static transient String st_unknown = "UNKNOWN";
}
