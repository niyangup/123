package com.niyang.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author niyangup
 * @since 2020-02-25 20:33
 */
@ApiModel(value = "Comment")
@Data
public class Comment implements Serializable {
  @ApiModelProperty(value = "null")
  private Integer id;

  @ApiModelProperty(value = "null")
  private Integer newsId;

  @ApiModelProperty(value = "null")
  private String content;

  @ApiModelProperty(value = "null")
  private Integer userId;

  @ApiModelProperty(value = "null")
  private String commitTime;

  @ApiModelProperty(value = "null")
  private String userName;
}
