package com.smarteye.utils.common.dto.sys;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 类实现描述：服务器详情
 * yinjie 2018/11/5 16:48
 */
@Data
public class ServerDetailReq extends BaseDTO
{
    private String serverAlias; // 行政服务器标识
}
