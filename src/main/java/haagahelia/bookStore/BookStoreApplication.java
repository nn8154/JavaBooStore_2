package haagahelia.bookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.bookStore.domain.Book;
import haagahelia.bookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save");
			Book b1 = new Book("Author1", "Title1", "123", 2021);
			Book b2 = new Book("Author2", "Title2", "456", 2022);	
			
			repository.save(b1);
			repository.save(b2);
			
			log.info("fetch");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
