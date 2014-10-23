package com.malsolo.orika.test.domain.mappers;

import com.malsolo.orika.test.domain.Customer;
import com.malsolo.orika.test.dto.CustomerDTO;
import ma.glasnost.orika.MapperFacade;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public enum CustomerMapper {
    
    INSTANCE;
    
    private final MapperFacade mapperFacade;
    
    private CustomerMapper() {
        BaseMapper.MAPPER_FACTORY.classMap(CustomerDTO.class, Customer.class)
                .byDefault()
                .register();
        mapperFacade = BaseMapper.MAPPER_FACTORY.getMapperFacade();
    }
    
    public Customer map(CustomerDTO customerDTO) {
        return this.mapperFacade.map(customerDTO, Customer.class);
    }
    
    public CustomerDTO map(Customer customer) {
        return this.mapperFacade.map(customer, CustomerDTO.class);
    }
}
