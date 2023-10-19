package de.ait.shop.repositories;
import de.ait.shop.models.User;



public interface UsersRepository extends CrudRepository<User> {
    User findeAllByEmail(String email);
}
