package com.smarteye.utils.common.dto.pole;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 类实现描述：开机上报响应
 * yinjie 2018/11/5 16:53
 */

@Data
public class OnlineRes extends BaseResponseData
{
    private long heartbeatTime;//心跳时间间隔 毫秒
}
