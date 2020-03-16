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

    private static final String EXTRA_POSITION = "dti.g25.maitredesbillets.position";
    private static final String EXTRA_DESCRIPTION_BILLET = "dti.g25.maitredesbillets.descriptionBillet";
    private static final String EXTRA_TITRE_BILLET = "dti.g25.maitredesbillets.titreBillet";

    private ContratVuePrésenteurVoirBillet.IVueVoirBille vue;
    private Modèle modèle;
    private Activity activité;

    public PrésenteurVoirBillet(Activity activité, ContratVuePrésenteurVoirBillet.IVueVoirBille vue, Modèle modèle) {
        this.activité=activité;
        this.modèle=modèle;
        this.vue=vue;
    }

    @Override
    public String getTitreBillet(int position) {
        return modèle.getBillets().get(position).getTitre();
    }

    @Override
    public void requêteAfficherDétailBillet(int position) {

    }

    @Override
    public void requêteSupprimerBillet(int position) {

    }

    @Override
    public void requêteModifierBillet(int position) {

    }

    /*
    @Override
    public void requêteCréerBillet() {
        CréationBillet interacteur=new CréationBillet();
        Billet billet=interacteur.créerBillet("Bruh", "ok", 2, 3);
        ArrayList<Billet> billets = modèle.getBillets();
        billets.add(billet);
        modèle.setBillets(billets);
        vue.rafraîchir();
    }
    */

    @Override
    public int getNombreItems() {
        if(modèle.getBillets() == null)
            return 0;
        return modèle.getBillets().size();
    }

    @Override
    public void requêteCréerBillet(){
        Intent intentModif=new Intent(activité, créerBilletActivity.class);

        activité.startActivityForResult(intentModif, 20);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==Activity.RESULT_OK){
            String titreBillet=data.getStringExtra(EXTRA_TITRE_BILLET);
            String descriptionBillet= data.getStringExtra(EXTRA_DESCRIPTION_BILLET);
            int position=data.getIntExtra(EXTRA_POSITION, -1);

            modèle.modifierBillets(position, titreBillet, descriptionBillet);
            vue.rafraîchir();
        }
    }
}
