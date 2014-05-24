package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			preco = getPreco(sessao, 0.05, 0.10);
		} else if((sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)) ||
				(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA))) {
			preco = getPreco(sessao, 0.5, 0.20);
			preco = getPreco(sessao, preco);
		}  else {
			preco = sessao.getPreco();
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal getPreco(Sessao sessao, BigDecimal preco) {
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

	private static BigDecimal getPreco(Sessao va1, double totalIngressos, double percentual) {
		BigDecimal preco;
		if((va1.getTotalIngressos() - va1.getIngressosReservados()) / va1.getTotalIngressos().doubleValue() <= totalIngressos) { 
			preco = va1.getPreco().add(va1.getPreco().multiply(BigDecimal.valueOf(percentual)));
		} else {
			preco = va1.getPreco();
		}
		return preco;
	}

}