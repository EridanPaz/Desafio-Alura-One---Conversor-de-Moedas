package com.alura.conversor_de_moeda.principal;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.stream.Collectors;

//@JsonIgnoreProperties(ignoreUnknown = true)
//public record TodosOsValoresDTO(@JsonAlias("base_code") String moedaBase,
//                                @JsonAlias("target_code") String moedaAlvo,
//                                @JsonAlias("conversion_rate") String fatorDeConversao,
//                                @JsonAlias("conversion_result") String valorConvertido) {
  
  
  public record TodosOsValoresDTO(String base_code,
                                  String target_code,
                                  double conversion_rate,
                                  double conversion_result) {
  
  @Override
  public String toString() {
    return  "------------------- Conversor de Moeda -----------------" +
      "\nMoeda-Base:           " + base_code +
      "\nMoeda-Alvo:           " + target_code +
      "\nFator de Conversão:   " + conversion_rate +
      "\nValor convertido:     " + conversion_result+
      "\n-------------------------------------------\n";
  }
}
