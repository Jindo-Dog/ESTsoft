package com.estsoft.estsoftspringdemoproject.wallet.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class WalletMapConverter implements AttributeConverter<Map<String, String>, String> {
	private static Type MAP_TYPE = new TypeToken<Map<String, String>>() {
	}.getType();
	private static Gson GSON = new Gson();

	@Override
	public String convertToDatabaseColumn(Map<String, String> attribute) {
		if (attribute == null)
			return "";

		return GSON.toJson(attribute);
	}

	@Override
	public Map<String, String> convertToEntityAttribute(String dbData) {
		if (StringUtils.isEmpty(dbData))
			return new HashMap<>();
		return GSON.fromJson(dbData, MAP_TYPE);
	}
}
