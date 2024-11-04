package banco;

public class Banco {
	public static void main(String args[]) {
		Conta c1;
		c1 = new ContaNormal();
		c1.setNumero(new String("1654-3"));
		c1.setSaldo(500);
		ContaDebEspecial c2 = new ContaDebEspecial();
		ContaDebEspecial c3 = new ContaDebEspecial(new String("4067-6"),2500,5050);
		
		ContaEstudantil c4 = new ContaEstudantil();
		
		c2.setNumero(new String("4067-6"));
		c2.setSaldo(2500);
		c2.setLimite(1000.67);
		
		c4.setNumero(new String("1234-5"));
		c4.setSaldo(1800);
		c4.setEmprestimo(1000.67);


		
		/*Conta c1;
		c1 = new ContaNormal();
		c1.setNumero(new String("1654-3"));
		c1.setSaldo(500);
		
		ContaDebEspecial c2;
		c2 = new ContaDebEspecial();
		
		ContaDebEspecial c3; 
		c3 = new ContaDebEspecial(new String("4067-6"), 2500, 2500);
		
		c2.setNumero(new String("4067-6"));
		c2.setSaldo(2500);
		c2.setLimite(1000.67);*/
		
		System.out.println("A conta número " + c1.getNumero() + " possui saldo " + c1.getSaldo());
		c1.creditar(1000);
		System.out.println("Após o crédito de R$ 1000,00, a conta número " + c1.getNumero() + 
				" passou a ter saldo " + c1.getSaldo());
		c1.debitar(100);
		System.out.println("Após o débito de R$ 100,00 a conta número " + c1.getNumero() + 
				" passou a ter o saldo de " + c1.getSaldo());
		
		System.out.println("");
		
		System.out.println("A conta número " + c2.getNumero() + " possui saldo " + c2.getSaldo());
		c2.debitar(500);
		System.out.println("A conta número " + c2.getNumero() + "possui saldo " + c2.getSaldo() + " após o denito de R$500,00");
		System.out.println("A conta número " + c2.getNumero() + "possui saldo " + c2.getSaldo() + " e limite de " +
				c2.getLimite());
		c2.setLimite(10000);
		System.out.println("A conta número " + c2.getNumero() + "possui saldo " + c2.getSaldo() + " e o novo limite de" +
				c2.getLimite());
	}
}
