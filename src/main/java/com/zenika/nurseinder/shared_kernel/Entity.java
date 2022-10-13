package com.zenika.nurseinder.shared_kernel;

public class Entity<T> {
    public ValueObjectId<T> id;
    public Entity(ValueObjectId<T> id){
        this.id = id;
    }

    public boolean equals(ValueObjectId<T> id){
        return this.id.equals(id);
    }


}
