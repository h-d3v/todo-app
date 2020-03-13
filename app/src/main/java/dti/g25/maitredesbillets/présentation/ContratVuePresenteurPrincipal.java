package dti.g25.maitredesbillets.présentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *le contrat entre la vue et le présenteur
 * pour s'assurer des rôles de chacuns
 */
public interface ContratVuePresenteurPrincipal {

     interface IVuePrincipale{
         void rafraichir();
    }

    interface IPresenteurPrincipal {
        void requeteNouveauProjet();
        void requeteAccederProjet(int position);
        void requeteModificationProjet(int position);
        void requeteSupprimerProjet(int position);
        int getNbItems();
        String getItemString(int position);
    }
}
