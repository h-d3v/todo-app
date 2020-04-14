package dti.g25.maitredesbillets.ui.activité;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.dao.DAOFactorySQLite;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.présentation.présenteur.PrésenteurCréerBillet;
import dti.g25.maitredesbillets.présentation.vue.VueCréerBillet;

import static android.content.Intent.getIntent;

public class créerBilletActivity extends AppCompatActivity {

    private static final String EXTRA_POSITION = "dti.g25.maitredesbillets.position";
    private static final String EXTRA_DESCRIPTION_BILLET = "dti.g25.maitredesbillets.descriptionBillet";
    private static final String EXTRA_TITRE_BILLET = "dti.g25.maitredesbillets.titreBillet";

    private PrésenteurCréerBillet présenteur;

    /**
<<<<<<< HEAD
     * Initialise la vue pour l'activité Créer billet ansi que le présenteur
     * pour la vue
=======
     * Créer la forme du formulaire pour créer un billet
>>>>>>> 22-swipe-pour-supprimer-un-billet
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_billet);

        VueCréerBillet vue=new VueCréerBillet();
        Modèle modèle=new Modèle(this,new DAOFactorySQLite());

        présenteur=new PrésenteurCréerBillet(this, vue, modèle);
        vue.setPrésenteur(présenteur);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_creer_billet, vue);
        ft.commit();

    }

    /**
     * debute l'activité de creation d'un novueau billet
     */
    @Override
    protected void onStart(){
        super.onStart();
        int position= getIntent().getIntExtra(EXTRA_POSITION, -1);

        présenteur.commencerCréeation(position);
    }
}
