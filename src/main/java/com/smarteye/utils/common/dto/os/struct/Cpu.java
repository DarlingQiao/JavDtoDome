package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class Cpu implements Serializable {
    private String coresNum;    //核数
    private String several;     //系统位数
    private String abi;         //指令集
    private int rate;           //百分比0-100
    private long maxFreq;        //最大频率 kHz
    private long minFreq;        //最小频率
    private String type;        //型号
    private String processor;   //架构
}
