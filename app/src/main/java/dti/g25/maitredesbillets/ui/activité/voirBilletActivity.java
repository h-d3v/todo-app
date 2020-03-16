package dti.g25.maitredesbillets.ui.activité;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
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
        ft.add(R.id.LayoutVoirBillet, vue);
        ft.commit();
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        présenteur.onActivityResult(requestCode, resultCode, data);
    }
    */
}
