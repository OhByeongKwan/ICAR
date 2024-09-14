package com.example.icar.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@DynamicInsert
public class AddItem {
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
