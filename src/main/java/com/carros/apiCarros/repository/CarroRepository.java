package com.carros.apiCarros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.apiCarros.models.Carro;
import com.carros.apiCarros.models.Marca;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

	Carro findById(int id);
	
	List<Carro> findByMarca(Marca marca);
}
