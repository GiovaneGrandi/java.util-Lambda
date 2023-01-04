package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayDeReferencias {

	public static void main(String[] args) { //O array usado no método main é um "array de referencia" por guardar dados de uma classe e não de um tipo primitivo como visto antes
//		ContaCorrente[] contas = new ContaCorrente[5]; //Criando um array que irá guardar referencias do tipo "ContaCorrente"
//		int[] refs = {1,2,3,4,5}; //Os arrays também tem uma forma de inicialização literal assim como as "String" assim informando os valores diretamente sem ter que criar um novo objeto toda vez
		
		Conta[] contas = new Conta[5]; //Criando um array que guarda dados de tipos mais genéricos, assim pode-se guardar no arra tanto "ContaCorrente" quanto "ContaPoupanca"
		
		ContaCorrente cc1 = new ContaCorrente(123, 321); //Criando uma conta para poder inseri-la no array
		contas[0] = cc1; //Adicionando uma referencia do tipo "ContaCorrente" ao nosso array de referencias
		
		ContaPoupanca cc2 = new ContaPoupanca(123, 322);
		cc2.deposita(100);
		contas[1] = cc2; //Colocando uma cópia da referencia cc2 dentro do array
		
		ContaPoupanca ref = (ContaPoupanca) contas[1]; //Mesmo eu passando uma referencia que represente um objeto do tipo ContaPoupanca no array, por ser um array do tipo conta o compilador não compila esse código porque por se tratar de um array do tipo genérico "Conta" ele pode ter tanto ContaCorrente quanto ContaPoupanca então na dúvida ele não executa, porém ao informar usando os () que aquela referencia aponta sim para um objeto de ContaPoupanca então o código compila, isso também é chamado de "type cast"
		//Porém ao usar o cast e os tipos das referencias não baterem acaba sendo lançada uma exceção no console (java.lang.ClassCastException)
		//O cast serve para converter referencias genéricas em referencias mais específicas, então sempre que tiver um array muito genérico, para acessar aquela classe de forma comum é necessário antes usar um cast e guardá-lo em uma referencia para poder chama-la e invocar seus métodos da maneira padrão
		//Ainda sobre o cast: o Java consegue fazer alguns cast automaticamente por exemplo, se guardarmos um "int" dentro de uma variavel de nome "numero" e então usarmos o seguinte código "double valor = numero" as referencias são de tipos diferentes, mas como uma int cabe dentro de uma double o Java faz o cast automaticamente fazendo o código funcionar normalmente
		//Só é necessário fazer o cast em casos como esse do array, onde a referencia "pode ou não ser daquele tipo" e então você avisa o compilador para ter confiança e rodar normalmente, porém se for um cast impossível de ser feito por exemplo colocar uma referencia do tipo Cliente dentro de uma do tipo Conta ele irá imprimir uma exceção, a ClassCastException
		
		System.out.println(contas[0].getNumero()); //Ao chamar o indice do nosso array com a referencia da conta no sysout ele exibe o método "toString" referente a ContaCorrente
		System.out.println(contas[1].getNumero()); //Também é possível acessar os métodos da referencia através do indice do array como nesse exemplo /Basicamente a gente chama o indice desejado e ao estar dentro do indice do array nós usamos o operador "." para então entrar no objeto daquela referencia e executar o método "x"
		System.out.println(ref.getNumero());
//		System.out.println(cc2.getSaldo()); //As duas maneiras de acessar a referencia são válidas afinal são 2 referencias que levam ao mesmo objeto
	}
	
}
