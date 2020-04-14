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
     * crée un DAO de Projet
     * @param context
     * @return DAO<Projet>
     */
    public abstract DAO<Projet> creerDAOProjet(Context context);

    /***
     *Crée une Liste DAO de Projets
     * @param context
     * @return List<DAO<Projet>>
     */
    public abstract List<DAO<Projet>> creerListeDAOProjet(Context context);

    /***
     * crée une Liste DAO de Billets par Projet (specifié en paramètre)
     * @param context
     * @param unProjet
     * @return  List<DAO<Billet>> la liste de billet selon l' objet d'access aux donnees projet
     */
    public abstract List<DAO<Billet>> creerListeDAOBilletParProjet(Context context, DAO<Projet> unProjet);

    /***
     * Ajoute un Billet (spécifié en paramètre) au Projet (spécifié en paramètre)
     * @param context
     * @param unProjet Le projet dans lequel le billet sera ajouté
     * @param unBillet le billet à ajouter
     * @return
     */
    public abstract Billet ajouterBilletAuProjet(Context context, DAO<Projet> unProjet, Billet unBillet);
}
