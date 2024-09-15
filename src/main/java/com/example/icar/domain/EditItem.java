package com.example.icar.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@DynamicInsert
public class EditItem {
    private Long idx;

    private String inventory;

    private String type;

    private String name;

    private String code;

    private String year;

    private String location;

    private Long itemNumber;

    private String hlLocation;

    private String note;
}
