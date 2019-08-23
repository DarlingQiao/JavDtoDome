package com.smarteye.utils.common.dto.os;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 获取桩的硬件具体信息
 */

@Data
public class GetPoleHardwareInfoReq extends BaseDTO {
    private boolean all;        //是否获取全部
    private boolean android;    //是否获取安卓版本信息
    private boolean cpu;        //是否获取cpu信息
    private boolean gpu;        //是否获取gpu信息
    private boolean battery;    //是否获取电池信息
    private boolean rom;        //是否获取存储信息
    private boolean ram;        //是否获取运存信息
    private boolean simCard;    //是否获取sim卡信息
    private boolean flashLight; //是否获取闪光灯信息
    private boolean gps;        //是否获取gps信息
}
