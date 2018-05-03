package org.elsys.serializer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JsonSerializer extends AbstractSerializer implements Serializer {

	@Override
	public String serialize(Object obj) {
		List<Field> fields = getFieldsToSerialize(obj.getClass());
		List<String> outputs = new ArrayList<String>();
		for (Field field : fields) {
			StringBuilder builder = new StringBuilder();
			System.out.println("field name: " + field.getName());
			builder.append(field.getName());
			builder.append(":");
			try {
				field.setAccessible(true);
				System.out.println("field value:" + field.get(obj));
				Object value = field.get(obj);
				if(isDirectlySerializable(value)) {
					// serialize simple
					builder.append(value.toString());
				} else if(isArray(value)) {
					// serialize array
					builder.append(serializeCollection(Arrays.stream((Object[])value)
							.collect(Collectors.toList())));
				} else if(isCollection(value)) {
					// serialize collection
					builder.append(serializeCollection((Collection<?>)value));
				} else {
					String out = serialize(value);
					builder.append(out);
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			outputs.add(builder.toString());
		}
		return join(outputs, ",");
	}
	public static String join(Collection<String> collection, String delimiter){
	    return collection.stream()
	            .collect(Collectors.joining(delimiter));
	}

	private String serializeCollection(Collection<?> collection) {
		// TODO: implement this...
		return "??";
	}

}
