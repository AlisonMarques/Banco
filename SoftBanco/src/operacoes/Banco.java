package operacoes;

public class Banco {
  
    public static void main(String[] args) {
        Conta p1 = new Conta();
        
        p1.setNumConta(1111);
        p1.setDono("Alison");
        p1.abrirConta("CC"); 
        
        p1.pagarMensal(); 
        //System.out.println(p1.toString());
        p1.menu();
        
        Conta p2 = new Conta();
        p2.setNumConta(101010);
        p2.setDono("Léia");
        p2.abrirConta("CP");
        
       
        
        
        
        p1.fecharConta();
        
       
        p2.toString();
    }
    
}
