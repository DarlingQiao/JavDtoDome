package com.smarteye.utils.common.physics;

import com.smarteye.utils.common.dto.CommonDaoDTO;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;

/**
 * 类实现描述：行政区域信息
 * yinjie 2018/11/26 9:33
 */
@Data
public class AreaInfoDTO extends CommonDaoDTO
{
    public AreaInfoDTO()
    {
        // 为了可以使用 @Data 注解而加
    }

    public AreaInfoDTO(LinkedHashMap<String, Object> source)
    {
        super(source);
    }

    @Override
    public void convertDTO()
    {

    }

    // 唯一标识
    private Long id;

    // 区域ID
    private Long aId;

    // 省份
    private String aProvince;

    // 市地
    private String aCity;

    // 县区
    private String aTown;

    // 街道
    private String aStreet;

    // 邮编
    private String aPostcode;

    // 电话区号
    private String aTel;

    // 身份证前6位
    private String aIdPreSix;

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
