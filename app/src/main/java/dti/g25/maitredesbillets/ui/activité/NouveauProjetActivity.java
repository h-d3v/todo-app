package dti.g25.maitredesbillets.ui.activité;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.présentation.présenteur.PresenteurNewProjet;
import dti.g25.maitredesbillets.présentation.vue.VueNewProjet;



public class NouveauProjetActivity extends AppCompatActivity {

    public static final String EXTRA_TITRE_NEW_PROJET="dti.g25.maitre-des-tickets.titre_new_projet";

    private PresenteurNewProjet _presenteur;

    /**
     * Initialise la vue ainsi que le présenteur pour cette activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_projet);

        VueNewProjet vue = new VueNewProjet();
        Modèle modele = new Modèle();

        _presenteur=new PresenteurNewProjet(this, vue, modele);
        vue.setPresenteur(_presenteur);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_new_projet, vue);
        ft.commit();
    }

    /**
     * Lorsqu'elle démare, on initialise le nouveau titre du projet
     */
    @Override
    protected void onStart(){
        super.onStart();
        String titre=getIntent().getStringExtra(EXTRA_TITRE_NEW_PROJET);
    }
}
