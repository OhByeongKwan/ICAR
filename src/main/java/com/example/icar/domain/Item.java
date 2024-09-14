package com.example.icar.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String inventory;

    private String type;

    private String name;

    private String code;

    private String year;

    private String location;

    private String imgName;

    private String storeName;

    private String imgPath;

    private String note;
}
