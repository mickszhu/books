package com.mickszhu.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "Book",description = "Books类型")
public class Book implements Serializable {

    @ApiModelProperty(value = "BookId",example = "")
    private long book_id;
    @ApiModelProperty(value = "书名",example = "深圳书城")
    private String name;
    @ApiModelProperty(value = "作者",example = "小劳")
    private String author;
    @ApiModelProperty(value = "出版社",example = "深圳文艺出版社")
    private String publish;
    @ApiModelProperty(value = "ISBN",example = "97870201252659787020125260")
    private String ISBN;
    @ApiModelProperty(value = "简介",example = "一个读书的地方")
    private String introduction;
    @ApiModelProperty(value = "语言",example = "中文")
    private String language;
    @ApiModelProperty(value = "售价",example = "39.9")
    private BigDecimal price;
    @ApiModelProperty(value = "出版日期",example = "2020-07-15")
    private Date pub_date;
    @ApiModelProperty(value = "类别Id",example = "9")
    private int class_id;
    @ApiModelProperty(value = "库存量",example = "10")
    private int number;
}
