import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;

public class TestJeu {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 6.2
        Jeu jeu = new Jeu(50);

        // question 6.1
        PaquetCartes p = jeu.getMain();
        PaquetCartes pioche = jeu.getPioche();
        PileCartes[] piles = jeu.getPiles();

        // question 6.3
        String s = jeu.toString();

        // question 6.4
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10);
        Jeu jeu2 = new Jeu(paquet);

        // question 6.5
        boolean res = jeu.jouerCarte(0,0);

        // question 6.6
        int fin = jeu.etreFini();
    }

    /**
    * lancement des tests
    */
    public static void main(String args[])
    {
        lancer(new TestJeu(),args);
    }

    public void test1_ConstructeurInt_OK(){
        Jeu jeu = new Jeu(10);
    }

    public void test2_ConstructeurPaquet_OK(){

    }

    public void test3_jouerCarte_Jouable(){
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10); 
        Jeu jeu = new Jeu(paquet);

        assertEquals("la carte n'est pas jouable", true, jeu.jouerCarte(0, 0));
    }

    public void test4_jouerCarte_NonJouable(){
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10); 
        Jeu jeu = new Jeu(paquet);
        jeu.jouerCarte(6, 0);

        assertEquals("la carte est jouable", false, jeu.jouerCarte(2, 0));
    }

    public void test5_etreFini_nonFini(){
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10); 
        Jeu jeu = new Jeu(paquet);

        assertEquals("le jeu devrait ne pas etre fini", 0, jeu.etreFini());
    }

    public void test6_etreFini_finiGagnee(){
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10); 
        Jeu jeu = new Jeu(paquet);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        jeu.jouerCarte(0, 0);
        
        assertEquals("la partie devrait etre gagnee", 1, jeu.etreFini());

    }

    public void test7_etreFini_finiPerdue(){
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(10); 
        Jeu jeu = new Jeu(paquet);
        jeu.jouerCarte(7, 0);
        jeu.jouerCarte(6, 1);
        jeu.jouerCarte(0, 2);
        jeu.jouerCarte(1, 3);
        assertEquals("la partie devrait etre perdue", -1, jeu.etreFini());
    }

    public void test8_completerMain_OK(){
        PaquetCartes paquet = new PaquetCartes();
        paquet.remplir(11); 
        Jeu jeu = new Jeu(paquet);

        assertEquals("la pioche n'a pas de carte", 1,jeu.getPioche().getNbCartes());

        jeu.jouerCarte(0, 0);
        jeu.completerMain();

        assertEquals("la main n'est pas remplie", 8, jeu.getMain().getNbCartes());
    }


}
