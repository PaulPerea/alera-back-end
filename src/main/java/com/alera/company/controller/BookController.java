package com.alera.company.controller;

import com.alera.company.api.BooksApi;
import com.alera.company.model.BookRequest;
import com.alera.company.model.BookResponse;
import com.alera.company.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController implements BooksApi {

    private final BookService bookService;

    @Override
    public Mono<ResponseEntity<BookResponse>> createBook(
            Mono<BookRequest> bookRequest,
            ServerWebExchange exchange
    ) {
        return bookRequest
                .flatMap(bookService::createBook)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response));
    }
}