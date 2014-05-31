package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public interface Calculadora {

	BigDecimal calcula(Sessao va1, double totalIngressos, double percentual);

}
