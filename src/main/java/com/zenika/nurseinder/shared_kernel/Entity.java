package com.zenika.nurseinder.shared_kernel;

public class Entity {
    public ValueObjectId id;
    public Entity(ValueObjectId id){

        this.id = id;
    }

    public boolean equals(ValueObjectId id){
        return this.id.equals(id);
    }


}
