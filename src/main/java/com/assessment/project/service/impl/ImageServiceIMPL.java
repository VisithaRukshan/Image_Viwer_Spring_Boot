package com.assessment.project.service.impl;

import com.assessment.project.dto.ImageDTO;
import com.assessment.project.dto.request.RequestImageSaveDTO;
import com.assessment.project.entity.Image;
import com.assessment.project.exception.EntryDuplicateException;
import com.assessment.project.exception.NotFoundException;
import com.assessment.project.repository.ImageRepo;
import com.assessment.project.service.ImageService;

import com.assessment.project.util.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageServiceIMPL implements ImageService {
    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public String addImage(RequestImageSaveDTO dto) {
        ImageDTO imageDTO = new ImageDTO(
                dto.getName(),
                dto.getImage()
        );
        if (!imageRepo.existsById(imageDTO.getImageId())) {
            return imageRepo.save(imageMapper.dtoToEntity(imageDTO)).getImage();
        } else {
            throw new EntryDuplicateException("already exists");
        }
    }

    @Override
    public List<ImageDTO> getAllImages() {
        List<Image> images = imageRepo.findAll();
        System.out.println(images.size());
        if(images.size()>0){
            return imageMapper.entityListToDtoList(images);
        }else{
            throw new NotFoundException("no entries");
        }

    }

    @Override
    public String deleteImage(int id) {
        if(imageRepo.existsById(id)){
         imageRepo.deleteById(id);
         return id + " deleted succes ";
        }else {
            throw new NotFoundException("no data found for id "+id);
        }

    }
}
