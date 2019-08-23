package com.smarteye.utils.common.dto.fm;

import com.smarteye.utils.common.dto.os.SetEnableBase;
import lombok.Data;

/**
 * 设置fm使能
 */

@Data
public class SetFmEnableReq extends SetEnableBase {
    private String channel;//连接频率 MHz
}
