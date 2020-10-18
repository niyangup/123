package com.niyang.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author niyangup
 * @since 2020-02-25 20:18
 */
@ApiModel(value = "Version")
@Data
public class Version implements Serializable {
  @ApiModelProperty(value = "null")
  private Integer id;

  @ApiModelProperty(value = "null")
  private String apkNum;

  @ApiModelProperty(value = "null")
  private String apkDesc;

  @ApiModelProperty(value = "null")
  private String apkUrl;

}
