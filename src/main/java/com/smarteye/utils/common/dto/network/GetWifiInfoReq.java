package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 获取wifi信息回包
 */

@Data
public class GetWifiInfoReq extends BaseDTO {
    private boolean connect;
    private boolean scanList;
    private boolean configurationsList;
}
