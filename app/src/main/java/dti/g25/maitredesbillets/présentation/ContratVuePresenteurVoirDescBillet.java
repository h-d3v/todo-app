package dti.g25.maitredesbillets.présentation;

public interface ContratVuePresenteurVoirDescBillet {

    interface IVueVoirDescBillet{
    }

    interface IPresenteurVoirDescBillet{
        String getTitreBillet();

        String getDescBillet();

    }

}
