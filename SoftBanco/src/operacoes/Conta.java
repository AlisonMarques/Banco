package operacoes;
import java.util.Scanner;

public class Conta {

	static public Scanner leia = new Scanner(System.in);

	public int numConta;
	protected String tipo;
	private String dono;
	private float saldo;
	private boolean status;



	public Conta() {
		this.setSaldo(0);
		this.setStatus(false);
	}

	public void setNumConta(int n) {
		this.numConta = n;
	}

	public int getNumConta() {
		return this.numConta;
	}

	public void setTipo(String t) {
		this.tipo = t;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setDono(String d) {
		dono = d;
	}

	public String getDono() {
		return dono;
	}

	public void setSaldo(float S) {
		saldo = S;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setStatus(boolean S) {
		status = S;
	}

	public boolean getStatus() {
		return status;
	}


	public void menu() {
		boolean sair = true;

		do {
			System.out.println("===================================================================================");
			System.out.println("                  C A I X A  E L E T R Ô N I C O                                   ");
			System.out.println("===================================================================================");
			System.out.println("Seja bem vindo(a) " + this.getDono());
			System.out.println("[1] Dados da Conta");
			System.out.println("[2] - Saldo");
			System.out.println("[3] - Sacar");
			System.out.println("[4] - Depositar");
			System.out.println("[5] - Tranferir");
			System.out.println("[0] - Sair");
			System.out.println("===================================================================================");
			int operacao = leia.nextInt();

			switch(operacao) {
			case 1:
				this.dadosConta();
				break;
				
			case 2:
				this.saldo();
				break;
				
			case 3:
				System.out.println("Valor para saque: R$");
				float valorSaque = leia.nextFloat();
				this.sacar(valorSaque);
				break;
				
			case 4:
				System.out.println("Valor para deposito: R$");
				float valorDeposito = leia.nextFloat();
				this.depositar(valorDeposito);
				break;
				
			case 5:
				System.out.println("Insira a conta para transferência");
				Conta conta = new Conta();
				int numeroConta = Integer.parseInt(leia.nextLine());
				conta.setNumConta(numeroConta);
				System.out.println("Valor para transferência");
				float valorTransferencia = leia.nextFloat();
				this.transferir(conta, valorTransferencia);
				break;
				
			case 0:
				sair = false;
				break;
			default:
				System.out.println("Operação inválida");
			}
		}while(sair);

		System.out.println("Até mais " + this.getDono());
	}

	public void dadosConta(){

		System.out.println("[Conta: " + numConta + ", Tipo: " + tipo + ", Dono: " + dono + ", Saldo: " + saldo + ", Status: " + status); 
	}

	public void saldo() {
		System.out.println("O seu saldo é de R$" + this.getSaldo());
	}

	public void abrirConta(String t) {
		this.setTipo(t);
		this.setStatus(true);
		if ("CC".equals(t)) {
			this.setSaldo(50);
		} else if("CP".equals(t)) {
			this.setSaldo(150);
		}
		System.out.println("Conta aberta aberta com sucesso");
	}

	public void fecharConta() {
		if (this.getSaldo() > 0) {
			System.out.println("A conta não pode ser fechada porque ainda tem dinheiro");
		} else if (this.getSaldo() < 0) {
			System.out.println("Conta não pode ser fechada pois ainda tem débito");
		}else {
			this.setStatus(false);
			System.out.println("Conta fechada com sucesso");
		}
	}

	public void depositar(float v) {
		if (this.getStatus()) {
			this.setSaldo(this.getSaldo() + v);
			System.out.println("Deposito realizado na conta de " + this.getDono());
		} else {
			System.out.println("Impossível depositar em uma conta fechada");
		}

	}

	public void sacar(float v) {
		if (this.getStatus()) {
			if(getSaldo() >= v){
				this.setSaldo(this.getSaldo() - v);
				System.out.println("Saque realizado na conta de " + getDono());
			}else {
				System.out.println("Saldo insuficiente para saque");
			}
		}else{
			System.out.println("Impossível sacar de uma conta fechada");
		}
	}

	public void pagarMensal() {
		int v = 0;
		if (this.getTipo() == "CC") {
			v = 12;
		} else if (getTipo() == "CP") {
			v = 20;
		}
		if (this.getStatus()) {
			this.setSaldo(this.getSaldo() - v);
			System.out.println("Mensalidade paga com sucesso por " + this.getDono());
		}else{
			System.out.println("Impossível pagar uma conta fechada");
		}
	}

	public void transferir(Conta conta, float valor) {
		
		if (this.getSaldo() < valor) {
			System.out.println("Saldo insuficiente para a operação");
		} else {
			this.setSaldo(this.getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
		}
		
	}

}

