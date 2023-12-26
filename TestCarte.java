import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

/**
 * Classe de test pour la classe Carte.
 */
public class TestCarte {

    /**
     * Test des méthodes de la classe Carte.
     */
    public void test_0_verifieMethodes() {
        Carte c = new Carte(10);
        Carte c2 = new Carte(20);

        // Test des méthodes
        int v = c.getValeur();
        String s = c.toString();

        boolean res = c.etrePlusGrand(c2);
        boolean diff = c.avoirDiffDe10(c2);
    }

    /**
     * Méthode de lancement des tests.
     * 
     * @param args Arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        lancer(new TestCarte(), args);
    }

    /**
     * Test du constructeur avec paramètre.
     */
    public void test1_constructeurParam() {
        Carte c = new Carte(10);
        assertEquals("La valeur de la carte devrait être 10", 10, c.getValeur());
    }

    /**
     * Test de la méthode etrePlusGrand avec des valeurs valides.
     */
    public void test2_etrePlusGrand_OK() {
        Carte c = new Carte(10);
        Carte c2 = new Carte(15);
        assertEquals("Devrait être false car 10 < 15", false, c.etrePlusGrand(c2));
        assertEquals("Devrait être true car 15 > 10", true, c2.etrePlusGrand(c));
    }

    /**
     * Test de la méthode etrePlusGrand avec des valeurs identiques.
     */
    public void test3_etrePlusGrand_TailleSimilaire() {
        Carte c = new Carte(10);
        Carte c2 = new Carte(10);
        assertEquals("Devrait être false car doit être strictement supérieur", false, c.etrePlusGrand(c2));
    }

    /**
     * Test de la méthode avoirDiffDe10 avec des valeurs valides.
     */
    public void test4_avoirDiffDe10_OK() {
        Carte c = new Carte(10);
        Carte c2 = new Carte(20);
        Carte c3 = new Carte(15);
        assertEquals("Devrait être true car il y a une différence de 10", true, c.avoirDiffDe10(c2));
        assertEquals("Devrait être false car il n'y a pas de différence de 10", false, c.avoirDiffDe10(c3));
    }

    /**
     * Test de la méthode toString avec une valeur valide.
     */
    public void test5_toString_OK() {
        Carte c = new Carte(10);
        assertEquals("Devrait être 'c10'", "c10", c.toString());
    }

}
