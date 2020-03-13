package dti.g25.maitredesbillets.présentation.présenteur;

import android.app.Activity;
import android.content.Intent;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.présentation.ContratVuePrésenteurVoirBillet;
import dti.g25.maitredesbillets.présentation.modèle.Modele;
import dti.g25.maitredesbillets.ui.activité.créerBilletActivity;

public class PrésenteurVoirBillet implements ContratVuePrésenteurVoirBillet.IPrésenteurVoirBillet{

    public static final String EXTRA_À_MODIFIER="dti.g25.maitredesbillets.à_modifier";
    public static final String EXTRA_POSITION="dti.g25.maitredesbillets.position";

    private ContratVuePrésenteurVoirBillet.IVueVoirBille vue;
    private Modele modèle;
    private Activity activité;

    public PrésenteurVoirBillet(Activity activité, ContratVuePrésenteurVoirBillet.IVueVoirBille vue, Modele modèle) {
        this.activité=activité;
        this.modèle=modèle;
        this.vue=vue;
    }

    @Override
    public String getTitreBillet(int position) {
        return "" ;
        // modèle.get(position).getTitre();
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

    @Override
    public void requêteCréerBillet() {

    }

    @Override
    public int getNombreItems() {
       // return modèle.size();
        return 0;
    }

    /*
    @Override
    public void requêteCréerBillet(){
        Intent intentModif=new Intent(activité, créerBilletActivity.class);

        activité.startActivityForResult(intentModif, MODIF_NOMBRE);
    }
    */
    /*
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==MODIF_NOMBRE && resultCode==Activity.RESULT_OK){
            Billet billet=data.getString();
            int position=data.getIntExtra(EXTRA_POSITION, -1);

            if(position>-1){
                modèle.set(position, new Billet(billet));
                vue.rafraîchir();
            }
        }
    }
    */
}
