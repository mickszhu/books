package com.mickszhu.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Lend",description = "借书记录信息")
public class Lend implements Serializable {
    @ApiModelProperty(value = "借阅数量",example = "1")
    private long ser_num;
    @ApiModelProperty(value = "借阅图书Id",example = "2")
    private long book_id;
    @ApiModelProperty(value = "借书证Id",example = "10000")
    private long reader_id;
    @ApiModelProperty(value = "借出日期",example = "2020-07-13")
    private Date lend_date;
    @ApiModelProperty(value = "归还日期",example = "2020-07-18")
    private Date back_date;
}
