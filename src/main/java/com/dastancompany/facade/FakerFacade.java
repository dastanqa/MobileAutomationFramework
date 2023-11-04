package com.dastancompany.facade;

import com.github.javafaker.Faker;

public class FakerFacade {
    public static void getBuildingNumber(){
        new Faker().address().buildingNumber();
    }
}
