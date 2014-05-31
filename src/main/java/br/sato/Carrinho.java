package br.sato;

public class Carrinho {

	private Produto produto;

	public Carrinho(Produto produto) {
		this.produto = produto;
		// TODO Auto-generated constructor stub
	}

	public double getMaiorValor() {
		// TODO Auto-generated method stub
		return produto.getPreco();
	}

	public void adiciona(Produto produto) {
		// TODO Auto-generated method stub
		if(this.produto.getPreco()<produto.getPreco()) {
			this.produto = produto;
		}
		
	}

}
