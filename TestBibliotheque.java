import java.util.Scanner;

public class TestBibliotheque {

	public static void main(String[] args) {
		//OldTest();
		
		//Testbase();
		
		//CompteTest();
		
		//Test();
		
		menu();
	}
	public static void Testbase(){
		MembreBibliotheque M1 = new MembreBibliotheque("Duclou","Paul","06 36 42 69 15","Vilepaum�e");
		MembreBibliotheque M2 = new MembreBibliotheque("Rhimbaud","Dash","06 07 08 09 10","Vilepon�");
		MembreBibliotheque M3 = new MembreBibliotheque("David","Lafarge","07 08 09 10 11","VileK�mone");
		MembreBibliotheque M4 = new MembreBibliotheque("Franck","Honnett","08 09 10 11 12","Vilefranche"); 
		DocBiblioth�que Doc1 = new DocBiblioth�que("004.178K20PM", "Introduction � Java", "J.LEBLANC", 2015,"Disponible");
		DocBiblioth�que Doc2 = new DocBiblioth�que("967.4987T248O", "Structures de Donn�es", "M.MACHIN", 2017,"Disponible");
		
		//d�but du test
		System.out.println("<Test de la num�rotation des abonn�s.>");
		System.out.println(M1.getnumabo());
		System.out.println(M2.getnumabo());
		System.out.println(M3.getnumabo());
		System.out.println(M4.getnumabo());
		System.out.println();
		
		System.out.println("<Test de la r�cup�ration des informations de la personne qui emprunte/r�serve>");
		System.out.println();
		Doc2.setToEmprunt(M3);		
		System.out.println("le nom de l'emprunteur du doc  "+ Doc2.gettitre() +" est : " +Doc2.getEmprunteur().getsirname()+" et son num�ro d'abonn� est : " + Doc2.getEmprunteur().getnumabo());
		Doc2.setToReserv(M2);
		System.out.println("La personne ayant r�serv� le doc " +Doc2.gettitre() +" est : " + Doc2.getR�serv().getname() +" "+ Doc2.getR�serv().getsirname());
		System.out.println();
		
		System.out.println("<test des m�thodes toString()>");
		System.out.println("Les documents : ");
		System.out.println(Doc2.toString());
		System.out.println();
		System.out.println(Doc1.toString());
		System.out.println();
		System.out.println("Un Membre : ");
		System.out.println( M4.toString());
		System.out.println();
		System.out.println();		
		//fin test
	}
	public static void OldTest(){
		//test extrait du Tp2
		MembreBibliotheque M1 = new MembreBibliotheque("Duclou","Paul","06 36 42 69 15","Vilepaum�e");
		MembreBibliotheque M2 = new MembreBibliotheque("Rhimbaud","Dash","06 07 08 09 10","Vilepon�");
		MembreBibliotheque M3 = new MembreBibliotheque("David","Lafarge","07 08 09 10 11","VileK�mone");
		DocBiblioth�que Doc1 = new DocBiblioth�que("004.178K20PM", "Introduction � Java", "J.LEBLANC", 2015,"Disponible");
		DocBiblioth�que Doc2 = new DocBiblioth�que("967.4987T248O", "Structures de Donn�es", "M.MACHIN", 2017,"Disponible");
		
		
		//test des premiers accesseurs/mutateurs
		System.out.println("le titre du premier document est : " +  Doc1.gettitre() +".");
		System.out.println("la date du second  document est : " +  Doc2.getpublication() +".");
		Doc2.setpublication(1954);
		System.out.println("la date du second  document est maintenant  : " +  Doc2.getpublication() +".");
		
		
		//Test Tache7
		System.out.println();      
		System.out.println("Et maintenant, test du systeme de statut des documents");
		System.out.println();
		System.out.println("Le statut du doc1 est "+Doc1.getStatut() +" celui du doc 2 est "+ Doc2.getStatut());
		System.out.println("Emrpunt et r�servation du document2");
		Doc2.setToEmprunt(M1);
		Doc2.setToReserv(M2);
		System.out.println("on rapporte le doc 2");
		Doc2.setToRetour();
		System.out.println("Le statut du doc2 est "+Doc2.getStatut());
		Doc2.CancelReserv();
		System.out.println("Le statut du doc2 est "+Doc2.getStatut());
		System.out.println();
		Doc2.setToDisponible();
		System.out.println("Le statut du doc2 est "+Doc2.getStatut());
		
		//test  sc�narios impossibles 
		System.out.println("<on tente de le rapporter alors qu'il est disponible>");
		Doc2.setToRetour();
		System.out.println();
		System.out.println("Le statut du doc2 est "+Doc2.getStatut()+", <le statut reste le m�me>");// le statut n'a pas chang� car la condition du mutateur n'est pas satisfaite
		System.out.println();
		Doc2.setToEmprunt(M1);
		System.out.println("Le statut du doc2 est "+Doc2.getStatut());
		Doc2.setToReserv(M2); // le doc est emprunt� et r�serv�
		System.out.println("Le statut du doc2 est "+Doc2.getStatut());
		System.out.println("<on a emprunt� et r�serv� le livre, et on tente de lui donner le statu disponible>");
		Doc2.setToDisponible(); // il devrait rester r�serv�.
		System.out.println();
		System.out.println("Le statut du doc2 est "+Doc2.getStatut()+ "; <depuis le statut r�serv�, le doc ne peut �tre rendu disponible sans annuler la r�servation>");
		System.out.println();
		System.out.println("<On tente de le r�server lorse qu'il est d�ja r�serv�>");
		System.out.println();
		Doc2.setToReserv(M3);
		System.out.println();
		
		
		
		//Test Tache 8 (on a d�ja test� l'accesseur qui donne l'�tat, ) on va tester ceux qui confirment un �tat sp�cifique
		System.out.println(Doc2.EstDansUnePile());
		System.out.println(Doc2.EstEmprunt�());
		System.out.println(Doc2.EstDisponible());
		System.out.println(Doc1.EstEmprunt�());
		System.out.println(Doc1.EstDisponible());
		//fin test tp2
	}
	public static void CompteTest(){
		//d�but test
		//MembreBibliotheque M1 = new MembreBibliotheque("Duclou","Paul","06 36 42 69 15","Vilepaum�e");
		MembreBibliotheque M2 = new MembreBibliotheque("Rhimbaud","Dash","06 07 08 09 10","Vilepon�");
		MembreBibliotheque M3 = new MembreBibliotheque("David","Lafarge","07 08 09 10 11","VileK�mone");
		MembreBibliotheque M4 = new MembreBibliotheque("Franck","Honnett","08 09 10 11 12","Vilefranche"); 
		DocBiblioth�que Doc1 = new DocBiblioth�que("004.178K20PM", "Introduction � Java", "J.LEBLANC", 2015,"Disponible");
		DocBiblioth�que Doc2 = new DocBiblioth�que("967.4987T248O", "Structures de Donn�es", "M.MACHIN", 2017,"Disponible");
		System.out.println("<Test du compte des documents>");
		System.out.println();
		Doc2.setToEmprunt(M4);
		Doc1.setToEmprunt(M2);
		System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());
		System.out.println();
		Doc2.setToRetour();
		System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());
		System.out.println();
		Doc1.setToReserv(M3);
		Doc1.setToRetour();
		System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());
		System.out.println();
		Doc2.setToDisponible();
		System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());
		System.out.println();
		Doc1.CancelReserv();
		System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());
		System.out.println();
		Doc1.setToDisponible();	
		System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());
		//fin test
	}
	public static void Test (){
		//MembreBibliotheque M1 = new MembreBibliotheque("Duclou","Paul","06 36 42 69 15","Vilepaum�e");
		MembreBibliotheque M2 = new MembreBibliotheque("Rhimbaud","Dash","06 07 08 09 10","Vilepon�");
		MembreBibliotheque M3 = new MembreBibliotheque("David","Lafarge","07 08 09 10 11","VileK�mone");
	//	MembreBibliotheque M4 = new MembreBibliotheque("Franck","Honnett","08 09 10 11 12","Vilefranche"); 
	//	DocBiblioth�que Doc1 = new DocBiblioth�que("004.178K20PM", "Introduction � Java", "J.LEBLANC", 2015,"Disponible");
		DocBiblioth�que Doc2 = new DocBiblioth�que("967.4987T248O", "Structures de Donn�es", "M.MACHIN", 2017,"Disponible");
		Doc2.setToEmprunt(M2);
		Doc2.setToReserv(M3);
		Doc2.setToRetour();
		Doc2.setToEmprunt(M2);
	}

public static void menu(){
	// Objets de test
	MembreBibliotheque M1 = new MembreBibliotheque("Duclou","Paul","06 36 42 69 15","Vilepaum�e");
	MembreBibliotheque M2 = new MembreBibliotheque("Rhimbaud","Dash","06 07 08 09 10","Vilepon�");
	MembreBibliotheque M3 = new MembreBibliotheque("David","Lafarge","07 08 09 10 11","VileK�mone");
	MembreBibliotheque M4 = new MembreBibliotheque("Franck","Honnett","08 09 10 11 12","Vilefranche"); 
	DocBiblioth�que Doc1 = new DocBiblioth�que("004.178K20PM", "Introduction � Java", "J.LEBLANC", 2015,"Disponible");
	DocBiblioth�que Doc2 = new DocBiblioth�que("967.4987T248O", "Structures de Donn�es", "M.MACHIN", 2017,"Disponible");
	//Menu
	int document;
	String Etat;
	int Membre;
	int optionMenu=1;
	Scanner entree = new Scanner(System.in);
while (optionMenu!=0){
	System.out.println("1 pour avoir des informations sur un document/ 2 pour voir le statut d'un document/ 3 pour changer le statut d'un document/ 4 pour afficher les comptes des documents : ");
	optionMenu = entree.nextInt();
	switch (optionMenu){
		case 1 :
			System.out.println("Entrez le numero du document : ");
			document = entree.nextInt();
			switch (document){
			
			case 1 : System.out.println(Doc1);break;
			case 2 : System.out.println(Doc2);break;
			}
			
			break;
		case 2 :
			System.out.println("Entrez le num du document : ");
			int document2 = entree.nextInt();
	
			switch (document2){
			
			case 1 : System.out.println(Doc1.getStatut());break;
			case 2 : System.out.println(Doc2.getStatut());break;
			}
			
			break;
		case 3 :
			System.out.println("Entrez le num du document et l'�tat D/E/R/C(annuler r�serv)/B(rendre) ainsi que le membre, pour les r�servations/emprunts: ");
			document = entree.nextInt();
			if(document == 1){
				Etat = entree.next();
				
				switch(Etat){
					case"D": Doc1.setToDisponible();break;
					case"E" :
						Membre = entree.nextInt();
						switch(Membre){
							case 1 :
								Doc1.setToEmprunt(M1);break;
							case 2 :
								Doc1.setToEmprunt(M2);break;
							case 3 :
								Doc1.setToEmprunt(M3);break;
							case 4 :
								Doc1.setToEmprunt(M4);break;
							default :
								System.out.println("Mauvaise saisie...");break;
							}break;
						
					case"R" :
						Membre = entree.nextInt();
						switch(Membre){
							case 1 :
								Doc1.setToReserv(M1);break;
							case 2 :
								Doc1.setToReserv(M2);break;
							case 3 :
								Doc1.setToReserv(M3);break;
							case 4 :
								Doc1.setToReserv(M4);break;
							default :
								System.out.println("Mauvaise saisie...");break;
							};break;
					case"C" : Doc1.CancelReserv();break;
					case"B"  : Doc1.setToRetour();;break;
					default : System.out.println("Mauvaise saisie...");break;
				}
				System.out.println("Statut : "+Doc1.getStatut());
			}
			else if(document == 2){
	Etat = entree.next();
				
				switch(Etat){
					case"D": Doc2.setToDisponible();break;
					case"E" :
						Membre = entree.nextInt();
						switch(Membre){
							case 1 :
								Doc2.setToEmprunt(M1);break;
							case 2 :
								Doc2.setToEmprunt(M2);break;
							case 3 :
								Doc2.setToEmprunt(M3);break;
							case 4 :
								Doc2.setToEmprunt(M4);break;
							default :
								System.out.println("Mauvaise saisie...");break;
							}break;
						
					case"R" :
						Membre = entree.nextInt();
						switch(Membre){
							case 1 :
								Doc2.setToReserv(M1);break;
							case 2 :
								Doc2.setToReserv(M2);break;
							case 3 :
								Doc2.setToReserv(M3);break;
							case 4 :
								Doc2.setToReserv(M4);break;
							default :
								System.out.println("Mauvaise saisie...");break;
							}break;
					case"C" :  Doc2.CancelReserv();break;
					case"B"  : Doc2.setToRetour();break;
					default : System.out.println("Mauvaise saisie...");break;
				}
				System.out.println("Statut : "+Doc2.getStatut());
			}
			break;
		case 4 :
			System.out.println("Pile : "+ DocBiblioth�que.getPile() +" Emprunts :"+ DocBiblioth�que.getEmprunts()+ " Section R�servation :"+ DocBiblioth�que.getSectRes());break;
		case 0 :
			System.out.println("Fermeture...");break;
		default :
			System.out.println("Mauvaise saisie...");break;
		}
	
	}
}
}