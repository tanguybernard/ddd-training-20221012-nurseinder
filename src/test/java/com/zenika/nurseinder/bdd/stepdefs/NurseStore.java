package com.zenika.nurseinder.bdd.stepdefs;

import com.zenika.nurseinder.meeting.domain.nurse_aggregate.Nurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NurseStore {

    private List<Nurse> nurses = new ArrayList<>();

    public void addBook(Nurse book) {
        nurses.add(book);
    }

    public void addAllBooks(Collection<Nurse> books) {
        this.nurses.addAll(books);
    }

    public List<Nurse> nurseById(String id) {
        return nurses.stream()
                .filter(nurse -> Objects.equals(id, nurse.getId().value()))
                .collect(Collectors.toList());
    }
}