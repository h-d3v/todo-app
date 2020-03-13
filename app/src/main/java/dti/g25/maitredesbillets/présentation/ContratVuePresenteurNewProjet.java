package dti.g25.maitredesbillets.présentation;

import dti.g25.maitredesbillets.domaine.entité.Projet;

public interface ContratVuePresenteurNewProjet {

    public interface IVueNewProjet{
        String getTitre();
        public boolean verifierTitre();
    }

    public interface IPresenteurNewProjet{
        void creationNouveauProjet();
    }



}
