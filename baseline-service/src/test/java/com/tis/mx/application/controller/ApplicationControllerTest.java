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
* Nombre de archivo: ApplicationControllerTest.java
* Autor: lcarbaja
* Fecha de creación: 10 sep. 2021
*/

package com.tis.mx.application.controller;

import static org.junit.Assert.assertEquals;
import java.util.List;
import javax.sql.rowset.FilteredRowSet;
import org.junit.Before;
import org.junit.Test;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import com.tis.mx.application.service.impl.CompoundIntererstCalculatorImpl;

/**
 * The Class ApplicationControllerTest.
 */
public class ApplicationControllerTest {
  
/** The controller. */
private AplicationController controller;

/** The initial investment dto. */
private InitialInvestmentDto initialInvestmentDto;

/** The calculator. */
private CompoundInterestCalculator calculator; 

  /**
   * Creates the values before to test.
   */
  @Before
  
  public void createValuesBeforeToTest() {
    
    //creamos calculadora
    
    this.calculator=new CompoundIntererstCalculatorImpl();
    //creo controlador
    this.initialInvestmentDto=new InitialInvestmentDto();
    //Crear los valores iniciales de la inversion
   
    this.initialInvestmentDto.setInitialInvestment(Double.valueOf(5000.00));
    this.initialInvestmentDto.setYearlyInput(Double.valueOf(3000.00));
    this.initialInvestmentDto.setYearlyInputIncrement(Integer.valueOf(1));
    this.initialInvestmentDto.setInvestmentYears(5);
    this.initialInvestmentDto.setInitialInvestment(Float.valueOf(21f));
    
    //crea controlador con su dependenia de una calculadora
  //  this.controller = new AplicationController(this.calculator);
    
  }
  
  /**
   * Should generate table yield.
   */
  @Test
  public void shouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield=controller.createTableYield("application/json",
        initialInvestmentDto);
    assertEquals(5,tableYield.size());
    
    InvestmentYieldDto firstYear=tableYield.get(0);
    
    assertEquals((5000.00),firstYear.getInitialInvestment());
    assertEquals((3000.00),firstYear.getYearInput());
    assertEquals((1680.00),firstYear.getInvestmentYield());
    assertEquals((9680.00),firstYear.getFinalBalance());
  }

}
