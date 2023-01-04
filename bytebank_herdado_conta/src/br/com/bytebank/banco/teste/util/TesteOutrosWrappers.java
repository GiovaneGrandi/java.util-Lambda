package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {
	
	public static void main(String[] args) {
		
		//Os métodos usados para construir um "Wrapper" são basicamente os mesmos independente dos tipos, mudando apenas alguns detalhes
		//Todos os "Wrappers" tem métodos que são muito parecidos uns com os outros
		//Todos os "Wrappers" podem ser construídos da maneira mais simplificada que é "wrapperPrimitivo referencia = umValorPrimitivo" porém tem a maneira mais completa na assinatura da construção que é a usada abaixo
		
		Integer idadeRef = Integer.valueOf(29); //Para fazer o autoboxing de um Integer se usa o "valueOf"
		System.out.println(idadeRef.intValue()); //Para fazer o unboxing de um Integer se usa o "intValue"
		
		Double dRef = Double.valueOf(3.2); //Para fazer o autoboxing de um Double se usa o "valueOf"
		System.out.println(dRef.doubleValue()); //Para fazer o unboxing de um Double se usa o "doubleValue"
		
		Float fRef = Float.valueOf(1.5f); //Para fazer o autoboxing de um Float se usa o "valueOf", com uma diferença que para passar um valor do tipo "Float" é necessário o "f" após o número
		System.out.println(fRef.floatValue()); //Para fazer o unboxing de um Float se usa o "floatValue"
		
		Boolean bRef = Boolean.FALSE; //No Boolean a inserção de valores é um pouco diferente pois como existem apenas dois valores é possível chamar o "Boolean" e então apontar o ".FALSE" ou ".TRUE"
		System.out.println(bRef.booleanValue()); //Para fazer o unboxing de um Integer se usa o "intValue"
		
		Number nRef = Integer.valueOf(29); 
		
		List<Number> lista = new ArrayList<>(); //Parametrizando a lista usando a classe mãe de todos os Wrappers numéricos "Number" para poder criar um array que usa do polimorfismo /Não é necessário informar o parametro (Number) no sinal "<>" da direita, apenas o informa-lo na esquerda já é o suficiente
		lista.add(10); //Adicionando ao array um inteiro
		lista.add(32.6); //Adicionando ao array um double
		lista.add(25.6f); //Adicionando ao array um float
		
	}

}
