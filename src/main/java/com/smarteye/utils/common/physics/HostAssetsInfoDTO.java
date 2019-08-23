package com.smarteye.utils.common.physics;

import com.smarteye.utils.common.dto.CommonDaoDTO;
import com.smarteye.utils.common.dto.pole.struct.ParkCameraInfo;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 类实现描述：主机对像
 * yinjie 2018/11/20 17:24
 */
@Data
public class HostAssetsInfoDTO extends CommonDaoDTO
{
    public HostAssetsInfoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    public HostAssetsInfoDTO(LinkedHashMap<String, Object> source)
    {
        super(source);
    }

    @Override
    public void convertDTO()
    {

    }

    // 唯一标识,主机ID
    private Long id;

    // 主机编号
    private String hHostNumber;

    // 主机名称
    private String hHostName;

    // 供货ID
    private Long hSupplyId;

    // IEMI
    private String hIemi;

    // MAC
    private String hMac;

    // SAM1
    private String hSam1;

    // SAM2
    private String hSam2;

    // 在线名称
    private String hOnName;

    // 宿主ID
    private Long hOnOwnerId;

    // 宿主 (桩)
    private PoleInfoDTO poleInfo;

    // 设备状况
    // 1 在线(运行) 2 离线 ----------------- 停机、断电、维护、升级、宕机、告警、
    private String hOnDeviceStatus;

    // 设备最后心跳时间
    private transient long hOnDeviceStatusLastUpdateTime;

    // WIFI_ID 场所wifi内网热点名称
    private String hOnWifiId;

    // IP地址
    private String hOnIp;

    // 端口号
    private Long hOnPort;

    // 数据状态
    private String dataState;

    // 提交姓名
    private String commitName;

    // 提交备注
    private String commitMark;

    // 提交日期
    private Date commitDate;

    // 审核人姓名
    private String verifyName;

    // 审核人备注
    private String verifyMark;

    // 审核日期
    private Date verifyDate;

    // 审批人姓名
    private String approvalName;

    // 审批人备注
    private String approvalMark;

    // 审批日期
    private Date approvalDate;

    // 开始生效日期
    private Date startDate;

    // 中止日期
    private Date endDate;

    // 管理状态
    private String manageState;

    // 许可凭证
    private String dataLicense;

    // 创建人
    private String creater;

    // 创建时间
    private Date createDate;

    // 修改人
    private String modifyer;

    // 修改时间
    private Date modifyDate;

    // 是否删除 1 已删除 0 未删除
    private Integer isDelete;

    // 备注
    private String mark;

    // ==========================================================================================================

    private String deviceId; // 设备ID
    private String deviceFactory; // 设备厂家
    private String deviceModel; // 设备型号

    private String gpsY; // 经度
    private String gpsX; // 纬度

    private String               appVersion;//app版本
    private String               androidVersion;//桩系统版本
    private String               cameraAppVersion;//识别app版本
    private List<ParkCameraInfo> parkInfo;//泊位信息
}
