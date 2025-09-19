package com.lego.lego_sets.set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// CRUD
@Repository
public interface SetRepository extends JpaRepository<LegoSet, String> {
    void deleteByName(String name);

    Optional<LegoSet> findByName(String name);
    List<LegoSet> findByMinifigsGreaterThan(int minMinifigs);
    List<LegoSet> findByAgeRangeMinGreaterThan(int minAge);
    List<LegoSet> findByPiecesGreaterThan(int minPieces);
    List<LegoSet> findByUsRetailPriceLessThan(float maxPrice);
}

