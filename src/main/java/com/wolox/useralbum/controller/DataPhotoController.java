package com.wolox.useralbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.useralbum.integration.model.Photo;
import com.wolox.useralbum.service.PhotoServiceImpl;

/**
 * @author Paola Pino 
 * Se obtiene la información de las fotografias, por medio del servicio externo
 */

@RestController
@RequestMapping("/photos")
@CrossOrigin(origins = "*")
public class DataPhotoController {
	
	@Autowired
	private PhotoServiceImpl service;

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de todos los usuarios
	 */
	
	@GetMapping("/")
	public List<Photo> findAll() {
		return service.findAll();
	}

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de un usuario por Id
	 */
	
	@GetMapping("/{id}")
	public Photo findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
}
