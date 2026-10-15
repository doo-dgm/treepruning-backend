package co.edu.uco.treepruning.infrastructure.controller;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.person.createperson.application.inputport.CreatePersonInputPort;
import co.edu.uco.treepruning.features.person.createperson.application.inputport.dto.CreatePersonDTO;
import co.edu.uco.treepruning.features.person.deleteperson.application.inputport.DeletePersonInputPort;
import co.edu.uco.treepruning.features.person.updateperson.application.inputport.UpdatePersonInputPort;
import co.edu.uco.treepruning.features.person.updateperson.application.inputport.dto.UpdatePersonDTO;
import co.edu.uco.treepruning.infrastructure.controller.request.CreatePersonRequest;
import co.edu.uco.treepruning.infrastructure.controller.request.UpdatePersonRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Personas", description = "Gestion de persona")
@RestController
@RequestMapping("/api/v1/persons")
public class ManagePersonController {

    private final CreatePersonInputPort createPersonInputPort;
    private final UpdatePersonInputPort updatePersonInputPort;
    private final DeletePersonInputPort deletePersonInputPort;
    private final MessageCatalogService catalog;

    public ManagePersonController(
            CreatePersonInputPort createPersonInputPort,
            UpdatePersonInputPort updatePersonInputPort,
            DeletePersonInputPort deletePersonInputPort,
            MessageCatalogService catalog) {
        this.createPersonInputPort = createPersonInputPort;
        this.updatePersonInputPort = updatePersonInputPort;
        this.deletePersonInputPort = deletePersonInputPort;
        this.catalog = catalog;
    }

    @Operation(summary = "Registrar persona")
    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createPerson(
            @RequestBody CreatePersonRequest request) {
        createPersonInputPort.execute(new CreatePersonDTO(request.firstName(), request.secondName(), request.firstLastName(), request.secondLastName(), request.document(), request.documentNumber(), request.birthDate(), request.address(), request.email(), request.phone()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.created(catalog.resolve("SUCCESS.PERSON.CREATED"), null));
    }

    @Operation(summary = "Actualizar persona")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updatePerson(
            @Parameter(description = "Identificador unico") @PathVariable UUID id,
            @RequestBody UpdatePersonRequest request) {
        updatePersonInputPort.execute(new UpdatePersonDTO(id, request.firstName(), request.secondName(), request.firstLastName(), request.secondLastName(), request.document(), request.documentNumber(), request.birthDate(), request.address(), request.email(), request.phone()));
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PERSON.UPDATED"), null));
    }

    @Operation(summary = "Eliminar persona")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePerson(
            @Parameter(description = "Identificador unico") @PathVariable UUID id) {
        deletePersonInputPort.execute(id);
        return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.PERSON.DELETED"), null));
    }
}
