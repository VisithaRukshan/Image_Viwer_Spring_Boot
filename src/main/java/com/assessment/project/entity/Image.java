package com.assessment.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {
    @Id
    @Column(name = "image_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;
}
