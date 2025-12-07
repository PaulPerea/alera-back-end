package com.alera.company.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("libros")
public class Book {

    @Id
    private Long id;

    @Column("titulo")
    private String title;

    @Column("autor")
    private String author;

    @Column("precio")
    private Double price;

    @Column("descripcion")
    private String description;

    @Column("imagen_url")
    private String imageUrl;

    @Column("created_at")
    private OffsetDateTime createdAt;
}