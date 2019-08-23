package com.smarteye.utils.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 类实现描述：基类
 * yinjie 2018/11/2 10:42
 */
@Data
public class BaseDTO implements Serializable
{
    private String pltCode; // 智能桩在平台的编号
}
