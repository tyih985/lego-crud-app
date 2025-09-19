package com.lego.lego_sets.set;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SetService {
    private final SetRepository setRepository;

    @Autowired
    public SetService(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    public List<LegoSet> getSets() {
        return setRepository.findAll();
    }

    public List<LegoSet> getSetsByMinifigs(int minMinifigs) {
        return setRepository.findByMinifigsGreaterThan(minMinifigs);
    }

    public List<LegoSet> getSetsByAge(int minAge) {
        return setRepository.findByAgeRangeMinGreaterThan(minAge);
    }

    public List<LegoSet> getSetsByPieces(int minPieces) {
        return setRepository.findByPiecesGreaterThan(minPieces);
    }

    public List<LegoSet> getSetsByPrice(float maxPrice) {
        return setRepository.findByUsRetailPriceLessThan(maxPrice);
    }

    public List<LegoSet> getFilteredLegoSets(String theme, String name, Integer minPieces, Integer minMinifigs, Integer minAge, Float maxPrice) {
        return setRepository.findAll().stream()
                .filter(set -> theme == null || set.getTheme().equalsIgnoreCase(theme))
                .filter(set -> name == null || set.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(set -> minPieces == null || (set.getPieces() != null && set.getPieces() > minPieces))
                .filter(set -> minMinifigs == null || (set.getMinifigs() != null && set.getMinifigs() > minMinifigs))
                .filter(set -> minAge == null || (set.getAgeRangeMin() != null && set.getAgeRangeMin() > minAge))
                .filter(set -> maxPrice == null || (set.getUsRetailPrice() != null && set.getUsRetailPrice() < maxPrice))
                .collect(Collectors.toList());
    }

    public LegoSet addSet(LegoSet legoSet) {
        setRepository.save(legoSet);
        return legoSet;
    }

    public LegoSet updateSet(LegoSet updatedLegoSet) {
        Optional<LegoSet> existingSet = setRepository.findByName(updatedLegoSet.getName());
        if (existingSet.isPresent()) {
            LegoSet legoSetToUpdate = existingSet.get();
            legoSetToUpdate.setName(updatedLegoSet.getName());
            legoSetToUpdate.setTheme(updatedLegoSet.getTheme());
            legoSetToUpdate.setPieces(updatedLegoSet.getPieces());
            legoSetToUpdate.setMinifigs(updatedLegoSet.getMinifigs());
            legoSetToUpdate.setAgeRangeMin(updatedLegoSet.getAgeRangeMin());
            legoSetToUpdate.setUsRetailPrice(updatedLegoSet.getUsRetailPrice());
            setRepository.save(legoSetToUpdate);
            return legoSetToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteSet(String name) {
        setRepository.deleteByName(name);
    }
}