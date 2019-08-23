package com.smarteye.utils.common.dto.os;

import com.smarteye.utils.common.dto.BaseResponseData;
import com.smarteye.utils.common.dto.os.struct.*;
import lombok.Data;

@Data
public class GetPoleHardwareInfoRes extends BaseResponseData {
    private Android android;        //安卓版本信息
    private Cpu cpu;                //cpu信息
    private Gpu gpu;                //gpu信息
    private Battery battery;        //电池信息
    private Rom rom;                //存储信息
    private Ram ram;                //运存信息
    private SimCard simCard;        //sim卡信息
    private FlashLight flashLight;  //闪光灯信息
    private Gps gps;                //gps信息
}
