package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {
	
	public static void main(String[] args) {
		
		//Na programação esse sinal "< >" é chamado de "Generics" 
		ArrayList<Conta> lista = new ArrayList<Conta>(); //O "ArrayList" é uma classe com um funcionamento parecido com o nosso teste do "GuardadorDeContas" porém muito mais refinada, além de criar um array com muito mais espaço, o limite de espaço do "ArrayList" é a memória da JVM
		//Ao utilizar o comando "<Classe>" é possível definir um tipo do array, assim ele só irá aceitar objetos que são ligados a classe informado dentro do "< >" /Afinal a ideia de ter um array completamente genérico é muito boa porém é má prática misturar mais de um tipo de referencias em um único array, por isso é mais fácil fazer um array para cada classe
		
//		Cliente cliente = new Cliente();
//		lista.add(cliente); //Ao tentar inserir uma referencia de algum outro tipo que não o específicado na assinatura do array o código sequer compila
		
		Conta cc1 = new ContaCorrente(123, 111);
		lista.add(cc1); //Usando o método "add" para adicionar a conta cc1 dentro do nosso array criado
		
		Conta cc2 = new ContaCorrente(123, 222);
		lista.add(cc2);
		
		System.out.println("Tamanho atual do array: " + lista.size()); //Utilizando o método "size" para que seja retornado quantas casas do array estão sendo ocupadas
		
//		Conta ref = (Conta) lista.get(0); //Invocando o método "get" para conseguir pegar a referencia que está na casa passada como parametro /Um detalhe: a "ArrayList" cria um array genérico do tipo "Object" portanto todas as referencias retornadas vem como "Object", por isso nesse caso como sabemos que a referencia da casa 0 é uma "Conta", foi possível fazer o "cast" para ser retornado uma referencia do tipo "Conta" de maneira correta
		Conta ref = lista.get(0); //Pelo array se tornar exclusivo de referencias da classe "Conta" o cast não é mais necessario
		
		System.out.println(ref);
		
		lista.remove(1); //O método "remove" serve para remover alguma referencia do array
		
		System.out.println("Tamanho atual do array: " + lista.size());	
		
		Conta cc3 = new ContaCorrente(321, 333);
		lista.add(cc3); 
		
		Conta cc4 = new ContaCorrente(321, 444);
		lista.add(cc4);
		
//		for(int i = 0; i < lista.size(); i++) { esse "for" é a maneira antiga de se acessar os itens de um array, porém é muito código para executar algo simples
//			Object referencia = lista.get(i);
//			System.out.println(referencia);
//		}
		
		for(Conta conta : lista) { //Essa é a versão resumida do "for" de cima para conseguir acessar os itens de um array, os dois tem a mesma saída
		//Essa prática também é chamada de "foreach"
			System.out.println(conta);
		}
		
	}

}
