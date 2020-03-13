package dti.g25.maitredesbillets.ui.activité;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.modèle.Modele;
import dti.g25.maitredesbillets.présentation.présenteur.PresenteurPrincipal;
import dti.g25.maitredesbillets.présentation.vue.VuePrincipale;

public class MainActivity extends AppCompatActivity {

    PresenteurPrincipal _presenteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Modele modele=new Modele();
        VuePrincipale vue=new VuePrincipale();
        _presenteur= new PresenteurPrincipal(this, vue, modele);

        vue.setPresenteur(_presenteur);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_principal, vue);
        ft.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        _presenteur.onActivityResult(requestCode, resultCode, data);
    }
}
