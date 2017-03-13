import java.util.ArrayList;

public class CatalogueBibliotheque {
	private ArrayList<DocBiblioth�que> Documents;
	
	//Constructeur des documents de la arraylist
	public CatalogueBibliotheque(){
		Documents = new ArrayList<DocBiblioth�que>();
	}
	
	//Mutateur d'ajout d'un document
	public void addDoc (DocBiblioth�que Doc){
		Documents.add(Doc);
	}
	
	//Mutateur de supression d'un document
	public void supressDoc (DocBiblioth�que Doc){
		Documents.remove(Doc);
	}
	
	//Obtenir la taille de la liste actuelle
	public int getSizeOf (){
		return Documents.size();
	}
	
	//Obtenir le document � l'indice "indiceDocument"
	public DocBiblioth�que getDocument (int indiceDocument){
		if ((indiceDocument<Documents.size())&&(indiceDocument>=0)){
		return Documents.get(indiceDocument);
		}
		else{
			System.out.println ("l'indice du document n'est pas dans la liste");
			return null;
		}
	}
	
	public void infoDocument(DocBiblioth�que Doc){
		System.out.print(Doc);
	}
}
