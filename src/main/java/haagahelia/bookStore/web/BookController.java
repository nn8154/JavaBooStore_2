package haagahelia.bookStore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import haagahelia.bookStore.domain.Book;
import haagahelia.bookStore.domain.BookRepository;
import haagahelia.bookStore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; 

	@Autowired
	private CategoryRepository drepository; 
	
	//Show all books
    @RequestMapping("/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
	// RESTful service to get all students
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    } 
    
    
    //Add new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categorys", drepository.findAll());
        return "addbook";
    } 
    
    //Save book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
    
    //Delete book
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
}
