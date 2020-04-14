package dti.g25.maitredesbillets.domaine.entité;

public enum Couleur
{
    BLEU ("#0000FF", "bleu"),
    BLEU_CIEL("#87CEEB", "bleu ciel");

    private final String VALEUR_HEX;
    private final String DESC;

    /**
     * Construis un objet "couleur" avec une valeur Hexadecimale et un nom
     * @param valeurHexadecimale Valeur de la couleur en Hexadecimale
     * @param description Nom de la couleur
     */
    Couleur(String valeurHexadecimale, String description) {
        VALEUR_HEX = valeurHexadecimale;
        DESC = description;
    }

    /**
     *
     * @return la couleur en Hexadecimale
     */
    public String getValeurHexadecimale() { return VALEUR_HEX; }

    /**
     *
     * @return la couleur en String
     */
    @Override
    public String toString() { return DESC; }

}