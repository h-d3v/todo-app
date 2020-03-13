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

    public void setPresenteur(ContratVuePresenteurNewProjet.IPresenteurNewProjet presenteur){
        _presenteur=presenteur;
    }

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

    @Override
    public String getTitre() {
        return _txtTitreNewProjet.getText().toString();
    }

    public boolean verifierTitre(){
        if(_txtTitreNewProjet.getText().toString().trim().length()>2){
            return true;
        }
        Toast.makeText(getContext(), "Le titre dois contenir au moin deux caractères", Toast.LENGTH_SHORT).show();
        return false;
    }


}
