package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteClasseAnonima {
	
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
        
//        NumeroDaContaComparator2 comparador = new NumeroDaContaComparator2(); //Quando se usa uma classe para apenas um funcção especifica (que nesse caso é apenas para pasa-la como parametro no "sort") essa classe é chamada de "Funtion Object" onde ela só serve para encapsular uma função, e isso é uma motivação muito fraca para criar uma classe inteira para realizar apenas isso, por isso existe uma maneira mais simples de fazer tudo isso
        lista.sort(new Comparator<Conta>() { //Essa sintaxe é chamada de "classe anônima", ao invés de criar uma classe nova para apenas usa-la de parametro aqui, é mais fácil criar uma classe já dentro dos parametros do método "sort", aqui nós passamos que é um novo objeto que implementa a interface "Comparator" e então sobreescrevemos o seu método logo abaixo
        	@Override //Ao criar uma classe anonima é possível ve-la nos arquivos bin do compilador como "Teste$1" por nós iniciarmos esse novo objeto sem um nome o próprio compilador dá um nome aleatório a ele
        	public int compare(Conta c1, Conta c2) {
        		return Integer.compare(c1.getNumero(), c2.getNumero()); 
        	}
        }); //Aqui se fecha o comando do método "sort" o que era pra ser uma assinatura de uma linha só acaba se extendendo um pouco porém poupando de ter que criar uma nova classe do zero
        
        Comparator<Conta> comp = new Comparator<Conta>() { //Aqui ao invés de criarmos a função anonima direto como parametro como no exemplo a cima, aqui nós estamos guardando-a em uma referencia
        	@Override
        	public int compare(Conta c1, Conta c2) { //Aqui implementamos o método do mesmo jeito que seria em uma classe separada porém de uma maneira muito mais enxuta
        		String nomeC1 = c1.getTitular().getNome(); 
        		String nomeC2 = c2.getTitular().getNome();  
        		return nomeC1.compareTo(nomeC2); 
        	}
        }; //Aqui se fecha a linha de comando
        //Com essas 2 classes anonimas nós não precisamos mais criar classes para usarmo em apenas um lugar no código e nos tomar tempo de desenvolvimento para desenvovler uma classe inteira para apenas executar uma função porém a legibilidade do código piora por ser um código muito grande e difícil de se entender        
        
        for (Conta conta : lista) { 
			System.out.println(conta + ", nome do titular: " + conta.getTitular().getNome()); 
		}
		
	}
}

//Jeito antigo que usamos para criar o comparator dos nomes:

//class TitularDaContaComparator2 implements Comparator<Conta> { 
//
//	@Override
//	public int compare(Conta c1, Conta c2) {
//		
//		String nomeC1 = c1.getTitular().getNome(); 
//		String nomeC2 = c2.getTitular().getNome();  
//		return nomeC1.compareTo(nomeC2); 
//		
//	}
//	
//}

//Jeito atigo que usamos para criar o comparator dos números:

//class NumeroDaContaComparator2 implements Comparator<Conta> { 
//
//	@Override
//	public int compare(Conta c1, Conta c2) {
//		return Integer.compare(c1.getNumero(), c2.getNumero()); 
//	}
//	
//}