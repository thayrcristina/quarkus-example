package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.acme.exception.BookNotFoundException;
import org.acme.model.adapter.BookAdapter;
import org.acme.model.dto.BookDTO;
import org.acme.repository.BookRepository;

@AllArgsConstructor
@ApplicationScoped
@Transactional
public class BookService {

    private BookRepository bookRepository;

    public BookDTO findById(Long id){
        return BookAdapter.toBookDTO(bookRepository.findByIdOptional(id).orElseThrow(BookNotFoundException::new));
    }

    public void save(BookDTO bookDTO){
        bookRepository.persistAndFlush(BookAdapter.toBook(bookDTO));
    }

    public void delete(Long id){
        BookDTO bookDTO = findById(id);
        bookRepository.delete(BookAdapter.toBook(bookDTO));
    }
}
