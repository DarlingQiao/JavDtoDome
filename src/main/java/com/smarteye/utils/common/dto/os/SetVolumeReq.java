package com.smarteye.utils.common.dto.os;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 设置音量
 */
@Data
public class SetVolumeReq extends BaseDTO {
    private int alarmVolume;        //闹铃音量 0 - 100
    private int musicVolume;        //多媒体音量 0 - 100
    private int phoneRingVolume;    //手机铃声音量 0 - 100
    private int callVolume;         //通话音量 0 - 100
}
