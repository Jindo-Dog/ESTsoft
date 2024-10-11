package com.estsoft.estsoftspringdemoproject.wallet.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Setter;

@MappedSuperclass
public class WalletEntityObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Version
	private int version;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(columnDefinition = "TEXT")
	@Convert(converter = WalletMapConverter.class)
	@Setter
	private Map<String, String> metadata = new HashMap<>();
}
