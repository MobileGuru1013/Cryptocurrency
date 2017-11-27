package com.itranswarp.bitcoin.serializer;

import java.io.IOException;

import org.bouncycastle.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.itranswarp.bitcoin.util.HashUtils;

/**
 * Serialize byte[] to hash string (byte[] reversed).
 * 
 * @author Michael Liao
 */
public class HashSerializer extends JsonSerializer<byte[]> {

	@Override
	public void serialize(byte[] value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		String s = HashUtils.toHexString(Arrays.reverse(value));
		gen.writeString(s);
	}

}
