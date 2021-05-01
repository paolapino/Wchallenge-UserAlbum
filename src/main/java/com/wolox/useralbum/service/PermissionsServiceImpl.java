package com.wolox.useralbum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.useralbum.model.Permissions;
import com.wolox.useralbum.repository.PermissionsRepository;

/**
 * @author Paola Pino
 */

@Service
public class PermissionsServiceImpl implements PermissionsService {

	@Autowired
	private PermissionsRepository permissionsRepository;

	@Override
	public List<Permissions> findAll() {
		return permissionsRepository.findAll();
	}
	
	@Override
	public List<Long> findByAlbumIdAndPermission(Long albumId, boolean writePermission) {
		return permissionsRepository.findByAlbumIdAndPermission(albumId, writePermission);
	}

	@Override
	public Permissions findByAlbumIdAndUserId(Long albumId, Long userId) {
		return permissionsRepository.findByAlbumIdAndUserId(albumId, userId);
	}
	
	@Override
	public List<Permissions> findByAlbumId(Long albumId) {
		return permissionsRepository.findByAlbumId(albumId);
	}

	@Override
	public void save(Permissions permissions) {
		Permissions p= permissionsRepository.findByAlbumIdAndUserId
				(permissions.getAlbumId(), permissions.getUserId());
		if (p==null) {
			permissionsRepository.save(permissions);	
		}
		
	}

	@Override
	public void update(Permissions permissions, Long albumId, Long userId) {
		Permissions p= permissionsRepository.findByAlbumIdAndUserId(albumId, userId);
		if (p!=null) {
		p.setWritePermission(permissions.getWritePermission());
		permissionsRepository.save(p);
		}
	}

	@Override
	public void deleteByAlbumIdUserId(Long albumId, Long userId) {
		Permissions p= permissionsRepository.findByAlbumIdAndUserId(albumId, userId);
		if(p!=null) {
		permissionsRepository.deleteById(p.getId());
		}
	}
	
}
