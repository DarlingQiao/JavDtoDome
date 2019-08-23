package com.smarteye.utils.common.physics;

import com.smarteye.utils.common.dto.CommonDaoDTO;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 类实现描述：桩对像
 * yinjie 2018/11/20 17:22
 */
@Data
public class PoleInfoDTO extends CommonDaoDTO
{
    public PoleInfoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    public PoleInfoDTO(LinkedHashMap<String, Object> source)
    {
        super(source);
    }

    @Override
    public void convertDTO()
    {

    }

    // 桩体ID
    private Long id;

    // 桩体编号
    private String poleId;

    // 桩体名称
    private String poleName;

    // 供货ID
    private Integer supplyId;

    // 主机ID
    private Long poleHostId;

    // 主机
    private HostAssetsInfoDTO hostAssetsInfo;

    // 摄像头1ID
    private Integer camera1Id;

    // 摄像头2ID
    private Integer camera2Id;

    // 充电设备ID
    private Integer batterychangersId;

    // 道闸ID
    private Integer roadgateId;

    // 喇叭/咪头
    private Integer hornId;

    // 漏保
    private Integer earthLeakageProtectionId;

    // 空气开关
    private Integer airSwitchId;

    // 场所ID
    private Long pliId;

    // 区块ID
    private Long pbiId;

    // 泊位ID
    private Long psiId;

    // 泊位
    private ParkingSpaceInfoDTO parkingSpaceInfo;

    // 计费ID
    private Integer piChargesId;

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

    // ==========================================================================================


}
