package org.acme.model.adapter;

import org.acme.model.Book;
import org.acme.model.dto.BookDTO;

public class BookAdapter {

    public static Book toBook(BookDTO bookDTO){
        return Book.builder().id(bookDTO.getId()).name(bookDTO.getName()).author(bookDTO.getAuthor()).publicationYear(bookDTO.getPublicationYear()).build();
    }

    public static BookDTO toBookDTO(Book book){
        return BookDTO.builder().id(book.getId()).name(book.getName()).author(book.getAuthor()).publicationYear(book.getPublicationYear()).build();
    }
}
