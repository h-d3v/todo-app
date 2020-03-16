package dti.g25.maitredesbillets.présentation.vue;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurPrincipal;


public class ProjetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ContratVuePresenteurPrincipal.IPresenteurPrincipal _presenteur;

    /**
     * @param presenteur le presenteur dans lequel se trouve le rv des projets
     */
    public ProjetAdapter(ContratVuePresenteurPrincipal.IPresenteurPrincipal presenteur) {
        _presenteur=presenteur;
    }

    /**
     * @param parent
     * @param viewType
     * @return le view holder
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout racine = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.projet_view, parent, false);

        return new RecyclerView.ViewHolder(racine){};

    }


    /**
     *
     * @param holder le holder
     * @param position la position du projets dans le rv
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ImageButton)holder.itemView.findViewById(R.id.btnAcceder)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View bouton){
                _presenteur.requeteAccederProjet(position);
            }
        });

        ((TextView)holder.itemView.findViewById(R.id.tvProjet)).setText(_presenteur.getItemString(position));
    }

    /**
     * @return le nombre d'item dans le rv
     */
    @Override
    public int getItemCount() {
        if(_presenteur==null) return 0;
        return _presenteur.getNbItems();
    }
}
