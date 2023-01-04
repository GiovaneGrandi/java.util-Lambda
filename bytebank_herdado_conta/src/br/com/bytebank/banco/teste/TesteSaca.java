package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta; //A ordem do código sempre é essa "primeiro mais em cima o pacote, logo abaixo os imports e aí por último que começa a classe"
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteSaca {
	
	public static void main(String[] args) {
		Conta conta = new ContaCorrente(123, 123);
		
		conta.deposita(200);
		
		try {
			conta.saca(210);
		} catch (SaldoInsuficienteException ex) { //Criando um tratamento para a exceção no código, mesmo que a exceção seja do tipo "Runtime" e não exija tratamento é possível trata-la para que o fluxo do código não mude
			System.out.println(ex.getMessage()); //Com a exceção sendo do tipo "Exception" é origatório um tratamento para o código compilar, seja um aviso de perigo na assinatura do método através do "throws" ou de um bloco try catch para pegar a exceção e manter o fluxo original do código
		}
		
		System.out.println(conta.getSaldo());
		//Sobre o sysout:
		//O "System" é uma classe que faz parte do pacote java.lang e também tem acesso público por isso pode ser usado em qualquer lugar
		//O "out" é um atributo da classe "System" que também é públic, podendo ser acessado de qualquer lugar e é uma referencia, além de ser um atributo "static" por isso ele é chamado usando a classe como sujeito e não uma referencia do tipo System, um atributo static é um atributo que pertence ao tipo da classe e não a um objeto individual
		//O "println" é um método público, por isso pode ser acessado de qualquer lugar, ele não é static por ser individual para cada objeto e ser invocado por uma referencia e não uma classe, e é um método que tem sobrecarga (tem diversos atributos iguais a ele porém que mudam os parametros que podem ser recebidos) para que assim ele funcione com qualquer tipo de input
	}

}
