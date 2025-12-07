package com.alera.company.repository;

import com.alera.company.domain.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends R2dbcRepository<Book, Long> {

    // ❌ ELIMINA ESTE MÉTODO - está generando el error
    // Mono<Book> findByTitle(String title);

    // ✅ USA ESTE en su lugar
    @Query("SELECT * FROM \"libros\" WHERE \"titulo\" = :title")
    Mono<Book> findByTitle(String title);

    @Query("SELECT COUNT(*) > 0 FROM \"libros\" WHERE \"titulo\" = :title")
    Mono<Boolean> existsByTitle(String title);

    @Query("SELECT COUNT(*) > 0 FROM \"libros\" WHERE \"titulo\" = :title AND \"id\" != :id")
    Mono<Boolean> existsByTitleAndIdNot(String title, Long id);
}