package com.smarteye.utils.common.dto.pole;

import com.smarteye.utils.common.dto.BaseDTO;
import com.smarteye.utils.common.dto.pole.struct.ParkCameraInfo;
import lombok.Data;

import java.util.List;

/**
 * 类实现描述：开机上报配置请求
 * yinjie 2018/11/5 16:48
 */
@Data
public class OnlineConfReq extends BaseDTO
{
    private String               pltCode; // 智能桩在平台的编号
    private String               areaAlias; // 区域字符标识
    private String               areaType; // 区域类型 1 路侧泊位 2 停车场
    private String               inOut; // 进出口标识 I 进 O 出
    private String               costId; // 收费策略ID
    private List<ParkCameraInfo> parkList; // 泊位列表
}
