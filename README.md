CSV Generator using OpenCSV Library

This application is an example of OpenCSV usage.

The Person class uses some annotations for fields:

```java
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
```

And the Phone class is a child from Person:

```java
package br.gabrielsmartins.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Phone {

    private Person person;
    private String code;
    private String number;

}
```

In the end we can see the result of generation file:

```
"PERSON_ID","PERSON_NAME","PHONES"
"1","John Wick","PhoneRecord(code=55, number=119000202020)"
"2","Neo","PhoneRecord(code=55, number=119000202020)"
```
