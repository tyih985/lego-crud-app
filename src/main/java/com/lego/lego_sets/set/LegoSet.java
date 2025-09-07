package com.lego.lego_sets.set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lego_stats")
public class LegoSet {
    @Column(name = "set_id", unique = true)
    private String setId;

    @Id
    @Column(name = "name", unique = true)
    private String name;
    private Integer year;
    private String theme;
    private String subtheme;
    private String themeGroup;
    private String category;
    private Integer pieces;
    private Integer minifigs;
    private Integer ageRangeMin;
    private Float usRetailPrice;
    private String bricksetUrl;
    private String thumbnailUrl;
    private String imageUrl;

    public LegoSet(String setId, String name, Integer year, String theme, String subtheme, String themeGroup, String category, Integer pieces, Integer minifigs, Integer ageRangeMin, Float usRetailPrice, String bricksetUrl, String thumbnailUrl, String imageUrl) {
        this.setId = setId;
        this.name = name;
        this.year = year;
        this.theme = theme;
        this.subtheme = subtheme;
        this.themeGroup = themeGroup;
        this.category = category;
        this.pieces = pieces;
        this.minifigs = minifigs;
        this.ageRangeMin = ageRangeMin;
        this.usRetailPrice = usRetailPrice;
        this.bricksetUrl = bricksetUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.imageUrl = imageUrl;
    }

    public LegoSet() {
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSubtheme() {
        return subtheme;
    }

    public void setSubtheme(String subtheme) {
        this.subtheme = subtheme;
    }

    public String getThemeGroup() {
        return themeGroup;
    }

    public void setThemeGroup(String themeGroup) {
        this.themeGroup = themeGroup;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Integer getMinifigs() {
        return minifigs;
    }

    public void setMinifigs(Integer minifigs) {
        this.minifigs = minifigs;
    }

    public Integer getAgeRangeMin() {
        return ageRangeMin;
    }

    public void setAgeRangeMin(Integer ageRangeMin) {
        this.ageRangeMin = ageRangeMin;
    }

    public Float getUsRetailPrice() {
        return usRetailPrice;
    }

    public void setUsRetailPrice(Float usRetailPrice) {
        this.usRetailPrice = usRetailPrice;
    }

    public String getBricksetUrl() {
        return bricksetUrl;
    }

    public void setBricksetUrl(String bricksetUrl) {
        this.bricksetUrl = bricksetUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
