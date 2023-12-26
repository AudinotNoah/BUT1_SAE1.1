import java.util.Random;

/**
 * Cette classe représente un paquet de cartes.
 */
public class PaquetCartes {

    private Carte[] cartes; // tableau de cartes
    private Random random = new Random(); // générateur de nombres aléatoires pour piocherHasard()

    /**
     * Constructeur par défaut qui initialise un paquet vide.
     */
    public PaquetCartes(){
        cartes = new Carte[0];
    }

    /**
     * Constructeur qui initialise le paquet avec un tableau de cartes donné.
     * @param pcartes Tableau de cartes.
     */
    public PaquetCartes(Carte[] pcartes){
        this.cartes = pcartes;
    }
    
     /**
     * Constructeur qui crée un paquet à partir d'un tableau d'entiers.
     * Chaque entier dans le tableau représente la valeur d'une carte.
     * 
     * @param tabInt Tableau d'entiers représentant les valeurs des cartes.
     */
    public PaquetCartes(int[] tabInt){
        // Création d'un tableau de cartes de la même taille que le tableau d'entiers
        Carte[] cartes2 = new Carte[tabInt.length];
        
        // Boucle pour créer une carte pour chaque entier dans le tableau et l'ajouter au tableau de cartes
        for (int i = 0; i < tabInt.length; i++){
            Carte c = new Carte(tabInt[i]);
            cartes2[i] = c;
        }

        // Assignation du tableau de cartes nouvellement créé à l'attribut "cartes" de l'objet PaquetCartes
        this.cartes = cartes2;
    }

    /**
     * Méthode privée pour piocher une carte au hasard dans le paquet.
     * 
     * @return Carte piochée au hasard, ou null si le paquet est vide.
     */
    private Carte piocherHasard(){
        // Vérifie si le paquet contient des cartes
        if (0 < this.getNbCartes()){
            // Génère un nombre aléatoire entre 0 (inclus) et le nombre de cartes dans le paquet (exclus)
            int num = random.nextInt(this.getNbCartes());
            // Utilise la méthode retirerCarte() pour retirer la carte à l'indice généré aléatoirement
            return this.retirerCarte(num);
        }
        // Retourne null si le paquet est vide
        return null;
    }

    
    /**
     * Méthode pour mélanger les cartes dans le paquet en utilisant l'algorithme de mélange par tirage au hasard.
     * Chaque carte est piochée au hasard du paquet original et placée dans un nouveau paquet mélangé.
     */
    public void melangerPaquet(){
        // Crée un nouveau tableau de cartes de la même taille que le nombre de cartes dans le paquet
        Carte[] cartes2 = new Carte[this.getNbCartes()];
        
        // Obtient le nombre de cartes dans le paquet
        int taille = this.getNbCartes();
        
        // Boucle pour piocher au hasard chaque carte du paquet original et la placer dans le nouveau tableau
        for (int i = 0; i < taille; i++){
            Carte c = this.piocherHasard();
            cartes2[i] = c;
        }
        
        // Remplace le paquet original par le nouveau paquet mélangé
        this.cartes = cartes2;
    }

    
    /**
     * Méthode pour insérer une carte de manière triée dans le paquet en utilisant la recherche binaire.
     * Si une carte ayant la même valeur existe déjà, la nouvelle carte est ajoutée à cet emplacement.
     * 
     * @param c Carte à insérer de manière triée.
     */
    public void insererTri(Carte c) {
        // Initialise les indices de début et de fin pour la recherche binaire
        int debut = 0;
        int fin = this.getNbCartes() - 1;

        // Utilise la recherche binaire pour trouver la position d'insertion
        while (debut <= fin) {
            int milieu = (debut + fin) / 2;

            if (c.getValeur() == this.cartes[milieu].getValeur()) {
                // Si une carte ayant la même valeur existe déjà, ajoute la nouvelle carte à cet emplacement
                this.ajouterCarte(c, milieu);
                return;
            } else if (c.getValeur() < this.cartes[milieu].getValeur()) {
                // Si la valeur de la nouvelle carte est inférieure, réduit la plage de recherche à la moitié inférieure
                fin = milieu - 1;
            } else {
                // Si la valeur de la nouvelle carte est supérieure, réduit la plage de recherche à la moitié supérieure
                debut = milieu + 1;
            }
        }

        // Ajoute la carte à la position trouvée par la recherche binaire
        this.ajouterCarte(c, debut);
    }

    
    /**
     * Méthode pour prendre la carte du dessus du paquet.
     * @return Carte du dessus du paquet.
     */
    public Carte prendreCarteDessus(){
        if (0 < this.getNbCartes()){
            return this.retirerCarte(0);
        }
        return null;
    }

    /**
     * Méthode pour obtenir le nombre de cartes dans le paquet.
     * @return Nombre de cartes dans le paquet.
     */
    public int getNbCartes(){
        return this.cartes.length;
    }

    /**
     * Méthode pour obtenir la carte à un certain indice dans le paquet.
     * @param n Indice de la carte.
     * @return Carte à l'indice donné.
     */
    public Carte getCarte(int n){
        if (n < this.getNbCartes()){
            return cartes[n];
        }
        return null;
    }
    
    /**
     * Méthode pour obtenir la dernière carte du paquet.
     * @return Dernière carte du paquet.
     */
    public Carte getDerniereCarte(){
        if (0 < this.getNbCartes()){
            return cartes[this.getNbCartes()-1];
        }
        return null;
    }
    
    /**
     * Méthode pour vérifier si le paquet est vide.
     * @return true si le paquet est vide, false sinon.
     */
    public boolean etreVide(){
        return (this.cartes.length == 0);
    }

    /**
     * Méthode pour remplir le paquet avec des cartes de valeurs croissantes à partir de 2.
     * Crée des cartes avec des valeurs allant de 2 à la valeur maximale spécifiée et remplit le paquet.
     * 
     * @param max Valeur maximale des cartes à ajouter.
     */
    public void remplir(int max){
        // Vérifie que la valeur maximale spécifiée est suffisamment grande pour créer au moins deux cartes
        if (max >= 2 ){
            // Crée un nouveau tableau de cartes de taille (max-2)
            Carte[] cartes2 = new Carte[max-2];
            
            // Boucle pour créer des cartes avec des valeurs allant de 2 à la valeur maximale spécifiée
            for (int i = 0; i < max-2; i++){
                Carte c = new Carte(i+2);
                cartes2[i] = c;
            }

            // Remplace le paquet original par le nouveau paquet créé
            this.cartes = cartes2;
        }
    }


    /**
     * Méthode pour ajouter une carte à la fin du paquet.
     * Crée un nouveau tableau de cartes de taille (taille + 1), y copie les cartes existantes,
     * puis ajoute la nouvelle carte à la dernière position.
     * 
     * @param pC Carte à ajouter à la fin du paquet.
     */
    public void ajouterCarteFin(Carte pC){
        // Obtient la taille actuelle du paquet
        int taille = this.cartes.length;
        
        // Crée un nouveau tableau de cartes de taille (taille + 1)
        Carte[] tabCartes2 = new Carte[taille+1];
        
        // Copie les cartes existantes dans le nouveau tableau
        for (int i = 0; i < taille; i++){
            tabCartes2[i] = this.cartes[i];
        }
        
        // Ajoute la nouvelle carte à la dernière position du nouveau tableau
        tabCartes2[taille] = pC;
        
        // Remplace le paquet original par le nouveau paquet avec la carte ajoutée à la fin
        this.cartes = tabCartes2;
    }


    /**
     * Méthode pour retirer une carte à un certain indice du paquet.
     * 
     * @param indice Indice de la carte à retirer.
     * @return Carte retirée, ou null si l'indice est invalide.
     */
    public Carte retirerCarte(int indice){
        // Obtient la taille actuelle du paquet
        int taille = this.cartes.length;

        // Vérifie si l'indice est valide
        if ((indice < 0) || (taille-1 < indice)){
            // Retourne null si l'indice est invalide
            return null;
        }

        Carte c = null;
        // Crée un nouveau tableau de cartes de taille (taille - 1)
        Carte[] tabCartes2 = new Carte[taille-1];
        int n = 0;
        
        // Copie les cartes existantes dans le nouveau tableau, sauf celle à l'indice spécifié
        for (int i = 0; i < taille; i++){
            if (i == indice) {
                // Garde la carte à l'indice spécifié pour la renvoyer plus tard
                c = this.cartes[i];
            }
            else {
                // Copie les autres cartes dans le nouveau tableau
                tabCartes2[n] = this.cartes[i];
                n++;
            }
        }

        // Remplace le paquet original par le nouveau paquet sans la carte retirée
        this.cartes = tabCartes2;
        return c;
    }

    
    /**
     * Méthode pour obtenir une représentation textuelle du paquet.
     * @return Représentation textuelle du paquet.
     */
    public String toString(){
        String renvoie = "";
        for (int i=0; i < this.cartes.length; i++){
            renvoie = renvoie + i + "-" + this.cartes[i].toString()+" ";
        }
        return renvoie;
    }

    /**
     * Méthode pour ajouter une carte au début du paquet.
     * Crée un nouveau tableau de cartes de taille (taille + 1), ajoute la nouvelle carte à la première position,
     * puis copie les cartes existantes dans le reste du tableau.
     * 
     * @param pC Carte à ajouter au début du paquet.
     */
    public void ajouterCarteDebut(Carte pC){
        // Obtient la taille actuelle du paquet
        int taille = this.cartes.length;
        
        // Crée un nouveau tableau de cartes de taille (taille + 1)
        Carte[] tabCartes2 = new Carte[taille+1];
        
        // Ajoute la nouvelle carte à la première position du nouveau tableau
        tabCartes2[0] = pC;
        
        // Copie les cartes existantes dans le reste du nouveau tableau
        for (int i = 1; i < taille+1; i++){
            tabCartes2[i] = this.cartes[i-1];
        }
        
        // Remplace le paquet original par le nouveau paquet avec la carte ajoutée au début
        this.cartes = tabCartes2;
    }


    /**
     * Méthode pour ajouter une carte à une certaine position dans le paquet.
     * Crée un nouveau tableau de cartes de taille (taille + 1), ajoute la nouvelle carte à la position spécifiée,
     * puis copie les cartes existantes dans le reste du tableau.
     * 
     * @param c Carte à ajouter.
     * @param place Position où ajouter la carte dans le paquet.
     */
    public void ajouterCarte(Carte c, int place){
        // Obtient la taille actuelle du paquet
        int taille = this.cartes.length;

        // Vérifie si la position spécifiée est valide
        if (taille+1 > place){
            // Crée un nouveau tableau de cartes de taille (taille + 1)
            Carte[] tabCartes2 = new Carte[taille+1];
            int n = 0;
            
            // Copie les cartes existantes dans le nouveau tableau, en ajoutant la nouvelle carte à la position spécifiée
            for (int i = 0; i < taille+1; i++){
                if (i == place) {
                    // Ajoute la nouvelle carte à la position spécifiée dans le nouveau tableau
                    tabCartes2[i] = c;
                }
                else {
                    // Copie les autres cartes dans le nouveau tableau
                    tabCartes2[i] = this.cartes[n];
                    n++;
                }
            }

            // Remplace le paquet original par le nouveau paquet avec la carte ajoutée à la position spécifiée
            this.cartes = tabCartes2;
        }
    }

}
