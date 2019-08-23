package com.smarteye.utils.common.dto.network.struct;

import lombok.Data;

import java.io.Serializable;

/**
 * 扫描的WiFi的连表
 */
@Data
public class WifiScanInfo implements Serializable {
    private String ssid;        //wifi名字
    private String bssid;       //wifi的唯一标识
    private int signal;         //wifi信号（0 --> 4,低 --> 高）
    private String capabilities;//支持的加密方式
    private String channelWidth;//通道宽度
    private int frequency;      //频率
}
