package br.com.bytebank.banco.modelo;


/**
 * Os comentarios especiais (documentacao, tambem chamada de Javadoc) sao incializado com "/**" e eles servem para ajudar na comunicacao na hora de se compartilhar um codigo Java com alguem, por isso e interessante que esses comentarios 
 * Sejam feitos em cima de membros publicos, afinal e eles que serao visiveis pelos outros programadores, um comentario falando sobre um atributo/metodo privado nao faria muito sentido
 * 
 * A classe Conta serve para representar uma conta do Bytebank
 * 
 * @author Giovane Grandi Os comandos com "@" são comandos especiais das anotações que servem para dar diferentes tipos de nformações extras
 */
	//Essas documentações, após criar um Javadoc no menu "project" são mostradas em uma página html que além de conter essas documentações também guarda todas as informações sobre as classes
	//Mais sobre a documentação: para enviar arquivos, seja uma classe ou um pacote inteiro, é necessário transformar os arquivos em um .JAR que serve basicamente como um zip do Java para isso é necessário selecionar o projeto, clicar em "Export" e ir em "Java" e "JAR file" e então ele irá pegar todos os códigos já compilados (Os .class) e transformará em um zip, também é possível exportar a documentação junto desses arquivos
	//Sempre que for utilizar uma biblioteca criada por outra pessoa em seu projeto é uma boa prática armazenar esses arquivos em uma pasta exclusiva para essas bibliotecas, geralmente chamada de "libs"

public abstract class Conta implements Comparable<Conta> { //Transformando a classe Conta em algo abstrato, que apenas pode ser herdada pelas outras contas e nunca pode ser instânciada
	//Adicionando a interface "Comparable" na nossa classe e passando através dos generics que a classe "Conta" irá se comparar com outros objetos do tipo "Conta"
	
	double saldo; 
	private int agencia;			
	private int numero;
	private Cliente titular; //Privando todos os atributos da classe pois eles só devem ser mexidos dentro da classe
	private static int total; //Criando um atributo para medir a quantidade de contas criadas no banco /Usando a palavra chave "static" para definir que aquele atributo não é exclusivo de cada conta, até agora todas as contas tinham um saldo, um numero, uma agencia... Mas com o static o total passa a ser um atributo de todas as contas e não de uma só, agora todas as contas compartilham um único atributo total
	
//	public Conta() { //Criando um construtor generico para poder usalo nas classes filhas
//		
//	}
	
	
	/**
	 * Um construtor para inicializar o objeto do tipo Conta a partir da agencia e numero
	 * 
	 * @param agencia /comandos que informam os parametros recebidos por esse construtor 
	 * @param numero
	 */
	public Conta(int agencia, int numero) { //Criando um construtor para a Conta, assim quando for criada uma new Conta será obrigatório passar os parâmetros desejados e então será executado tudo o que está dentro das chaves junto com a inicialização desse novo objeto
		Conta.total++; //Assim que o construtor rodar ele irá aumentar a contagem de contas criadas /No momento que se tem um atributo estático o "this." não funciona pra ele por não ser um atributo daquela conta específica, agora como o "total" é um atributo da classe Conta ele pode ser referenciado usando o "NomeDaClasse." no caso sendo "Conta."
		
		this.agencia = agencia; //Informando que os atributos da Conta vão receber os parâmetros informados no construtor
		this.numero = numero;
		
//		System.out.println("Estou criando a conta " + this.numero + " da agência " + this.agencia); //Toda vez que uma Conta nova for criada essa mensagem será inicializada
//		System.out.println("O total de contas criadas agora é " + Conta.total);
	}
	//O Java automaticamente te dá um construtor padrão até você definir um você mesmo, porém depois de definir um construtor o Java não aplicará mais o default, caso você precise dele terá que adiciona-lo por conta própria
	
	
	public void deposita(double valor) { 
		this.saldo += valor; 
	}
	
	
	/**
	 * O valor inserido precisa obrigatoriamente ser maior ou igual que o saldo da Conta que está invocando este método 
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException /Informando o tipo de exceção que esse método joga
	 */
	public void saca(double valor) throws SaldoInsuficienteException { //Ao mudar a exceção para checked é necessário avisar o compilador que aqui será jogada uma exceção 
		if(this.saldo < valor) { //É mais comum quando se trabalha com a aplicação de exceções que os if que detectam se tem algo de errado na execução estejam no topo e que depois venha as condições para o código funcionar, assim as exceções são jogadas logo de cara caso algo dê errado 
			throw new SaldoInsuficienteException("O seu saldo é: " + this.saldo + " e o valor tentado retirar foi de: " + valor); //Criando uma exceção e a jogando na mesma linha sem variaveis intermediarias e também adicionando uma mensagem para auxiliar no entendimento do erro
		}
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException { //Mesmo ele recebendo um objeto do tipo generico Conta é possível fazer transferencias entre contas de tipos diferentes
			this.saca(valor); //Não é mais preciso fazer uma verificação nesse método pois o método "saca" acima já faz a verificação, se ele não funcionar a exceção será disparada, se funcionar ele irá para a próxima linha do código desse método e irá executar corretamente a trasnferencia
			destino.deposita(valor);
	}
	
	public double getSaldo() { 
		return this.saldo; 
	}
	
	public int getNumero() { //Criando um método que irá pegar o número da conta e retorna-lo para quem o invoca
		return this.numero;
	}
	
	public void setNumero(int numero) { //Criando um método que servirá para criar um novo número para a conta caso precise no futuro adicionar novos parâmetros para o numero da conta
		if(numero <= 0) {
			System.out.println("Não é permitido números menores ou iguais a 0");
			return;
		}
		this.numero = numero; //Pode usar uma variavel temporária com o mesmo nome do atributo pois ele está sendo apoiado pelo this, então é o número "dessa conta que está chamando" que receberá o numero passado pelo programador
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Não é permitido números menores ou iguais a 0");
			return; //Como esse método é um void e não retorna nada eu apenas uso o return para encerrar a execução do método ao concluir o if
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() { //Usando o "static" pra definir um método para a classe Conta ao invés de suas intâncias, agora ao invés de ter que chamar uma conta qualquer para saber o total de contas podemos ir direto para a classe pedir
		return total;
	}
	//Um método estático só consegue acessar atributos estáticos daquela classe, o getTotal não conseguiria acessar o saldo de alguma conta por exemplo
	
	@Override
	public String toString() { //Criando um método "toString" genérico para ser reaproveitado pelos filhos da classe "Conta"
		return "de número: " + this.getNumero() + " e de agência: " + this.getAgencia() + " tem um saldo de: " + this.getSaldo(); //O dev pode escolher a exibição que ele quiser para determinado objeto utilizando desse método
	}
	
	@Override
	public boolean equals(Object ref) { //Criando um método para verificar se 2 objetos do tipo Conta não apontam para a mesma conta (se tiverem agencia e numero iguais é porque são a mesma conta) /Para isso acabamos sobreescrevendo o método "equals" da classe Object que já tem essa função de comparação porém utilizando os nossos parametros desejados
		Conta conta = (Conta) ref; //Utilizando o cast para passar a referencia do tipo Object que é obrigatória no método para o tipo Conta para poder acessar os métodos dessa classe
		
		if(this.agencia != conta.agencia) { //O operador "!=" é o completo contrário do "==" ele serve para apontar a diferença, nesse caso o if fica "se a agencia dessa conta for diferente da agencia da outra conta, faça o que está aqui dentro"
			return false;
		}
		
		if(this.numero != conta.numero) { //Aqui verificando os numeros das duas contas
			return false;
		}
		
		return true; //Caso o if chegue até aqui é porque as contas são iguais (se elas tiverem algum atributo diferente será retornado false e assim cancelando a execução do if)
	}
	
	@Override
		public int compareTo(Conta outraConta) { //Criando uma "ordem natural" para a classe Conta, a ordem natural serve para ser usada como regra de comparação caso não usemos nenhum comparator para tal
			return Double.compare(this.getSaldo(), outraConta.getSaldo()); //Fazendo a ordem natural das contas através do saldo
		}
	
}

//No atalho "Window" e "Show View" pode ser acessado o "Outline" que serve para listar todos os atributos e métodos de um objeto resumidamente para melhor navegação, também é possível acessar ele pelo atalho no teclado "Ctrl + O" ele irá abrir uma janelinha do Outline para navegar dentro dos objetos com mais facilidade
