package com.smarteye.utils.common.dto.network;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 断开某个wifi连接
 */

@Data
public class DisconnectWifiReq extends BaseDTO {
    private String ssid;        //断开wifi的名字
    private boolean oneself;    //是否断开当前连接的wifi
}
