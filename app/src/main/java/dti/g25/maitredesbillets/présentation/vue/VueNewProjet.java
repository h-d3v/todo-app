package dti.g25.maitredesbillets.présentation.vue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurNewProjet;

public class VueNewProjet extends Fragment implements ContratVuePresenteurNewProjet.IVueNewProjet {

    private ContratVuePresenteurNewProjet.IPresenteurNewProjet _presenteur;

    private TextView _txtTitreNewProjet;

    /**
     * @param presenteur le presenteur de la vue
     */
    public void setPresenteur(ContratVuePresenteurNewProjet.IPresenteurNewProjet presenteur){
        _presenteur=presenteur;
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return la vue après qu'elle est été créée
     */
    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState){
        View racine=inflater.inflate(R.layout.frag_new_projet, container, false);
        racine.findViewById(R.id.btnCreerProjet).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                boolean verification=verifierTitre();
                if(verification) {
                    _presenteur.creationNouveauProjet();
                }
            }
        });


        _txtTitreNewProjet=racine.findViewById(R.id.txtTitreNewProjet);
        return racine;
    }

    /**
     * @return le titre du nouveau projet entré parl'utilisateur
     */
    @Override
    public String getTitre() {
        return _txtTitreNewProjet.getText().toString();
    }

    /**
     * Verifie si le titre du projet contient au moin 2 caracrtères
     * @return true si le titre est bon, false si non
     */
    public boolean verifierTitre(){
        if(_txtTitreNewProjet.getText().toString().trim().length()>=2){
            return true;
        }
        Toast.makeText(getContext(), "Le titre dois contenir au moin deux caractères", Toast.LENGTH_SHORT).show();
        return false;
    }


}
