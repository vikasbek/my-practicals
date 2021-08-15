package com.paytm.springbootcassandra.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.paytm.springbootcassandra.tables.Products;

public class ProductSerializer extends JsonSerializer<Products> {

	boolean isUpdate;
	public ProductSerializer( boolean isUptate){
		this.isUpdate = isUptate;
	}
	@Override
	public void serialize(Products value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		
		ObjectNode json = (ObjectNode) gen.getCodec().createObjectNode();
		json.put("id", String.valueOf(value.getId()));
		json.put("isUpdate", isUpdate);
	}

}
