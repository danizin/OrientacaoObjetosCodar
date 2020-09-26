package br.com.codar.processador;

public class Fornecedor {
	
	private int codigo;
	private String descricaoFornecedor;
	
	

	public Fornecedor() {
	
	}

	public Fornecedor(int codigo, String descricaoFornecedor) {
		
		this.codigo = codigo;
		this.descricaoFornecedor = descricaoFornecedor;
	}

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescricaoFornecedor() {
		return descricaoFornecedor;
	}

	public void setDescricaoFornecedor(String descricaoFornecedor) {
		this.descricaoFornecedor = descricaoFornecedor;
	}



	@Override
	public String toString() {
		
		return  "Código: " + codigo + " - Descrição: " + descricaoFornecedor;
	}
	
	
}
