package com.niyang.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author niyangup
 * @since 2020-02-25 20:28
 */
@ApiModel(value = "User")
@Data
public class User implements Serializable {
  @ApiModelProperty(value = "1")
  private Integer id;

  @ApiModelProperty(value = "张三")
  private String userName;

  @ApiModelProperty(value = "123")
  private String userPwd;

  @ApiModelProperty(value = "10086")
  private String userPhone;

  @ApiModelProperty(value = "10086")
  private String userType;
}
