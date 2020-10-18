package com.niyang.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * @author niyangup
 * @since 2020-02-27 12:17
 */
@Data
public class LogInDto implements Serializable {
  private String username;
}
