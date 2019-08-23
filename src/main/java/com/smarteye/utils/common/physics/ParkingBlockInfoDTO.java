package com.smarteye.utils.common.physics;

import com.smarteye.utils.common.dto.CommonDaoDTO;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

@Data
public class ParkingBlockInfoDTO extends CommonDaoDTO
{
    public ParkingBlockInfoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    public ParkingBlockInfoDTO(LinkedHashMap<String, Object> source)
    {
        super(source);
    }

    @Override
    public void convertDTO()
    {

    }

    // 区块ID
    private Long id;

    // 场所ID
    private Long pliId;

    // 场所
    private ParkingLotInfoDTO lotInfo;

    // 区块编号
    private String blockId;

    // 区块名称
    private String blockName;

    // 详细地址
    private Integer blockAddress;

    // 平均经度
    private Integer blockLng;

    // 平均维度
    private String blockLat;

    // 泊位总数
    private String pbParkingNum;

    // 运营状况
    private Integer pbOperatState;

    // 计费方式
    private Integer pbChargesMode;

    // 计费ID
    private Integer pbChargesId;

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
