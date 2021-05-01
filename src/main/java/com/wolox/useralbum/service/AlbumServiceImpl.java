package com.wolox.useralbum.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.useralbum.integration.model.Album;

/**
 * @author Paola Pino
 */

@Service
public class AlbumServiceImpl {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//url servicio externo [albums]
	@Value("${url_albums_get}")
	protected String urlAlbumsGet;
	
	/**
	 * Método que se encarga de obtener la información registrada de los
	 * albums, haciendo uso del servicio externo.
	 * @return Listado con la información de todos los albums
	 */
	public List<Album> findAll() {
		return Arrays.stream(restTemplate.getForObject(urlAlbumsGet, Album[].class)).
	    		collect(Collectors.toList());
	}
	
	/**
	 * Método que se encarga de obtener la información registrada de un álbum
	 * por id, haciendo uso del servicio externo.
	 * @param id El parametro id, define el identificador de un álbum
	 * @return información de un álbum
	 */
	public Album findById(Long id) {
		return restTemplate.getForEntity(urlAlbumsGet+id, Album.class).getBody();
	}

}
