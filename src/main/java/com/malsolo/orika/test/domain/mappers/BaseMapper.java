package com.malsolo.orika.test.domain.mappers;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public class BaseMapper {
    
    final static MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();
    
}
