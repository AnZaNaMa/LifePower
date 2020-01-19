package com.networkoverflow.lifepower.content.capabilities;

public interface ILifeForce {
    public void consume(int amount);

    public void fill(int amount);

    public void set(int amount);

    public int getLifeForce();
}
