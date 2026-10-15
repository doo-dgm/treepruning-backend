package co.edu.uco.treepruning.features.tool.updatetool.application.usecase.impl;

import co.edu.uco.treepruning.features.tool.updatetool.application.usecase.UpdateToolUseCase;
import co.edu.uco.treepruning.features.tool.updatetool.application.usecase.domain.UpdateToolDomain;
import org.springframework.stereotype.Service;

@Service
public class UpdateToolUseCaseImpl implements UpdateToolUseCase {

    @Override
    public Void execute(UpdateToolDomain data) {
        throw new UnsupportedOperationException(
                "No implementado todavia: este flujo esta generado como andamiaje y falta definir su logica de negocio.");
    }
}
