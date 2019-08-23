package com.smarteye.utils.common.dto.bluetooth;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 设置蓝牙信息
 */

@Data
public class SetBluetoothInfoReq extends BaseDTO {
    private String name;        //设置本机蓝牙名字
}
