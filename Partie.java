import java.util.Scanner;


public class Partie {
	
	private Joueur attaquant;
	private Joueur victime;
	private Ocean ocean;
	
	
	public Joueur getAttaquant() {
		return attaquant;
	}

	public void setAttaquant(Joueur attaquant) {
		this.attaquant = attaquant;
	}

	public Joueur getVictime() {
		return victime;
	}

	public void setVictime(Joueur victime) {
		this.victime = victime;
	}

	public Ocean getOcean() {
		return ocean;
	}

	public void setOcean(Ocean ocean) {
		this.ocean = ocean;
	}

	public Partie()
	{
		this.attaquant = new Joueur();
		this.victime = new Joueur();
		this.ocean = new Ocean();
		
	}
	
	public void placerBateau(Joueur j)
	{
		int x=0;
		int ligne;
		int colonne;
		Scanner scanner= new Scanner(System.in);
		String choix;
		char c;
		
		for(int i=0; i<4; i++)
		{
			
			System.out.println(j.getPseudo() + ": Vous allez placer vos bateaux");
			System.out.println("votre bateau de taille " + j.getBateau(i).getTaille() + " doit etre placer");
			System.out.println("Voulez vous placer ce bateau � l'horizontale ou � la verticale?");
			do{
			System.out.println("Entrez 'H' pour horizontale ou 'V' pour verticale");
			choix= scanner.next();
			c = choix.charAt(0);
			}while(c != 'h' && c != 'H' & c != 'V' && c != 'v' );
			
			System.out.println("Choisissez maintenant � quelle ligne et quelle colonne le bateau doit commencer");
			if(c == 'h' || c == 'H')
			{
			do{
				
				System.out.println("Ligne (entre 1 et 5): ");
				ligne=scanner.nextInt();
				System.out.println("Colonne (entre 1 et 5): ");
				colonne=scanner.nextInt();
				
		   	}while(ligne < 1 || colonne < 1 || ligne > 5 || colonne > 5 || (colonne-1)+(j.getBateau(i).getTaille()) > 5);
			
			}else
			{
				do{
					
					
					ligne=scanner.nextInt();
					System.out.println("Colonne (entre 1 et 5): ");
					colonne=scanner.nextInt();
					
			   	}while(ligne < 1 || colonne < 1 || ligne > 5 || colonne > 5 || ligne+(j.getBateau(i).getTaille()) > 5);
			}
			
			x=0;
			
				if(c == 'h' || c =='H')
				{
					while(x < j.getBateau(i).getTaille())
					{
						ocean.plateau[5*(ligne-1)+(colonne-1+x)]=1;
						x++;
					}
				}
				else
				{
					while(x < j.getBateau(i).getTaille())
					{
						ocean.plateau[5*(ligne-1+x)+(colonne-1)]=1;
						x++;
					}
				}
				
				
		 }
		for(int a=0;a<30; a++)
		{
			System.out.println("");
		}
		
	
	}
	
	public void lancerBombeS(Joueur j)
	{
		
		System.out.println("Il est temps de passer � l'attaque pour " + j.getPseudo());
		
		
		while(j.getBombe()>0)
		{
			
			lancerUneBombe(j);
			j.setBombe(j.getBombe()-1);
			System.out.println("Il vous reste " + j.getBombe() + " bombes" );
			ocean.verifierSiFin(attaquant, victime);
			ocean.voirTerrain();

		}
		ocean.voirTerrainFinal();
	}

	
	public void lancerUneBombe(Joueur j)
	{
		Scanner scanner = new Scanner(System.in);
		int ligne=0;
		int colonne=0;
		
		
		System.out.println("choisissez la zone que vous voulez attaquer avec votre bombe");
		
		do{
		System.out.println("Ligne (entre 1 et 5): ");
		ligne = scanner.nextInt();
		}while(ligne > 5 || ligne < 1);
		
		do{
			System.out.println("Colonne (entre 1 et 5): ");
			colonne = scanner.nextInt();
		}while(colonne > 5 || colonne < 1);
		
		if(ocean.plateau[5*(ligne-1)+(colonne-1)]==1)
		{
			System.out.println("Touch� !");
			ocean.plateau[5*(ligne-1)+(colonne-1)] = -2;
		}
		
		else if(ocean.plateau[5*(ligne-1)+(colonne-1)]==0)
		{
			System.out.println("Rat�!");
			ocean.plateau[5*(ligne-1)+(colonne-1)] = -1;
		}
		
		else if(ocean.plateau[5*(ligne-1)+(colonne-1)]==-2)
		{
			System.out.println("Cible d�j� touch�e ... vous perdez votre bombe");
		}
		else
		{
			System.out.println("Rat�!");
		}
	}
	
	
	
}
