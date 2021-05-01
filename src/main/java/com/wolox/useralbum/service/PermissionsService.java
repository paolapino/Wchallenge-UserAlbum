package com.wolox.useralbum.service;

import java.util.List;

import com.wolox.useralbum.model.Permissions;

/**
 * @author Paola Pino
 */

public interface PermissionsService {

	    public List<Permissions> findAll();
		
		public List<Long> findByAlbumIdAndPermission(Long albumId, boolean writePermission);
		
		public Permissions findByAlbumIdAndUserId(Long albumId, Long userId);
		
		public List<Permissions> findByAlbumId(Long albumId);
		
		public void save(Permissions p);
		
		public void update(Permissions permissions, Long albumId, Long userId);
		
		public void deleteByAlbumIdUserId(Long albumId, Long userId);
		
}
