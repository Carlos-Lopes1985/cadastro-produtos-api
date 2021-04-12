package com.zup.cadastroprodutos.validation;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class SchemaValidatorImpl implements SchemaValidator{

	public void validate(String jsonValidate, Object obj) {

		JSONObject jsonSchema = new JSONObject(
				new JSONTokener(SchemaValidatorImpl.class.getResourceAsStream(jsonValidate)));

		SchemaLoader loader = SchemaLoader.builder().schemaJson(jsonSchema).draftV6Support() // or draftV7Support()
				.build();
		Schema schema = loader.load().build();

		try {
			schema.validate(new JSONObject(obj));
		} catch (ValidationException e) {
			throw new DataIntegrityViolationException(e.getAllMessages().toString());
		}
	}
	
	/**
	 * Convert JSON File to a JSONObject
	 * 
	 * @param filename
	 * @return
	 */
	public JSONObject getJSONObject(final String filename) {
		return new JSONObject(new JSONTokener(SchemaValidatorImpl.this.getClass().getResourceAsStream(filename)));
	}
}
