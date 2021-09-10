package com.tis.mx.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tis.mx.application.dto.InitialInvestmentDto;
import com.tis.mx.application.dto.InvestmentYieldDto;
import com.tis.mx.application.service.CompoundInterestCalculator;
import lombok.AllArgsConstructor;

@Service
public class CompoundIntererstCalculatorImpl implements CompoundInterestCalculator{

  @Override
  public List<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestmentDto){
    Integer investmentYear=0;
    Double initialInvestment=0.00;
    Double yearlyInput=0.00;
    Double investmentYield=0.00;
    Double finalBalance=0.00;
    
    ArrayList<InvestmentYieldDto>investmentYielList =new ArrayList<>();
    double aux=0.00;
    for (int i=0;i<initialInvestmentDto.getInvestmentYears();i++) {
      investmentYear=i+1;
      yearlyInput=initialInvestmentDto.getYearlyInput()+aux;
      aux+=yearlyInput*initialInvestmentDto.getYearlyInputIncrement()/100;
      aux=Math.ceil(aux);
      if(i==0) {
        initialInvestment=initialInvestmentDto.getInitialInvestment();
        
      }else if(i>0) {
        initialInvestment=finalBalance;
      }
      

      investmentYield =
            (initialInvestment + yearlyInput) * initialInvestmentDto.getInvestmentYield();
       finalBalance = initialInvestment + yearlyInput + investmentYield;
       investmentYielList.add(new InvestmentYieldDto(investmentYear,
           initialInvestment,yearlyInput,investmentYield,finalBalance));
       
       

    }
    
    
    return investmentYielList;
  }

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvetment) {
    
    this.setDefaults(initialInvetment);
    boolean cumple=true;
    
    cumple=cumple && (initialInvetment.getInitialInvestment()>=1000);
    cumple=cumple && (initialInvetment.getYearlyInput()>=0.0);
    cumple=cumple && (initialInvetment.getInvestmentYears()>=0.0);
    cumple=cumple && (initialInvetment.getInvestmentYield()>=0.0);
    cumple=cumple && (initialInvetment.getYearlyInputIncrement()<=0);
    return cumple;
  }
  private void setDefaults(InitialInvestmentDto initialInvestment) {
    
    Double YearlyInput=initialInvestment.getYearlyInput();
    YearlyInput=YearlyInput==null ? 0.0 : YearlyInput;
    initialInvestment.setYearlyInput(YearlyInput);
    
    Integer yearlyInputIncrement=initialInvestment.getYearlyInputIncrement();
    yearlyInputIncrement =yearlyInputIncrement==null?0:yearlyInputIncrement;
    initialInvestment.setYearlyInputIncrement(yearlyInputIncrement);
  }
}
