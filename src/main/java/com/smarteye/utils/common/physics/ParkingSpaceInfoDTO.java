package com.smarteye.utils.common.physics;

import com.smarteye.utils.common.dto.CommonDaoDTO;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

@Data
public class ParkingSpaceInfoDTO extends CommonDaoDTO
{
    public ParkingSpaceInfoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    public ParkingSpaceInfoDTO(LinkedHashMap<String, Object> source)
    {
        super(source);
    }

    @Override
    public void convertDTO()
    {

    }

    // 泊位ID
    private Long id;

    // 场所ID
    private Long pliId;

    // 区块ID
    private Long pbiId;

    // 区块
    private ParkingBlockInfoDTO blockInfo;

    // 泊位编号
    private String spaceId;

    // 泊位名称
    private String spaceName;

    // 泊位长度
    private Integer spaceLong;

    // 泊位宽度
    private Integer spaceWidth;

    // 泊位朝向
    private Integer spaceOrientation;

    // 泊位照片
    private String spacePhoto;

    // 经度
    private Integer spaceLng;

    // 维度
    private Integer spaceLat;

    // 运营状况
    private Integer psOperatState;

    // 计费方式
    private Integer psChargesMode;

    // 计费ID
    private Integer psChargesId;

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
}
