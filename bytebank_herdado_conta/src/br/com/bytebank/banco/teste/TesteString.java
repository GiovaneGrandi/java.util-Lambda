package br.com.bytebank.banco.teste;

public class TesteString {

	public static void main(String[] args) {
		String vazio = " ";
		String outroVazio = vazio.trim(); //O método "trim" serve para remover os espaços no início e fim de uma string
		
		String espacado = "   Alura   ";
		String semEspaco = espacado.trim(); //Usando o trim para remover os espaços no inicio e no fim da string
		System.out.println(espacado.contains("Alu")); //O "contains" serve para você perguntar se aquela string contém o que você passar de parametro, seja uma string ou substring, nesse caso como a String espacado contém os caracteres "Alu" o retorno é true
		System.out.println(semEspaco);
		
//		System.out.println(outroVazio.isEmpty()); //O Java entende o espaço como um caractere portanto em situações normais uma string que só tem espaço seria considerada uma string preenchida, porém utilizando o método trim ela passa a ser vazia novamente
//		System.out.println(vazio.isEmpty()); //O método "isEmpty" serve para perguntar ao Java se aquela string está vazia ou não, esse método retorna um boolean, vazia = true, não está vazia = false
		
		int a = 3; //Um int, ou os tipos primitivos no geral não são capazes de usar métodos, o código "a.algumaCoisa" iria dar erro de compilação, já o objeto "nome" do tipo String por ser uma classe padrão ela consegue invocar métodos /A sintaxe de escrita de uma variavel do tipo primitivo e um objeto do tipo String é a mesma
		String nome = "Alura"; //Essa forma de escrever um novo objeto do tipo String também é chamado de "object literal" /Quando uma string é criada ela nasce e morre daquele jeito, a string que está sendo referenciada é imutável
		String outroNome = new String("Alura"); //Por a String ser uma classe ela também tem uma referencia na qual podemos guardar um objeto (uma string também é um objeto) porém não precisamos usar todos os comandos padrões de quando se cria um novo objeto (o comando "new" + "nomeDaClasse()") por ser mais prático, embora funcione desses 2 jeitos utilizar esse método mais completo e formal é considerado uma má prática
		
		String nome2 = nome.replace("Al", "aL"); //Por a string ser imutável ao utilizar o método "replace" ele não muda a string já existente, ele cria uma nova string que contenha as mudanças desejadas, então é necessário criar uma nova referencia para armaenar essa nova string para então conseguir efetuar as mudanças desejadas nela com sucesso
		String nome3 = nome.replace('a', 'A'); //Existem 2 tipos de "replace" o e cima pode substituir uma sequencia de caracteres e o de beixo só é capaz de mudar um único caractére, porém utilizando aspas simples, no mundo Java as aspas simples são usadas para indicar um único caractére
		
		//nome.toLowerCase(); //Comando para deixar o objeto desejado apenas com letras minusculas
		
//		System.out.println(nome);
//		System.out.println(nome2);
//		System.out.println(nome3);
		
		char c = nome.charAt(0); //O método "charAt" é usado para mostrar qual caractére está naquela posição da string, porém no Java o primeiro caractére sempre está na posição 0, portanto o caractere na posição 2 na verdade é a terceira letra da string /Uma string que faz parte de uma outra também é chamada de "Sub-String"
//		System.out.println(c);
		
		int pos = nome.indexOf("ur"); //O método "indexOf" que recebe uma string serve para informar em que posição essa string passada está no objeto string que a invocou, nesse caso a string "ur" começa na posição 2 da string "Alura" 
//		System.out.println(pos);
		
		String sub = nome.substring(1); //O método "substring" serve para criar uma substring da string desejada de forma automática apenas informando a partir de qual posição essa substring irá começar
//		System.out.println(sub);
		
//		System.out.println(nome.length()); //O método "length" serve para informar quantos caracteres existem na string informada, no caso da string na referencia "nome" existem 5 caracteres
		
//		for(int i = 0; i < nome.length(); i++) {
//			System.out.println(nome.charAt(i)); //Utilizando os métodos da String para fazer um laço onde ele irá fazer um contador subir até a posição de todos os caracteres da string e então irá exibindo eles no console, um de cada vez 
//		}
	}
	
}

//Sempre que eu quiser pesquisar alguma classe e seus métodos é interessante entrar nos javadocs oficiais que contém todas funcionalidades da classe "x"