package com.bankino.training.api;

import com.bankino.training.domain.Counter;
import com.bankino.training.service.CounterService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/counter")
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to counter Entity!!!!")
public class CounterResourceApi {

    @Autowired
    private CounterService counterService;

    @PostMapping("/create")
    @ApiOperation(value = "add a counter", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add counter"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<Object> save(@ApiParam(value = "Counter object store in database table", required = true)
                                       @Valid @RequestBody Counter counter) {

        Counter savedCounter = counterService.create(counter);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCounter.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{counterId}")
    @ApiOperation(value = "remove counter ", response = Iterable.class)
    public void delete(@PathVariable Long counterId) {
        counterService.delete(counterId);

    }

    @GetMapping(value = "/allCounter")
    @ApiOperation(value = "retrieve all counter ", response = Iterable.class)
    public List<Counter> retrieveAll() {
        return counterService.getAll();
    }

    @GetMapping(value = "/{counterId}")
    @ApiOperation(value = "retrieve a counter ", response = Iterable.class)
    public Optional<Counter> retrieveOneCounter(@PathVariable Long counterId) {
        return counterService.getById(counterId);
    }

}
