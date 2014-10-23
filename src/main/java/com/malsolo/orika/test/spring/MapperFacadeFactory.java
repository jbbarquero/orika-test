package com.malsolo.orika.test.spring;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.FactoryBean;

//@Component
public class MapperFacadeFactory implements FactoryBean<MapperFacade> {

	@Override
	public MapperFacade getObject() throws Exception {
		return new DefaultMapperFactory.Builder().build().getMapperFacade();
	}

	@Override
	public Class<?> getObjectType() {
		return MapperFacade.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	

}
