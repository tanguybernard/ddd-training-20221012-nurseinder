package com.zenika.nurseinder.meeting.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zenika.nurseinder.meeting.domain.enumeration.Status;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Builder
@Data
public class Period {

  private Date beginDate;

  private Date endDate;

  private List<Day> days;

  private Status status;

}
