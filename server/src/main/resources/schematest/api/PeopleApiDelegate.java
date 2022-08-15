package schematest.api;

import schematest.model.Person;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link PeopleApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-16T06:37:06.519022126+10:00[Australia/Melbourne]")
public interface PeopleApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /people
     * Create a new person
     *
     * @param person  (optional)
     * @return Success (status code 200)
     * @see PeopleApi#createPerson
     */
    default ResponseEntity<Person> createPerson(Person person) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"1\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /people : Return a list of people
     *
     * @return List of all people (status code 200)
     * @see PeopleApi#getPeople
     */
    default ResponseEntity<List<Person>> getPeople() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"1\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /people/{personId} : Return a specific person
     *
     * @param personId The id of the person to retrieve (required)
     * @return Name for a specific person (status code 200)
     * @see PeopleApi#getPerson
     */
    default ResponseEntity<Person> getPerson(String personId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"1\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /people/{personId}
     * Remove an existing new person
     *
     * @param personId The id of the person to retrieve (required)
     * @return Success (status code 200)
     * @see PeopleApi#removePerson
     */
    default ResponseEntity<Void> removePerson(String personId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /people/{personId}
     * Update an existing new person
     *
     * @param personId The id of the person to retrieve (required)
     * @param person  (optional)
     * @return Success (status code 200)
     * @see PeopleApi#updatePerson
     */
    default ResponseEntity<Person> updatePerson(String personId,
        Person person) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"John Doe\", \"id\" : \"1\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
