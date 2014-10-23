package com.malsolo.orika.test.spring;

import com.malsolo.orika.test.dto.PersonDTO;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public interface PersonRepository {
    
    public PersonDTO findPerson();

}
