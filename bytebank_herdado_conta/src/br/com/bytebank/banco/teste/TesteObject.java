package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteObject {

	public static void main(String[] args) {
//		System.out.println("x");
//		System.out.println(3);
//		System.out.println(false);
		
		ContaCorrente cc = new ContaCorrente(123, 321); //Colocando aqui uma referencia especifica para um objeto do tipo "ContaCorrente", isso faz com que essa nova conta referenciada pelo "cc" consegue acessar a métodos tanto dela mesma, como da classe mãe "Conta" e da classe mãe da "Conta" a "Object"
		cc.deposita(150);
		
		ContaPoupanca cp = new ContaPoupanca(123, 222);
		cp.deposita(35);
		
		Object cliente = new Cliente();
		
		System.out.println(cc); //A classe Object também tem seus métodos, um deles é o "toString" que serve para converter o endereço de uma referencia em uma string, ele já é invocado automaticamente ao colocar uma referencia no sysout então invoca-lo junto do parametro não muda o retorno no console /Mesmo que a referencia "cc" que está referenciando um objeto do tipo "ContaCorrente" seja do tipo "Object" o método chamado sempre vai ser o da ContaCorrente 
		System.out.println(cp); //O método "println" consegue receber qualquer tipo de referencia, além dos tipos primitivos ele também pode receber qualquer tipo de referencia criada pelo dev sem ter que mexer em seu código fonte por ela receber um parametro do tipo "Object"
		
		println(cliente); //Graças ao parametro bem genérico do nosso método criado ele consegue receber qualquer tipo de objeto, até mesmo o Cliente
	}
	
	static void println() {
		
	}
	
	static void println(int a) {
		
	}
	
	static void println(boolean valor) {
		
	}
	
	static void println(Object referencia) { //A classe Object é a classe mãe de todos os objetos, qualquer classe que for criada vai ter um pouco de Object então o polimorfismo ataca 
		
	}
	
}
