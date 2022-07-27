package com.assessment.project.util.mapper;

import com.assessment.project.dto.ImageDTO;
import com.assessment.project.entity.Image;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-27T09:26:45+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public Image dtoToEntity(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        image.setImageId( imageDTO.getImageId() );
        image.setName( imageDTO.getName() );
        image.setImage( imageDTO.getImage() );

        return image;
    }

    @Override
    public List<ImageDTO> entityListToDtoList(List<Image> image) {
        if ( image == null ) {
            return null;
        }

        List<ImageDTO> list = new ArrayList<ImageDTO>( image.size() );
        for ( Image image1 : image ) {
            list.add( imageToImageDTO( image1 ) );
        }

        return list;
    }

    protected ImageDTO imageToImageDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setImageId( image.getImageId() );
        imageDTO.setName( image.getName() );
        imageDTO.setImage( image.getImage() );

        return imageDTO;
    }
}
