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

public class ApplicationControllerTest {
  
private AplicationController controller;
private InitialInvestmentDto initialInvestmentDto;
private CompoundInterestCalculator calculator; 

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
    this.initialInvestmentDto.setInitialInvestment(Float.valueOf(21));
    
    //crea controlador con su dependenia de una calculadora
    this.controller = new AplicationController(this.calculator);
    
  }
  @Test
  public void shouldGenerateTableYield() {
    List<InvestmentYieldDto> tableYield=controller.createTableYield(initialInvestmentDto);
    assertEquals(5,tableYield.size());
    
    InvestmentYieldDto firstYear=tableYield.get(0);
    
    assertEquals((5000.00),firstYear.getInitialInvestment());
    assertEquals((3000.00),firstYear.getYearInput());
    assertEquals((1680.00),firstYear.getInvestmentYield());
    assertEquals((9680.00),firstYear.getFinalBalance());
  }

}
