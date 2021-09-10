package com.tis.mx.application.controller;

import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import java.util.List;



public class AplicationController {
  
  
  private CompoundInterestCalculator calculator;
  
  
  public AplicationController(CompoundInterestCalculator calculator) {
    this.calculator=calculator;
  }
  
  
  
  
  public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestment){
    
    if (calculator.validateInput(initialInvestment)) {
      return calculator.createRevenueGrid(initialInvestment);
    }
  
  throw new RuntimeException("El calculo no puede ser ejecutado");
  }
  
}
