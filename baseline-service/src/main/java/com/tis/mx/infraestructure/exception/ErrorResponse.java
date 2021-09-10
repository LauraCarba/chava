
package com.tis.mx.infraestructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@AllArgsConstructor
public class ErrorResponse {
  private Integer code;
  private String message;
  private String location;
  private String moreInfo;


}
