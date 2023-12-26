public class PileCartes {
    private boolean croissant;
    private PaquetCartes paquet;



    public PileCartes(boolean pCroissant,int max){
            this.paquet = new PaquetCartes();

            if (pCroissant){
                Carte c1 = new Carte(1);
                this.paquet.ajouterCarteFin(c1);
            }
            else{
                Carte c1 = new Carte(max);
                this.paquet.ajouterCarteFin(c1);
            }

            this.croissant = pCroissant;
    }


    public boolean etrePosable(Carte c){
        boolean posable = false;
        if (this.croissant == true){
            if (this.paquet.getDerniereCarte().getValeur() < c.getValeur()){
                posable = true;
            }
        }
        if (this.croissant == false){
            if (this.paquet.getDerniereCarte().getValeur() > c.getValeur()){
                posable = true;
            }
        }
        return posable;
    }


    public boolean poserCarte(Carte c) {
        if (this.etrePosable(c)) {
            this.paquet.ajouterCarteFin(c);
            return true;
        } else return false;
    }

    public String toString(){
        String s = "";
        if (this.croissant == true){
            s += "c";
        }
        else {
            s += "d";
        }
        s += "-"+this.paquet.getDerniereCarte().toString()+"-("+this.paquet.getNbCartes()+")";
        
        return s;

    }

    public Carte getDerniereCarte(){
        if (0 < this.paquet.getNbCartes()){
            return this.paquet.getDerniereCarte();
        }
        return null;
    }
}
