package br.com.bytebank.banco.teste.util;

import java.util.LinkedList;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteLinkedList {
	
	public static void main(String[] args) {
		
		LinkedList<Conta> lista = new LinkedList<Conta>(); //A classe "LinkedList" é uma alternativa a "ArrayList" para quem vai apenas iterar a sequencia de referencias a "ArrayList" é perfeita por conceder acesso direto as referencias para o usuario, porém para remover elementos que estão localizados mais ao meio da sequencia é muito custoso para o "ArrayList" por exigir um rearranjo na sequencia /Todas as listas aceitam duplicadas, ou seja, é possível colocar várias vezes a mesma referencia na mesma sequencia, por isso existe o método para saber se aquela referencia já existe na sequencia, assim evitando duplicatas
		//Já a "LinkedList" é melhor para aqueles que vão remover e editar muito a sequencia por ela ter um sistema onde cada casa lembra qual é a referencia anterior a ela e próxima, para editar e remover referencias do meio da sequencia é ótimo, porém a iteração não é um ponto forte dessa list por ela sempre ter que começar do início, não é possível acessar elementos que estão no meio da lista de forma direta
		//Além do mais, essas 2 classes dividem os mesmos métodos então a execução do código é identica para as duas classes, só mudando a assinatura e a classe que precisa ser importada do "java.util" /Essa semelhança se dá porque as 2 classes assinam um contrato com a interface "List" do java.util que exige esses métodos 
		//Também existe um terceiro tipo de lista, o "Vector" que é basicamente a primeira versão do "ArrayList" porém a principal diferença entre os dois é que o "Vector" é o que chamamos de "threadsafe" (ele consegue compartilhar uma lista entre diversas pilhas caso seja criado vários métodos mains pelo dev) porém ele tem um desempenho muito travado em relação ao "ArrayList" então só é recomendavel usar essa lista em caso de múltiplas pilhas
		
		Conta cc1 = new ContaCorrente(123, 111);
		lista.add(cc1); 
		
		Conta cc2 = new ContaCorrente(123, 222);
		lista.add(cc2);
		
		System.out.println("Tamanho atual do array: " + lista.size()); 
		
		Conta ref = lista.get(0); 
		
		System.out.println(ref);
		
		lista.remove(1); 
		
		System.out.println("Tamanho atual do array: " + lista.size());	
		
		Conta cc3 = new ContaCorrente(321, 333);
		lista.add(cc3); 
		
		Conta cc4 = new ContaCorrente(321, 444);
		lista.add(cc4);
				
		for(Conta conta : lista) { 
			System.out.println(conta);
		}
		
	}

}
