package com.isa.donorapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class LoyaltyProgramDTO {
    private int pointsPerDonation;
    private String category1Name;
    private int category1Points;
    private String category2Name;
    private int category2Points;
    private String category3Name;
    private int category3Points;

    public LoyaltyProgramDTO(int pointsPerDonation, String category1Name, int category1Points, String category2Name,
                             int category2Points, String category3Name, int category3Points) {
        this.pointsPerDonation = pointsPerDonation;
        this.category1Name = category1Name;
        this.category1Points = category1Points;
        this.category2Name = category2Name;
        this.category2Points = category2Points;
        this.category3Name = category3Name;
        this.category3Points = category3Points;
    }

    public int getPointsPerDonation() {
        return pointsPerDonation;
    }

    public void setPointsPerDonation(int pointsPerDonation) {
        this.pointsPerDonation = pointsPerDonation;
    }

    public String getCategory1Name() {
        return category1Name;
    }

    public void setCategory1Name(String category1Name) {
        this.category1Name = category1Name;
    }

    public int getCategory1Points() {
        return category1Points;
    }

    public void setCategory1Points(int category1Points) {
        this.category1Points = category1Points;
    }

    public String getCategory2Name() {
        return category2Name;
    }

    public void setCategory2Name(String category2Name) {
        this.category2Name = category2Name;
    }

    public int getCategory2Points() {
        return category2Points;
    }

    public void setCategory2Points(int category2Points) {
        this.category2Points = category2Points;
    }

    public String getCategory3Name() {
        return category3Name;
    }

    public void setCategory3Name(String category3Name) {
        this.category3Name = category3Name;
    }

    public int getCategory3Points() {
        return category3Points;
    }

    public void setCategory3Points(int category3Points) {
        this.category3Points = category3Points;
    }
}
