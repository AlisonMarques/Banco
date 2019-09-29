package operacoes;

public class Banco {

	public static void main(String[] args) {
		Conta p1 = new Conta();

		p1.setNumConta(1111);
		p1.setDono("Alison");
		p1.abrirConta("CC"); 
		p1.pagarMensal(); 
		//p1.menu();
		p1.fecharConta();
		
		Conta p2 = new Conta();
		p2.setNumConta(101010);
		p2.setDono("Léia");
		p2.abrirConta("CP");
		p2.menu();


		p1.transferir(p2, 33);
		


		//p2.toString();
	}

}
