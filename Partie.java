import java.util.Scanner;


public class Partie {
	
	Joueur attaquant;
	Joueur victime;
	Ocean ocean;
	
	
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
			
			System.out.println(j.pseudo + ": Vous allez placer vos bateaux");
			System.out.println("votre bateau de taille " + j.bateau[i].taille + " doit etre placer");
			System.out.println("Voulez vous placer ce bateau à l'horizontale ou à la verticale?");
			do{
			System.out.println("Entrez 'H' pour horizontale ou 'V' pour verticale");
			choix= scanner.next();
			c = choix.charAt(0);
			}while(c != 'h' && c != 'H' & c != 'V' && c != 'v' );
			
			System.out.println("Choisissez maintenant à quelle ligne et quelle colonne le bateau doit commencer");
			if(c == 'h' || c == 'H')
			{
			do{
				
				System.out.println("Ligne (entre 1 et 5): ");
				ligne=scanner.nextInt();
				System.out.println("Colonne (entre 1 et 5): ");
				colonne=scanner.nextInt();
				
		   	}while(ligne < 1 || colonne < 1 || ligne > 5 || colonne > 5 || (colonne-1)+(j.bateau[i].taille) > 5);
			
			}else
			{
				do{
					
					
					ligne=scanner.nextInt();
					System.out.println("Colonne (entre 1 et 5): ");
					colonne=scanner.nextInt();
					
			   	}while(ligne < 1 || colonne < 1 || ligne > 5 || colonne > 5 || ligne+(j.bateau[i].taille) > 5);
			}
			
			x=0;
			
				if(c == 'h' || c =='H')
				{
					while(x < j.bateau[i].taille)
					{
						ocean.plateau[5*(ligne-1)+(colonne-1+x)]=1;
						x++;
					}
				}
				else
				{
					while(x < j.bateau[i].taille)
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
		
		System.out.println("Il est temps de passer à l'attaque pour " + j.pseudo);
		
		
		while(j.bombe>0)
		{
			
			lancerUneBombe(j);
			j.bombe--;
			System.out.println("Il vous reste " + j.bombe + " bombes" );
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
			System.out.println("Touché !");
			ocean.plateau[5*(ligne-1)+(colonne-1)] = -2;
		}
		
		else if(ocean.plateau[5*(ligne-1)+(colonne-1)]==0)
		{
			System.out.println("Raté!");
			ocean.plateau[5*(ligne-1)+(colonne-1)] = -1;
		}
		
		else if(ocean.plateau[5*(ligne-1)+(colonne-1)]==-2)
		{
			System.out.println("Cible déjà touchée ... vous perdez votre bombe");
		}
		else
		{
			System.out.println("Raté!");
		}
	}
	
	
	
}
