package com.smarteye.utils.common.dto.fm;

import com.smarteye.utils.common.dto.BaseResponseData;
import com.smarteye.utils.common.dto.fm.struct.FmSearchInfo;
import lombok.Data;

import java.util.List;


@Data
public class GetFmIfoRes extends BaseResponseData {
    private String status;//状态
    private String channel;//当前连接频率 MHz
    List<FmSearchInfo> searchInfoList;//搜索的连表

    public static transient String st_on = "ON";
    public static transient String st_off = "OFF";
}
