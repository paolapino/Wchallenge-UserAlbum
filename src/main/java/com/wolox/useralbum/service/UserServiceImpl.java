package com.wolox.useralbum.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.useralbum.integration.model.User;

/**
 * @author Paola Pino
 */

@Service
public class UserServiceImpl {

	@Autowired
	private RestTemplate restTemplate;

	// url servicio externo [user]
	@Value("${url_users_get}")
	protected String urlUsersGet;

	/**
	 * Método que se encarga de obtener la información registrada de todos los
	 * usuarios, haciendo uso del servicio externo.
	 * @return Listado con la información de todos los usuarios
	 */
	public List<User> findAll() {
		return Arrays.stream(restTemplate.getForObject(urlUsersGet, User[].class)).collect(Collectors.toList());
	}

	/**
	 * Método que se encarga de obtener la información registrada de un usuario por
	 * id, haciendo uso del servicio externo.
	 * @param id El parametro id, define el identificador del usuario
	 * @return información de un usuario
	 */
	public User findById(Long id) {
		return restTemplate.getForEntity(urlUsersGet+id, User.class).getBody();
	}

}
