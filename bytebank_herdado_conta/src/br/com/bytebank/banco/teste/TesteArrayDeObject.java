package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayDeObject {

	public static void main(String[] args) {
		Object[] referencias = new Object[5]; //Criando um array ainda mais genérico do qual é capaz de receber qualquer tipo de referencia, seja ela de alguma conta específica, de um cliente e etc
		
		ContaCorrente cc1 = new ContaCorrente(123, 321);
		referencias[0] = cc1;
		
		ContaPoupanca cp1 = new ContaPoupanca(123, 322);
		referencias[1] = cp1;
		
		Cliente cliente = new Cliente();
		referencias[2] = cliente;
		
		System.out.println(referencias[0]);
		System.out.println(referencias[1]);
		System.out.println(referencias[2]);
	}
	
}
