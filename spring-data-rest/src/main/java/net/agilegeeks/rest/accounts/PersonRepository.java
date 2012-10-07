package net.agilegeeks.rest.accounts;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource(path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

  @RestResource(path = "name", rel = "names")
  public List<Person> findByName(@Param("name") String name);
  
  @RestResource(path = "nameLike", rel = "names")
  public List<Person> findByNameLike(@Param("name") String name);
  
  @RestResource(path = "nameContaining", rel = "names")
  public List<Person> findByNameContaining(@Param("name") String name);
    
  
}
