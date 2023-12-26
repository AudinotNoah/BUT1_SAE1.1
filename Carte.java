/**
 * La classe Carte représente une carte très simple avec une seule valeur.
 */
public class Carte {

  /** La valeur de la carte */
  private int valeur;

  /**
   * Constructeur de la classe Carte.
   * 
   * @param val Valeur de la carte à initialiser.
   */
  public Carte(int val) {
    this.valeur = val;
  }

  /**
   * Compare la valeur de la carte actuelle avec une autre carte pour déterminer
   * si elle est plus grande.
   * 
   * @param c2 La carte à comparer.
   * @return true si la carte actuelle a une valeur plus grande que la carte c2,
   *         sinon false.
   */
  public boolean etrePlusGrand(Carte c2) {
    return (this.valeur > c2.getValeur());
  }

  /**
   * Vérifie si la différence entre la valeur de la carte actuelle et la valeur
   * d'une autre carte est égale à 10 (ou -10).
   * 
   * @param c2 La carte à comparer.
   * @return true si la différence est égale à 10 ou -10, sinon false.
   */
  public boolean avoirDiffDe10(Carte c2) {
    int diff = this.valeur - c2.getValeur();
    if (diff == 10 || diff == -10) {
      return true;
    }
    return false;
  }

  /**
   * Getter pour obtenir la valeur de la carte.
   * 
   * @return La valeur de la carte.
   */
  public int getValeur() {
    return this.valeur;
  }

  /**
   * Convertit la carte en une représentation sous forme de chaîne de caractères.
   * 
   * @return Une chaîne de caractères représentant la carte, par exemple, "c5" pour
   *         une carte avec une valeur de 5.
   */
  public String toString() {
    return "c" + this.valeur;
  }

}
