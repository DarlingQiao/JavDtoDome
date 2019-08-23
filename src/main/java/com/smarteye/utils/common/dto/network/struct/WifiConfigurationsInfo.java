package com.smarteye.utils.common.dto.network.struct;

import lombok.Data;

import java.io.Serializable;

@Data
public class WifiConfigurationsInfo implements Serializable {
    private String ssid;
    private String status;
    private boolean hidden;
    private int networkId;
}
