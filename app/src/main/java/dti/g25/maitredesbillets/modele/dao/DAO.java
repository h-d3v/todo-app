package dti.g25.maitredesbillets.modele.dao;

public interface DAO<T> {
     T creer(T t);
     T lire();
     T modifier(T t);
     boolean supprimer();
}
