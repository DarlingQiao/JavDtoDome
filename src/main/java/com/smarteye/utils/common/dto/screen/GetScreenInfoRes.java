package com.smarteye.utils.common.dto.screen;

import com.smarteye.utils.common.dto.BaseResponseData;
import lombok.Data;

/**
 * 获取屏幕信息回包
 */
@Data
public class GetScreenInfoRes extends BaseResponseData {
    private double size;        //屏幕大小英寸
    private int horizontal;     //水平像素点
    private int vertical;       //垂直像素点
    private int dpi;            //像素点密度
    private boolean isAutoBrightness;   //亮度是否是自动调节模式
    private int brightness;             //屏幕亮度百分比
    private int orientation;            //屏幕方向
    private long lockScreenTime;        //息屏时间秒
    //屏幕方向
    public static transient int orientation_x = 1;
    public static transient int orientation_y = 2;
    public static transient int orientation_auto = 3;
}
