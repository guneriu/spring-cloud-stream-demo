package com.guneriu.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

import lombok.*;

/**
 * Created by AB75448 on 01.09.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskMessage implements Serializable {

    private static final long serialVersionUID = -4432340284987970764L;
    private String value;

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println(new ObjectMapper().writeValueAsString(new TaskMessage("ugur")));
    }

}
