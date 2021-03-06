/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: ErrorResponse.java
* Autor: lcarbaja
* Fecha de creación: 11 sep. 2021
*/

package com.tis.mx.infraestructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Sets the more info.
 *
 * @param moreInfo the new more info
 */
@Setter

/**
 * Gets the more info.
 *
 * @return the more info
 */
@Getter

/**
 * Instantiates a new error response.
 *
 * @param code the code
 * @param message the message
 * @param location the location
 * @param moreInfo the more info
 */
@AllArgsConstructor
public class ErrorResponse {
  
  /** The code. */
  private Integer code;
  
  /** The message. */
  private String message;
  
  /** The location. */
  private String location;
  
  /** The more info. */
  private String moreInfo;


}
