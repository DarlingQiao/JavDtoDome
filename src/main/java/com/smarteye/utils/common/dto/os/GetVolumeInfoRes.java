package com.smarteye.utils.common.dto.os;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;


/**
 * 获取音量回包
 */
@Data
public class GetVolumeInfoRes extends BaseResponseData {
    private int alarmVolume;        //闹铃音量 0 - 100
    private int musicVolume;        //多媒体音量 0 - 100
    private int phoneRingVolume;    //手机铃声音量 0 - 100
    private int callVolume;         //通话音量 0 - 100
}
