package com.restapi;

import com.restapi.Model.Categories;
import com.restapi.Model.Person;
import com.restapi.Repository.PersonRepositoryIml;
import com.restapi.Service.PersonService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class PersonserviceImlTest {
    @Inject
    private PersonRepositoryIml employeeRepositoryIml;

    @Inject
    private PersonService employeeService;

    @MockBean(PersonRepositoryIml.class)
    PersonRepositoryIml employeeRepositoryIml() {
        return mock(PersonRepositoryIml.class);
    }


    @Test
    public void getAllPerson() {
        when(employeeRepositoryIml.getAllPerson()).thenReturn(Stream.of(new Person(),
                new Person(),
                new Person()).collect(Collectors.toList()));

        Assertions.assertEquals(3, employeeService.getAllPerson().size());
    }

    @Test
    public void addPerson() {
        //arrange
        Categories categories = new Categories(12,"dfgh");
        Person person = new Person(12, "ganesh", "pawarganesh1212@gmail.com", 2345, "2021-09-07", categories);

        when(employeeService.addPerson(person)).thenReturn("Person saved successfully..!=");

        String result = employeeService.addPerson(person);

        assertEquals(result, "Person saved successfully..!=");
    }

    @Test
    public void updatePerson() {
        Categories categories = new Categories(12,"rty");
        Person person = new Person("ganesh", "pawarganesh1212@gmail.com", 12345, "2020-04-22",  categories);
        person.setName("ganesh");
        Person newEmp = new Person("ganesh", "pawarganesh1212@gmail.com", 23145, "2032-05-16",  categories);

        when(employeeService.updatePerson(person, 12)).thenReturn("Person Updated..!=");

        String result = employeeService.updatePerson(person, 12);

        assertEquals(result, "Person Updated..!=");
    }

    @Test
    public void deleteById() {
        Categories categories = new Categories(12,"sdfgh");
        Person person = new Person("ganesh", "pawarganesh1212@gmail.com", 1234, "2019-04-10",  categories);
        person.setId(12);

        when(employeeService.deleteById(12)).thenReturn("Person Deleted By Id..!=");

        String result = employeeService.deleteById(12);

        assertEquals(result, "Person Deleted By Id..!=");
    }

}

