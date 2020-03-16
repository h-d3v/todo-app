package dti.g25.maitredesbillets.ui.activité;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;

=======
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
>>>>>>> 8-visualition-de-projet
import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.modèle.Modèle;
import dti.g25.maitredesbillets.présentation.présenteur.PrésenteurVoirBillet;
import dti.g25.maitredesbillets.présentation.vue.VueVoirBillet;
public class voirBilletActivity extends AppCompatActivity {
    PrésenteurVoirBillet présenteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_billet);

        Modèle modèle=new Modèle();
        VueVoirBillet vue=new VueVoirBillet();


        présenteur=new PrésenteurVoirBillet(this, vue, modèle);
        vue.setPrésenteur(présenteur);

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_voir_billet, vue);
        ft.commit();
    }
<<<<<<< HEAD

=======
    /*
>>>>>>> 8-visualition-de-projet
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        présenteur.onActivityResult(requestCode, resultCode, data);
    }
}
