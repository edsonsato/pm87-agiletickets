package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			return Calcula.getPreco(sessao, 0.05, 0.10);
		}
	}, SHOW {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			return Calcula.getPreco(sessao, 0.05, 0.10);
		}
	}, TEATRO {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			return sessao.getPreco();
		}
		
	}, BALLET {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			BigDecimal preco = Calcula.getPreco(sessao, 0.5, 0.20);
			return Calcula.getPreco(sessao, preco);
		}
	}, ORQUESTRA {
		@Override
		public BigDecimal calcula(Sessao sessao) {
			BigDecimal preco = Calcula.getPreco(sessao, 0.5, 0.20);
			return Calcula.getPreco(sessao, preco);
		}
	};
	
	public abstract BigDecimal calcula(Sessao sessao);
}
