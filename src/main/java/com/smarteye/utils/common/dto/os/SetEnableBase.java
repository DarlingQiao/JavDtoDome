package com.smarteye.utils.common.dto.os;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 设置使能基类
 */
@Data
public class SetEnableBase extends BaseDTO {
    private boolean enable;      //使能(true - 开,false - 关)
}
