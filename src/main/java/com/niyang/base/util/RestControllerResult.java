package com.niyang.base.util;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 返回结果封装Dto.
 *
 * @author niyangup
 * @since 2020-02-22 15:43
 */
public class RestControllerResult<T> implements Serializable {
  private Boolean success;
  private Integer code;
  private List<String> infoMsgs = new LinkedList();
  private List<String> warningMsgs = new LinkedList();
  private String errorMsg;
  private T data;

  public RestControllerResult() {}

  public RestControllerResult(T t) {
    this.data = t;
  }

  public Boolean getSuccess() {
    return this.success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public Integer getCode() {
    return this.code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public List<String> getInfoMsgs() {
    return this.infoMsgs;
  }

  public void setInfoMsgs(List<String> infoMsgs) {
    this.infoMsgs = infoMsgs;
  }

  public List<String> getWarningMsgs() {
    return this.warningMsgs;
  }

  public void setWarningMsgs(List<String> warningMsgs) {
    this.warningMsgs = warningMsgs;
  }

  public String getErrorMsg() {
    return this.errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> RestControllerResult<T> success(T data) {
    RestControllerResult result = new RestControllerResult(data);
    result.setSuccess(true);
    return result;
  }

  public static <T> RestControllerResult<T> fail(int errorCode, String errorMsg) {
    RestControllerResult result = new RestControllerResult();
    result.setSuccess(false);
    result.setCode(errorCode);
    result.setErrorMsg(errorMsg);
    return result;
  }

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (o != null && this.getClass() == o.getClass()) {
      RestControllerResult<?> that = (RestControllerResult) o;
      return this.code == that.code
          && Objects.equals(this.success, that.success)
          && Objects.equals(this.infoMsgs, that.infoMsgs)
          && Objects.equals(this.warningMsgs, that.warningMsgs)
          && Objects.equals(this.errorMsg, that.errorMsg)
          && Objects.equals(this.data, that.data);
    } else {
      return false;
    }
  }

  public int hashCode() {
    return Objects.hash(
        new Object[] {
          this.success, this.code, this.infoMsgs, this.warningMsgs, this.errorMsg, this.data
        });
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("RestControllerResult{");
    sb.append("success=").append(this.success);
    sb.append(", code=").append(this.code);
    sb.append(", infoMsgs=").append(this.infoMsgs);
    sb.append(", warningMsgs=").append(this.warningMsgs);
    sb.append(", errorMsg='").append(this.errorMsg).append('\'');
    sb.append(", data=").append(this.data);
    sb.append('}');
    return sb.toString();
  }
}
