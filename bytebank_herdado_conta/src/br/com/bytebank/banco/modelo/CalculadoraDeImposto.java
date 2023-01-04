//package modelo; //No Java é obrigatório que a primeira linha de código (sem contar os comentários) seja a declaração de qual pacote (package) está guardando esse código /Os packages basicamente são as pastas que deixam os códigos organizandos evitando-os de ficarem amontoados no mesmo lugar
package br.com.bytebank.banco.modelo; //O padrão utilizado em nomes de pacotes é esse é utilizado o padrão parecido com de um site só que invertido então para uma empre do brasil criar o seu código ficaria assim "br.com.nomeDaEmpresa.nomeDoProjeto.nomeDoPacote.nomeSimplesDaClasse"
 //Esse modelo de nomenclatura adotado para os pacotes é usado para que um programador ao pegar um código feito por outra pessoa não acabe esbarrando em pacotes ou classes de nomes iguais, com essa especificação nos nomes do pacote torna muito dificil que 2 empresas diferentes tenham os mesmos nomes nas classes

public class CalculadoraDeImposto {
	
	private double totalImposto;
	
	public void registra(Tributavel tributavel) { //Método que recebe qualquer objeto que seja um Tributavel
		double valor = tributavel.getValorImposto(); //Percorrendo pela classe desse tributavel e invocando o método "getValorImposto"
		this.totalImposto += valor;
	}
	
	public double getTotalImposto() {
		return totalImposto;
	}
	
}
