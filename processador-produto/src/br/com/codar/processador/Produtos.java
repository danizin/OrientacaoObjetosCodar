package br.com.codar.processador;

public class Produtos {
	
	private int codigo;
	private String descricaoProduto;
	private int quantidade;
	private double valor;
	private Fornecedor fornecedor;
	

	public Produtos() {
		
	}
	
	public Produtos(int codigo, String descricaoProduto, int quantidade, double valor, Fornecedor codigoFornecedor) {
		this.codigo = codigo;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.fornecedor = codigoFornecedor;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getDescricaoProduto() {
		return descricaoProduto;
	}



	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	


	@Override
	public String toString() {
		return "Código: " + codigo + " - Descrição: " + descricaoProduto + "- Fornecedor: "
				+ fornecedor.getDescricaoFornecedor() + " - Valor Total: " + valor*quantidade ;
	}

	
	
	
}
