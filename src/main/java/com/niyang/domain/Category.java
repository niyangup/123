package com.niyang.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 分类实体.
 *
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@ApiModel(value = "Category")
@Data
public class Category implements Serializable {
  @ApiModelProperty(value = "id", name = "id", example = "1")
  private Integer id;

  @ApiModelProperty(value = "分类名称", name = "cateName", example = "头条")
  private String cateName;
}
