package dti.g25.maitredesbillets.présentation;

import dti.g25.maitredesbillets.domaine.entité.Billet;

public interface ContratVuePrésenteurVoirBillet{

    public interface  IVueVoirBille{
        public void rafraîchir();
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
