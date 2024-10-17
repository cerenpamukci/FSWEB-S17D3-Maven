package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Kangaroo {
   private Integer id;
   private String name;
   private Double height;
    private Double weight;
    private String gender;
    private boolean isAggressive;

    public boolean isAggressive() {
        return isAggressive;
    }

    public boolean getIsAggressive() {
        return isAggressive;
    }

    public void setIsAggressive(boolean isAggressive) {
        this.isAggressive = isAggressive;
    }
}
