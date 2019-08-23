package com.smarteye.utils.common.dto.bluetooth;

import com.smarteye.utils.common.dto.os.SetEnableBase;
import lombok.Data;

/**
 * 设置蓝牙使能
 */

@Data
public class SetBluetoothEnableReq extends SetEnableBase {
    private boolean isPublic;       //打开蓝牙是是否开放检查
}
