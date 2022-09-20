package haagahelia.bookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	    private String author;
	    private String title;
	    private String isbn;
	    private int publish; 
	    
	    public Book() {}
	    
		public Book(String author, String title, String isbn, int publish) {
			super();
			this.author = author;
			this.title = title;
			this.isbn = isbn;
			this.publish = publish;
		}
		
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public int getPublish() {
			return publish;
		}
		public void setPublish(int publish) {
			this.publish = publish;
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", publish="
					+ publish + "]";
		}
			
}
