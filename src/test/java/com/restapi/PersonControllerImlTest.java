package com.restapi;

import com.restapi.Controller.PersonController;
import com.restapi.Model.Categories;
import com.restapi.Model.Person;
import com.restapi.Repository.PersonRepository;
import com.restapi.Repository.PersonRepositoryIml;
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
public class PersonControllerImlTest {
    @Inject
    private PersonRepositoryIml personRepositoryIml;

    @Inject
    private PersonController personController;

    @MockBean(PersonRepositoryIml.class)
    PersonRepositoryIml personRepositoryIml() {
        return mock(PersonRepositoryIml.class);
    }



    @Test
    public void getAllPerson(){
        when(personRepositoryIml.getAllPerson()).thenReturn(Stream.of(new Person(),
                new Person(),
                new Person()).collect(Collectors.toList()));

        Assertions.assertEquals(3,personController.getAllPerson().size());
    }
    @Test
    public void addPerson() {
        //arrange
        Categories categories = new Categories(12,"dfghj");
        Person person = new Person(12,"ganesh","pawarganesh1212@gmail.com", 2345,"2012-09-26",categories);

        when(personController.addPerson(person)).thenReturn("Person saved successfully..!=");

        String result = personController.addPerson(person);

        assertEquals(result, "Person saved successfully..!=");
    }
    @Test
    public void updatePerson(){
        Categories categories = new Categories(12,"dfghj");
        Person person = new Person(12,"ganesh","pawarganesh1212@gmail.com",2345,"2023-09-12",categories);
        person.setName("hrishi");
        Person newEmp= new Person("ganes","pawarganesh1212@gmail.com",23145,"2022-12-12",categories);

        when(personController.updatePerson(person,12)).thenReturn("Person Updated..!=");

        String result = personController.updatePerson(person,12);

        assertEquals(result,"Person Updated..!=" );
    }
    @Test
    public void deleteById(){
        Categories categories = new Categories(12,"gyhjkl");
        Person person = new Person("ganesh","pawarganesh1212@gmail.com",1234,"2022-08-22",categories);
        person.setId(12);

        when(personController.deleteById(12)).thenReturn("Person Deleted By Id..!=");

        String result = personController.deleteById(12);

        assertEquals(result, "Person Deleted By Id..!=");
    }
}
