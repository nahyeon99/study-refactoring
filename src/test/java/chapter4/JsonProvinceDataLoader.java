package chapter4;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProvinceDataLoader {

	static final JsonProvinceDataLoader JSON_PROVINCE_DATA_LOADER = new JsonProvinceDataLoader(
		JsonProvinceDataLoader.class.getClassLoader(), new ObjectMapper());

	private final ClassLoader classLoader;
	private final ObjectMapper objectMapper;

	public JsonProvinceDataLoader(ClassLoader classLoader, ObjectMapper objectMapper) {
		this.classLoader = classLoader;
		this.objectMapper = objectMapper;
	}

	public ProvinceCreate provinceData() {
		return getResource("chapter4/ProvinceData.json", new TypeReference<>() {
		});
	}

	private <T> T getResource(final String jsonPath, final TypeReference<T> typeReference) {
		try (InputStream inputStream = classLoader.getResourceAsStream(jsonPath)) {
			if (Objects.isNull(inputStream)) {
				throw new IllegalStateException("Can't find " + jsonPath);
			}
			return objectMapper.readValue(inputStream, typeReference);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}