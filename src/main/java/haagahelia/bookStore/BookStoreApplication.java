package haagahelia.bookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.bookStore.domain.Book;
import haagahelia.bookStore.domain.BookRepository;
import haagahelia.bookStore.domain.Category;
import haagahelia.bookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository srepository, CategoryRepository drepository) {
		return (args) -> {
			log.info("save a couple of books");
			drepository.save(new Category("Detective"));
			drepository.save(new Category("Novella"));
			drepository.save(new Category("Documentary"));
			
			srepository.save(new Book("Author1", "Title1", "1234", 2022, drepository.findByName("Detective").get(0)));
			srepository.save(new Book("Author2", "Title2", "1234", 2021, drepository.findByName("Novella").get(0)));	
			
			
			log.info("fetch all books");
			for (Book book: srepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
