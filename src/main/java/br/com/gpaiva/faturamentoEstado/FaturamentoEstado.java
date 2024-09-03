package br.com.gpaiva.faturamentoEstado;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FaturamentoEstado {
    private String estado;
    private double valor;
}