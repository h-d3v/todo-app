package dti.g25.maitredesbillets.modele.dao;

import android.content.Context;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;

import java.util.List;

public abstract class DAOFactory {
    public abstract DAO<Projet> creerDAOProjet(Context context);

    public abstract List<DAO<Projet>> creerListeDAOProjet(Context context);

    public abstract List<DAO<Billet>> creerListeDAOBilletParProjet(Context context, DAO<Projet> unProjet);

    public abstract Billet ajouterBilletAuProjet(Context context, DAO<Projet> unProjet, Billet unBillet);
}
