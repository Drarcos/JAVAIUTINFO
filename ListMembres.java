import java.util.ArrayList;

public class ListMembres {
	private ArrayList<MembreBibliotheque> Membres;
	
	public ListMembres(){
		Membres = new ArrayList<MembreBibliotheque>();
	}
	public void addMembre (MembreBibliotheque membre){
		Membres.add(membre);
	}
	
	//Mutateur de supression d'un document
	public void supressMembre (MembreBibliotheque membre){
		Membres.remove(membre);
	}
	
	//Obtenir la taille de la liste actuelle
	public int getSizeOf (){
		return Membres.size();
	}
	
	//Obtenir le document à l'indice "indiceDocument"
	public MembreBibliotheque getMembre (int numAbo){
		return Membres.get(numAbo-1);
	}
}
