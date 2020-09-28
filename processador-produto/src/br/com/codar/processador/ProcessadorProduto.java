package br.com.codar.processador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ProcessadorProduto {
	public static void main(String[] args) throws Exception {
		
		// Fornecedor
				BufferedReader readerFornecedor = new BufferedReader(
						new InputStreamReader(new FileInputStream("fornecedor.csv")));
				ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
				String linhaFornecedor = readerFornecedor.readLine();
		// Produtos
		BufferedReader readerProdutos = new BufferedReader(new InputStreamReader(new FileInputStream("produtos.csv")));
		ArrayList<Produtos> listaProd = new ArrayList<Produtos>();
		String linhaProdutos = readerProdutos.readLine();

		
		

		while (linhaFornecedor != null) {
			String[] atributosFornecedor = linhaFornecedor.split(";");
			int codigo = Integer.parseInt(atributosFornecedor[0]);
			String descricaoFornecedor = atributosFornecedor[1];

			Fornecedor forn = criarFornecedor(listaFornecedor, codigo, descricaoFornecedor);
			listaFornecedor.add(forn);
			

			linhaFornecedor = readerFornecedor.readLine();
		}

		while (linhaProdutos != null) {

			String[] atributosProduto = linhaProdutos.split(";");
			
			int codigoProduto = Integer.parseInt(atributosProduto[0]);
			String descricaoProduto = atributosProduto[1];
			int quantidade = Integer.parseInt(atributosProduto[2]);
			double valor = Double.parseDouble(atributosProduto[3]);
			int codigoFornecedor = Integer.parseInt(atributosProduto[4]);
			int dias = 0;
			boolean perecivel = false;
			
			if(atributosProduto.length == 6) {
				dias = Integer.parseInt(atributosProduto[5]);
				perecivel = true;
				
			}

			Fornecedor fornecedorProduto = null;

			for (Fornecedor fornecedor : listaFornecedor) {

				if (fornecedor.getCodigo() == codigoFornecedor) {
					fornecedorProduto = fornecedor;
					break;
				}
			}
			
			
			Produtos prod = criarProdutos(listaProd, codigoProduto, descricaoProduto, quantidade, valor, fornecedorProduto,dias,perecivel);
			if (prod  != null) {
				listaProd.add(prod);
			}

			linhaProdutos = readerProdutos.readLine();

		}

		System.out.println("FORNECEDORES:");
		for (Fornecedor fornecedor : listaFornecedor) {
			System.out.println(fornecedor);
		}

		System.out.println("PRODUTOS");
		for (Produtos produtos : listaProd) {
			System.out.println(produtos);
		}
		
		

		readerProdutos.close();

	}

	public static Fornecedor criarFornecedor(ArrayList<Fornecedor> listaFornecedor, int codigo,
			String descricaoFornecedor) throws Exception {
		boolean existe = false;
		double codigoDouble = codigo;
		
		
		validarIntervalo(1.0, 9999.0,codigoDouble);
		
		// Condição para não ter códigos repetidos.
		if (listaFornecedor.size() == 0) {
			Fornecedor forn = new Fornecedor(codigo, descricaoFornecedor);
			return forn;
		} else {
			for (Fornecedor fornecedor : listaFornecedor) {
				if (fornecedor.getCodigo() == codigo) {
					existe = true;
				}
			}
			if (existe == false) {
				Fornecedor forn = new Fornecedor(codigo, descricaoFornecedor);
				return forn;
			} else {
				throw new Exception("Codigo já existe");
			}
		}
	}

	public static Produtos criarProdutos(ArrayList<Produtos> listaProd, int codigoProduto, String descricaoProduto,
			int quantidade, double valor, Fornecedor fornecedorProduto, int dias, boolean perecivel) throws Exception {
		boolean existe = false;
		
		double codigoDouble = codigoProduto;
		double quantidadeDouble = quantidade;
		double diasDouble = dias;
		
		validarIntervalo(1.0, 9999.0, codigoDouble);
		validarIntervalo(1.0, 9999.0, quantidadeDouble);
		validarIntervalo(0.01, 9999.99, valor);
		
		// Condição para não ter códigos repetidos.
		if(descricaoProduto.equals("")) {
			throw new Exception("Desrição vazia");
		}
		
		if (listaProd.size() == 0) {
			if(perecivel == false) {
				ProdutosNaoPereciveis prod = new ProdutosNaoPereciveis(codigoProduto, descricaoProduto, quantidade, valor, fornecedorProduto);
				return prod;
			}else {
				validarIntervalo(1.0, 999.0, dias);
				ProdutosPereciveis prodPereciveis = new ProdutosPereciveis(codigoProduto, descricaoProduto, quantidade, valor, fornecedorProduto,dias);
				return prodPereciveis;
			}
		} else {
			for (Produtos produtos : listaProd) {
				if (produtos.getCodigo() == codigoProduto) {
					existe = true;
				}
			}
			if (existe == false) {
				if(perecivel == false) {
					ProdutosNaoPereciveis prod = new ProdutosNaoPereciveis(codigoProduto, descricaoProduto, quantidade, valor, fornecedorProduto);
					return prod;
				}else {
					validarIntervalo(1.0, 999.0, dias);
					ProdutosPereciveis prodPereciveis = new ProdutosPereciveis(codigoProduto, descricaoProduto, quantidade, valor, fornecedorProduto,dias);
					return prodPereciveis;
				}
			} else {
				throw new Exception("Codigo já existe");
			}
		}
	}
	public static void validarIntervalo(double minimo, double maximo, double valor) throws Exception {
		if(valor > maximo || valor < minimo) {
			throw new Exception("Número não está no alcance");
		}
		
	}
}
