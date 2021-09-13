package com.tis.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvestmentYieldDto {
  private Integer investmentYear;//año de la inversion
  private Double initialInvestment;//inversion inicial
  private Double yearInput;//entrada anual
  private Double investmentYield;//rendimiento de la inversion
  private Double finalBalance;//balance final

}
