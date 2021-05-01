package com.wolox.useralbum.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.useralbum.integration.model.Post;

/**
 * @author Paola Pino
 */

@Service
public class PostServiceImpl {
	@Autowired
	private RestTemplate restTemplate;

	// url servicio externo [post]
	@Value("${url_posts_get}")
	protected String urlPostsGet;

	/**
	 * Método que se encarga de obtener la información registrada de todos los
	 * posts, haciendo uso del servicio externo.
	 * @return Listado con la información de todos los posts
	 */
	public List<Post> findAll() {
		return Arrays.stream(restTemplate.getForObject(urlPostsGet, Post[].class)).collect(Collectors.toList());
	}

	/**
	 * Método que se encarga de obtener la información registrada de un post por
	 * id, haciendo uso del servicio externo.
	 * @param id El parametro id, define el identificador del post
	 * @return información de un post
	 */
	public Post findById(Long id) {
		return restTemplate.getForEntity(urlPostsGet+id, Post.class).getBody();
	}


}
