import java.lang.reflect.Array;
import java.util.Scanner;


public class Joueur {
	
	String pseudo;
	int bombe;
	Bateau[] bateau;
	
	
	public Joueur()
	{	
		String pseudo;
		System.out.println("Veuillez choisir votre pseudo");
		
		Scanner scanner = new Scanner(System.in);
		pseudo = scanner.nextLine();
		this.pseudo=pseudo;
		
		
		this.bombe= 15;
		this.bateau=new Bateau[4];
		
		for (int i=0; i<4; i++)
		{
			this.bateau[i] = new Bateau(i+1);
		}
	}

	
}
