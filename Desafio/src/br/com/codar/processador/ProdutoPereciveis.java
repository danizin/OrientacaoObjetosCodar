package br.com.codar.processador;

public class ProdutoPereciveis extends Produto implements Comparable<ProdutoPereciveis> {

	private int dias;

	public ProdutoPereciveis(int codigo, String descricao, int quantidade, double valor, Fornecedor codigoFornecedor,
			int dias) {
		super(codigo, descricao, quantidade, valor, codigoFornecedor);
		setDias(dias);
	}

	public void setDias(Integer dias) {
		if (dias < 1 || dias > 999) {
			throw new IllegalArgumentException("Dias de Validade Errado: Não está entre 1 e 999");
		} else {
			this.dias = dias;
		}
	}

	public String imposto(double valor, int quantidade) {
		if (quantidade > 50) {
			double v = (valor * quantidade) * 0.1;
			return " Imposto: " + String.format("%.2f", v);
		} else {
			return " - Sem Imposto";
		}
	}

	@Override
	public String toString() {
		
		return super.toString() + imposto(super.getValor(), super.getQuantidade()) + " - " + dias + " dias de validade";
	}

	@Override
	public int compareTo(ProdutoPereciveis outraDescricao) {
		if (super.getDescricao().compareTo(outraDescricao.getDescricao()) < 0) {
			return -1;
		}
		return 0;
	}
}
