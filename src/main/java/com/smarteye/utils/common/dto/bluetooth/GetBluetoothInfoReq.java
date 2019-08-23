package com.smarteye.utils.common.dto.bluetooth;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 获取蓝牙信息
 */
@Data
public class GetBluetoothInfoReq extends BaseDTO {
    private boolean searchList;     //是否获取扫描连表
    private boolean matchedList;    //是否获取已匹配过的连表
}
