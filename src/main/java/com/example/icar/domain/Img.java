package com.example.icar.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode
@ToString
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Img {
    private String imgName;

    private String storeName;

    private String imgPath;
}
