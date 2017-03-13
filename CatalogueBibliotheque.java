import java.util.ArrayList;

public class CatalogueBibliotheque {
	private ArrayList<DocBibliothèque> Documents;
	
	//Constructeur des documents de la arraylist
	public CatalogueBibliotheque(){
		Documents = new ArrayList<DocBibliothèque>();
	}
	
	//Mutateur d'ajout d'un document
	public void addDoc (DocBibliothèque Doc){
		Documents.add(Doc);
	}
	
	//Mutateur de supression d'un document
	public void supressDoc (DocBibliothèque Doc){
		Documents.remove(Doc);
	}
	
	//Obtenir la taille de la liste actuelle
	public int getSizeOf (){
		return Documents.size();
	}
	
	//Obtenir le document à l'indice "indiceDocument"
	public DocBibliothèque getDocument (int indiceDocument){
		if ((indiceDocument<Documents.size())&&(indiceDocument>=0)){
		return Documents.get(indiceDocument);
		}
		else{
			System.out.println ("l'indice du document n'est pas dans la liste");
			return null;
		}
	}
	
	public void infoDocument(DocBibliothèque Doc){
		System.out.print(Doc);
	}
}
