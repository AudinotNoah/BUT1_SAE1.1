import java.util.Scanner;


public class Jeu {
    private PaquetCartes main;
    private PaquetCartes pioche;
    private PileCartes[] piles;
    private int scoreMax;
    private Score s;

    // Constructeur
    public Jeu(int max) {
        PaquetCartes piocheMelangee = new PaquetCartes();
        piocheMelangee.remplir(max);
        piocheMelangee.melangerPaquet();

        // Créer la main initiale du joueur (8 cartes triées dans l'ordre)
        this.main = new PaquetCartes();
        for (int i = 0; i < 8; i++) {
            Carte carte = piocheMelangee.retirerCarte(0);
            this.main.insererTri(carte);
        }

        // Initialiser les piles dans l'ordre croissant et décroissant
        this.piles = new PileCartes[4];
        this.piles[0] = new PileCartes(true, max);
        this.piles[1] = new PileCartes(true, max);
        this.piles[2] = new PileCartes(false, max);
        this.piles[3] = new PileCartes(false, max);


        // La pioche contient le reste des cartes
        this.pioche = piocheMelangee;
        this.scoreMax = max;
        this.s = new Score();
    }

    public Jeu(PaquetCartes paquet) {
        this.scoreMax = paquet.getNbCartes();
        this.s = new Score();
        // Créer la main initiale du joueur (8 cartes triées dans l'ordre)
        this.main = new PaquetCartes();
        for (int i = 0; i < 8; i++) {
            Carte carte = paquet.retirerCarte(0);
            this.main.insererTri(carte);
        }

        // Initialiser les piles dans l'ordre croissant et décroissant
        int max = paquet.getNbCartes();
        this.piles = new PileCartes[4];
        this.piles[0] = new PileCartes(true, max);
        this.piles[1] = new PileCartes(true, max);
        this.piles[2] = new PileCartes(false, max);
        this.piles[3] = new PileCartes(false, max);

        // La pioche contient le reste des cartes
        this.pioche = new PaquetCartes();
        while (paquet.getNbCartes() > 0) {
            Carte carte = paquet.retirerCarte(0);
            this.pioche.ajouterCarteFin(carte);
        }
    }

    public boolean jouerCarte(int indice, int numPile){
        if (this.piles[numPile].etrePosable(this.main.getCarte(indice))){
            this.piles[numPile].poserCarte(this.main.getCarte(indice));
            this.main.retirerCarte(indice);
            return true;
        }

        return false;
    }


    public int etreFini(){
        if (this.main.getNbCartes()==0 && this.pioche.getNbCartes()==0){
            return 1;
        }
        else {
            for (int i = 0;i<4;i++){
                for (int j=0;j<this.main.getNbCartes();j++){
                    if (this.piles[i].etrePosable(this.main.getCarte(j))){
                        return 0;
                    }
                }
            }
        }
        return -1;
    }

    public String toString(){
        String s = "################################################\n";
        for (int i = 0;i<4;i++){
            s = s + "- PILE " + i + " : ";
            s = s + this.piles[i].toString();
            s = s + "\n";
        }
        s = s + "################################################\n";
        s = s + "Reste "+ this.pioche.getNbCartes() +" cartes dans la pioche \n";
        s = s + "################################################\n";
        s = s + "Main du joueur :\n";
        s = s + this.main.toString() + "\n";
        s = s + "################################################";
        return s;
    }


    public PaquetCartes getMain(){
        return this.main;
    }

    public PaquetCartes getPioche(){
        return this.pioche;
    }

    public PileCartes[] getPiles(){
        return this.piles;
    }

    // Méthode pour compléter la main du joueur à 8 cartes
    public void completerMain() {
        while (this.main.getNbCartes() < 8 && this.pioche.getNbCartes() > 0) {
            Carte carte = this.pioche.retirerCarte(0);
            this.main.insererTri(carte);
        }
    }

    // Méthode principale pour lancer le jeu
    public void lancerJeu() {
        boolean fini = false;
        Scanner scanner = new Scanner(System.in);
        int tour = 0;

        System.out.println("Bienvenue dans The Game!");

        // Boucle du jeu
        System.out.println(this.s.toString());
        while (fini == false) {
            // Affichage de l'état du jeu
            System.out.println("\nTour " + (tour+1) + " :");

            for (int i = 0;i<2;i++){
                boolean carte_jouer = false;
                while (carte_jouer == false){
                
                    System.out.println(this.toString());

                    // Demander au joueur de jouer une carte
                    int indice = -1;
                    while (indice < 0 || indice >= this.main.getNbCartes()){
                        System.out.println("Veuillez jouer une carte de votre main (entrez l'indice) : ");
                        indice = scanner.nextInt();

                    }
                    // Demander où placer la carte
                    int numPile = -1;
                    while (numPile < 0 || numPile >= 4){
                        System.out.println("Sur quelle pile souhaitez-vous poser cette carte ? (0, 1, 2, ou 3) : ");
                        numPile = scanner.nextInt();

                    }

                    // Jouer la carte et compléter la main
                    boolean jouer_placer = this.jouerCarte(indice, numPile);
                    if (jouer_placer) {
                        System.out.println("Coup réussi.");
                        carte_jouer = true;

                        // Vérifier si le jeu est terminé
                        int etatJeu = etreFini();
                        if (etatJeu == 1) {
                            fini = true;
                            System.out.println("\nFélicitations! Vous avez gagné!");
                            System.out.println("Votre score est : "+this.scoreMax);
                            System.out.println("\nVotre nom :");
                            String nom = scanner.nextLine();
                            this.s.ajoutScore(nom,scoreMax);

                            break;
                        } else if (etatJeu == -1) {
                            System.out.println("\nDésolé, vous avez perdu.");
                            fini = true;
                            int score_defaite = this.scoreMax-this.pioche.getNbCartes()-this.main.getNbCartes();
                            System.out.println("Votre score est : "+score_defaite);
                            System.out.println("\nVotre nom :");
                            String nom = scanner.nextLine();
                            this.s.ajoutScore(nom,scoreMax);
                            break;
                        }
                    } 
                    else {
                        System.out.println("Coup impossible. Veuillez réessayer.");
                    }
                }
            }
            tour++;
            this.completerMain();
        }
    }
}
