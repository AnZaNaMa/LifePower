package com.networkoverflow.lifepower.content.capabilities;

public class LifeForce implements ILifeForce {
    private int lifeForce = 0;

    @Override
    public void consume(int amount) {
        this.lifeForce -= amount;

        if(this.lifeForce < 0) this.lifeForce = 0;
    }

    @Override
    public void fill(int amount) {
        this.lifeForce += amount;
    }

    @Override
    public void set(int amount) {
        this.lifeForce = amount;
    }

    @Override
    public int getLifeForce() {
        return this.lifeForce;
    }
}
