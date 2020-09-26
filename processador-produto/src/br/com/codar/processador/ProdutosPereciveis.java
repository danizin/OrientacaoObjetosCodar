package br.com.codar.processador;

public class ProdutosPereciveis extends Produtos {
	
	private int dias;
	
	
	public ProdutosPereciveis() {
		// TODO Auto-generated constructor stub
	}

	public ProdutosPereciveis(int codigo, String descricaoProduto, int quantidade, double valor,
			Fornecedor codigoFornecedor, int dias) {
		super(codigo, descricaoProduto, quantidade, valor, codigoFornecedor);
		this.dias = dias;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	public String imposto(double valor, int quantidade) {
		if(quantidade > 50 ) {
			double v = (valor*quantidade) * 0.1 ;
			return " Imposto: " + String.valueOf(v) ;
		}else {
			return " - Sem Imposto";
		}
		
		
	}

	@Override
	public String toString() {
		
		return super.toString() +  imposto(getValor(),getQuantidade()) + " - " + dias +" dias de validade";
	}

}
