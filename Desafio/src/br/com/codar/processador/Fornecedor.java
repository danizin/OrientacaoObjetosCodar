package br.com.codar.processador;

public class Fornecedor {

	private int codigo;
	private String descricao;

	public Fornecedor(int codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
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

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	
	
	@Override
	public String toString() {
		
		return  "Código: " + codigo + " - Descrição: " + descricao;
	}
}
