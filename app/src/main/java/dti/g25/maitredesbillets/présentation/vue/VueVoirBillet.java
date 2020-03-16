package dti.g25.maitredesbillets.présentation.vue;


import dti.g25.maitredesbillets.présentation.ContratVuePrésenteurVoirBillet;
import dti.g25.maitredesbillets.R;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
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

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    //cree le swipe gauche pour le rv
    final ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

        /**
         * Cette méthode n'Est pa utilisée pour l'intsant
         * @param recyclerView le rv des projets
         * @param viewHolder
         * @param target
         * @return null
         */
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        /**
         * Ce qu'il se passe quand on swipe un element du rv selon une direction
         * @param viewHolder le viewHolder
         * @param direction la dr
         */
        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            présenteur.requêteSupprimerBillet(position);
        }

        /**
         * Décore le swipe vers la droite, y met la couleure ansi que l'icone
         * J'ai pris cette méthode d'une librairie sur git, voir le fichier gradle.build de l'app
         * @param c
         * @param recyclerView
         * @param viewHolder
         * @param dX
         * @param dY
         * @param actionState
         * @param isCurrentlyActive
         */
        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent))
                    .addActionIcon(R.drawable.ic_remove_circle_black_24dp)
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    };


}
