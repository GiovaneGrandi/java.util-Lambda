package br.com.bytebank.banco.teste; //Ao declarar um pacote que não existe o eclipse dá 2 opcões, corrigir o pacote para algum que já exista caso tu tenha errado a escrita ou então criar um pacote novo do jeito que foi escrito e mover essa classe para lá automaticamente 

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

//import br.com.bytebank.banco.modelo.*; //A palavra chave "import" serve para importar um pacote específico para ao invé de ter que escrever o FQN da classe apenas chama-la pelo nome simples /O asterisco ao final do comando serve para dizer que ele importa todos os arquivos daquele pacote
//É preciso importar todos os pacotes que forem usados no código, porém um pacote em específico não é necessário a importação, que é o caso do Java.lang (que inclui classes como a String e System) pois por esse pacote ser fundamental para a criação de códigos o Java já o adiciona de forma automatica


public class TesteContas {
	public static void main(String[] args) throws SaldoInsuficienteException { //Agora com o uso dos packages, como os arquivos de classes estão em uma pasta diferente dos arquivos de teste para poder chama-los aqui é necessário apontar "nomeDoPacote.nomeDaClasse" não serve mais usar o nome simples da classe como antes
		ContaCorrente cc = new ContaCorrente(111, 111); //O "Simple Name" (nome simples) é o nome da classe em sí, nesse caso o nome simples dessa classe é "TesteContas"
		cc.deposita(100);											  //Já o "Full Qualified Name" (Nome completo qualificado) ou a sigla FQN é o nome completo da classe acompanhado do seu package de origem, neste caso o FQN dessa clase é "teste.TesteContas"
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200);
		
		cc.transfere(10, cp); //Na hora da transferencia é pedido um objeto do tipo "Conta" mas ele funciona mesmo mandando objetos filhos da conta, como a contapoupança, de novo o polimorfismo está funcionando
		//Ao fazer a transeferencia o método "saca" executado dentro do transfere é o método de quem o está chamando, no caso a contacorrente, por isso a taxa foi aplicada com sucesso, ele poderia chamar o saca generico da conta mas decidiu por chamar do objeto correto
		System.out.println("CC: " + cc.getSaldo());
		System.out.println("CP: " + cp.getSaldo());
	}
}
