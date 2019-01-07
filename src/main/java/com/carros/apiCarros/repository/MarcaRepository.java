package com.carros.apiCarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.apiCarros.models.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

	Marca findById(int id);
}
