package com.zenika.nurseinder.meeting.domain;


import com.zenika.nurseinder.meeting.domain.enumeration.Status;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Period {

  private Date beginDate;

  private Date endDate;

  private List<Day> days;

  private Status status;

}
