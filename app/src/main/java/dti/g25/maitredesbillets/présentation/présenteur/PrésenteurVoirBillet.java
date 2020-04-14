package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;

import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.interacteur.CréationBillet;
import dti.g25.maitredesbillets.présentation.ContratVuePrésenteurVoirBillet;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.ui.activité.créerBilletActivity;

public class PrésenteurVoirBillet implements ContratVuePrésenteurVoirBillet.IPrésenteurVoirBillet{

    private static final String EXTRA_POSITION_BILLET = "dti.g25.maitredesbillets.positionBillet";
    private static final String EXTRA_DESCRIPTION_BILLET = "dti.g25.maitredesbillets.descriptionBillet";
    private static final String EXTRA_TITRE_BILLET = "dti.g25.maitredesbillets.titreBillet";
    private static final String EXTRA_POSITION_PROJET = "dti.g25.maitredesbillets.positionProjet";
    private static final int REQUEST_CODE_AJOUTER_BILLET= 5;

    private ContratVuePrésenteurVoirBillet.IVueVoirBille vue;
    private Modèle modèle;
    private Activity activité;

    private int positionProjet;

    /**
     * Constructeur du presentateur du billet
     * @param activité Activité dans laquelle le billet agit
     * @param vue  La vue qui est relié au billet, qui sera la vue principale
     * @param modèle le modele du MVP
     * @param positionProjet l'emplacement du projet en int
     */
    public PrésenteurVoirBillet(Activity activité, ContratVuePrésenteurVoirBillet.IVueVoirBille vue, Modèle modèle, int positionProjet) {
        this.activité=activité;
        this.modèle=modèle;
        modèle.setDaoBillets(positionProjet);
        this.vue=vue;
        this.positionProjet = positionProjet;
    }

    /**
     *
     * @param position position du billet
     * @return le titre du billet en String
     */
    @Override
    public String getTitreBillet(int position) {
        return modèle.getDAOBillets(positionProjet).get(position).lire().getTitre();
    }

    /**
     * permet d'afficher les détail d'un billet
     * @param position la positon du billet
     */
    @Override
    public void requêteAfficherDétailBillet(int position) {

    }

    /**
     * Supprime le billet du modele et raffraichit la vue
     * @param position position du billet
     */
    @Override
    public void requêteSupprimerBillet(int position) {
        modèle.supprimerBillet(position);
        modèle.rafraichir();
        vue.rafraîchir();
    }

    /**
     * Crée l'intention pour modifier un projet et débutel 'activité
     * @param position position du billet
     */
    @Override
    public void requêteModifierBillet(int position) {

    }

    /**
     * Permet d'obtenir le nombre de bilelt présent dans un projet
     * @return le nombre de billet dans un projet
     */
    @Override
    public int getNombreItems() {
        if(modèle.getBillets(positionProjet) == null)
            return 0;
        return modèle.getDAOBillets(positionProjet).size();
    }

    /**
     * Crée l'intention pour la création d'un billet
     */
    @Override
    public void requêteCréerBillet() {
        Intent intentModif=new Intent(activité, créerBilletActivity.class);
        activité.startActivityForResult(intentModif, REQUEST_CODE_AJOUTER_BILLET);
    }

    /**
     * traite ;es novelle donné lorsque l'on revien d'une autre activité
     * @param requestCode le code de la requete
     * @param resultCode le code du résultat de la reuqete
     * @param data toute donné de l'activité qui viens de s'arrêter
     * @throws Exception Totu ce qui pourait être mauvais avec le billet
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) throws  Exception{

        if (requestCode==REQUEST_CODE_AJOUTER_BILLET&&resultCode==Activity.RESULT_OK){
            String titreBillet=data.getStringExtra(EXTRA_TITRE_BILLET);
            String descriptionBillet= data.getStringExtra(EXTRA_DESCRIPTION_BILLET);
            Billet billet= CréationBillet.créerBillet(titreBillet,descriptionBillet);
            modèle.ajouterDAOBillet(positionProjet, billet);
            modèle.setDaoBillets(positionProjet);
            vue.rafraîchir();
        }
    }

}
