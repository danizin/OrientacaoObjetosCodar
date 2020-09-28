package br.com.codar.processador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ProcessadorProtudos {

	public static void main(String[] args) throws IOException {

		// Fornecedor
		BufferedReader readerFornecedor = new BufferedReader(
				new InputStreamReader(new FileInputStream("fornecedor.csv")));
		ArrayList<Fornecedor> listaFornecedor = new ArrayList<Fornecedor>();
		String linhaFornecedor = readerFornecedor.readLine();

		BufferedReader readerProduto = new BufferedReader(new InputStreamReader(new FileInputStream("produtos.csv")));
		String linhaProduto = readerProduto.readLine();

		// Produtos Perecivel
		ArrayList<ProdutoPereciveis> listaProduto = new ArrayList<ProdutoPereciveis>();

		// Produtos Não Perecivel
		ArrayList<ProdutosNaoPereciveis> listaProdutoNaoPerecivel = new ArrayList<ProdutosNaoPereciveis>();

		// Fornecedor
		while (linhaFornecedor != null) {
			String[] atributosFornecedor = linhaFornecedor.split(";");
			int codigo = Integer.parseInt(atributosFornecedor[0]);
			String descricaoFornecedor = atributosFornecedor[1];

			Fornecedor forn = new Fornecedor(codigo, descricaoFornecedor);
			listaFornecedor.add(forn);

			linhaFornecedor = readerFornecedor.readLine();
		}

		// Produto Perecivel
		while (linhaProduto != null) {

			String[] atributosProduto = linhaProduto.split(";");

			int codigoProduto = Integer.parseInt(atributosProduto[0]);
			String descricaoProduto = atributosProduto[1];
			int quantidade = Integer.parseInt(atributosProduto[2]);
			double valor = Double.parseDouble(atributosProduto[3]);
			int codigoFornecedor = Integer.parseInt(atributosProduto[4]);
			int dias = 0;

			Fornecedor fornecedorProduto = null;
			for (Fornecedor fornecedor : listaFornecedor) {
				if (fornecedor.getCodigo() == codigoFornecedor) {
					fornecedorProduto = fornecedor;
					break;
				}
			}

			if (atributosProduto.length == 6) {
				dias = Integer.parseInt(atributosProduto[5]);
				ProdutoPereciveis produtoPerecivel = new ProdutoPereciveis(codigoProduto, descricaoProduto, quantidade,
						valor, fornecedorProduto, dias);
				listaProduto.add(produtoPerecivel);
				Collections.sort(listaProduto);

			}
			if (atributosProduto.length == 5) {
				ProdutosNaoPereciveis produtoNaoPerecivel = new ProdutosNaoPereciveis(codigoProduto, descricaoProduto,
						quantidade, valor, fornecedorProduto);
				listaProdutoNaoPerecivel.add(produtoNaoPerecivel);
				Collections.sort(listaProdutoNaoPerecivel);
			}

			linhaProduto = readerProduto.readLine();

		}

		System.out.println("PRODUTOS PERECIVEIS");
		for (Produto produtosPereciveis : listaProduto) {
			System.out.println(produtosPereciveis);

		}
		System.out.println();
		System.out.println("PRODUTOS NÃO PERECIVEIS");
		for (Produto produtosNaoPereciveis : listaProdutoNaoPerecivel) {
			System.out.println(produtosNaoPereciveis);
		}
		System.out.println();

		System.out.println("FORNECEDORES:");
		for (Fornecedor fornecedor : listaFornecedor) {
			System.out.println(fornecedor);
		}

		readerFornecedor.close();
		readerProduto.close();

	}

}
