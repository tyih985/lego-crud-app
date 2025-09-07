package com.lego.lego_sets.set;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SetService {
    private final SetRespository setRespository;

    @Autowired
    public SetService(SetRespository setRespository) {
        this.setRespository = setRespository;
    }

    public List<LegoSet> getSets() {
        return setRespository.findAll();
    }

    public List<LegoSet> getSetsByMinifigs(int minMinifigs) {
        return setRespository.findByMinifigsGreaterThan(minMinifigs);
    }

    public List<LegoSet> getSetsByAge(int minAge) {
        return setRespository.findByAgeRangeMinGreaterThan(minAge);
    }

    public List<LegoSet> getSetsByPieces(int minPieces) {
        return setRespository.findByPiecesGreaterThan(minPieces);
    }

    public List<LegoSet> getSetsByPrice(float maxPrice) {
        return setRespository.findByUsRetailPriceLessThan(maxPrice);
    }

    public List<LegoSet> getFilteredLegoSets(String theme, String name, Integer minPieces, Integer minMinifigs, Integer minAge, Float maxPrice) {
        return setRespository.findAll().stream()
                .filter(set -> theme == null || set.getTheme().equalsIgnoreCase(theme))
                .filter(set -> name == null || set.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(set -> minPieces == null || (set.getPieces() != null && set.getPieces() > minPieces))
                .filter(set -> minMinifigs == null || (set.getMinifigs() != null && set.getMinifigs() > minMinifigs))
                .filter(set -> minAge == null || (set.getAgeRangeMin() != null && set.getAgeRangeMin() > minAge))
                .filter(set -> maxPrice == null || (set.getUsRetailPrice() != null && set.getUsRetailPrice() < maxPrice))
                .collect(Collectors.toList());
    }

    public LegoSet addSet(LegoSet legoSet) {
        setRespository.save(legoSet);
        return legoSet;
    }

    public LegoSet updateSet(LegoSet updatedLegoSet) {
        Optional<LegoSet> existingSet = setRespository.findByName(updatedLegoSet.getName());
        if (existingSet.isPresent()) {
            LegoSet legoSetToUpdate = existingSet.get();
            legoSetToUpdate.setName(updatedLegoSet.getName());
            legoSetToUpdate.setTheme(updatedLegoSet.getTheme());
            legoSetToUpdate.setPieces(updatedLegoSet.getPieces());
            legoSetToUpdate.setMinifigs(updatedLegoSet.getMinifigs());
            legoSetToUpdate.setAgeRangeMin(updatedLegoSet.getAgeRangeMin());
            legoSetToUpdate.setUsRetailPrice(updatedLegoSet.getUsRetailPrice());
            setRespository.save(legoSetToUpdate);
            return legoSetToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteSet(String name) {
        setRespository.deleteByName(name);
    }
}