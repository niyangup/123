package com.niyang.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@ApiModel(value = "Collection")
@Data
public class Collection implements Serializable {
  @ApiModelProperty(value = "null")
  private Integer id;

  @ApiModelProperty(value = "null")
  private Integer userId;

  @ApiModelProperty(value = "null")
  private Integer newsId;

}
