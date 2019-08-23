package com.smarteye.utils.common.dto.pole;

import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.pole.struct.ParkCameraInfo;
import lombok.Data;

import java.util.List;

/**
 * 类实现描述：开机上报
 * yinjie 2018/11/5 16:48
 */
@Data
public class OnlineReq extends BaseDTO
{
    private String deviceId; // 设备ID
    private String deviceFactory; // 设备厂家
    private String deviceModel; // 设备型号

    private Double gpsY; // 经度
    private Double gpsX; // 纬度

    private String appVersion;//app版本
    private String androidVersion;//桩系统版本
    private String cameraAppVersion;//识别app版本
    private List<ParkCameraInfo> parkInfo;//泊位信息
}
