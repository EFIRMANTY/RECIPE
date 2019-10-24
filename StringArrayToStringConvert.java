package moj_spring2.recipe_api.WEB;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringArrayToStringConvert implements AttributeConverter<List<String>,String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null ? null : Arrays.toString(attribute.toArray());
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData.isEmpty()) {
            return Collections.emptyList();
        }
        try (Stream<String> stream = Arrays.stream(dbData.split(","))) {
            return stream.collect(Collectors.toList());
        }
    }
}
