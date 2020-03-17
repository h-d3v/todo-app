package dti.g25.maitredesbillets.domaine.entité;

public enum Couleur
{
    BLEU ("#0000FF", "bleu"),
    BLEU_CIEL("#87CEEB", "bleu ciel");

    private final String VALEUR_HEX;
    private final String DESC;

    Couleur(String valeurHexadecimale, String description) {
        VALEUR_HEX = valeurHexadecimale;
        DESC = description;
    }

    public String getValeurHexadecimale() { return VALEUR_HEX; }

    @Override
    public String toString() { return DESC; }

}