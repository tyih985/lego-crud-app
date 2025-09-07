package com.lego.lego_sets.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/set")
public class SetController {
    private final SetService setService;

    @Autowired
    public SetController(SetService setService) {
        this.setService = setService;
    }

    @GetMapping
    public List<LegoSet> getLegoSets(
            @RequestParam(required = false) String theme,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minPieces,
            @RequestParam(required = false) Integer minMinifigs,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Float maxPrice
    ) {
        return setService.getFilteredLegoSets(theme, name, minPieces, minMinifigs, minAge, maxPrice);
    }

    @PostMapping
    public ResponseEntity<LegoSet> addSet(@RequestBody LegoSet legoSet) {
        LegoSet newSet = setService.addSet(legoSet);
        return new  ResponseEntity<>(newSet, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LegoSet> updateSet(@RequestBody LegoSet legoSet) {
        LegoSet resultSet = setService.updateSet(legoSet);
        if (resultSet != null) {
            return new  ResponseEntity<>(resultSet, HttpStatus.OK);
        }
        else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{setName}")
    public ResponseEntity<String> deleteSet(@PathVariable String setName) {
        setService.deleteSet(setName);
        return new ResponseEntity<>("Set deleted successfully", HttpStatus.OK);
    }
}
