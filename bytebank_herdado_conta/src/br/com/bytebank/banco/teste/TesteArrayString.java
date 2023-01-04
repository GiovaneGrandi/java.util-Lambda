package br.com.bytebank.banco.teste;

public class TesteArrayString {
	
	public static void main(String[] args) { //O método "main" recebe um array do tipo de String para que seja possível passar argumentos (parametros) para ele através da tela de comando do terminal
		System.out.println("Funcionou!!");
		
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}

//Uma forma de passar argumentos para o código como se fosse em um terminal é selecionar a seta ao lado do botão de executar o código e ir na opção "Run Configurations.." e ir na aba "arguments" na parte superior da tela, assim abrindo um prompt onde os argumentos poderão ser dados e então podem ser executados através do array do tipo String e nesse caso serem adicionados ao laço de repetição do for