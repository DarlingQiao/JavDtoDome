package com.smarteye.utils.common.dto.sys;

import lombok.Data;

/**
 * 类实现描述：服务器详情
 * yinjie 2018/11/5 16:53
 */
@Data
public class ServerDetailRes extends ServerInfoRes
{
    private String mqttUrl; // mqtt服务器访问路径
    private String webApiUrl; // 网关服务器访问路径
}
