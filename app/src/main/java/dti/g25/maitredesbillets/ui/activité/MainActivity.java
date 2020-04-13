package dti.g25.maitredesbillets.ui.activité;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.dao.DAOFactorySQLite;
import dti.g25.maitredesbillets.dao.SQLiteConnection;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.présentation.présenteur.PresenteurPrincipal;
import dti.g25.maitredesbillets.présentation.vue.VuePrincipale;

public class MainActivity extends AppCompatActivity {

    PresenteurPrincipal _presenteur;

    /**
     * Initialise la vue pour l'activité principale ansi que le présenteur
     * pour la vue
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Modèle modele=new Modèle(this, new DAOFactorySQLite());
        VuePrincipale vue=new VuePrincipale();
        _presenteur= new PresenteurPrincipal(this, vue, modele);

        vue.setPresenteur(_presenteur);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_principal, vue);
        ft.commit();
    }

    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        _presenteur.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SQLiteConnection.close();
    }

}
