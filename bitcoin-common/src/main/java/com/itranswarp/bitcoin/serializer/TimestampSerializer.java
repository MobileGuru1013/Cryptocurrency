package com.itranswarp.bitcoin.serializer;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serialize long to timestamp.
 * 
 * @author Michael Liao
 */
public class TimestampSerializer extends JsonSerializer<Long> {

	@Override
	public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		String s = Instant.ofEpochSecond(value).atZone(ZoneId.of("Z")).toString();
		gen.writeString(s);
	}

}
