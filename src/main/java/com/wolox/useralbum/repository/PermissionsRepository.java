package com.wolox.useralbum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.wolox.useralbum.model.Permissions;

/**
 * @author Paola Pino
 */

public interface PermissionsRepository extends JpaRepository<Permissions, Long>{
	
	List<Permissions> findByAlbumId(Long albumId);
     
	@Query(value="select user_id from permissions where album_id = :albumId and write_permission= :writePermission", nativeQuery = true)
	public List<Long> findByAlbumIdAndPermission(Long albumId, boolean writePermission);
	
	@Query(value="select * from permissions where album_id = :albumId and user_id= :userId", nativeQuery = true)
	public Permissions findByAlbumIdAndUserId(Long albumId, Long userId);
	

}

