package com.alera.company.service;

import com.alera.company.model.BookRequest;
import com.alera.company.model.BookResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<BookResponse> createBook(BookRequest request);

}