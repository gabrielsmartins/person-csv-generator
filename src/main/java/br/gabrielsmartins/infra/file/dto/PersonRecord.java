package br.gabrielsmartins.infra.file.dto;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.util.List;

@Data
public class PersonRecord {

    @CsvBindByName(column = "person_id", required = true)
    private Integer id;

    @CsvBindByName(column = "person_name", required = true)
    private String name;

    @CsvBindAndSplitByName(elementType= PhoneRecord.class, splitOn = "\\|")
    private List<PhoneRecord> phones;


}
