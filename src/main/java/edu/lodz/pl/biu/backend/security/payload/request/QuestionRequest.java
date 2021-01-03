package edu.lodz.pl.biu.backend.security.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class QuestionRequest {

    @NotBlank
    private String topic;

    @NotBlank
    @Size(max = 150)
    private String text;

    @NotBlank
    private String username;

}
