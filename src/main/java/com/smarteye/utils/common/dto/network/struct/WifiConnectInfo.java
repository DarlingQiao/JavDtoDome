package com.smarteye.utils.common.dto.network.struct;

import lombok.Data;

import java.io.Serializable;

/**
 * 当前连接的wifi的信息
 */
@Data
public class WifiConnectInfo implements Serializable {
    private String ssid;        //wifi名字
    private String ip;          //ip
    private String bssid;       //设备唯一标识
    private int signal;         //wifi信号（0 --> 4,低 --> 高）
    private int networkId;      //在配置信息里的网络号
    private String macAddress;  //wifi的路由器mac地址
    private boolean hidden;     //是否是隐藏的wifi
    private int speed;          //连接的书读Mbps
    private String netmask;     //子网掩码
    private String gateway;     //网关
    private String serverAddress;   //路由器地址
    private String dns1;        //dns1
    private String dns2;        //dns2
}
