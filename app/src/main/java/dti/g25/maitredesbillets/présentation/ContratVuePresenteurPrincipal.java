package dti.g25.maitredesbillets.présentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface ContratVuePresenteurPrincipal {

    public interface IVuePrincipale{
        public void rafraichir();

        @SuppressLint("WrongViewCast")
        View onCreateView (LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState);
    }
    public interface IPresenteurPrincipal {
        void requeteNouveauProjet();
        void requeteAccederProjet(int position);
        void requeteModificationProjet(int position);
        int getNbItems();
        String getItemString(int position);
    }
}
