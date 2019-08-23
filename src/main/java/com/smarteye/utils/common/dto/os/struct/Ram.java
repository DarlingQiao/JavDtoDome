package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

/**
 * 运存信息
 */


@Data
public class Ram implements Serializable {
    private long total;     //总容量 kb
    private long remianing; //剩余容量
    private long used;      //使用容量
    private int usedRate;   //使用率
}
