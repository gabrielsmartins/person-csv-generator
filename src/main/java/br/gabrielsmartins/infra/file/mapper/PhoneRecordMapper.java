package br.gabrielsmartins.infra.file.mapper;

import br.gabrielsmartins.domain.Phone;
import br.gabrielsmartins.infra.file.dto.PhoneRecord;
import org.modelmapper.ModelMapper;

public class PhoneRecordMapper {

    public PhoneRecord mapToRecord(Phone phone){
        var mapper = new ModelMapper();
        return mapper.map(phone, PhoneRecord.class);
    }
}
