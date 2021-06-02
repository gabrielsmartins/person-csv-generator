package br.gabrielsmartins.infra.file.mapper;

import br.gabrielsmartins.domain.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PhoneRecordMapperTest {

    private PhoneRecordMapper mapper;

    @BeforeEach
    public void setup(){
        this.mapper = new PhoneRecordMapper();
    }

    @Test
    @DisplayName("Given Phone When Map Then Return Record")
    public void givenPhoneWhenMapThenReturnRecord(){
        var phone = Phone.builder()
                                 .withCode("55")
                                 .withNumber("119000202020")
                                 .build();

        var record = this.mapper.mapToRecord(phone);

        assertThat(record).hasNoNullFieldsOrProperties();
        assertThat(record.getCode()).isEqualTo(record.getCode());
        assertThat(record.getNumber()).isEqualTo(record.getNumber());
    }
}
