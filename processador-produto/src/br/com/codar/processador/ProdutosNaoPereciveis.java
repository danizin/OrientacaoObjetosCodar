package br.com.codar.processador;

public class ProdutosNaoPereciveis extends Produtos {

	public ProdutosNaoPereciveis() {
		// TODO Auto-generated constructor stub
	}

	public ProdutosNaoPereciveis(int codigo, String descricaoProduto, int quantidade, double valor,
			Fornecedor codigoFornecedor) {
		super(codigo, descricaoProduto, quantidade, valor, codigoFornecedor);
		// TODO Auto-generated constructor stub
	}

	public String imposto(double valor, int quantidade) {
		return " Imposto: " + (valor*quantidade) * 0.2;
		
		
	}
	
	@Override
	public String toString() {
		return super.toString() + imposto(getValor(),getQuantidade());
	}
}
