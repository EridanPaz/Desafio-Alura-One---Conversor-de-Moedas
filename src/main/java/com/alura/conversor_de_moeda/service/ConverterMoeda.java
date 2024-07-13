package com.alura.conversor_de_moeda.service;

import com.alura.conversor_de_moeda.principal.PrincipalConversor;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoeda {
  
  public PrincipalConversor Converter(String enderecoAPI){
    
    Gson json = new Gson();
    
    HttpClient client   = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(enderecoAPI))
      .build();
    HttpResponse<String> response  = null;
    
    try {
      response = client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      System.out.println("Ocorreu um erro ao pesquisar na API: " + enderecoAPI);
    }
    
    return json.fromJson(response.body(), PrincipalConversor.class);
    
  }
}
