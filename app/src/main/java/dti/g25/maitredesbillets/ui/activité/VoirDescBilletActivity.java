package dti.g25.maitredesbillets.ui.activité;

import android.app.TaskInfo;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.dao.DAOFactorySQLite;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurVoirDescBillet;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.présentation.présenteur.PresenteurVoirDescBillet;
import dti.g25.maitredesbillets.présentation.vue.VueVoirDescBillet;

public class VoirDescBilletActivity extends AppCompatActivity {

    private ContratVuePresenteurVoirDescBillet.IPresenteurVoirDescBillet _presenteur;

    /**
     * Initialise la vue ainsi que le présenteur pour cette activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_desc_billet);
        Modèle modèle= new Modèle(this, new DAOFactorySQLite());
        VueVoirDescBillet vue = new VueVoirDescBillet();
        int positionBillet = getIntent().getIntExtra( "EXTRA_POSITION_BILLET", -1);
        int positionProjet= getIntent().getIntExtra("EXTRA_POSITION_PROJET", -2);
        _presenteur=new PresenteurVoirDescBillet(this, vue, modèle,positionBillet, positionProjet);
        vue.setPresenteur(_presenteur);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_voir_desc_billet, vue);
        ft.commit();
     }



}
