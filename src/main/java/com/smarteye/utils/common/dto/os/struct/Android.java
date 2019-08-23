package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class Android implements Serializable {
    private String version;     //系统版本
    private String seriaNo;     //序列号
    private String fireware;    //固件版本
}
