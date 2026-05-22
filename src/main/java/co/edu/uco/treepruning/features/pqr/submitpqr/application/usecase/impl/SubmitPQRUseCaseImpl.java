package co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.treepruning.crosscutting.exception.TreePruningException;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.SubmitPQRUseCase;
import co.edu.uco.treepruning.features.pqr.submitpqr.application.usecase.domain.SubmitPQRDomain;

@Service
public class SubmitPQRUseCaseImpl implements SubmitPQRUseCase {

    @Override
    public Void execute(SubmitPQRDomain data) {
        // PQR persistence layer and repository not yet implemented.
        throw TreePruningException.create(
                "La funcionalidad de radicación de PQR aún no está disponible.",
                "SubmitPQRUseCaseImpl.execute: not yet implemented — PQR repository pending");
    }
}
