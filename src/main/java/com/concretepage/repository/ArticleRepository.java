package com.concretepage.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.concretepage.entity.Article;

/**
 * 
 * We will create:
 *    A service class for CRUD operations using ((CrudRepository)) implementation. 
 *      ((CrudRepository)) provides generic CRUD operations on a repository for 
 *      a specific type. ((CrudRepository)) is a Spring data interface and 
 *      to use it we need to create our interface by extending ((CrudRepository)). 
 *      Spring provides ((CrudRepository)) implementation class automatically 
 *      at runtime. It contains methods such as (save), (findById), (delete), 
 *      (count) etc. We can also create custom methods. We can start our custom 
 *      query method names with ((find...By)), ((read...By)), ((query...By)), 
 *      ((count...By)), and ((get...By)). Before (By) we can add expression 
 *      such as (Distinct). After (By) we need to add property names of our 
 *      entity. We can also use ((( @Query ))) annotation to create custom methods. 
 *      
 *      
 * Now find the repository interface used in our example
 *
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {

	Article findByArticleId(long articleId);
    List<Article> findByTitleAndCategory(String title, String category);
	
    
   // The implementation class of our repository interface will be created by 
   //   Spring automatically. Now we will create service and use or repository 
   //   for CRUD operations. 
}
