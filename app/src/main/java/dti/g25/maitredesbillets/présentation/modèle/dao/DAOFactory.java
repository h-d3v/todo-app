package dti.g25.maitredesbillets.présentation.modèle.dao;

import android.content.Context;
import dti.g25.maitredesbillets.domaine.entité.Billet;
import dti.g25.maitredesbillets.domaine.entité.Projet;

import java.util.List;

/***
 *Factory permettant de creer des objets d'acces aux donnees
 */
public abstract class DAOFactory {
    /***
     *
     * @param context
     * @return DAO<Projet>
     */
    public abstract DAO<Projet> creerDAOProjet(Context context);

    /***
     *
     * @param context
     * @return List<DAO<Projet>>
     */
    public abstract List<DAO<Projet>> creerListeDAOProjet(Context context);

    /***
     *
     * @param context
     * @param unProjet
     * @return  List<DAO<Billet>> la liste de billet selon l' objet d'access aux donnees projet
     */
    public abstract List<DAO<Billet>> creerListeDAOBilletParProjet(Context context, DAO<Projet> unProjet);

    /***
     *
     * @param context
     * @param unProjet
     * @param unBillet
     * @return
     */
    public abstract Billet ajouterBilletAuProjet(Context context, DAO<Projet> unProjet, Billet unBillet);

}
