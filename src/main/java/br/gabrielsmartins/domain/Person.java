package br.gabrielsmartins.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Person {

    private Integer id;
    private String name;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private final List<Phone> phones = new ArrayList<>();

    public List<Phone> getPhones() {
        return Collections.unmodifiableList(phones);
    }

    public Integer addPhone(Phone phone){
        phone.setPerson(this);
        this.phones.add(phone);
        return this.phones.size();
    }

    public Integer removePhone(Phone phone){
        phone.setPerson(null);
        this.phones.remove(phone);
        return this.phones.size();
    }

}
