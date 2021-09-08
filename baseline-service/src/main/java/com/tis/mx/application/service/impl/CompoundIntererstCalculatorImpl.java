package com.tis.mx.application.service.impl;

import java.util.List;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;

public class CompoundIntererstCalculatorImpl implements CompoundInterestCalculator{

  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestment){
    return null;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvetment) {
    // TODO Auto-generated method stub
    return false;
  }
}
