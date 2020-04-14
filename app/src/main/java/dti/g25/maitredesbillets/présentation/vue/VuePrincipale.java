package dti.g25.maitredesbillets.présentation.vue;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.jetbrains.annotations.NotNull;

import dti.g25.maitredesbillets.R;
import dti.g25.maitredesbillets.présentation.ContratVuePresenteurPrincipal;
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class VuePrincipale extends Fragment implements ContratVuePresenteurPrincipal.IVuePrincipale {
    private RecyclerView _rvProjets;
    private ProjetAdapter _pjAdapter;
    private ContratVuePresenteurPrincipal.IPresenteurPrincipal _presenteur;

    /**
     * @param presenteur le presenteur de la vue
     */
    public void setPresenteur(ContratVuePresenteurPrincipal.IPresenteurPrincipal presenteur) {
        _presenteur=presenteur;
    }


    /**
     * rafraichis la vue
     */
    @Override
    public void rafraichir() {
        if(_pjAdapter!=null)
            _pjAdapter.notifyDataSetChanged();
    }


    /**
     * Cree la vue
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return la vue
     */
    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        View vue = inflater.inflate(R.layout.frag_principal, container, false);
        _rvProjets = vue.findViewById(R.id.rvProjet);
        _pjAdapter = new ProjetAdapter(_presenteur);
        _rvProjets.setAdapter(_pjAdapter);
        _rvProjets.setLayoutManager(new LinearLayoutManager(getContext()));

        vue.findViewById(R.id.btnNouveauProjet).setOnClickListener(new View.OnClickListener() {
            /**
             * Au clique du boutton de la vue, une requete de nouveau projet
             * sera faite au présenteur
             * @param v la vue
             */
            @Override
            public void onClick(View v) {
                _presenteur.requeteNouveauProjet();
            }
        });
        //sert au swipe gauche pour le rv
        ItemTouchHelper itemTouchHelper= new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(_rvProjets);
        return vue;
    }

        //cree le swipe gauche pour le rv
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {

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
                int position=viewHolder.getAdapterPosition();
                _presenteur.requeteSupprimerProjet(position);
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
