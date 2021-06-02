package br.gabrielsmartins.domain;

import java.util.stream.Stream;

public interface ExportPersonService {

    void export(Stream<Person> personStream);

}
