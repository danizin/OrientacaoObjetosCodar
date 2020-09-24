package br.com.codar.processador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ProcessadorProduto {
	public static void main(String[] args) throws Exception {
		//Produtos
		BufferedReader readerProdutos = new BufferedReader(new InputStreamReader(new FileInputStream("produtos.csv")));
		ArrayList<Produtos> listaProd = new ArrayList<Produtos>();
		String  linhaProdutos = readerProdutos.readLine();
		
		//Fornecedor
		BufferedReader readerFornecedor = new BufferedReader(new InputStreamReader(new FileInputStream("fornecedor.csv")));
		ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		String  linhaFornecedor = readerFornecedor.readLine();
		
		while(linhaFornecedor != null) {
			String [] vetor = linhaFornecedor.split(";");
			int codigo = Integer.parseInt(vetor[0]);
			String descricaoFornecedor = vetor[1];
			
			Fornecedor forn = new Fornecedor(codigo, descricaoFornecedor);
			listaFornecedor.add(forn);
			
			linhaFornecedor = readerFornecedor.readLine();
		
		}
		
		
		
		while(linhaProdutos != null) {
			
			String [] vetor = linhaProdutos.split(";");
			
			int codigo = Integer.parseInt(vetor[0].toString());
			String descricaoProduto = vetor[1].toString();
			int quantidade = Integer.parseInt(vetor[2].toString());
			double valor = Double.parseDouble(vetor[3].toString());
			String codigoFornecedor = vetor[4];

			Produtos prod = new Produtos Produtos(codigo, descricaoProduto, quantidade, valor, fornecedor);
			listaProd.add(prod);
	
			linhaProdutos = readerProdutos.readLine();
			
		}
		
		System.out.println("FORNECEDORES:");
		for (Fornecedor fornecedor : listaFornecedor) {
			System.out.println(fornecedor);
		}
		
		for (Produtos produtos : listaProd) {
			System.out.println(produtos);
		}
		
		
		
			
			
		
	
		
		
		
		
		
		readerProdutos.close();
	}
	
}
