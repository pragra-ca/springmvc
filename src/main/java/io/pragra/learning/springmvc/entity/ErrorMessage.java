package io.pragra.learning.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class ErrorMessage {
    private String errCode;
    private String desc;
    @JsonFormat(pattern = "yyyy-DD-mm HH:mm:ss.SSS")
    private Date timeOfError;
}
