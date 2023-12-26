import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquet {

	public void test_0_verifieMethodes() {
        // Question 4.1
        Carte[] tabC = {new Carte(10), new Carte(20)};
        PaquetCartes paq = new PaquetCartes(tabC);
        paq.ajouterCarteFin(new Carte(25));
        paq.retirerCarte(0);

        // Question 4.2
        PaquetCartes paq2 = new PaquetCartes();

        // Question 4.3
        paq2.remplir(20);

        // Question 4.4
        int tabInt[] = {10,20,30,40,50};
        PaquetCartes paq3 = new PaquetCartes(tabInt);

        // Question 4.5
        Carte c = paq.getCarte(0);
        Carte c2 = paq.getDerniereCarte();
        int nb = paq.getNbCartes();
        boolean vide = paq.etreVide();

        // question 4.7
        paq.melangerPaquet();

        // question  4.8
        paq.insererTri(new Carte(23));

        // question  4.9
        Carte c3 = paq.prendreCarteDessus();

    }

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquet(), args);
	}

	/**
	 * test du constructeur vide
	 */

	public void test1_constructeur() {
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}

	/**
	 * test du constructeur parametres
	 */

	public void test2_constructeurParam() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}


        /**
	 * test getCarte
	 */

	public void test3_getCarte_ok() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(1);
		assertEquals("la carte 1 a pour valeur 2", 2, c.getValeur());
	}

	/**
	 * test getCarte hors tableau
	 */

	public void test4_getCarte_horsTableau() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

    Carte c = paquet.getCarte(3);
		assertEquals("la carte 3 n'existe pas", null, c);
	}

	/**
	 * test ajoutCarteFin ok
	 */

	public void test5_ajoutCarteFin() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteFin(new Carte(4));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

		// chaque carte doit etre bien placee: place i => valeur i+
		for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+"a pour valeur"+(i+1), i+1, c.getValeur());
		}

	}

	/**
	 * test retirerCarte ok
	 */

	public void test6_retirerCarte() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);

		PaquetCartes paquet = new PaquetCartes(tab);
		Carte c = paquet.retirerCarte(1);

		// test paquet
		assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
		assertEquals("premiere carte valeur 1", 1, paquet.getCarte(0).getValeur());
		assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).getValeur());

		// test carte retournee
		assertEquals("carte retiree a pour valeur 2", 2, c.getValeur());


	}
	/**
     * Test de la méthode ajouterCarte.
     */
	public void test7_ajouterCarte() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarte(new Carte(0),2);

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());
        
		assertEquals("la carte d'indice 2 devrait avoir comme valeur 0 ",0 ,paquet.getCarte(2).getValeur());
        
	}
    /**
     * Test de la méthode remplir.
     */
	public void test8_Remplir(){
		PaquetCartes paquet = new PaquetCartes();
		paquet.remplir(100);
		assertEquals("paquet devrait avoir 98 cartes", 98, paquet.getNbCartes());

		assertEquals("la première carte devrait être égal à 2", 2, paquet.getCarte(0).getValeur());
		assertEquals("la derniere carte devrait être égal à 99", 99, paquet.getCarte(paquet.getNbCartes()-1).getValeur());
				
	}
    /**
     * Test de la méthode remplir avec une valeur invalide.
     */
	public void test9_RemplirInvalide(){
		PaquetCartes paquet = new PaquetCartes();
		paquet.remplir(0);
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
		paquet.remplir(1);
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());	
	}
	/**
	 * Test du constructeur avec un tableau d'entiers.
	 */
	public void test10_ConstructeurTabInt(){
		int[] tabInt = new int[10];
		for (int i = 0; i < 10;i++){
			tabInt[i] = i;
		}
		PaquetCartes paquet = new PaquetCartes(tabInt);
		assertEquals("paquet devrait avoir 10 cartes", 10, paquet.getNbCartes());
		assertEquals("la première carte devrait être égal à 0", 0, paquet.getCarte(0).getValeur());
		assertEquals("la derniere carte devrait être égal à 9", 9, paquet.getCarte(paquet.getNbCartes()-1).getValeur());
	}

	/**
	 * Test de la méthode getDerniereCarte.
	 */
	public void test11_getDerniereCarte(){
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("getDerniereCarte devrait renvoyer null", null, paquet.getDerniereCarte());

		int[] tabInt = new int[10];
		for (int i = 0; i < 10;i++){
			tabInt[i] = i;
		}
		paquet = new PaquetCartes(tabInt);
		assertEquals("la derniere carte devrait être égal à 9", 9, paquet.getDerniereCarte().getValeur());
	}
	/**
	 * Test de la méthode etreVide.
	 */
	public void test12_etreVide(){
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("devrait renvoyer true", true, paquet.etreVide());
		paquet.ajouterCarteDebut(new Carte(10));
		assertEquals("devrait renvoyer false", false, paquet.etreVide());
	}
	/**
	 * Test de la méthode melangerPaquet.
	 */
	public void test13_melangerPaquet(){
		
		PaquetCartes paquet = new PaquetCartes();
		paquet.remplir(100);
		paquet.melangerPaquet();
		
		boolean diff = false;
		int taille = paquet.getNbCartes();
		for (int i = 0;i<taille;i++){
			if (i != paquet.getCarte(i).getValeur()){
				diff = true;
			}
		}
		assertEquals("le paquet n'a pas été mélangé", true, diff);
	}
	/**
	 * Test de la méthode insererTri.
	 */
	public void test14_insererTri() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.insererTri(new Carte(3));

		assertEquals("la carte est mal rangee", 4, paquet.getCarte(3).getValeur());
	}
	/**
	 * Test de la méthode insererTriDebut.
	 */
	public void test15_insererTriDebut() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(2);
		tab[1] = new Carte(3);
		tab[2] = new Carte(4);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.insererTri(new Carte(1));

		assertEquals("la carte est mal rangee", 1, paquet.getCarte(0).getValeur());
	}
	/**
	 * Test de la méthode insererTriFin.
	 */
	public void test16_insererTriFin() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.insererTri(new Carte(4));

		assertEquals("la carte est mal rangee", 4, paquet.getCarte(3).getValeur());
	}
	/**
	 * Test de la méthode insererTriVide.
	 */
	public void test17_insererTriVide() {
		Carte[] tab = new Carte[0];			
		PaquetCartes paquet = new PaquetCartes(tab);
		
		paquet.insererTri(new Carte(1));
		
		assertEquals("la carte n'a pas été inséré", 1, paquet.getNbCartes());
	}
	/**
     * Test de la méthode prendreCarteDessus lorsque le paquet n'est pas vide.
     */
	public void test18_prendreCarteDessus_OK() {
		Carte[] tab = new Carte[3];
		Carte c1 = new Carte(1);
		tab[0] = c1;
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		Carte Cartetest = paquet.prendreCarteDessus();
		
		assertEquals("la carte récupéré n'est pas bonne", c1.getValeur(),Cartetest.getValeur());
	}
    /**
     * Test de la méthode prendreCarteDessus lorsque le paquet est vide.
     */
	public void test19_prendreCarteDessus_vide() {
		PaquetCartes paquet = new PaquetCartes();
		Carte Cartetest = paquet.prendreCarteDessus();
		
		assertEquals("la carte devrait etre null", null,Cartetest);
	}
    /**
     * Test de la méthode toString lorsque le paquet n'est pas vide.
     */
	public void test20_ToString_OK() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
		PaquetCartes paquet = new PaquetCartes(tab);
		String s = "";
		s = s + "0-c1 1-c2 2-c3 ";
		
		assertEquals("le tostring ne s'affiche pas correctement", s, paquet.toString());
	}
    /**
     * Test de la méthode ajouterCarteDebut lorsque le paquet est vide.
     */
	public void test21_ajouterCarteDebut() {
		PaquetCartes paquet = new PaquetCartes();
		Carte c1 = new Carte(5);
		paquet.ajouterCarteDebut(c1);
	
		assertEquals("Le paquet devrait avoir 1 carte", 1, paquet.getNbCartes());
		assertEquals("La première carte devrait être 5", 5, paquet.getCarte(0).getValeur());
	}

	/**
	 * Test de la méthode ajouterCarteDebut lorsque le paquet n'est vide pas.
	 */
	public void test22_ajouterCarteDebutNonVide() {
		Carte[] cartes = {new Carte(2), new Carte(4)};
		PaquetCartes paquet = new PaquetCartes(cartes);
		Carte c1 = new Carte(1);
		paquet.ajouterCarteDebut(c1);
	
		assertEquals("Le paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		assertEquals("La première carte devrait être 1", 1, paquet.getCarte(0).getValeur());
		assertEquals("La deuxième carte devrait être 2", 2, paquet.getCarte(1).getValeur());
		assertEquals("La troisième carte devrait être 4", 4, paquet.getCarte(2).getValeur());
	}
	/**
	 * Test de la méthode ajouterCarteDebut lorsque qu'on ajoute plusieurs cartes.
	 */
	public void test23_ajouterCarteDebutMultiple() {
		PaquetCartes paquet = new PaquetCartes();
		Carte c1 = new Carte(3);
		Carte c2 = new Carte(2);
		Carte c3 = new Carte(1);
		paquet.ajouterCarteDebut(c1);
		paquet.ajouterCarteDebut(c2);
		paquet.ajouterCarteDebut(c3);
	
		assertEquals("Le paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		assertEquals("La première carte devrait être 1", 1, paquet.getCarte(0).getValeur());
		assertEquals("La deuxième carte devrait être 2", 2, paquet.getCarte(1).getValeur());
		assertEquals("La troisième carte devrait être 3", 3, paquet.getCarte(2).getValeur());
	}
	/**
     * Test de la méthode toString quand le paquet est vide.
     */
	public void test24_ToStringVide() {
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("Le toString devrait renvoyer une chaîne vide", "", paquet.toString());
	}
    /**
     * Test de la méthode retirerCarte lorsque le paquet est vide.
     */
	public void test26_retirerCarteVide() {
		PaquetCartes paquet = new PaquetCartes();
		Carte c = paquet.retirerCarte(0);
	
		assertEquals("La carte retirée devrait être null", null, c);
		assertEquals("Le paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}
	
    /**
     * Test de la méthode retirerCarte avec un indice invalide (négatif).
     */	
	public void test27_retirerCarteIndiceInvalide() {
		Carte[] cartes = {new Carte(5), new Carte(8), new Carte(3)};
		PaquetCartes paquet = new PaquetCartes(cartes);
		Carte c = paquet.retirerCarte(-1);
	
		assertEquals("La carte retirée devrait être null", null, c);
		assertEquals("Le paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}
    /**
     * Test de la méthode retirerCarte avec un indice invalide (trop grand).
     */
	public void test28_retirerCarteIndiceInvalide() {
		Carte[] cartes = {new Carte(5), new Carte(8), new Carte(3)};
		PaquetCartes paquet = new PaquetCartes(cartes);
		Carte c = paquet.retirerCarte(5);
	
		assertEquals("La carte retirée devrait être null", null, c);
		assertEquals("Le paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}
    /**
     * Test de la méthode insererTri avec plusieurs éléments.
     */
	public void test29_insererTriMultiple() {
		PaquetCartes paquet = new PaquetCartes();
		paquet.insererTri(new Carte(5));
		paquet.insererTri(new Carte(2));
		paquet.insererTri(new Carte(8));
	
		assertEquals("Le paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
		assertEquals("La première carte devrait être 2", 2, paquet.getCarte(0).getValeur());
		assertEquals("La deuxième carte devrait être 5", 5, paquet.getCarte(1).getValeur());
		assertEquals("La troisième carte devrait être 8", 8, paquet.getCarte(2).getValeur());
	}

}
