package com.smarteye.utils.common.dto.network.struct;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * wifi信息
 */

@Data
public class WifiInfo implements Serializable {
    private String status;              //wifi状态
    private WifiConnectInfo connect;    //连接的wifi的信息
    //private List<WifiScanInfo> scanList;//扫描的wifi信息连表
    //private List<WifiConfigurationsInfo> configurationsList;//连接过的wifi的配置信息
    //wifi状态
    public static transient String st_disabling = "DISABLING";
    public static transient String st_disabled = "DISABLED";
    public static transient String st_enabling = "ENABLING";
    public static transient String st_enabled = "ENABLED";
    public static transient String st_connected = "CONNECTED";
    public static transient String st_unknown = "UNKNOWN";
}
