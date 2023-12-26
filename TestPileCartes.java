import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

public class TestPileCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 5.1
        PileCartes pile = new PileCartes(true,20);

        // question 5.2
        boolean res = pile.etrePosable(new Carte(15));

        // question 5.3
        boolean res2 = pile.poserCarte(new Carte(13));

        // question 5.5
        Carte c = pile.getDerniereCarte();

    }

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }

    public void test1_constructeur_Croissant(){
        PileCartes pile = new PileCartes(true, 3);

        assertEquals("la pile n'a pas ete cree correctement", 1, pile.getDerniereCarte().getValeur());
    }

    public void test1_2_constructeur_Decroissant(){
        PileCartes pile = new PileCartes(false, 3);

        assertEquals("la pile n'a pas ete cree correctement", 3, pile.getDerniereCarte().getValeur());
    }

    public void test2_etrePosable_Posable(){
        PileCartes pile = new PileCartes(true, 3);
        Carte carte = new Carte(30);
        boolean posable = pile.etrePosable(carte);

        assertEquals("la carte n'est pas posable", true, posable);
    } 

    public void test3_etrePosable_NonPosable(){
        PileCartes pile = new PileCartes(true, 3);
        Carte carte = new Carte(0);
        boolean posable = pile.etrePosable(carte);

        assertEquals("la carte est posable", false, posable);
    }

    public void test4_poserCarte_posee(){
        PileCartes pile = new PileCartes(true, 3);
        Carte carte = new Carte(30);
        boolean posee = pile.poserCarte(carte);

        assertEquals("la carte n'a pas ete posee", true, posee);
    }

    public void test5_poserCarte_nonPosee(){
        PileCartes pile = new PileCartes(true, 3);
        Carte carte = new Carte(0);
        boolean posee = pile.poserCarte(carte);

        assertEquals("la carte a ete posee", false, posee);
    }

    public void test6_ToString_OK(){
        PileCartes pile = new PileCartes(true, 3);
        String s = "";
        s = s + "c-c1-(1)";

        assertEquals("le tostring ne s'affiche pas correctement", s, pile.toString());

    }

    public void test7_getDerniereCarte_OK(){
        PileCartes pile = new PileCartes(true, 3);
        Carte carte = new Carte(1);

        assertEquals("la derniere carte n'est pas celle attendue", carte.getValeur(), pile.getDerniereCarte().getValeur());
    }
}
