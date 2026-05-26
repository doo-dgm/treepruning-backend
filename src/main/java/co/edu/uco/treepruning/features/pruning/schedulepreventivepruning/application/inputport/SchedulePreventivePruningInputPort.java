package co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport;

import co.edu.uco.treepruning.application.inputport.InputPort;
import co.edu.uco.treepruning.features.pruning.schedulepreventivepruning.application.inputport.dto.SchedulePreventivePruningDTO;

/**
 * Programa una o varias podas preventivas (una por arbol).
 * Retorna la cantidad de podas creadas (igual al tamano de la lista de arboles).
 */
public interface SchedulePreventivePruningInputPort
        extends InputPort<SchedulePreventivePruningDTO, Integer> {

}
