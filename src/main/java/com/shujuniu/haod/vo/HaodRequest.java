package com.shujuniu.haod.vo;

import com.shujuniu.common.rest.BasePageListRequest;
import lombok.Data;

@Data
public class HaodRequest extends BasePageListRequest {
    private Integer id;

    private String mobile;

    private String status;

}
