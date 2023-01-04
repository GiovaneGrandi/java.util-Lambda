package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.GuardadorDeContas;

public class Teste {
	
	public static void main(String[] args) {
		GuardadorDeContas guardador = new GuardadorDeContas(); //Inicializando um novo objeto do tipo "GuardadorDeContas" para ser usado no lugar do array comum
		
		ContaCorrente cc = new ContaCorrente(123, 321);
		guardador.adiciona(cc);
		
		ContaCorrente cc2 = new ContaCorrente(123, 322);
		guardador.adiciona(cc2);
		
		int tamanho = guardador.getQuantidadeDeElementos();
		System.out.println(tamanho);
		
		Conta referencia1 = guardador.getReferencia(1);
		System.out.println(referencia1.getNumero());
	}

}
