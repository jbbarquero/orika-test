package com.malsolo.orika.test.spring;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malsolo.orika.test.domain.Person;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    @Autowired
    private MapperFacade mapper;

//    @Autowired
//    public void setMapperFactory(MapperFactory mapperFactory) {
//        this.mapper = mapperFactory.getMapperFacade();
//    }
    
    @Override
    public Person obtainPerson() {
        return mapper.map(this.personRepository.findPerson(), Person.class);
    }

}
