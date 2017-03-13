
public class MembreBibliotheque {
	
	private String nom;
	private String prénom;
	private String numtel;
	private String adresse;
	private int numabo;
	static int derniernumabonne=1;
	//default
	public MembreBibliotheque(){
		nom="sirname";
		prénom="name";		
		numtel="01 02 03 04 05";
		adresse="place";
		numabo=derniernumabonne;
		derniernumabonne+=1;
	}
	//not default
	public MembreBibliotheque(String sirname,String name,String number,String place){
		nom=sirname;
		prénom=name;		
		numtel=number;
		adresse=place;
		numabo=derniernumabonne;
		derniernumabonne+=1;
	}
	//accesseurs
	public String getsirname(){
		return nom;
	}
	public String getname(){
		return prénom;
	}
	public String getnumtel(){
		return numtel;
	}
	public String getplace(){
		return adresse;
	}
	public int getnumabo(){
		return numabo;
	}
	 public String toString() {
	        return this.nom + "," +  this.prénom + "," + this.numtel +  "," + this.adresse + "," + this.numabo;
	    }
}
