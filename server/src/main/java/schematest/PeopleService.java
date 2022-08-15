package schematest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import schematest.api.PeopleApiDelegate;
import schematest.model.Person;

@Service
public class PeopleService implements PeopleApiDelegate {
    
    List<Person> people = new ArrayList<>();
    
    @Override
    public ResponseEntity<List<Person>> getPeople() {
        return ResponseEntity.ok(people);
    }
    
    @Override
    public ResponseEntity<Person> getPerson(String id) {
        var option = people.stream().filter(person -> person.getId().equals(id)).findFirst();
        return ResponseEntity.ok(option.get());
    }
    
    @Override
    public ResponseEntity<Person> createPerson(Person person) {
        person.id(UUID.randomUUID().toString());
        people.add(person);
        return ResponseEntity.ok(person);
    }
    
    @Override
    public ResponseEntity<Person> updatePerson(String id, Person updatedPerson) {
        var option = people.stream().filter(person -> person.getId().equals(id)).findFirst();
        option.get().name(updatedPerson.getName());
        return ResponseEntity.ok(option.get());
    }
    
    @Override
    public ResponseEntity<Void> removePerson(String id) {
        people.removeIf(person -> person.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
