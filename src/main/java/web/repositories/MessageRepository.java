package web.repositories;

import org.springframework.data.repository.CrudRepository;

import web.domain.Message;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findByTag(String tag);
}