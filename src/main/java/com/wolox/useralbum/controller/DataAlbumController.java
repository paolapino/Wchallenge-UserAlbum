package com.wolox.useralbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.useralbum.integration.model.Album;
import com.wolox.useralbum.service.AlbumServiceImpl;

/**
 * @author Paola Pino 
 * Se obtiene la información de los albums, por medio del servicio externo
 */
@RestController
@RequestMapping("/albums")
@CrossOrigin(origins = "*")
public class DataAlbumController {
	
	@Autowired
	private AlbumServiceImpl service;

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de todos los albums 
	 */
	
	@GetMapping("/")
	public List<Album> findAll() {
		return service.findAll();
	}

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de un álbum por Id
	 */
	
	@GetMapping("/{id}")
	public Album findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}


}
