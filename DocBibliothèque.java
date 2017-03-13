public class DocBiblioth�que {
	private String codearchivage;
	private String titre;
	private String auteur;
	private int publication;
	private String Statut;
	static int CurrentEmprunts=0;
	static int CurrentPile=0;
	static int CurrentSectRes=0;
	private MembreBibliotheque Emprunteur;
	private MembreBibliotheque R�serv;

	//D�faut
	public DocBiblioth�que(){
		codearchivage="default";
		titre="title";
		auteur="none";
		publication=0000;
		Statut="Disponible";
		Emprunteur=null;
		R�serv=null;	
	}
	// pas d�faut
	public DocBiblioth�que(String codeDoc, String titreDoc, String auteurDoc, int publicationDoc,String StatutDoc){
		codearchivage=codeDoc;
		titre=titreDoc;
		auteur=auteurDoc;
		publication=publicationDoc;	
		Statut=StatutDoc;
		Emprunteur=null;
		R�serv=null;
	}
	//accesseurs
	public String getcode(){
		return codearchivage;
	}
	public String gettitre(){
		return titre;
	}
	public String getauteur(){
		return auteur;
	}
	public int getpublication(){
		return publication;
	}
	public String getStatut(){
		return Statut;
	}
	
	// Accesseurs Pour un �tat sp�cifique -- il est tout de m�me plus simple de demander directement le statut du document -- ces accesseurs afficheront une phrase.
	public String EstEmprunt�(){
		if (Statut=="Emprunt�Emprunt�R�serv�"){ 
			 return (titre + " est couramment emprunt� et R�serv�");
		}
		else if(Statut=="Emprunt�"){
			return (titre + "est couramment emprunt�");
		}
		else {
			return (titre + " n'est pas emprunt�");
		}
	}
	public String EstDisponible(){
		if (Statut=="Disponible"){
			 return (titre + " est couramment disponible");
		}
		else {
			return (titre + " n'est pas disponible, raison : Statut= "+ Statut);
		} 
	}
	public String EstDansUnePile(){
		if ((Statut=="SectionR�servation")||(Statut=="PileRetour")){
			 return (titre + " est couramment dans une pile ou la section r�servation");
		}
		else {
			return (titre + " n'est pas dans une pile ou la section r�servation");
		}
	}
	
	//accesseurs relatifs aux membres
	public MembreBibliotheque getEmprunteur() 
	{ 
		if (Emprunteur==null)
		{
		System.out.println( this.gettitre()+ " n'est pas emprunt�");
		return Emprunteur;
		}
		return Emprunteur;
	}
	public  MembreBibliotheque getR�serv() 
	{ 
		if (R�serv==null)
		{
		System.out.println(this.gettitre()+ " n'est pas r�serv�");
		return R�serv;
		
		}
		else
		{
		return R�serv;
		
		}
	}
	public static int getPile() {
		return CurrentPile;
	}
	public static int getEmprunts() {
		return CurrentEmprunts;
	}
	public static int getSectRes() {
		return CurrentSectRes;
	}
	// To string
	 public String toString() {
	        return "Code : " + this.codearchivage + ", Titre : " +  this.titre + ", Auteur : " + this.auteur +  ", Ann�e : " + this.publication + ", Statut : " + this.Statut + ", emprunt : "+ this.getEmprunteur() +", r�servation : " + this.getR�serv();
	    }
	//mutateurs
	public void setcode(String modcode){
		codearchivage=modcode;
	}
	public void settitre(String modtitre){
		titre=modtitre;
	}
	public void setauteur(String modauteur){
		auteur=modauteur;
	}
	public void setpublication(int modpublic){
		publication=modpublic;
	}
	
	
	// Disponibilit� et statut du document (emplacement physique)
	
	/*public void setStatut(String modStatut){ // Un simple mutateur qui peut contourner les r�gles
		Statut=modStatut;
	}
	*/
	public void setToDisponible(){
		if (Statut.equals("PileRetour")){ // le livre est replac� sur son emplacement
		Statut="Disponible";
		System.out.println("Replac� dans la biblioth�que avec succ�s!");
		CurrentPile-=1;
		}
		else{
			System.out.println("Le document n'est pas dans la pile retour !");
		}	
	}
	public void setToEmprunt(MembreBibliotheque membre){
		if(Statut.equals("Disponible")){ 
		System.out.println("Emrpunt� avec succ�s!");
		Statut="Emprunt�";
		Emprunteur=membre;
		CurrentEmprunts+=1;
		}
		else if(Statut.equals("SectionR�servation")&&(membre==R�serv)){
			System.out.println("Emrpunt� avec succ�s par le la personne qui l'a r�serv�!");
			Statut="Emprunt�";
			Emprunteur=membre;
			R�serv=null;
			CurrentEmprunts+=1;
			CurrentSectRes-=1;
		}
		else if(Statut.equals("SectionR�servation")&&(membre!=R�serv)){
			System.out.println("Cette personne n'est pas celle qui a r�serv� le livre !");
		}
		else{
			System.out.println("Le document n'est pas pret � l'emprunt !");
		}	
	}
	public void setToRetour(){
		if(Statut.equals("Emprunt�")){ // ne peut pas �tre R�serv�, le statut serait alors "Emprunt�R�serv�"
			Statut="PileRetour";
			System.out.println("Rapport� avec succ�s dans la pile retour!");
			CurrentPile+=1;
			CurrentEmprunts-=1;
			Emprunteur=null;
		}
		else if(Statut.equals("Emprunt�R�serv�")){
			Statut="SectionR�servation";
			System.out.println("Rendu. Replac� dans la section r�servation avec succ�s!");
			CurrentSectRes+=1;
			CurrentEmprunts-=1;
			Emprunteur=null;
		}
		else{
			System.out.println("Le document n'est pas en dehors de la biblioth�que !");
		}	
	}
	public void setToReserv(MembreBibliotheque membre){
		if (Statut.equals("Emprunt�")){ // Le livre doit �tre emprunt� pour �tre r�servable
			Statut="Emprunt�R�serv�";
			System.out.println("R�serv� avec succ�s!");
			R�serv=membre;
		}
		else if (Statut.equals("Emprunt�R�serv�")){
			System.out.println("Le document est d�ja r�serv� !");
		}
		else{
			System.out.println("Le document n'est pas emprunt�, allez donc le prendre par vous meme sur l'�tag�re !");
		}
	}
	public void CancelReserv(){
		if(Statut.equals("Emprunt�R�serv�")){ // annulation
			Statut="Emprunt�";
			System.out.println("reservation annul�e avec succ�s (le livre est toujours emrpunt�)!");
			R�serv=null;
		}
		else if(Statut.equals("SectionR�servation")) // annulation apr�s retour
		{
			Statut="PileRetour";
			CurrentPile+=1;
			CurrentSectRes-=1;	
			System.out.println("R�servation annul�e. Replac� dans la pile retour avec succ�s!");
			R�serv=null;
		}
		else{
			System.out.println("Le document n'est pas r�serv� !");
		}
	}
}

