package br.sato;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class CarrinhoTest {
	@Test
	public void verificaMaiorValorComUmProduto() {
		Produto p = new Produto(20.0);
		Carrinho c = new Carrinho(p);
		double maiorValor = c.getMaiorValor();
		Assert.assertEquals(21.0, maiorValor, 0.001);
	}
	@Test
	public void verificaMaiorValorComVariosProdutos() throws Exception {
		Produto bola = new Produto(10.0);
		Produto boneca = new Produto(30.0);
		Carrinho carrinho = new Carrinho(bola);
		carrinho.adiciona(boneca);
		double maiorValor = carrinho.getMaiorValor();
		Assert.assertEquals(30, maiorValor, 0.001);
	}
}
