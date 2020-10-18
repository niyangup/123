package com.niyang.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@ApiModel(value = "News")
@Data
public class News implements Serializable {
  @ApiModelProperty(value = "null")
  private Integer id;

  @ApiModelProperty(value = "null")
  private String newsPic;

  @ApiModelProperty(value = "null")
  private String newsTitle;

  @ApiModelProperty(value = "null")
  private String newsDesc;

  @ApiModelProperty(value = "null")
  private String newsContent;

  @ApiModelProperty(value = "null")
  private String newsCategory;

  @ApiModelProperty(value = "null")
  private Integer cateId;

  @ApiModelProperty(value = "null")
  private String newsShareUrl;
}
