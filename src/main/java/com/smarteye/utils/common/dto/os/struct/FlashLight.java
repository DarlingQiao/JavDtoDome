package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

/**
 * 闪光灯信息
 */

@Data
public class FlashLight implements Serializable {
    private String status;  //状态

    public static transient String st_on = "ON";
    public static transient String st_ff = "OFF";
    public static transient String st_unknown = "UNKNOWN";
}
