package dti.g25.maitredesbillets.présentation.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurPrincipal;

public class VuePrincipale extends Fragment implements ContratVuePresenteurPrincipal.IVuePrincipale {
    private RecyclerView _rvProjets;
    private ProjetAdapter _pjAdapter;
    private ContratVuePresenteurPrincipal.IPresenteurPrincipal _presenteur;

    public void setPresenteur(ContratVuePresenteurPrincipal.IPresenteurPrincipal presenteur) {
        _presenteur=presenteur;
    }


    @Override
    public void rafraichir() {
        if(_pjAdapter!=null)
            _pjAdapter.notifyDataSetChanged();
    }


    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState){
        View vue=inflater.inflate(R.layout.frag_principal, container, false);
        _rvProjets=vue.findViewById(R.id.rvProjet);
        _pjAdapter=new ProjetAdapter(_presenteur);
        _rvProjets.setAdapter(_pjAdapter);
        _rvProjets.setLayoutManager(new LinearLayoutManager(getContext()));

        vue.findViewById(R.id.btnNouveauProjet).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                _presenteur.requeteNouveauProjet();
            }
        });

        return vue;
    }
}
