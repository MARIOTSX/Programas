package core.udemy.springU.springU.Boostrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import core.udemy.springU.springU.Author;
import core.udemy.springU.springU.Book;
import core.udemy.springU.springU.Publisher;
import core.udemy.springU.springU.repositories.AuthorRepository;
import core.udemy.springU.springU.repositories.BookRepository;
import core.udemy.springU.springU.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	 

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		initData();
	}

	private void initData() {
		// TODO Auto-generated method stub
		Publisher pub= new Publisher();
		pub.setName("Abrego Brothers");
		pub.setAddress("St. 29 San Lorenzo California");
		

		publisherRepository.save(pub);
		
		Author eric=new Author("Eric","Evans");
		Book odd= new Book("Domain Driven Desktop", "1234",pub); 
		eric.getBooks().add(odd);
		odd.getAuthors().add(eric); 
		
		authorRepository.save(eric);
		bookRepository.save(odd);
		
		Publisher pub2= new Publisher();
		pub2.setName("Quiroz Brothers");
		pub2.setAddress("St. 29 San Lorenzo California");
		publisherRepository.save(pub2);
		
		Author rod=new Author("Rod","Johnson");
		Book noEJB=new Book("J2EE Development","23334", pub2);
		
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB); 
	}

}
