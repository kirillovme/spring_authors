package dkirillov.springframework.spring5webapp.bootstrap;

import dkirillov.springframework.spring5webapp.domain.Author;
import dkirillov.springframework.spring5webapp.domain.Book;
import dkirillov.springframework.spring5webapp.domain.Publisher;
import dkirillov.springframework.spring5webapp.repositories.AuthorRepository;
import dkirillov.springframework.spring5webapp.repositories.BookRepository;
import dkirillov.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123211");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3213124");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher johnMichels = new Publisher("Michaelis", "Gribok", "Kovrov", "Vladimir", "601900");

        publisherRepository.save(johnMichels);
        ddd.setPublisher(johnMichels);
        johnMichels.getBooks().add(ddd);
        publisherRepository.save(johnMichels);

        noEJB.setPublisher(johnMichels);
        johnMichels.getBooks().add(noEJB);
        publisherRepository.save(johnMichels);

        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publishers Number of Books: " + johnMichels.getBooks().size());
    }
}
