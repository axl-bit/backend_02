package pe.company.pmmcourier.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.company.pmmcourier.model.Tarifa;
import pe.company.pmmcourier.service.TarifaService;

@RestController
@RequestMapping("/Tarifa")
public class TarifaController {

	@Autowired
	private TarifaService service;
	
	public TarifaController() {
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Tarifa> tarifa = service.findAll();
		return new ResponseEntity<>(tarifa, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer tarifaId){
		Tarifa tarifa = service.findById(tarifaId);
		if(tarifa == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no se encontro tarifa con ese id");
		}
		return new ResponseEntity<>(tarifa, HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Tarifa tarifa){
		
		service.insert(tarifa);
		
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("codigo", "OK");
		respuesta.put("mensaje", "se creo correctamente la tarifa");
		
		return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar/{TarifaID}")
	public ResponseEntity<?> editar(@PathVariable Integer TarifaID, @RequestBody Tarifa tarifa){
		
		Tarifa tarifaActual = service.findById(TarifaID);
		
		if(tarifaActual != null) {
			
			tarifaActual.setTarifa(tarifa.getTarifa());
			
			service.update(tarifaActual);
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("codigo", "OK");
			respuesta.put("mensaje", "se actualizo correctamente la tarifa");
			
			
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{tarifaId}")
	public ResponseEntity<?> borrar(@PathVariable Integer tarifaId){
		
		Tarifa tarifa= service.findById(tarifaId);
		
		if(tarifa!=null) {
			
			service.delete(tarifaId);
			
			Map<String, String> respuesta = new HashMap<>();
			respuesta.put("codigo", "OK");
			respuesta.put("mensaje", "se elimino correctamente la tarifa");
			
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
