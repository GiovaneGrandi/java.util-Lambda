package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {
	
	private Conta[] contas; //Criando um atributo para representar um array que armazena dados do tipo Conta
	private int posicaoLivre; //Criando um atributo que servirá para armazenar qual será a próxima posição do array que poderá ser preenchida
	
	public GuardadorDeContas() { //Criando um método que irá invocar um array no código de uma maneira melhor e mais sintática
		this.contas = new Conta[10]; //Toda vez que ele for iniciado será inicializado um novo array, neste caso com 10 posições
		this.posicaoLivre = 0; //Não é necessário passar o valor inicial de zero para o atributo, já que por ele ser int o seu valor default já é zero, porém é interessante deixar isso explícito no código
	}
	
	public void adiciona(Conta ref) { //Criando um método que irá receber uma referencia do tipo Conta como parametro para então adiciona-la dentro do array
		this.contas[this.posicaoLivre] = ref; //Utilizando o atributo "posicaoLivre" para que a referencia sempre seja adicionada em uma posição que não tenha sido ocupada ainda
		this.posicaoLivre++; //Após o método adicionar a referencia dentro do array o contador da posição livre sobe em um para continuar mantendo o fluxo do array
	}
	
	public int getQuantidadeDeElementos() {
		return this.posicaoLivre; //Reutilizando o contador da posicaoLivre como um contador de posições ocupadas no array porque esses números sempre serão iguais, pelo array começar em zero assim que a primeira referencia for adicionada dentro do array a posição livre vai ser a casa 1, que também é a mesma quantidade de casas ocupadas e vai ser assim até o fim do array
	}
	
	public Conta getReferencia(int posicao) { //Criando um método que irá pegar a referencia que está na posição que passarmos como parametro
		return this.contas[posicao]; //Ele irá retornar a referencia que está dentro da casa que for referente ao número passando através da variavel "posicao"
	}

}
