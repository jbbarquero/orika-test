package com.malsolo.orika.test.spring;

import com.malsolo.orika.test.domain.Address;
import com.malsolo.orika.test.domain.Person;
import com.malsolo.orika.test.dto.PersonDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
@Component
public class PersonDtoToPersonMapper extends CustomMapper<PersonDTO, Person> {

    @Override
    public void mapAtoB(PersonDTO a, Person b, MappingContext context) {
        b.setId(a.getId());
        b.setName(a.getName());
        b.setSurnames(a.getLastNames());
        //I could use the protected mapperFacade if I need to map a particular field
        //this.mapperFacade.map(sourceObject, destinationClass);
        Address address = new Address();
        address.setStreet(a.getStreetAddress());
        address.setCity(a.getCity());
        address.setZipCode(a.getPostalCode());
        b.setAddress(address);
    }

    @Override
    public void mapBtoA(Person b, PersonDTO a, MappingContext context) {
        a.setId(b.getId());
        a.setName(b.getName());
        a.setLastNames(b.getSurnames());
        Address address = b.getAddress();
        if (address != null) {
            a.setStreetAddress(address.getStreet());
            a.setCity(address.getCity());
            a.setPostalCode(address.getZipCode());
        }
    }

}
