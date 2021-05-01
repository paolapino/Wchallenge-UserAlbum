package com.wolox.useralbum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.useralbum.model.Permissions;

import com.wolox.useralbum.service.PermissionsService;

/**
 * @author Paola Pino 
 * Se obtiene la información de los Permisos.
 */
@RestController
@RequestMapping("/permissions")
@CrossOrigin(origins = "*")
public class DataPermissionsController {
	
	@Autowired
	private PermissionsService service;

	/**
	 * Expone la respuesta - Obtiene toda la información registrada en la tabla permisos
	 */
	@GetMapping("/")
	public List<Permissions> findAll() {
		return service.findAll();
	}

	/**
	 * Expone la respuesta - Obtiene todos los usuarios que tienen un permiso determinado 
	 * respecto a un álbum específico.
	 */
	@GetMapping("/albumId/{albumId}/writePermission/{writePermission}")
	public List<Long> findByAlbumIdAndPermission(@PathVariable("albumId") Long albumId,
			@PathVariable("albumId") boolean writePermission){
		return service.findByAlbumIdAndPermission(albumId, writePermission);
	}
	
	/**
	 * Almacena la Información de un Determinado Permiso 
	 */
	@PostMapping("/")
	public Permissions save (@RequestBody Permissions permissions) {
		 service.save(permissions);
		 return permissions;
	}
	
	/**
	 * Actualizar los permisos de un usuario para un álbum determinado.
	 */
	@PutMapping("/albumId/{albumId}/userId/{userId}")
	public boolean update (@RequestBody Permissions permissions,
			@PathVariable("albumId") Long albumId,
			@PathVariable("userId") Long userId ) {
	        service.update(permissions, albumId, userId);;
		    return permissions.getWritePermission();
	}
	
	/**
	 * Eliminar la Información de un Determinado Permiso, por medio de su Id
	 */
	@DeleteMapping("/albumId/{albumId}/userId/{userId}")
	public void eliminar (@PathVariable("albumId") Long albumId,
			@PathVariable("userId") Long userId)
	{
		service.deleteByAlbumIdUserId(albumId, userId);
	}
	
}
