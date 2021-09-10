package com.tis.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvestmentYieldDto {
  public int investmentYear;//año de la inversion
  public double initialInvestment;//inversion inicial
  public double yearInput;//entrada anual
  public double investmentYield;//rendimiento de la inversion
  public double finalBalance;//balance final

}
