package dti.g25.maitredesbillets.présentation;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public interface ContratVuePrésenteurCréerBillet {

    public interface  IVueCréerBillet{
        public String getTitreBillet();
        public String getDescriptionBillet();

    }

    public interface  IPrésenteurCréerBillet{
        public void terminerÉdition();
        public void commencerCréeation(int position);
    }

}
