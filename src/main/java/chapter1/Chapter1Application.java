package chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import chapter1.dto.Invoice;
import chapter1.dto.Play;

public class Chapter1Application {

	private static final String PLAYS_JSON_PATH = "chapter1/plays.json";
	private static final String INVOICES_JSON_PATH = "chapter1/invoices.json";

	public static void main(String[] args) throws IOException {
		final Map<String, Play> plays = getResource(PLAYS_JSON_PATH, new TypeReference<>() {
		});
		final Invoice invoice = getResource(INVOICES_JSON_PATH, new TypeReference<>() {
		});

		Statement statement = new Statement();
		String result = statement.statement(invoice, plays);

		System.out.println(result);
	}

	/**
	 * 지정한 경로의 리소스 파일을 읽은 후, 역직렬화하는 메서드
	 */
	private static <T> T getResource(final String jsonPath, final TypeReference<T> typeReference) throws IOException {
		ClassLoader classLoader = Chapter1Application.class.getClassLoader();
		ObjectMapper mapper = new ObjectMapper();

		try (InputStream inputStream = classLoader.getResourceAsStream(jsonPath)) {
			if (Objects.isNull(inputStream)) {
				throw new IllegalStateException("Can't find " + jsonPath);
			}
			return mapper.readValue(inputStream, typeReference);
		}
	}
}
