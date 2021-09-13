package com.tis.mx.application.dto;
import lombok.*;



@Getter
@Setter
public class InitialInvestmentDto {
 private Double initialInvestment;//inversion inicial
 private Double yearlyInput;//entradad anual
 private Integer yearlyInputIncrement;//incremento de entrada anual
 private Float investmentYield;//rendimiento de la inversion
 private Integer investmentYears;//rendimiento anual

}
