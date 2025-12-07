package com.alera.company.service.imp;

import com.alera.company.domain.Book;
import com.alera.company.exception.BookAlreadyExistsException;
import com.alera.company.exception.BookNotFoundException;
import com.alera.company.mapper.BookMapper;
import com.alera.company.model.BookRequest;
import com.alera.company.model.BookResponse;
import com.alera.company.repository.BookRepository;
import com.alera.company.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Mono<BookResponse> createBook(BookRequest request) {

        return bookRepository.existsByTitle(request.getTitle())
                .flatMap(exists -> {
                    if (exists) {
                        log.error("Book with ISBN {} already exists", request.getTitle());
                        return Mono.error(new BookAlreadyExistsException(
                                "Book with ISBN " + request.getTitle() + " already exists"
                        ));
                    }

                    Book book = bookMapper.toEntity(request);
                    return bookRepository.save(book);
                })
                .map(bookMapper::toResponse)
                .doOnSuccess(response -> log.info("Book created successfully with ID: {}", response.getId()))
                .doOnError(error -> log.error("Error creating book: {}", error.getMessage()));
    }

}