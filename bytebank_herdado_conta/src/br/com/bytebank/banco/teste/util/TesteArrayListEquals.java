package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {
	
	public static void main(String[] args) {
		
//		Conta cc1 = new ContaCorrente(123, 222);
//		Conta cc2 = new ContaCorrente(123, 222);
//
//		boolean igual = cc1.ehIgual(cc2);
//		System.out.println(igual);
		
		ArrayList<Conta> lista = new ArrayList<Conta>(); 
		
		Conta cc1 = new ContaCorrente(123, 111);
		lista.add(cc1);
		
		Conta cc2 = new ContaCorrente(123, 222);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(123, 222);
		
		boolean existe = lista.contains(cc3); //O método "contains" serve para perguntar ao array se aquela determinada referencia exitse dentro do array, nesse caso ele retorna um true por termos adicionado a referencia cc2 dentro do array /O método "contains" faz a comparação do nosso método "equals" por baixo dos panos e então informa com exatidão se duas contas se referem a mesma ou contas diferentes
		System.out.println("Existe essa referência no array? " + existe);
		
//		for(Conta conta : lista) { //Criando um foreach que tem a mesma função do método "contains" onde ele passa por todo array e procura para ver se encontra a referencia passada para ele
//			if(conta.ehIgual(cc3)) {
//				System.out.println("Eu tenho essa conta no array!");
//			} 
//		}
		
		for(Conta conta : lista) { 
			System.out.println(conta);
		}
		
	}

}
