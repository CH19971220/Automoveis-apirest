package com.carros.apiCarros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.apiCarros.models.Marca;
import com.carros.apiCarros.repository.MarcaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Carros")
@CrossOrigin(origins="*")
public class MarcaResource {
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@GetMapping("/marcas")
	@ApiOperation(value="Retorna uma lista de marcas de automóveis")
	public List<Marca> listaMarcas() {
		return marcaRepository.findAll();
	}
	
	@GetMapping("/marca/{id}")
	@ApiOperation(value="Retorna uma marca")
	public Marca listaMarcaUnica(@PathVariable(value="id") int id) {
		return marcaRepository.findById(id);
	}
	
	@PostMapping("/marca")
	@ApiOperation(value="Salva uma marca")
	public Marca salvaMarca(@RequestBody Marca marca) {
		return marcaRepository.save(marca);
	}
	
	@PutMapping("/marca")
	@ApiOperation(value="Altera uma marca")
	public Marca alteraMarca(@RequestBody Marca marca) {
		return marcaRepository.save(marca);
	}
	
	@DeleteMapping("/marca")
	@ApiOperation(value="Deleta uma marca")
	public void deletaMarca(@RequestBody Marca marca) {
		marcaRepository.delete(marca);
	}
}
