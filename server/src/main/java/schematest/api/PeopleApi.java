/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package schematest.api;

import schematest.model.Person;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-16T06:57:16.050905141+10:00[Australia/Melbourne]")
@Api(value = "people", description = "the people API")
public interface PeopleApi {

    default PeopleApiDelegate getDelegate() {
        return new PeopleApiDelegate() {};
    }

    /**
     * POST /people
     * Create a new person
     *
     * @param person  (optional)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "", nickname = "createPerson", notes = "Create a new person", response = Person.class, tags={ "people", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Person.class) })
    @PostMapping(
        value = "/people",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Person> createPerson(@ApiParam(value = ""  )   @RequestBody(required = false) Person person) {
        return getDelegate().createPerson(person);
    }


    /**
     * GET /people : Return a list of people
     *
     * @return List of all people (status code 200)
     */
    @ApiOperation(value = "Return a list of people", nickname = "getPeople", notes = "", response = Person.class, responseContainer = "List", tags={ "people", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of all people", response = Person.class, responseContainer = "List") })
    @GetMapping(
        value = "/people",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Person>> getPeople() {
        return getDelegate().getPeople();
    }


    /**
     * GET /people/{personId} : Return a specific person
     *
     * @param personId The id of the person to retrieve (required)
     * @return Name for a specific person (status code 200)
     */
    @ApiOperation(value = "Return a specific person", nickname = "getPerson", notes = "", response = Person.class, tags={ "people", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Name for a specific person", response = Person.class) })
    @GetMapping(
        value = "/people/{personId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Person> getPerson(@ApiParam(value = "The id of the person to retrieve",required=true) @PathVariable("personId") String personId) {
        return getDelegate().getPerson(personId);
    }


    /**
     * DELETE /people/{personId}
     * Remove an existing new person
     *
     * @param personId The id of the person to retrieve (required)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "", nickname = "removePerson", notes = "Remove an existing new person", tags={ "people", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success") })
    @DeleteMapping(
        value = "/people/{personId}"
    )
    default ResponseEntity<Void> removePerson(@ApiParam(value = "The id of the person to retrieve",required=true) @PathVariable("personId") String personId) {
        return getDelegate().removePerson(personId);
    }


    /**
     * PUT /people/{personId}
     * Update an existing new person
     *
     * @param personId The id of the person to retrieve (required)
     * @param person  (optional)
     * @return Success (status code 200)
     */
    @ApiOperation(value = "", nickname = "updatePerson", notes = "Update an existing new person", response = Person.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Success", response = Person.class) })
    @PutMapping(
        value = "/people/{personId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Person> updatePerson(@ApiParam(value = "The id of the person to retrieve",required=true) @PathVariable("personId") String personId,@ApiParam(value = ""  )   @RequestBody(required = false) Person person) {
        return getDelegate().updatePerson(personId, person);
    }

}
