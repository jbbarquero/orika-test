package com.malsolo.orika.test.spring;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
//@Component
public class MapperFactoryFactory implements FactoryBean<MapperFactory> {

    @Override
    public MapperFactory getObject() throws Exception {
        return new DefaultMapperFactory.Builder().build();
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
