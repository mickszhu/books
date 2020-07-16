package com.mickszhu.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ReaderCard",description = "借书证信息")
public class ReaderCard implements Serializable {
    @ApiModelProperty(value = "借书证Id",example = "10000")
    private long reader_id;
    @ApiModelProperty(value = "借书人",example = "张华")
    private String username;
    @ApiModelProperty(value = "借书人密码",example = "123456")
    private String password;
}
