package dti.g25.maitredesbillets.présentation;



/**
 * le contrat entre la vue et le présenteur
 * pour s'assurer des rôles de chacuns
 */
public interface ContratVuePresenteurNewProjet {

    public interface IVueNewProjet{
        String getTitre();
        public boolean verifierTitre();
    }

    public interface IPresenteurNewProjet{
        void creationNouveauProjet();
    }



}
