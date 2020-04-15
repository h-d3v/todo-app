package dti.g25.maitredesbillets.présentation.vue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurVoirDescBillet;

public class VueVoirDescBillet extends Fragment implements ContratVuePresenteurVoirDescBillet.IVueVoirDescBillet{
    private TextView _tvTitreBillet;
    private TextView _tvDescBillet;
    private ContratVuePresenteurVoirDescBillet.IPresenteurVoirDescBillet _presenteur;


    public void setPresenteur(ContratVuePresenteurVoirDescBillet.IPresenteurVoirDescBillet presenteur) {
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
        View racine=inflater.inflate(R.layout.frag_voir_desc_billet, container, false);
        _tvTitreBillet=racine.findViewById(R.id.tvTitreBillet);
        _tvDescBillet=racine.findViewById(R.id.tvDescBillet);
        _tvTitreBillet.setText(_presenteur.getTitreBillet());
        _tvDescBillet.setText(_presenteur.getDescBillet());
        return racine;
    }
}
