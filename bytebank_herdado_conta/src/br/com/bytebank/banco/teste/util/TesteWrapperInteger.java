package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {
	
	public static void main(String[] args) {
		
		int idade = 29;
//		Integer idadeRef = new Integer(29); //A classe "Integer" serve para armazenar um inteiro dentro de uma referencia, afinal uma variavel como escrita acima não é uma referencia mas sim uma variavel que é um inteiro, por isso se cria um objeto do tipo "Integer" para poder referenciar o int
		//O construtor desse objeto aparece riscado pois essa não é a maneira certa de se criar um objeto do tipo "Integer"
		Integer idadeRef = Integer.valueOf(29); //Esse é o jeito certo de se criar um "Integer", através do método "valueOf" nós adicionamos o valor inteiro que queremos guardar então o método retorna o construtor do novo objeto já pronto
		Integer inteiro = 29; //Também é possível de crair um "Integer" utilizando essa maneira mais resumida
		
		int valor = idadeRef.intValue(); //Utilizando a referencia para conseguir invocar um método que serve para nos devolver o int que está "embrulhado" nessa referencia, nos permitindo fazer o "unboxing"
		System.out.println(idadeRef.doubleValue()); //Existem métodos dentro da classe "Integer" que são capazes de transformar o valor armazenado dentro da referencia em outros tipos primitivos, nesse caso transformamos nosso Integer em um double, mas também é possível fazer com outros tipos
		
		System.out.println(Integer.MAX_VALUE); //Também existem métodos que servem para informar o número máximo/minímo que um "Integer" pode armazenar
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.SIZE); //Esse método serve para informar o tamanho de um Integer em "bits"
		System.out.println(Integer.BYTES); //Já esse mostra o tamanho em "bytes"
		
		
		String s = args[0]; //Acessando o argumento passado nas configurações de execução através do array que já vem implementado no método main, o "args" que guarda strings
//		Integer numero = Integer.valueOf(s); //Porém como o argumento passado foi um número e o array é do tipo String ese número será devolvido como uma string dentro de aspas, para recebe-lo como um inteiro é preciso criar um novo objeto do tipo "Integer" porém utilizando um método sobrecarregado do "valueOf" que recebe uma String e então consegue passar ele para um int normalmente
		int numero = Integer.parseInt(s); //Porém um outro jeito de executar essa troca é chamando o método "parseInt" que faz essa troca e então armazena o resultado dentro de uma variavel do tipo int
		System.out.println(numero); //Ao exibir a referencia numero o resultado é o 10 que foi inserido nos argumentos porém mesmo ele vindo de um array do tipo String ele foi exibido como um int normal
		
		List<Integer> numeros = new ArrayList<Integer>(); //Parametrizando a lista para que ela só guarde referencias do tipo "Integer" que aramazenam inteiros
		numeros.add(29); //As listas só são capazes de armazenar referencias, elas não conseguem guardar nenhum tipo primitivo, porém o Java na atual versão dá uma força e faz um objeto do tipo "Integer" automaticamente ao adicionar um inteiro na lista, então é possível passar como parametro uma referencia que guarda um inteiro, o valor inteiro por si só e uma referencia do tipo "Integer" que todos resultados darão na mesma
		//Essa técnica que o Java usa para automaticamente transformar um valor primitivo em uma referencia para caber na lista é chamada de "Autoboxing" /Além de a técnica contrária também existir, quando se transforma uma referencia em um tipo primitivo se chama "Unboxing"
		//Todos tipos primitivos tem seus representantes em forma de classes para que assim o mundo das listas e das colecttions do Java consigam utilizar os tipos primitivos sem problemas
		//As classe que "embrulham" um tipo primitivo em uma referencia são chamadas de "Wrappers"
		//Os métodos "Wrappers" pertencem ao pacote java.lang, por isso não é necessária nenhum tipo de importação para o código funcionar
		
	}

}
