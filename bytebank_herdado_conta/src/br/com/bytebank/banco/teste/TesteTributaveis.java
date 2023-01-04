package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.CalculadoraDeImposto; //Ao usar o atalho "Ctrl + Shift + O" o eclipse irá fazer os imports de todas as classes chamadas nesse código
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SeguroDeVida; //Além de importar utilizando o "*" para importar todas as classes daquele pacote também é possível importar classes específicas para não importar classes das quais não serão usadas

public class TesteTributaveis {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.deposita(100);
		
		SeguroDeVida seguro = new SeguroDeVida();
		
		CalculadoraDeImposto calc = new CalculadoraDeImposto();
		calc.registra(cc);
		calc.registra(seguro);
		
		System.out.println(calc.getTotalImposto());
		
	}
	
}
