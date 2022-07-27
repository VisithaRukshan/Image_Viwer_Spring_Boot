package com.assessment.project.util.mapper;

import com.assessment.project.dto.ImageDTO;
import com.assessment.project.entity.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    Image dtoToEntity(ImageDTO imageDTO);

    List<ImageDTO> entityListToDtoList(List<Image> image);
}
