package com.smarteye.utils.common.physics;

import com.smarteye.utils.common.dto.CommonDaoDTO;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

@Data
public class ParkingLotInfoDTO extends CommonDaoDTO
{
    public ParkingLotInfoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    public ParkingLotInfoDTO(LinkedHashMap<String, Object> source)
    {
        super(source);
    }

    @Override
    public void convertDTO()
    {

    }

    // 场所ID
    private Long id;

    // 场所编号
    private Integer parkingId;

    // 场所简称
    private String plShortName;

    // 场所全称
    private String plName;

    // 业主ID
    private Integer plOwnerId;

    // 场所类别(路测场所 封闭场所)
    private Integer plType;

    // 区域ID
    private Long areaId;

    // 区域信息
    private AreaInfoDTO areaInfoDTO;

    // 详细地址
    private String plAddress;

    // 平均经度
    private Integer lotLng;

    // 平均维度
    private Integer lotLat;

    // 区块总数
    private Integer blockNum;

    // 泊位总数
    private String plParkingNum;

    // 运营状况(在建 维修 停运 试运营 运营)
    private Date plOperatState;

    // 计费方式
    private Date plChargesMode;

    // 计费ID
    private Integer plChargesId;

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
