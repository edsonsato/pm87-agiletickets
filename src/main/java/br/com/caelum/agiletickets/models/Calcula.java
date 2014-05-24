package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public class Calcula {
	
	public static BigDecimal getPreco(Sessao sessao, BigDecimal preco) {
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

	public static BigDecimal getPreco(Sessao va1, double totalIngressos, double percentual) {
		BigDecimal preco;
		if((va1.getTotalIngressos() - va1.getIngressosReservados()) / va1.getTotalIngressos().doubleValue() <= totalIngressos) { 
			preco = va1.getPreco().add(va1.getPreco().multiply(BigDecimal.valueOf(percentual)));
		} else {
			preco = va1.getPreco();
		}
		return preco;
	}
}
