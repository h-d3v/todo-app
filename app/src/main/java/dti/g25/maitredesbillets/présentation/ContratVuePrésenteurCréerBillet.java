package dti.g25.maitredesbillets.présentation;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public interface ContratVuePrésenteurCréerBillet {

    /**
     * contrate de la vue créer billet
     */
    public interface  IVueCréerBillet{
        public String getTitreBillet();
        public String getDescriptionBillet();

    }

    /**
     * contrat du présenteur créer billet
     */
    public interface  IPrésenteurCréerBillet{
        public void terminerÉdition();
        public void commencerCréeation(int position);
    }

}
