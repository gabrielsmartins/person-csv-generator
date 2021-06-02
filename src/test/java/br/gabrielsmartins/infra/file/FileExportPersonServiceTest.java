package br.gabrielsmartins.infra.file;

import br.gabrielsmartins.domain.Person;
import br.gabrielsmartins.domain.Phone;
import br.gabrielsmartins.infra.file.mapper.PersonRecordMapper;
import br.gabrielsmartins.infra.file.mapper.PhoneRecordMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class FileExportPersonServiceTest {

    private FileExportPersonService service;

    @BeforeEach
    public void setup(){
        var phoneMapper = new PhoneRecordMapper();
        var mapper = new PersonRecordMapper(phoneMapper);
        this.service = new FileExportPersonService(mapper);
    }


    @Test
    @DisplayName("Given Person Stream When Is Valid Then Write File")
    public void givenPersonStreamWhenIsValidThenWriteFile(){
        Person person1 = createPerson(1, "John Wick");
        Person person2 = createPerson(2, "Neo");

        Stream<Person> personStream = Stream.of(person1, person2);

        this.service.export(personStream);
    }

    public Person createPerson(Integer id, String name){
         var phone = Phone.builder()
                .withCode("55")
                .withNumber("119000202020")
                .build();

        var person = Person.builder()
                .withId(id)
                .withName(name)
                .build();

        person.addPhone(phone);
        return person;
    }


}
