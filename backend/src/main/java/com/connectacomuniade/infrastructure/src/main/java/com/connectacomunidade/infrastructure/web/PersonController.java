package com.connectacomunidade.infrastructure.web;

import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefInput;
import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefOutput;
import com.connectacomunidade.application.usecases.person.retrieve.ref.FindPersonByRefUseCase;
import com.connectacomunidade.infrastructure.web.dto.ReadPerson;
import com.connectacomunidade.application.usecases.person.create.CreatePersonInput;
import com.connectacomunidade.application.usecases.person.create.CreatePersonOutput;
import com.connectacomunidade.application.usecases.person.create.CreatePersonUseCase;
import com.connectacomunidade.infrastructure.mapper.PersonMapper;
import com.connectacomunidade.infrastructure.web.dto.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/persons")
public class PersonController {
    private final CreatePersonUseCase createPersonUseCase;
    private final FindPersonByRefUseCase findPersonByRefUseCase;
    private final PersonMapper personMapper;

    public PersonController(CreatePersonUseCase createPersonUseCase, FindPersonByRefUseCase findPersonByRefUseCase, PersonMapper personMapper) {
        this.createPersonUseCase = createPersonUseCase;
        this.findPersonByRefUseCase = findPersonByRefUseCase;
        this.personMapper = personMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReadPerson> createPerson(@RequestBody @Validated CreatePersonRequest request) {
        CreatePersonInput useCaseInput = personMapper.createPersonRequestToUseCaseInput(request);

        CreatePersonOutput personOutput = createPersonUseCase.execute(useCaseInput);

        ReadPerson response = ReadPerson.fromPerson(personOutput.person());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{personRef}")
    public ResponseEntity<ReadPerson> getPersonProfile(@PathVariable String personRef) {
        FindPersonByRefInput input = new FindPersonByRefInput(
                UUID.fromString(personRef)
        );

        FindPersonByRefOutput output = findPersonByRefUseCase.execute(input);

        ReadPerson readPerson = ReadPerson.fromPerson(output.person());

        return ResponseEntity.ok(readPerson);
    }

}
