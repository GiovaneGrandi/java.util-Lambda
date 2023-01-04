package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteOrdenacao {
	
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
        
        for (Conta conta : lista) { //Ao digitar "foreach" e pressionar o "Ctrl + espaço" ele autocompleta para o for usado nas listas
			System.out.println(conta + ", nome do titular: " + conta.getTitular().getNome()); //Um laço antes da organização da lista
		}
        
//        NumeroDaContaComparator comparador = new NumeroDaContaComparator();
//        TitularDaContaComparator titularComparator = new TitularDaContaComparator(); //Essa maneira de declarar novos comparators não é muito usada, é mais sintático declarar eles diretamente nos parenteses do método de comparação como no exemplo abaixo:
        lista.sort(new NumeroDaContaComparator()); //O método "sort" serve para organizar a lista e como parametro para isso ele recebe um "comparator" que precisa ser criado pelo dev para que ele implemente a organização desejada
        
//        Collections.sort(lista, new NumeroDaContaComparator()); //Essa era a forma antiga de se organizar listas, se delegava para uma outra classe fazer isso, a classe "Collections" que pertence ao java.util e então passamos como parametro a lista que queremos organizar e qual o comparator
        Collections.sort(lista); //Também existe esse método de comparação que só recebe a lista e não recebe nenhum comparator porque com esse método é aplicada a ordem natural de determinada classe (se a classe não tiver uma ordem natural definida o código não compilará)
//        Collections.shuffle(lista); //Essa classe também tem outros métodos como o de emabaralhar a lista
//        Collections.reverse(lista); //E de deixar a lista em uma ordem ao contrário
        
        System.out.println("---------------");
        
        for (Conta conta : lista) { 
			System.out.println(conta + ", nome do titular: " + conta.getTitular().getNome()); //Um laço depois da organização da lista
		}
		
	}

}

class TitularDaContaComparator implements Comparator<Conta> { //Criando mais um comparador de contas porém que dessa vez compara os nomes dos titulares

	@Override
	public int compare(Conta c1, Conta c2) {
		
		String nomeC1 = c1.getTitular().getNome(); //Guardando o nome dos titulares das contas em uma referencia do tipo String
		String nomeC2 = c2.getTitular().getNome(); //Acessando o Cliente que foi linkado a conta através do atributo titular e ao conseguir acessar o método que retorna o titular eu acesso o método do Cliente que retorna o nome, através dos "." eu consigo percorrer pelas classes 
		return nomeC1.compareTo(nomeC2); //O método "compareTo" é um método da classe String que já faz a comparação em ordem alfabética automaticamente implementando a mesma lógica númerica do comparator de baixo (primeiro número menor que o segundo retorna negativo.....)
		
	}
	
}

class NumeroDaContaComparator implements Comparator<Conta> { //Assinando um contrato com a interface "Comparator" que serve para comparar objetos, nesse caso nós parametrizamos para comparar contas como consta no "<>"

	@Override
	public int compare(Conta c1, Conta c2) {

		return Integer.compare(c1.getNumero(), c2.getNumero()); //Também é possível chamar o wrapper "Integer" e o seu método "compare" que já implementa essa lógica de comparação
		
//		return c1.getNumero() - c2.getNumero(); //Os ifs abaixo podem ser resumidos nessa linha, fazendo essa operação matemática retornara os números da maneira correta, se o primeiro for menor retornara negativo, se for maior retornara positivo, se forem iguais retornara 0
		
//		if(c1.getNumero() < c2.getNumero()) { //O comparador irá comparar as contas através do seu numero, fazendo assim o posicionamento das contas na lista
//			return -1; //A documentação pede para que caso o primeiro elemento for menor que o segundo é preciso retornar -1
//		}
//		
//		if(c1.getNumero() > c2.getNumero()) {
//			return 1; //Caso o primeiro elemento for maior que o segundo é preciso retornar 1
//		}
//		
//		return 0; //Caso eles sejam iguais é preciso retornar 0
	}
	
	
	
}

//O atalho "Ctrl + Shift + O" serve para fazer todas as importações necessárias no código
