package com.company;

public abstract class Animal
{
    public String kind;
    public String animal_sound;
    public boolean noise_status; // true = кричит
    public boolean sleep_status; // true = спит
    public boolean get_noise_status()
    {
        return this.noise_status;
    }
    public boolean get_sleep_status()
    {
        return this.sleep_status;
    }
}
