package com.wolox.useralbum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Paola Pino
 */

@Entity
@Table(
		name = "permissions",
		uniqueConstraints= @UniqueConstraint(columnNames = { "user_id", "album_id" })
)
public class Permissions {
	
	/** Id de la entidad */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/** identificación del usuario */
	@Column(name = "user_id")
	private Long userId;
	
	/** identificador del album */
	@Column(name = "album_id")
	private Long albumId;
	
	/** Permiso de escritura */
	@Column(name = "write_permission")
	private Boolean writePermission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public Boolean getWritePermission() {
		return writePermission;
	}

	public void setWritePermission(Boolean writePermission) {
		this.writePermission = writePermission;
	}

}
