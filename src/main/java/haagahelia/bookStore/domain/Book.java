package haagahelia.bookStore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	    private String author;
	    private String title;
	    private String isbn;
	    private int publish; 
	    
	    @ManyToOne
	    @JoinColumn(name = "categoryid")
	    private Category category;
	    
	    public Book() {}


		public Book(String author, String title, String isbn, int publish, Category category) {
			super();
			this.author = author;
			this.title = title;
			this.isbn = isbn;
			this.publish = publish;
			this.category = category;
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

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			if (this.category != null)
				return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", publish="
					+ publish + ", category=" + category + " category = " + this.getCategory() + "]";
			else
				return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", publish="
				+ publish + ", category=" + category + "]";
				
		}
		 
}
