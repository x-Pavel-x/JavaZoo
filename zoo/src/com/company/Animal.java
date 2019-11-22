package com.company;

public abstract class Animal
{
    public String kind;
    public String animal_sound;
    public boolean noise_status; // true = кричит
    public boolean sleep_status; // true = спит
    public boolean get_noise_status()
    {
        return noise_status;
    }
}
