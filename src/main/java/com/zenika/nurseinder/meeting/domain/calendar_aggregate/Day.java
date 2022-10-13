package com.zenika.nurseinder.meeting.domain.calendar_aggregate;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Day {

  private String type;

  private Date date;
}
