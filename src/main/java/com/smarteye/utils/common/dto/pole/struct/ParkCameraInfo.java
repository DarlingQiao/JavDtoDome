package com.smarteye.utils.common.dto.pole.struct;

import lombok.Data;

import java.io.Serializable;


/**
 * 车辆与泊位号绑定信息
 */
@Data
public class ParkCameraInfo implements Serializable {
    private String parkCode; // 泊位编号
    private String carId; // 车牌号
    private int parkPosition; // 方位

    private int state;

    public transient static final int POSITION_LEFT = 1; // 方位 左
    public transient static final int POSITION_RIGHT = 2; // 方位 右

    public transient static final int STATE_ON = 1;//有车在
    public transient static final int STATE_FREE = 2;//空闲状态
    //public transient static final int STATE_BAN = 3;//禁止使用的
    //public transient static final int STATE_UNKNOWN = 4;//坏的  无效的
}
