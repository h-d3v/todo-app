package dti.g25.maitredesbillets.présentation.vue;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePrésenteurVoirBillet;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class BilletAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ContratVuePrésenteurVoirBillet.IPrésenteurVoirBillet présenteur;

    public BilletAdapter(ContratVuePrésenteurVoirBillet.IPrésenteurVoirBillet présenteur) {
        this.présenteur=présenteur;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        LinearLayout racine = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.billet_view, parent, false);

        return new RecyclerView.ViewHolder(racine){};
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
//        ((ImageButton)holder.itemView.findViewById(R.id.btnVoirDétail)).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View bouton){
//                //présenteur.requêteAfficherDétailBillet(position);
//            }
//        });
        ((TextView)holder.itemView.findViewById(R.id.txtTitreBillet)).setText(présenteur.getTitreBillet(position));
    }

    @Override
    public int getItemCount(){
        if(présenteur==null) return 0;

        return présenteur.getNombreItems();
    }
}
