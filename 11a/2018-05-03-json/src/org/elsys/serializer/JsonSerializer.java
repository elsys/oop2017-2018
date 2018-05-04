package org.elsys.serializer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JsonSerializer extends AbstractSerializer implements Serializer {

	@Override
	public String serialize(Object obj) {
		List<Field> fields = getFieldsToSerialize(obj.getClass());
		List<String> outputs = new ArrayList<String>();
		
		for(Field field: fields) {
			StringBuilder builder = new StringBuilder();
			
			String fieldName = field.getName();
			MapAs[] maps = 
					field.getDeclaredAnnotationsByType(MapAs.class);
			if(maps.length>0) {
				MapAs map = maps[0];
				fieldName = map.value();
			}
			// System.out.println("field name: " + fieldName);
			builder.append('"');
			builder.append(fieldName);
			builder.append('"');
			builder.append(':');
			
			try {
				field.setAccessible(true);
				Object value = field.get(obj);
				// System.out.println("field value: " + value);
				if(isDirectlySerializable(value)) {
					builder.append('"');
					builder.append(value.toString());
					builder.append('"');
				} else if(isArray(value)) {
					// ?????
				} else if(isCollection(value)) {
					String result = serializeCollection((Collection)value);
					builder.append(result);
				} else {
					builder.append(serialize(value));
				}
				
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outputs.add(builder.toString());
		}
		// System.out.println(outputs);
		StringBuilder builder = new StringBuilder();
		builder.append('{');
		builder.append(String.join(",", outputs));
		builder.append('}');
		return builder.toString();
	}

//	private String join(Collection<String> strings, String delimiter) {
//		return strings.stream()
//				.collect(Collectors.joining(delimiter));
//	}
//	
	private String serializeCollection(Collection<?> collection) {
		List<String> outputs = new ArrayList<String>();
		for(Object value: collection) {
			// outputs.add(serialize(value));
			outputs.add(value.toString());
		}
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		builder.append(String.join(",", outputs));
		builder.append(']');
		return builder.toString();
	}

}
