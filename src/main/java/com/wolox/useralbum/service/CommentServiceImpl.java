package com.wolox.useralbum.service;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.useralbum.integration.model.Comment;


/**
 * @author Paola Pino
 */

@Service
public class CommentServiceImpl {

	@Autowired
	private RestTemplate restTemplate;

	// url servicio externo [comments]
	@Value("${url_comments_get}")
	protected String urlCommentsGet;

	/**
	 * Método que se encarga de obtener la información registrada de los
	 * comentarios, haciendo uso del servicio externo.
	 * @return Listado con la información de todos los comentarios
	 */
	public List<Comment> findAll() {
		return Arrays.stream(restTemplate.getForObject(urlCommentsGet, Comment[].class)).collect(Collectors.toList());
	}

	/**
	 * Método que se encarga de obtener la información registrada de un comentario
	 * por id, haciendo uso del servicio externo.
	 * @param id El parametro id, define el identificador del comentario
	 * @return información de un comentario
	 */
	public Comment findById(Long id) {
		return restTemplate.getForEntity(urlCommentsGet+id, Comment.class).getBody();
	}

	/**
	 * Método que se encarga de obtener la información registrada de un comentario
	 * por nombre, haciendo uso del servicio externo.
	 * @param name El parametro name, define el nombre definido para un comentario
	 * @return información de un comentario
	 * @throws UnsupportedEncodingException 
	 */
	public List<Comment> findByName(String name) {
		ResponseEntity<List<Comment>> response = restTemplate.exchange(urlCommentsGet, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Comment>>() {
				}, name);
		return response.getBody();
	
	}
	
}
