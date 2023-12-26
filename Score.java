public class Score {

    private int[] scores;
    private String[] noms;

    public Score() {
        this.scores = new int[5];
        this.noms = new String[5];
    }

    public void ajoutScore(String nom, int score) {
        // Trouver l'index où ajouter le score
        int index = -1;
        for (int i = 0; i < scores.length; i++) {
            if (score > scores[i]) {
                index = i;
                break;
            }
        }

        // Si l'index est différent de -1, ajouter le score et le nom
        if (index != -1) {
            // Décaler les éléments pour faire de la place à la nouvelle entrée
            for (int i = scores.length - 1; i > index; i--) {
                scores[i] = scores[i - 1];
                noms[i] = noms[i - 1];
            }
            scores[index] = score;
            noms[index] = nom;
        }
    }

    public String toString() {
        String result = "Meilleurs scores :\n";
        for (int i = 0; i < scores.length; i++) {
            result += (i + 1) + ". " + noms[i] + " - " + scores[i];
            if (i < scores.length - 1) {
                result += "\n";  // Ajouter un saut de ligne sauf pour le dernier score
            }
        }
        return result;
    }

}
