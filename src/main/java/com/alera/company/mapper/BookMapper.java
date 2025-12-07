package com.alera.company.mapper;

import com.alera.company.domain.Book;
import com.alera.company.model.BookRequest;
import com.alera.company.model.BookResponse;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class BookMapper {

    public Book toEntity(BookRequest request) {
        return Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .price(request.getPrice())
                .createdAt(OffsetDateTime.now())
                .build();
    }

    public BookResponse toResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setPrice(book.getPrice());
        response.setCreatedAt(book.getCreatedAt());
        return response;
    }

    public void updateEntityFromRequest(Book book, BookRequest request) {
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
    }
}