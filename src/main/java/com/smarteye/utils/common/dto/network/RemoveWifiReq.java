package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

import java.util.List;

/**
 * 移除wfif
 */

@Data
public class RemoveWifiReq extends BaseDTO {
    private List<String> ssidList;  //wifi名字连表
    private boolean all;            //是否移除全部
}
