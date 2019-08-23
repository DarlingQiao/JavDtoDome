package com.smarteye.utils.common.dto;

import lombok.Data;

/**
 * 类实现描述：响应消息结构
 * yinjie 2018/11/5 16:11
 */
@Data
public class BaseResponseData extends BaseDTO
{
    private int code;
    private String errMsg;
}
