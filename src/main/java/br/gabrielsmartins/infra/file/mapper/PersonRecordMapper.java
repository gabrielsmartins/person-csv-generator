package br.gabrielsmartins.infra.file.mapper;

import br.gabrielsmartins.domain.Person;
import br.gabrielsmartins.infra.file.dto.PersonRecord;
import br.gabrielsmartins.infra.file.dto.PhoneRecord;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PersonRecordMapper {

    private final PhoneRecordMapper phoneRecordMapper;

    public PersonRecord  mapToRecord(Person person) {
        var mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Person, PersonRecord>() {
            @Override
            protected void configure() {
                skip(destination.getPhones());
            }
        });
        PersonRecord record = mapper.map(person, PersonRecord.class);
        List<PhoneRecord> phoneRecords = person.getPhones().stream()
                .map(phoneRecordMapper::mapToRecord).collect(Collectors.toList());
        record.setPhones(phoneRecords);
        return record;
    }
}
