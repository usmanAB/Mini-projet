
public class Ocean {
	
	int[] plateau;
	
	
	public Ocean()
	{
		this.plateau = new int[25];
		for(int i =0; i<25; i++)
		{
			this.plateau[i]=0;
		}
	}
	
	

	public void creerLigne()
	{
		System.out.println("--------------------------------------------------------------------------------------");
	}
	
	public void creerColonne()
	{
		
		System.out.println("|                |                |                |                |                |");      
		
	}
	
	public void creerCase(int i)
	{
		if(this.plateau[i]==0 || this.plateau[i]==1 )
		{
			System.out.print("       ?        |");
		}
		else if(this.plateau[i]==-1)
		{
			System.out.print("      vide      |");
		}
		else
		{
			System.out.print("     Touché!    |");
		}
	}
		
	public void creerCaseFinale(int i)
	{
		if(this.plateau[i]==0)
		{
			System.out.print("    etait vide  |");
		}
		else if(this.plateau[i]==-1)
		{
			System.out.print("    coup raté   |");
		}
		else if(this.plateau[i]==-2)
		{
			System.out.print("   coup réussi  |");
		}
		else
		{
			System.out.print("       x        |");
		}
	}
		
		
	public void voirTerrain()
	{
		int j=0;
		int nbCase=0;
		
		for(int i=0; i<5; i++)
		{
			creerLigne();
			for(int y=0; y<5;y++)
			{
				if(y==2)
				{
					j=0;
					System.out.print("|");
					while(j<5)
					{
						creerCase(nbCase);
						nbCase++;
						j++;
					}
					System.out.println("");
				}
				else
				{
					creerColonne();
				}
					
			}
			
		}
		creerLigne();
	}
	
	public void voirTerrainFinal()
	{
		
			int j=0;
			int nbCase=0;
			
			for(int i=0; i<5; i++)
			{
				creerLigne();
				for(int y=0; y<5;y++)
				{
					if(y==2)
					{
						j=0;
						System.out.print("|");
						while(j<5)
						{
							creerCaseFinale(nbCase);
							nbCase++;
							j++;
						}
						System.out.println("");
					}
					else
					{
						creerColonne();
					}
						
				}
				
			}
			creerLigne();
		
	}
	
	public void verifierSiFin(Joueur attaque, Joueur def)
	{
		int x=0;
		int i=0;
		while(i<this.plateau.length)
		{
			if(this.plateau[i] == 1)
			{
				x++;
			}
			i++;
		}
		
		if(x==0)
		{
			System.out.println("Vous avez coulé tout les bateaux ! ");
			System.out.println(attaque.pseudo + " gagne !!");
		}
		else
		{
			System.out.println("Il vous reste " + x + " cases à toucher");
		}
		
		if(attaque.bombe==0)
		{
			System.out.println(attaque.pseudo + " n'a plus de bombe");
			System.out.println(def.pseudo + " gagne!!");
		}
			
	}
}
