package br.gabrielsmartins.infra.file.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class PhoneRecord {

    @CsvBindByName(column = "phone_code", required = true)
    private String code;

    @CsvBindByName(column = "phone_number", required = true)
    private String number;

}
