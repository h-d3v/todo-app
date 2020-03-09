package dti.g25.maitredesbillets.présentation.vue;


import dti.g25.maitredesbillets.présentation.ContratVuePrésenteurVoirBillet;
import dti.g25.maitredesbillets.R;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;

public class VueVoirBillet extends Fragment implements ContratVuePrésenteurVoirBillet.IVueVoirBille {

    private RecyclerView rvBillets;
	private BilletAdapter billetAdapter;
	private ContratVuePrésenteurVoirBillet.IPrésenteurVoirBillet présenteur;

    public void setPrésenteur(ContratVuePrésenteurVoirBillet.IPrésenteurVoirBillet présenteur) {
        this.présenteur=présenteur;
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState){
        View vue=inflater.inflate(R.layout.fragement_voir_billet, container, false);

        rvBillets=(RecyclerView)vue.findViewById(R.id.rvBillets);
        billetAdapter=new BilletAdapter(présenteur);
        rvBillets.setAdapter(billetAdapter);
        rvBillets.setLayoutManager(new LinearLayoutManager(getContext()));
        ((Button)vue.findViewById(R.id.btnCréerBillet)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View bouton){
                présenteur.requêteCréerBillet();
            }
        });
        return vue;
    }

    @Override
    public void rafraîchir() {
        if(billetAdapter!=null)
            billetAdapter.notifyDataSetChanged();
    }
}
