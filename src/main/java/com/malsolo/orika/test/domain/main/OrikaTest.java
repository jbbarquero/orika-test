package com.malsolo.orika.test.domain.main;

import com.google.common.collect.ImmutableList;
import com.malsolo.orika.test.domain.Customer;
import com.malsolo.orika.test.domain.Person;
import com.malsolo.orika.test.domain.Simple;
import com.malsolo.orika.test.domain.mappers.CustomerMapper;
import com.malsolo.orika.test.dto.CustomerDTO;
import com.malsolo.orika.test.dto.PersonDTO;
import com.malsolo.orika.test.dto.SimpleDTO;
import java.util.Date;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 *
 * @author Javier Beneito Barquero <jbbarquero@gmail.com>
 */
public class OrikaTest {

    public static void main(String... args) {
        
        System.out.println("***** ORIKA TEST *****");

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(PersonDTO.class, Person.class) //A ClassMapBuilder<PersonDTO, Person>
                .field("lastNames", "surnames") //Register field mappings
                .field("streetAddress", "address.street")
                .field("city", "address.city")
                .field("postalCode", "address.zipCode")
                .byDefault() //the remaining fields on both classes should be mapped matching the fields by name
                .register(); //register the mapping with the MapperFactory.
        
//        new DefaultMapperFactory.Builder()
//                .constructorResolverStrategy(new SimpleConstructorResolverStrategy()) //By default, you can extend it or implement your own ConstructorResolverStrategy
//                .compilerStrategy(new JavassistCompilerStrategy()) //By default, you can extend it, implement your own CompilerStrategy or use EclipseJdtCompilerStrategy
//                .propertyResolverStrategy(new IntrospectorPropertyResolver()) //By default, you can extend it or implement your own PropertyResolverStrategy
//                .classMapBuilderFactory(new ClassMapBuilder.Factory()) //by default. You can use //enabled by default or //enabled by default.Factory
//                .useAutoMapping(true) //enabled by default
//                .mapNulls(true) //enabled by default
//                .build();
        
        MapperFacade mapper = mapperFactory.getMapperFacade();

        System.out.println("> Mapper facade for person");

        PersonDTO personDTO = createPersonDTO(1L);
        
        Person person = mapper.map(personDTO, Person.class);
        
        System.out.printf("1. PersonDTO: %s\n", personDTO.toString());
        System.out.printf("1. Person: %s\n", person.toString());
        
        System.out.println("> Mapper facade for person mapping in-place");

        PersonDTO personDTO2 = createPersonDTO(2L);
        Person person2 = new Person();
        mapper.map(personDTO2, person2);
        System.out.printf("2. PersonDTO: %s\n", personDTO2.toString());
        System.out.printf("2. Person: %s\n", person2.toString());

        BoundMapperFacade<CustomerDTO, Customer> boundMapper = mapperFactory
                .getMapperFacade(CustomerDTO.class, Customer.class);
        
        System.out.println("> Bound Mapper facade for customer");

        CustomerDTO customerDTO = createCustomerDTO(1L);
        Customer customer = boundMapper.map(customerDTO);
        customerDTO = boundMapper.mapReverse(customer, customerDTO);
        
        System.out.printf("1. CustomerDTO: %s\n", customerDTO.toString());
        System.out.printf("1. Customer: %s\n", customer.toString());

        System.out.println("> Bound Mapper facade for customer mapping in-place");

        CustomerDTO customerDTO2 = createCustomerDTO(2L);
        Customer customer2 = new Customer();
        boundMapper.map(customerDTO2, customer2);
        System.out.printf("2. CustomerDTO: %s\n", customerDTO2.toString());
        System.out.printf("2. Customer: %s\n", customer2.toString());

        System.out.println("> Mapper facade for customer mapping in-place");

        MapperFacade mapper2 = mapperFactory.getMapperFacade();
        CustomerDTO customerDTO3 = createCustomerDTO(3L);
        Customer customer3 = new Customer();
        mapper2.map(customerDTO3, customer3);
        System.out.printf("3. CustomerDTO: %s\n", customerDTO3.toString());
        System.out.printf("3. Customer: %s\n", customer3.toString());
        
        mapperFactory.classMap(SimpleDTO.class, Simple.class)
                .field("id", "number")
                .exclude("noName")
                .byDefault()
                .register();

        PersonDTO personDTO3 = createPersonDTO(3L);
        Person person3 = new Person();
        mapper.map(personDTO3, person3);
        System.out.printf("3. PersonDTO: %s\n", personDTO3.toString());
        System.out.printf("3. Person: %s\n", person3.toString());
        
        SimpleDTO simpleDTO = new SimpleDTO(1, "name", "no name");
        Simple simple = new Simple();
        mapper.map(simpleDTO, simple);
        System.out.printf("1. SimpleDTO: %s\n", simpleDTO.toString());
        System.out.printf("1. Simple: %s\n", simple.toString());
        mapper.map(simple, simpleDTO);
        System.out.printf("1.Bis SimpleDTO: %s\n", simpleDTO.toString());
        System.out.printf("1.Bis Simple: %s\n", simple.toString());
        
        CustomerMapper customerMapper = CustomerMapper.INSTANCE;
        System.out.printf("NaN. %s\n", customerMapper.map(customer).toString());
        System.out.printf("NaN. %s\n", CustomerMapper.INSTANCE.map(customerDTO).toString());

        System.out.println("***** ORIKA TEST: END *****");
    }
    
    private static PersonDTO createPersonDTO(long l) {
        PersonDTO dto = new PersonDTO();
        dto.setId(l);
        dto.setName("Name " + l);
        dto.setLastNames(ImmutableList.of("S.", "Surname " + l));
        dto.setStreetAddress("My street " + l);
        dto.setCity("City "+ l);
        dto.setPostalCode("code " + l);
        return dto;
    }
    
    private static CustomerDTO createCustomerDTO(long l) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(l);
        dto.setName("Client " + l);
        dto.setAddress("Address " + l);
        dto.setDate(new Date());
        return dto;
    }

}
