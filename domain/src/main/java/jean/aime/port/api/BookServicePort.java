package jean.aime.port.api;

import jean.aime.data.BookDto;

import java.util.List;

public interface BookServicePort {

    BookDto addBook(BookDto bookDto);

    void deleteBookById(Long id);

    BookDto updateBook(BookDto bookDto);

    List<BookDto> getBooks();

    BookDto getBookById(Long bookId);
}
