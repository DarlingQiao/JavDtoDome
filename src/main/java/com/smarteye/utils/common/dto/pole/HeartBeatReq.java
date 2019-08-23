package com.smarteye.utils.common.dto.pole;

import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.pole.struct.ParkCameraInfo;
import lombok.Data;

import java.util.List;

/**
 * 类实现描述：心跳请求
 * yinjie 2018/11/5 17:29
 */
@Data
public class HeartBeatReq extends BaseDTO
{
    private String deviceId; // 设备ID
    private String appVersion;//app版本
    private String androidVersion;//桩系统版本
    private String cameraAppVersion;//识别app版本
    private List<ParkCameraInfo> parkInfo;//泊位信息
}
