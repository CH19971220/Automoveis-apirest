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

import com.carros.apiCarros.models.Carro;
import com.carros.apiCarros.models.Marca;
import com.carros.apiCarros.repository.CarroRepository;
import com.carros.apiCarros.repository.MarcaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Carros")
@CrossOrigin(origins="*")
public class CarroResource {
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	@GetMapping("/carros")
	@ApiOperation(value="Retorna uma lista de automóveis")
	public List<Carro> listaCarros() {
		return carroRepository.findAll();
	}

	@GetMapping("/carro/{id}")
	@ApiOperation(value="Retorna um automóvel de acordo com o id fornecido")
	public Carro listaCarroUnico(@PathVariable(value="id") int id) {
		return carroRepository.findById(id);
	}
	
	@GetMapping("/carro/marca/{id}")
	@ApiOperation(value="Retorna uma lista de automóveis de uma marca específica")
	public List<Carro> listaCarroByMarca(@PathVariable(value="id") int id) {
		Marca marca = marcaRepository.findById(id);
		return carroRepository.findByMarca(marca);
	}
	
	@PostMapping("/carro")
	@ApiOperation(value="Salva um novo automóvel")
	public Carro salvaCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}
	
	@PutMapping("/carro")
	@ApiOperation(value="Altera um automóvel")
	public Carro alteraCarro(@RequestBody Carro carro) {
		return carroRepository.save(carro);
	}
	
	@DeleteMapping("/carro")
	@ApiOperation(value="Deleta um automóvel")
	public void deletaMarca(@RequestBody Carro carro) {
		carroRepository.delete(carro);
	}
}
