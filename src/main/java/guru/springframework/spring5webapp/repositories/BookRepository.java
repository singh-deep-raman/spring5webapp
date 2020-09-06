package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    /**
     * Notes -
     *   Setting up Spring Data JPA
     *     1. It is very easy to setup Spring Data JPA which will help us to perform CRUD operations
     *     2. Create a package 'repositories' and create an interface for each Entity/Domain you have created in this package
     *     3. The interfaces you will create will extend CrudRepository<T,U> where T is of type Entity and U is of type of primary key for T type entity
     *
     *     R--> This is the primary reason you will use Long id instead of 'long id' in Entity for primary key because we need to use this in Spring Data JPA
     */

}
