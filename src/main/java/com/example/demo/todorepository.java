package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface todorepository extends CrudRepository<todo, Long>{}