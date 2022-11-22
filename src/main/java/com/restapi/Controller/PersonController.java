package com.restapi.Controller;

import com.restapi.Model.Person;
import com.restapi.Service.PersonService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
//import io.swagger.v3.oas.annotations.tags.Tag;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/Person")
@Tag(name = "Person Details")
@SecurityRequirement(name="Authorization")
@Secured({SecurityRule.IS_AUTHENTICATED})
public class PersonController {

    @Inject
    PersonService employeeService;


    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(@Body Person person){
         return employeeService.addPerson(person);
    }
    @Get(value = "/GetallPerson")
    public List<Person> getAllPerson(){
        return employeeService.getAllPerson();
    }
    @Get(value = "/getperson/{id}")
    public Person getPersonById(@PathVariable("id") int id){
        return employeeService.getPersonById(id);

    }
    //@Transactional
//    @Put(value = "/update/{id}")
//    public String updatePerson(@Body Person person ,@PathVariable("id") int id ){
//       return employeeService.updatePerson(person, id);
//
//    }
    @Delete(value = "/delete/{id}")
    public String deleteById(int id){
        return employeeService.deleteById(id);
    }
}
