package com.wolox.useralbum.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.useralbum.integration.model.Photo;

/**
 * @author Paola Pino
 */

@Service
public class PhotoServiceImpl {
	
	@Autowired
	private RestTemplate restTemplate;

	// url servicio externo [photo]
	@Value("${url_photos_get}")
	protected String urlPhotosGet;

	/**
	 * Método que se encarga de obtener la información registrada de todas las
	 * fotografias, haciendo uso del servicio externo.
	 * @return Listado con la información de todas las fotografias
	 */
	public List<Photo> findAll() {
		return Arrays.stream(restTemplate.getForObject(urlPhotosGet, Photo[].class)).collect(Collectors.toList());
	}

	/**
	 * Método que se encarga de obtener la información registrada de una fotografía por
	 * id, haciendo uso del servicio externo.
	 * @param id El parametro id, define el identificador de una fotografía
	 * @return información de una fotografía
	 */
	public Photo findById(Long id) {
		return restTemplate.getForEntity(urlPhotosGet+ id, Photo.class).getBody();
	}

}
