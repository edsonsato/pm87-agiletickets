package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public class CalculadoraSimples implements Calculadora {

	@Override
	public BigDecimal calcula(Sessao va1, double totalIngressos, double percentual) {
		BigDecimal preco;
		if((va1.getTotalIngressos() - va1.getIngressosReservados()) / va1.getTotalIngressos().doubleValue() <= totalIngressos) { 
			preco = va1.getPreco().add(va1.getPreco().multiply(BigDecimal.valueOf(percentual)));
		} else {
			preco = va1.getPreco();
		}
		return preco;
	}

}
