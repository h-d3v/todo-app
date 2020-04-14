package dti.g25.maitredesbillets.ui.activité;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.dao.DAOFactorySQLite;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.présentation.présenteur.PrésenteurVoirBillet;
import dti.g25.maitredesbillets.présentation.vue.VueVoirBillet;
public class voirBilletActivity extends AppCompatActivity {
    PrésenteurVoirBillet présenteur;

    /**
     * créer la forme de l'application
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_billet);

        Modèle modèle= new Modèle(this, new DAOFactorySQLite());
        VueVoirBillet vue=new VueVoirBillet();

        int positionProjet = getIntent().getIntExtra("EXTRA_POSITION_PROJET", -1);
        présenteur=new PrésenteurVoirBillet(this, vue, modèle, positionProjet);
        vue.setPrésenteur(présenteur);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_voir_billet, vue);
        ft.commit();
    }

    /**
     * Prend tout les réseultat des activité qui viens de se terminer
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            présenteur.onActivityResult(requestCode, resultCode, data);
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), (CharSequence) e, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
