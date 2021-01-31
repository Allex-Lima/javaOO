package chaptertwo.exercicioone;

import java.util.Scanner;

public class PrincipalContaCorrente {
	public final static int TAM = 3;
	ContaCorrente cc[] = new ContaCorrente[TAM];
	public static int indice = 0;
	// atributo utilizado para a pesquisa de uma conta corrente já cadastrada no vetor
	int op;
	public int getOp() {
		return this.op;
	}
	
	public void setOp(int op) {
		/* 
		 * se op for maior ou menor igual a 0 do que o indice cadastrado presenta (posição inválida)
		 * e utiliza a primeira posição como padrão.
		 */
		if(op > indice || op <= 0) {
			System.out.println("Posição inválida");
			this.op = 1;
		} else {
			this.op = op;
		}
	}
	
	public static void main(String[] args) {
		PrincipalContaCorrente obj = new PrincipalContaCorrente();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Consultar");
			System.out.println("9 - Sair");
			System.out.print("Entre com a opção.....: ");
			int opcaoMenu = sc.nextInt();
			
			switch(opcaoMenu) {
			case 1:
				obj.execCadastrar();
				break;
			case 2:
				obj.execDepositar();
				break;
			case 3:
				obj.execSacar();
				break;
			case 4:
				obj.execConsultar();
				break;
			default:
				if(opcaoMenu == 9) {
					System.exit(0);
				}
				System.out.println("Opção inválida.");
			}
		}
	}
	
	public void execCadastrar() {
		if(indice >= TAM) {
			System.out.println("Não há indice vazio");
			System.exit(0);
		}
		
		Scanner sc = new Scanner(System.in);
		this.cc[indice] = new ContaCorrente();
		
		System.out.print("Forneça agencia.............: ");
		this.cc[indice].agencia = sc.nextLong();
		System.out.print("Forneça a conta.............: ");
		this.cc[indice].conta = sc.next();
		System.out.print("Primeiro depósito...........: R$ ");
		this.cc[indice].saldo = sc.nextDouble();
		System.out.print("Forneça nome do cliente.....: ");
		this.cc[indice].nomeCliente = sc.next();
		indice++;
	}
	
	public void execDepositar() {
		if(indice > 0) {
			System.out.print("Qual a posição que devera ser o depósito?.....: ");
			Scanner sc = new Scanner(System.in);
			// setOp valida se a posição digitada esta dentro dos limites.
			setOp(sc.nextInt());
			System.out.print("Valor a ser depositado.....: R$ ");
			double valor = sc.nextDouble();
			// getOp recupera o valor do atributo op após ser validado pelo método setOp.
			this.cc[getOp() - 1].depositar(valor);
			
		} else {
			System.out.println("Nenhuma conta foi cadastrada.");
		}
	}
	
	public void execSacar() {
		if(indice > 0) {
			System.out.println("Qual posição que deseja sacar?.....: ");
			Scanner sc = new Scanner(System.in);
			
			// setOp valida se a posição digitada esta dentro dos limites.
			setOp(sc.nextInt());
			System.out.println("Digite o valor do saque.....: R$ ");
			double valor = sc.nextDouble();
			
			// getOp recupera o valor do atributo op após ser validado pelo método setOp.
			int ret = this.cc[getOp() - 1].sacar(valor);
			if(ret == 0) {
				System.out.println("Saque não realizado...");
			} else {
				System.out.println("Saque realizado...");
			}
		} else {
			System.out.println("Nenhuma conta foi cadastrada.");
		}
	}
	
	public void execConsultar() {
		
		if(indice > 0) {
			System.out.println("Qual posição que deseja o extrato?.....: ");
			Scanner sc = new Scanner(System.in);
			
			setOp(sc.nextInt());
			this.cc[getOp() - 1].imprimir();
		} else {
			System.out.println("Nenhuma conta foi cadastrada.");
		}
	}
}
