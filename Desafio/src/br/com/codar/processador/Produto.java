package br.com.codar.processador;

public class Produto {
	private int codigo;
	private String descricao;
	private int quantidade;
	private double valor;
	private Fornecedor fornecedor;
	// private Integer dias;

	public Produto(int codigo, String descricao, int quantidade, double valor, Fornecedor codigoFornecedor) {
		setCodigo(codigo);
		setDescricao(descricao);
		setQuantidade(quantidade);
		setValor(valor);
		this.fornecedor = codigoFornecedor;

	}

	public void setCodigo(int codigo) {
		if (codigo < 1 || codigo > 9999) {
			throw new IllegalArgumentException("Código errado: Não está entre 1 e 9999");
		} else {
			this.codigo = codigo;
		}

	}

	public void setDescricao(String descricao) {
		if (descricao != null && !descricao.equals("")) {
			this.descricao = descricao;
		} else {
			throw new IllegalArgumentException("Descrição vazia: A descrição está vazia");
		}
	}

	public void setQuantidade(int quantidade) {
		if (quantidade < 1 || quantidade > 9999) {
			throw new IllegalArgumentException("Quantidade errada: Não está entre 1 e 9999");
		} else {
			this.quantidade = quantidade;
		}
	}

	public void setValor(double valor) {
		if (valor < 0.01 || valor > 9999.99) {
			throw new IllegalArgumentException("Valor errado: Não está entre 0.01 e 9999.99");
		} else {
			this.valor = valor;
		}
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public double getValor() {
		return this.valor;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public int getCodigo() {
		return this.codigo;
	}
	
	public String importado(int codigo) {
		if(fornecedor.getCodigo() > 900 && fornecedor.getCodigo() < 920) {
			return "*IMPORTADO* ";
		}else {
			return "";
		}
	}

	@Override
	public String toString() {
		return importado(fornecedor.getCodigo()) + "Código: " + codigo + " - Descrição: " + descricao + "- Fornecedor: " + fornecedor.getDescricao()
				+ " - Valor Total: " + String.format("%.2f", valor * quantidade);
	}

}
