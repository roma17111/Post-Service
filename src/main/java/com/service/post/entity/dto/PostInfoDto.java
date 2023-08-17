package com.service.post.entity.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostInfoDto {

    long postId;
    String typeOfPost;
    String nameOfRecieved;
    String addressOfRecieved;
    String indexOfRecieved;

    String status;

    String nameOfOrg;
    String addressOfOrg;
    String indexOfOrg;
    String date;

}
