package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /** Create a publisher */
        Publisher publisher = new Publisher("ABC Publishers", "Mahajan Vihar", "Ludhiana", "Punjab", "141010");
        publisherRepository.save(publisher);

        /** Create 1st author and 1st book */
        Book book1 = new Book("Eat your Frog", "1234");
        Author author1 = new Author("Brian", "Tracy");
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        author1.getBookSet().add(book1);
        publisher.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        /** Create 2nd author and 2nd book */
        Book book2 = new Book("Rich Dad Poor Dad", "2345");
        Author author2 = new Author("Robert", "Kioski");
        book2.getAuthors().add(author2);
        author2.getBookSet().add(book2);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        /** adding books to publisher */


        /** Save both books and author */
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);


        System.out.println("No of books in DB: "+bookRepository.count());
        System.out.println("No of authors in DB: "+authorRepository.count());
        System.out.println("No of publishers in DB: "+publisherRepository.count());
    }
}
