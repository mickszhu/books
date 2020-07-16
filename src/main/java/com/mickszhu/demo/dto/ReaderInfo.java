package com.mickszhu.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ReaderInfo",description = "借阅者信息")
public class ReaderInfo implements Serializable {
    @ApiModelProperty(value = "借书证Id",example = "10000")
    private long reader_id;
    @ApiModelProperty(value = "姓名",example = "张华")
    private String name;
    @ApiModelProperty(value = "性别",example = "女")
    private String sex;
    @ApiModelProperty(value = "出生日期",example = "1999-01-01")
    private Date birth;
    @ApiModelProperty(value = "地址",example = "深圳福田区大冲一号楼")
    private String address;
    @ApiModelProperty(value = "电话",example = "12123456")
    private String phone;
}
