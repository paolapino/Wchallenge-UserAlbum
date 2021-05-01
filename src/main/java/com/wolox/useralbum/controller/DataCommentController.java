package com.wolox.useralbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.useralbum.integration.model.Comment;
import com.wolox.useralbum.service.CommentServiceImpl;


/**
 * @author Paola Pino 
 * Se obtiene la información de los usuarios, por medio del servicio externo
 */
@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*")
public class DataCommentController {
	
	@Autowired
	private CommentServiceImpl service;
	
	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de todos los comentarios
	 */
	
	@GetMapping("/")
	public List<Comment> findAll() {
		return service.findAll();
	}

	/**
	 * Expone la respuesta del servicio, encargado de obtener la información registrada de un comentario por Id
	 */
	@GetMapping("/{id}")
	public Comment findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@GetMapping(params = "name")
	public List<Comment> findByName(@RequestParam(required = false, name = "name") String name){
		return service.findByName(name);
	}
    
}
