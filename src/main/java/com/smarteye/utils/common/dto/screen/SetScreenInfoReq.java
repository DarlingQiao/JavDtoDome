package com.smarteye.utils.common.dto.screen;

import com.smarteye.utils.common.dto.BaseDTO;
import lombok.Data;

/**
 * 设置屏幕信息
 */
@Data
public class SetScreenInfoReq extends BaseDTO {
    private boolean isAutoBrightness;   //亮度是否是自动调节模式
    private int brightness;             //屏幕亮度百分比
    private int orientation;            //屏幕方向
    private long lockScreenTime;        //息屏时间秒
    //屏幕方向
    public static transient int orientation_x = 1;
    public static transient int orientation_y = 2;
    public static transient int orientation_auto = 3;
}
