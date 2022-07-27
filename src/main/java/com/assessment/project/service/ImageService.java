package com.assessment.project.service;

import com.assessment.project.dto.ImageDTO;
import com.assessment.project.dto.request.RequestImageSaveDTO;

import java.util.List;

public interface ImageService {
    String addImage(RequestImageSaveDTO dto);

    List<ImageDTO> getAllImages();

    String deleteImage(int id);
}
