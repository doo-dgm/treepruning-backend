package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase;

import co.edu.uco.treepruning.application.usecase.UseCase;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.usecase.domain.SchedulePreventivePruningDomain;

/**
 * Programa una poda preventiva por cada arbol de {@link SchedulePreventivePruningDomain#getTrees()}.
 * Retorna la cantidad de podas efectivamente creadas.
 */
public interface SchedulePreventivePruningUseCase
        extends UseCase<SchedulePreventivePruningDomain, Integer> {

}
