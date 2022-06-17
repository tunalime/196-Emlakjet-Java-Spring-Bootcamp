package com.emlakjet.crudapp.dto;

import com.emlakjet.crudapp.entity.Author;
import com.emlakjet.crudapp.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFilter {

    Author author;
    Category category;
}
