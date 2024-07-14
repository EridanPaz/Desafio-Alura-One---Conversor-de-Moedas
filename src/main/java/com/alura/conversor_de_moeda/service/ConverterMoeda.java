package com.alura.conversor_de_moeda.service;

import com.alura.conversor_de_moeda.principal.ApenasOValorConvertidoDTO;
import com.alura.conversor_de_moeda.principal.TodosOsValoresDTO;
import com.google.gson.Gson;

public class ConverterMoeda {
  
  private ConsultarApi response = new ConsultarApi();
  private Gson gson             = new Gson();
  
  private String acessarApi(String enderecoAPI){
    
    String json = response.pesquisar(enderecoAPI);
    
    return json;
  }
  
  public ApenasOValorConvertidoDTO retorarSoOValorConvertido(String enderecoAPI) {
    
    String json = acessarApi(enderecoAPI);
    
    return gson.fromJson(json, ApenasOValorConvertidoDTO.class);
  }
  
  public TodosOsValoresDTO retornarDadosCompletos(String enderecoAPI){
    
    String json = acessarApi(enderecoAPI);
    
    return gson.fromJson(json, TodosOsValoresDTO.class);
  }
  
}
