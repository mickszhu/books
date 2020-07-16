package com.mickszhu.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Admin",description = "管理员信息")
public class Admin {

    @ApiModelProperty(value = "admin_id",example = "1000000")
    private long admin_id;
    @ApiModelProperty(value = "password",example = "123456")
    private String password;
    @ApiModelProperty(value = "username",example = "admin")
    private String username;
}
