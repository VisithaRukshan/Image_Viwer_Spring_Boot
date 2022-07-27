package com.assessment.project.controller;

import com.assessment.project.dto.ImageDTO;
import com.assessment.project.dto.request.RequestImageSaveDTO;
import com.assessment.project.service.ImageService;
import com.assessment.project.util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
@CrossOrigin
public class ImageController {
    private final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private ImageService imageService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            path = "/save")
    public ResponseEntity<StandardResponse> SaveImage(@RequestBody RequestImageSaveDTO dto) {
        String id = imageService.addImage(dto);
        LOGGER.info("added image , Id:" + dto.getImage());
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + "image successfully saved!", id),
                HttpStatus.CREATED);
    }

    @GetMapping(path = "/get-all-images")
    public ResponseEntity getAllImages() {
        List<ImageDTO> imageDTOs = imageService.getAllImages();
        LOGGER.info("getting All Images");
        return new ResponseEntity(new StandardResponse(200, "Success", imageDTOs), HttpStatus.OK);
    }

    @DeleteMapping(
            path = {"/delete-image/{id}"})
    public ResponseEntity getAllImages(@PathVariable int id) {
        String ids = imageService.deleteImage(id);
        LOGGER.info("delete Image");
        return new ResponseEntity(new StandardResponse(200, "Success", ids), HttpStatus.OK);
    }


}
