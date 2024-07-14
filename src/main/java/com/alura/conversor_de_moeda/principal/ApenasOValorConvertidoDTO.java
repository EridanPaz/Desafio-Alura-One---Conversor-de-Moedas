package com.alura.conversor_de_moeda.principal;

public record ApenasOValorConvertidoDTO(double conversion_result) {
    @Override
    public String toString() {
        return "" + conversion_result;
    }
}
