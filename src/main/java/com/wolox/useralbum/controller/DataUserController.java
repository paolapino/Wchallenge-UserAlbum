package com.wolox.useralbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.useralbum.integration.model.User;
import com.wolox.useralbum.service.UserServiceImpl;

/**
 * @author Paola Pino 
 * Se obtiene la información de los usuarios, por medio del servicio externo
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class DataUserController {
	
	@Autowired
	private UserServiceImpl service;
	
	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de todos los usuarios
	 */
	
	@GetMapping("/")
	public List<User> findAll() {
		return service.findAll();
	}

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de un usuario por Id
	 */
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
}
