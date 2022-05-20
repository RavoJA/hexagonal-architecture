package jean.aime.config;

import jean.aime.adapter.BookJpaAdpter;
import jean.aime.port.api.BookServicePort;
import jean.aime.port.spi.BookPersistencePort;
import jean.aime.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistence(){
        return new BookJpaAdpter();
    }

    @Bean
    public BookServicePort bookService(){
        return new BookServiceImpl(bookPersistence());
    }
}
