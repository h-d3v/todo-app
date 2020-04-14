package dti.g25.maitredesbillets.présentation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dti.g25.maitredesbillets.domaine.entité.Billet;

/**
 *le contrat entre la vue et le présenteur
 * pour s'assurer des rôles de chacuns
 */

public interface ContratVuePrésenteurVoirBillet{

    public interface  IVueVoirBille{
        public void rafraîchir();

        void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction);
    }

    public interface  IPrésenteurVoirBillet{
        public void requêteAfficherDétailBillet(int position);
        public void requêteSupprimerBillet(int position);
        public void requêteModifierBillet(int position);
        public void requêteCréerBillet();
        public int getNombreItems();
        public String getTitreBillet(int position);
    }
}
