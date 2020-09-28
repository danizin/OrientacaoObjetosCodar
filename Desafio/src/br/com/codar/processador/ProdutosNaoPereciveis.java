package br.com.codar.processador;

public class ProdutosNaoPereciveis extends Produto implements Comparable<ProdutosNaoPereciveis>{

	public ProdutosNaoPereciveis(int codigo, String descricaoProduto, int quantidade, double valor,
			Fornecedor codigoFornecedor) {
		super(codigo, descricaoProduto, quantidade, valor, codigoFornecedor);
		
	}

	public String imposto(double valor, int quantidade) {
		
		double v = (valor*quantidade) * 0.2;
		return " Imposto: " + String.format("%.2f", v);
		
		
	}
	
	@Override
	public String toString() {
		return  super.toString()  + imposto(getValor(),getQuantidade());
	
	}

	@Override
	public int compareTo(ProdutosNaoPereciveis outraDescricao) {
		if (super.getDescricao().compareTo(outraDescricao.getDescricao()) < 0) {
			return -1;
		}
		return 0;
	}
}
