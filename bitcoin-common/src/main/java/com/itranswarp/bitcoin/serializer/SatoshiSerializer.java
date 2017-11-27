package com.itranswarp.bitcoin.serializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serialize long to satoshi.
 * 
 * @author Michael Liao
 */
public class SatoshiSerializer extends JsonSerializer<Long> {

	@Override
	public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		String s = BigDecimal.valueOf(value).divide(N).toString();
		gen.writeString(s);
	}

	final static BigDecimal N = BigDecimal.valueOf(100000000L);
}
