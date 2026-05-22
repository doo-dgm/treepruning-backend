package co.edu.uco.treepruning.application.usecase;

public interface UseCase<D, R> {
    R execute(D data);  
}
