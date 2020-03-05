package dti.g25.maitredesbillets.domaine.interacteurs;

public class PersistanceException extends Exception {
    public Exception exception;

    public PersistanceException(Exception e) {
        exception=e;
    }
}
