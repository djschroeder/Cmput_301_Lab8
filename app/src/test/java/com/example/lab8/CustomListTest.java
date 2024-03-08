package com.example.lab8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void setUp() {
        list = new CustomList(null, new ArrayList<>());
        // Adding initial cities for testing
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Regina", "SK"));
    }

    @Test
    public void hasCityTest() {
        assertTrue(list.hasCity("Estevan"));
        assertFalse(list.hasCity("Calgary"));
    }

    @Test
    public void deleteCityTest() {
        assertTrue(list.deleteCity("Estevan"));
        assertFalse(list.hasCity("Estevan")); // Verify city was deleted
        assertFalse(list.deleteCity("Calgary")); // Verify false when trying to delete a non-existent city
    }

    @Test
    public void countCitiesTest() {
        assertEquals(2, list.countCities());
        list.addCity(new City("Saskatoon", "SK"));
        assertEquals(3, list.countCities()); // Verify count after adding a city
    }
}
