package br.gabrielsmartins.infra.file;

import br.gabrielsmartins.domain.ExportPersonService;
import br.gabrielsmartins.domain.Person;
import br.gabrielsmartins.infra.file.dto.PersonRecord;
import br.gabrielsmartins.infra.file.mapper.PersonRecordMapper;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Slf4j
public class FileExportPersonService implements ExportPersonService {

    private final PersonRecordMapper mapper;

    @Override
    public void export(Stream<Person> personStream) {
        try {
            String fileName = "person.csv";
            log.info("Exporting file: {}", fileName);
            try(var writer = new FileWriter(fileName)){
                Stream<PersonRecord> personRecordStream = personStream.map(this.mapper::mapToRecord);
                StatefulBeanToCsv<PersonRecord> beanToCsv = new StatefulBeanToCsvBuilder<PersonRecord>(writer)
                                                                 .withSeparator(';')
                                                                 .withApplyQuotesToAll(false)
                                                                 .build();
                beanToCsv.write(personRecordStream);
                log.info("File {} exported successfully", fileName);
            }
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
            log.error("Error exporting file", e);
        }
    }
}
