package com.fullcycle.imersaoms.models;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@Data
@With
public class Payment {

  String id;
  String userId;
  PaymentStatus status;

  public enum PaymentStatus {
    PENDING, APPROVED
  }
}
