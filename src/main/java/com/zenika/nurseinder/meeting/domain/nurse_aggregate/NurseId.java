package com.zenika.nurseinder.meeting.domain.nurse_aggregate;

import static java.util.Objects.requireNonNull;

public record NurseId(String value) {

    public NurseId{
        requireNonNull(value);

    }
}
