package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class Teste {
	
	public static void main(String[] args) {
		
        Conta cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);

        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);
        
//        lista.sort( (c1, c2) -> Integer.compare(c1.getNumero(), c2.getNumero()) ); //É possível resumir ainda mais aquela classe anonima para deixa-la mais legivel, nesse exemplo nós tiramos tudo que estava a esquerda dos parametros de entrada do método (como o "new" o nome do método, o construtor da classe e etc) e essa versão é ainda mais resumida porque como ela tem apenas uma linha de implementação é possível remover o return (ele é feito de maneira implicita) e também removemos as chaves e os tipos dos parametros (afinal uma lista de contas só vai comparar contas, então acaba sendo meio redundante) assim deixando o código em apenas uma linha usando o "->" para informar que isso é um LAMBDA
        
        Comparator<Conta> comp = (Conta c1, Conta c2) -> { //Essa é a maneira de fazer o LAMBDA por extenso sem aqueles cortes acima, aqui mantivemos os tipos dos parametros, as chaves e o return, não se esquecendo do "->"
        		String nomeC1 = c1.getTitular().getNome(); 
        		String nomeC2 = c2.getTitular().getNome();  
        		return nomeC1.compareTo(nomeC2); 
        };
        
        lista.sort(comp);
        
        lista.forEach( (conta) -> System.out.println(conta + ", nome do titular: " + conta.getTitular().getNome()) ); //Seguindo a mesma lógica de "é mais sintático que a lista cuide da própria organização sem classes externas" podemos criar um laço utilizando a própria lista invocando o método "forEach" e nele aplicamos um LAMBDA para passar o comportamento das iterações do laço
        //Com o código assim a legibilidade fica mais ou menos assim "Para cada item (que são uma conta) faça isso: sysout...
		
	}
}