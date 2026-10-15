package co.edu.uco.treepruning.infrastructure.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.treepruning.crosscutting.catalog.MessageCatalogService;
import co.edu.uco.treepruning.crosscutting.exception.ResourceNotFoundException;
import co.edu.uco.treepruning.crosscutting.response.ApiResponse;
import co.edu.uco.treepruning.features.country.exploreregisteredcountries.application.inputport.ExploreRegisteredCountriesInputPort;
import co.edu.uco.treepruning.features.country.exploreregisteredcountries.application.inputport.dto.ExploreCountriesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Paises", description = "Consulta de paises")
@RestController
@RequestMapping("/api/v1/countries")
public class GetCountryController {
	
	private final ExploreRegisteredCountriesInputPort inputPort;
	private final MessageCatalogService catalog;
	
	public GetCountryController(ExploreRegisteredCountriesInputPort inputPort, MessageCatalogService catalog) {
		this.inputPort = inputPort;
		this.catalog = catalog;
	}
	
	@Operation(summary = "Listar paises", description = "Retorna todos los paises registrados en el sistema.")
	@GetMapping
	public ResponseEntity<ApiResponse<List<ExploreCountriesDTO>>> getAllCountries(
		@Parameter(description = "Lista de paises registrados en el sistema") @RequestParam(required = false) UUID id,
		@Parameter(description = "Nombre del pais") @RequestParam(required = false) String name,
		@Parameter(description = "Codigo ISO del pais") @RequestParam(required = false) String isoCode
		
		) {
		List<ExploreCountriesDTO> results = inputPort.execute(
				new ExploreCountriesDTO(id, name, isoCode));
		
		return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.COUNTRY.LIST"), results));
}

	@Operation(summary = "Obtener pais por ID", description = "Retorna el detalle de un pais dado su identificador. Responde 404 si no existe.")
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ExploreCountriesDTO>> getById(
		@Parameter(description = "Identificador unico del pais") @PathVariable UUID id) {
		List<ExploreCountriesDTO> results = inputPort.execute(new ExploreCountriesDTO(id));
		if (results.isEmpty()) {
			throw ResourceNotFoundException.create("Country", id);
		}
		return ResponseEntity.ok(ApiResponse.ok(catalog.resolve("SUCCESS.COUNTRY.GET"), results.get(0)));
	}

}
