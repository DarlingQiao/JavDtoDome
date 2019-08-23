package com.smarteye.utils.common.dto.sys;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 类实现描述：服务器列表
 * yinjie 2018/11/5 16:53
 */
@Data
public class ServerInfoRes extends BaseResponseData
{
    private String parentAlias; // 上级标识
    private String serverAlias; // 自身标识
    private String ServerName; // 名称
    private String ServerUrl; // 访问地址
}
