package jean.aime.adapter;

import jean.aime.dto.BookDto;
import jean.aime.entity.Book;
import jean.aime.mapper.BookMapper;
import jean.aime.port.out.BookPersistencePort;
import jean.aime.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookJpaAdpter implements BookPersistencePort {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDto addBook(BookDto bookDto) {

        Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);

        Book bookSaved = bookRepository.save(book);

        return BookMapper.INSTANCE.bookToBookDto(bookSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {

        List<Book> bookList = bookRepository.findAll();

        return BookMapper.INSTANCE.bookListToBookDtoList(bookList);
    }

    @Override
    public BookDto getBookById(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        return book.map(BookMapper.INSTANCE::bookToBookDto).orElse(null);

    }
}
