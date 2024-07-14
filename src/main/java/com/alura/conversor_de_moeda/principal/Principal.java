package com.alura.conversor_de_moeda.principal;

import com.alura.conversor_de_moeda.service.ConverterMoeda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
  private Scanner leitor              = new Scanner(System.in);
  private ConverterMoeda conversor    = new ConverterMoeda();
  private String enderecoAPIConversor = "https://v6.exchangerate-api.com/v6/b0ecb1cf47b99d0620247b1b/pair/";
  private String baseAndTarget        = "";
  private double valor                = 0;
  private String soOValorConvertido;
  
  public void menu(){
    int opcao    = -1;
    
    while (opcao != 0){
      String opcoes = """
                    ******************* Bem Vindo ao Conversor de Moedas *******************
                    Selecione uma opção :
                    
                    0 - Sair do Conversor de Moedas
                    1 - [USD] para [BRL]
                    2 - [BRL] para [USD]
                    3 - [EUR] para [BRL]
                    4 - [BRL] para [EUR]
                    5 - [USD] para [EUR]
                    6 - [BRL] para [GBP]
                    
                    """ ;
      try {
        System.out.println(opcoes);
        opcao = leitor.nextInt();
        
        if (opcao > 0) {
          System.out.println("Retornar só o valor convertido (S/N?");
          soOValorConvertido = leitor.nextLine();
          
          System.out.println("Informe o valor para conversão:");
          valor = leitor.nextDouble();
        }
        
        switch (opcao){
          case 0:
            System.out.println("Saindo do aplicativo...");
            break;
          case 1:
            baseAndTarget = "USD/BRL/";
            break;
          case 2:
            baseAndTarget = "BRL/USD/";
            break;
          case 3:
            baseAndTarget = "EUR/BRL/";
            break;
          case 4:
            baseAndTarget = "BRL/EUR/";
            break;
          case 5:
            baseAndTarget = "USD/EUR/";
            break;
          case 6:
            baseAndTarget = "EUR/USD/";
            break;
          default:
            System.out.println("Opção inválida.");
        }
      }catch (InputMismatchException e){
        System.out.println("Deverá ser informado um número inteiro.");
        leitor.nextLine();
      }
      
      String converter = enderecoAPIConversor + baseAndTarget + valor;
      fazerConversao(converter);
    }
  }
  
  private void fazerConversao(String urlBaseTargetValor){
    
    System.out.println(urlBaseTargetValor);
    
    String moedaBase = urlBaseTargetValor.substring(65, 68);
    String moedaAlvo = urlBaseTargetValor.substring(69, 72);
    
    if (soOValorConvertido.toUpperCase() == "S") {
        ApenasOValorConvertidoDTO valorConvetido = conversor.retorarSoOValorConvertido(urlBaseTargetValor);
      
        System.out.println("O valor de: " + moedaBase + valor + " convertido para " + moedaAlvo + " é: " + moedaAlvo + valorConvetido);
    }
    
    System.out.println(conversor.retornarDadosCompletos(urlBaseTargetValor));
  }
}
