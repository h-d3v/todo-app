package dti.g25.maitredesbillets.domaine.interacteur;

import dti.g25.maitredesbillets.domaine.entité.Billet;


/**
 * Interface de persistance d'un compteur
 *
 */
public interface IPersistanceCompte {

	/**
	 * Sauvegarde les données d'un compteur
	 *
	 * @param billet Le billet à sauvegarder
	 *
	 * @throws PersistanceException si une erreur survient pendant la sauvegarde
	 */

    public void sauvegarder(Billet billet) throws PersistanceException;

    /**
	 * Récupère un compte sauvegardé
	 *
	 * @return un Billet
	 */
	public Billet récupérer() throws PersistanceException;
}
