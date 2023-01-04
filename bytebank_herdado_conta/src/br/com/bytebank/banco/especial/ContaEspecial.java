package br.com.bytebank.banco.especial;

import br.com.bytebank.banco.modelo.Conta;

public class ContaEspecial extends Conta {

	public ContaEspecial(int agencia, int numero) {
		super(agencia, numero);
	}
	
	public void AdicionarSaldo(double valor) {
		//super.saldo += valor;
	}

}

//Sobre os modificadores de visibilidade:
//Public - É visto de todos os lugares, dentro ou fora do pacote
//Protected - Só é visto pelos seus filhos
//Package private - (Ao contrário dos outros o package private não tem uma palavra chave, alguma coisa só é package private quando não tem nenhum modificador de visibilidade antes da assinatura) o package private só é visto dentro daquele pacote específico
//Private - Só é visto dentro daquela classe