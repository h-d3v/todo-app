package dti.g25.maitredesbillets.présentation;

import android.content.Intent;

public interface ContratVuePresenteurVoirDescBillet {

    interface IVueVoirDescBillet{
    }

    interface IPresenteurVoirDescBillet{
        String getTitreBillet();

        String getDescBillet();

    }

}
