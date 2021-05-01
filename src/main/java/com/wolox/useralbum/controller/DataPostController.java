package com.wolox.useralbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.useralbum.integration.model.Post;
import com.wolox.useralbum.service.PostServiceImpl;


/**
 * @author Paola Pino 
 * Se obtiene la información de los posts, por medio del servicio externo
 */
@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*")
public class DataPostController {


	@Autowired
	private PostServiceImpl service;

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de todos los posts
	 */
	
	@GetMapping("/")
	public List<Post> findAll() {
		return service.findAll();
	}

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de un post por Id
	 */
	
	@GetMapping("/{id}")
	public Post findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

}
