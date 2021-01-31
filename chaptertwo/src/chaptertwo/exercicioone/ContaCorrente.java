package chaptertwo.exercicioone;

public class ContaCorrente {
	
	Long agencia;
	String conta;
	double saldo;
	String nomeCliente;
	
	public ContaCorrente() { }
	
	public ContaCorrente(Long agencia, String conta, double saldo, String nomeCliente) {
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
		this.nomeCliente = nomeCliente;
	}
	
	public int sacar(double valor) {
		if(valor > this.saldo) {
			return 0;
		}
		this.saldo = this.saldo - valor;
		return 1;
	}
	
	public void depositar(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void imprimir() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("	Agencia..................: " + this.agencia);
		System.out.println("	Conta....................: " + this.conta);
		System.out.println("	Saldo....................: " + this.saldo);
		System.out.println("	Nome do Cliente..........: " + this.nomeCliente);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
