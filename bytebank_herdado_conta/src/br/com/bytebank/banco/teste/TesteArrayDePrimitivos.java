package br.com.bytebank.banco.teste;

public class TesteArrayDePrimitivos {

	public static void main(String[] args) { //Os colchetes "[]" depois do "String" simbolizam um "array", no mundo Java os arrays são declarados informando o tipo de dados que vai estar no array + [], por exemplo: se quiser fazer um array que guarda números terá que invoca-lo assim "int [] nomeDaVariavel"
		int [] idades = new int[5]; //Para criar um novo array o compilador o obriga a informar dentro dos [] do lado direito a quantidade de dados que ele irá guardar /O tamanho de um array é fixo
//		idades [0] = 29; //Inserindo um valor dentro do indice 0 do nosso array /Todos arrays são inicializados com base no valor default do seu tipo de dados
//		idades [1] = 39;
//		idades [2] = 49;
//		idades [3] = 59;
//		idades [4] = 69;
//		int idade1 = idades [2]; //Para acessar uma posição específica do array é necessário invocar a variavel e colocar dentro dos [] o número do índice que você quer ver, nesse caso eu coloquei o resultado dentro de uma variavel para conseguir visualiza-lo através do sysout 
//		
//		System.out.println(idade1);
//		System.out.println(idades.length); //O "length" é um atributo do array que serve para informar o tamanho total do array que o invoca
		
		for(int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
			System.out.println(idades[i]);
		}
	}
	
}
