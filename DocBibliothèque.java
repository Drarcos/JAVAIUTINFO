public class DocBibliothèque {
	private String codearchivage;
	private String titre;
	private String auteur;
	private int publication;
	private String Statut;
	static int CurrentEmprunts=0;
	static int CurrentPile=0;
	static int CurrentSectRes=0;
	private MembreBibliotheque Emprunteur;
	private MembreBibliotheque Réserv;

	//Défaut
	public DocBibliothèque(){
		codearchivage="default";
		titre="title";
		auteur="none";
		publication=0000;
		Statut="Disponible";
		Emprunteur=null;
		Réserv=null;	
	}
	// pas défaut
	public DocBibliothèque(String codeDoc, String titreDoc, String auteurDoc, int publicationDoc,String StatutDoc){
		codearchivage=codeDoc;
		titre=titreDoc;
		auteur=auteurDoc;
		publication=publicationDoc;	
		Statut=StatutDoc;
		Emprunteur=null;
		Réserv=null;
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
	
	// Accesseurs Pour un état spécifique -- il est tout de même plus simple de demander directement le statut du document -- ces accesseurs afficheront une phrase.
	public String EstEmprunté(){
		if (Statut=="EmpruntéEmpruntéRéservé"){ 
			 return (titre + " est couramment emprunté et Réservé");
		}
		else if(Statut=="Emprunté"){
			return (titre + "est couramment emprunté");
		}
		else {
			return (titre + " n'est pas emprunté");
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
		if ((Statut=="SectionRéservation")||(Statut=="PileRetour")){
			 return (titre + " est couramment dans une pile ou la section réservation");
		}
		else {
			return (titre + " n'est pas dans une pile ou la section réservation");
		}
	}
	
	//accesseurs relatifs aux membres
	public MembreBibliotheque getEmprunteur() 
	{ 
		if (Emprunteur==null)
		{
		System.out.println( this.gettitre()+ " n'est pas emprunté");
		return Emprunteur;
		}
		return Emprunteur;
	}
	public  MembreBibliotheque getRéserv() 
	{ 
		if (Réserv==null)
		{
		System.out.println(this.gettitre()+ " n'est pas réservé");
		return Réserv;
		
		}
		else
		{
		return Réserv;
		
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
	        return "Code : " + this.codearchivage + ", Titre : " +  this.titre + ", Auteur : " + this.auteur +  ", Année : " + this.publication + ", Statut : " + this.Statut + ", emprunt : "+ this.getEmprunteur() +", réservation : " + this.getRéserv();
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
	
	
	// Disponibilité et statut du document (emplacement physique)
	
	/*public void setStatut(String modStatut){ // Un simple mutateur qui peut contourner les règles
		Statut=modStatut;
	}
	*/
	public void setToDisponible(){
		if (Statut.equals("PileRetour")){ // le livre est replacé sur son emplacement
		Statut="Disponible";
		System.out.println("Replacé dans la bibliothèque avec succès!");
		CurrentPile-=1;
		}
		else{
			System.out.println("Le document n'est pas dans la pile retour !");
		}	
	}
	public void setToEmprunt(MembreBibliotheque membre){
		if(Statut.equals("Disponible")){ 
		System.out.println("Emrpunté avec succès!");
		Statut="Emprunté";
		Emprunteur=membre;
		CurrentEmprunts+=1;
		}
		else if(Statut.equals("SectionRéservation")&&(membre==Réserv)){
			System.out.println("Emrpunté avec succès par le la personne qui l'a réservé!");
			Statut="Emprunté";
			Emprunteur=membre;
			Réserv=null;
			CurrentEmprunts+=1;
			CurrentSectRes-=1;
		}
		else if(Statut.equals("SectionRéservation")&&(membre!=Réserv)){
			System.out.println("Cette personne n'est pas celle qui a réservé le livre !");
		}
		else{
			System.out.println("Le document n'est pas pret à l'emprunt !");
		}	
	}
	public void setToRetour(){
		if(Statut.equals("Emprunté")){ // ne peut pas être Réservé, le statut serait alors "EmpruntéRéservé"
			Statut="PileRetour";
			System.out.println("Rapporté avec succès dans la pile retour!");
			CurrentPile+=1;
			CurrentEmprunts-=1;
			Emprunteur=null;
		}
		else if(Statut.equals("EmpruntéRéservé")){
			Statut="SectionRéservation";
			System.out.println("Rendu. Replacé dans la section réservation avec succès!");
			CurrentSectRes+=1;
			CurrentEmprunts-=1;
			Emprunteur=null;
		}
		else{
			System.out.println("Le document n'est pas en dehors de la bibliothèque !");
		}	
	}
	public void setToReserv(MembreBibliotheque membre){
		if (Statut.equals("Emprunté")){ // Le livre doit être emprunté pour être réservable
			Statut="EmpruntéRéservé";
			System.out.println("Réservé avec succès!");
			Réserv=membre;
		}
		else if (Statut.equals("EmpruntéRéservé")){
			System.out.println("Le document est déja réservé !");
		}
		else{
			System.out.println("Le document n'est pas emprunté, allez donc le prendre par vous meme sur l'étagère !");
		}
	}
	public void CancelReserv(){
		if(Statut.equals("EmpruntéRéservé")){ // annulation
			Statut="Emprunté";
			System.out.println("reservation annulée avec succès (le livre est toujours emrpunté)!");
			Réserv=null;
		}
		else if(Statut.equals("SectionRéservation")) // annulation après retour
		{
			Statut="PileRetour";
			CurrentPile+=1;
			CurrentSectRes-=1;	
			System.out.println("Réservation annulée. Replacé dans la pile retour avec succès!");
			Réserv=null;
		}
		else{
			System.out.println("Le document n'est pas réservé !");
		}
	}
}

