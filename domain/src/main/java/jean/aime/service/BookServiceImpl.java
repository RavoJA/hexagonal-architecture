package jean.aime.service;

import jean.aime.data.BookDto;
import jean.aime.port.api.BookServicePort;
import jean.aime.port.spi.BookPersistencePort;

import java.util.List;

public class BookServiceImpl implements BookServicePort {
    private BookPersistencePort bookPersistencePort;

    public BookServiceImpl(BookPersistencePort bookPersistencePort) {
        this.bookPersistencePort = bookPersistencePort;
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        return bookPersistencePort.addBook(bookDto);
    }

    @Override
    public void deleteBookById(Long id) {
        bookPersistencePort.deleteBookById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return bookPersistencePort.updateBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {
        return bookPersistencePort.getBooks();
    }

    @Override
    public BookDto getBookById(Long bookId) {
        return bookPersistencePort.getBookById(bookId);
    }
}
