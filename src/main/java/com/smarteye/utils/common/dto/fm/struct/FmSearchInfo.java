package com.smarteye.utils.common.dto.fm.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class FmSearchInfo implements Serializable {
    private String name;//名字
    private String channel;//频率 MHz
}
