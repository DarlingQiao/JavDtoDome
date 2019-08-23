package com.smarteye.utils.common.dto.os.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class Gpu implements Serializable {
    private String vendor;//发行商
    private String renderer;//渲染器
    private String version;//版本
}
