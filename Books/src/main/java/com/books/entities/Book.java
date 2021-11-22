package com.books.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Document(collection = "books")
public class Book
{
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;
}