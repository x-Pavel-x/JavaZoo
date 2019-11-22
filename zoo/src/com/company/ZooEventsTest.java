package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static com.company.Main.list_of_herbivores;
import static com.company.Main.list_of_predators;
import static com.company.ZooEvents.*;
import static org.junit.jupiter.api.Assertions.*;

class ZooEventsTest {

    @BeforeEach
    void setUp() throws ParseException, IOException {

        list_of_predators = new ArrayList<>();
        list_of_herbivores = new ArrayList<>();
        Object obj = new JSONParser().parse(new FileReader("src\\com\\company\\AList.json"));
        JSONObject jo = (JSONObject) obj;
        String kind, animal_sound;
        long number;
        number = (long) jo.get("number1");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind1");
            animal_sound = (String) jo.get("animal_sound1");
            list_of_herbivores.add(new herbivores(kind,animal_sound));
        }
        number = (long) jo.get("number2");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind2");
            animal_sound = (String) jo.get("animal_sound2");
            list_of_herbivores.add(new herbivores(kind,animal_sound));
        }
        number = (long) jo.get("number3");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind3");
            animal_sound = (String) jo.get("animal_sound3");
            list_of_predators.add(new predators(kind,animal_sound));
        }
        number = (long) jo.get("number4");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind4");
            animal_sound = (String) jo.get("animal_sound4");
            list_of_predators.add(new predators(kind,animal_sound));
        }
    }

    @AfterEach
    void tearDown() {
        list_of_predators.clear();
        list_of_herbivores.clear();
    }

    @Test
    void test_event1_generate_event_for_predators() {
        generate_event_for_predators(list_of_predators,event1);
        for(predators i : list_of_predators) {
            assertEquals(true,i.get_noise_status());
        }
    }

    @Test
    void test_event1_generate_event_for_herbivores() {
        generate_event_for_herbivores(list_of_herbivores,event1);
        for(herbivores i : list_of_herbivores) {
            assertEquals(true,i.get_noise_status());
        }
    }
    @Test
    void test_event2_generate_event_for_predators() {
        generate_event_for_predators(list_of_predators,event2);
        for(predators i : list_of_predators) {
            assertEquals(true,i.get_noise_status());
        }
    }

    @Test
    void test_event3_generate_event_for_predators() {
        generate_event_for_predators(list_of_predators,event3);
        for(predators i : list_of_predators) {
            assertEquals(false,i.get_noise_status());
        }
    }

    @Test
    void test_event3_generate_event_for_herbivores() {
        generate_event_for_herbivores(list_of_herbivores,event3);
        for(herbivores i : list_of_herbivores) {
            assertEquals(false,i.get_noise_status());
        }
    }
    @Test
    void test_event4_generate_event_for_predators() {
        generate_event_for_predators(list_of_predators,event4);
        for(predators i : list_of_predators) {
            assertEquals(true,i.get_sleep_status());
        }
    }

    @Test
    void test_event4_generate_event_for_herbivores() {
        generate_event_for_herbivores(list_of_herbivores,event4);
        for(herbivores i : list_of_herbivores) {
            assertEquals(true,i.get_sleep_status());
        }
    }
    @Test
    void test_event5_generate_event_for_predators() {
        generate_event_for_predators(list_of_predators,event4);
        generate_event_for_predators(list_of_predators,event5);
        for(predators i : list_of_predators) {
            assertEquals(false,i.get_sleep_status());
        }
    }

    @Test
    void test_event5_generate_event_for_herbivores() {
        generate_event_for_predators(list_of_predators,event4);
        generate_event_for_herbivores(list_of_herbivores,event5);
        for(herbivores i : list_of_herbivores) {
            assertEquals(false,i.get_sleep_status());
        }
    }
    @Test
    void test_event6_generate_event_for_predators() {
        generate_event_for_predators(list_of_predators,event6);
        for(predators i : list_of_predators) {
            assertEquals(true,i.get_noise_status());
            assertEquals(false, i.get_sleep_status());
        }
    }
    @Test
    void test_event6_generate_event_for_herbivores() {
        generate_event_for_herbivores(list_of_herbivores,event6);
        for(herbivores i : list_of_herbivores) {
            assertEquals(true,i.get_noise_status());
            assertEquals(false, i.get_sleep_status());
        }
    }

}