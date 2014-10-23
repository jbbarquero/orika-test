package com.malsolo.orika.test.spring;

import com.google.common.collect.ImmutableList;
import com.malsolo.orika.test.dto.PersonDTO;
import java.util.Random;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {
    
    Random random = new Random();

    @Override
    public PersonDTO findPerson() {
        return this.createPersonDTO(random.nextInt(100));
    }

    private PersonDTO createPersonDTO(long l) {
        PersonDTO dto = new PersonDTO();
        dto.setId(l);
        dto.setName("Name " + l);
        dto.setLastNames(ImmutableList.of("S.", "Surname " + l));
        dto.setStreetAddress("My street " + l);
        dto.setCity("City "+ l);
        dto.setPostalCode("code " + l);
        return dto;
    }
}
