package com.assessment.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageDTO {
    private int imageId;
    private String name;
    private String image;

    public ImageDTO(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
