package br.gabrielsmartins.infra.file.mapper;

import br.gabrielsmartins.domain.Person;
import br.gabrielsmartins.domain.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PersonRecordMapperTest {

    private PersonRecordMapper mapper;

    @BeforeEach
    public void setup(){
        var phoneMapper = new PhoneRecordMapper();
        this.mapper = new PersonRecordMapper(phoneMapper);
    }

    @Test
    @DisplayName("Given Person When Map Then Return Record")
    public void givenPersonWhenMapThenReturnRecord(){

        var phone = Phone.builder()
                .withCode("55")
                .withNumber("119000202020")
                .build();

        var person = Person.builder()
               .withId(1)
               .withName("John Wick")
                .build();

        person.addPhone(phone);

        var record = this.mapper.mapToRecord(person);

        assertThat(record).hasNoNullFieldsOrProperties();
        assertThat(record.getId()).isEqualTo(record.getId());
        assertThat(record.getName()).isEqualTo(record.getName());
        assertThat(record.getPhones().size()).isEqualTo(record.getPhones().size());
    }
}
