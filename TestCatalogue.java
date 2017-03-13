
public class TestCatalogue {

	public static void main(String[] args) {
		// 1 : test de CtalogueBibiltheque
		// FirstTest();
		
		// 2: test de listMembre
		//SecondTest();
	}
	public static void FirstTest(){
		// la mise des premier truc utiles
		DocBibliothèque Doc1 = new DocBibliothèque("004.178K20PM", "Introduction à Java", "J.LEBLANC", 2015,"Disponible");
		DocBibliothèque Doc2 = new DocBibliothèque("967.4987T248O", "Structures de Données", "M.MACHIN", 2017,"Disponible");
		
		//création du catalogueD
		CatalogueBibliotheque CatalogueD = new CatalogueBibliotheque();
		CatalogueD.addDoc(Doc1);
		CatalogueD.addDoc(Doc2);
		System.out.println(CatalogueD.getDocument(0));
		System.out.println(CatalogueD.getDocument(1));
		CatalogueD.supressDoc(Doc2);
		System.out.println(CatalogueD.getDocument(0));
	}
	
	public static void SecondTest(){
		// la mise des premier truc utiles
		MembreBibliotheque M1 = new MembreBibliotheque("Duclou","Paul","06 36 42 69 15","Vilepaumée");
		MembreBibliotheque M2 = new MembreBibliotheque("Rhimbaud","Dash","06 07 08 09 10","Vileponé");
		MembreBibliotheque M3 = new MembreBibliotheque("David","Lafarge","07 08 09 10 11","VileKémone");
		MembreBibliotheque M4 = new MembreBibliotheque("Franck","Honnett","08 09 10 11 12","Vilefranche");
		
		//création du catalogueM
		ListMembres CatalogueM = new ListMembres();
		CatalogueM.addMembre(M1);
		CatalogueM.addMembre(M2);
		CatalogueM.addMembre(M3);
		CatalogueM.addMembre(M4);
		System.out.println(CatalogueM.getMembre(1));
		System.out.println(CatalogueM.getMembre(2));
		System.out.println(CatalogueM.getMembre(3));
		System.out.println(CatalogueM.getMembre(4));
		CatalogueM.supressMembre(M3);
		System.out.println(CatalogueM.getMembre(1));
		System.out.println(CatalogueM.getMembre(2));
		System.out.println(CatalogueM.getMembre(3));
		System.out.println(CatalogueM.getMembre(4));
	}
}
