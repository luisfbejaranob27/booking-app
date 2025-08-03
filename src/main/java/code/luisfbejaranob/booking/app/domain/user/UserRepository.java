package code.luisfbejaranob.booking.app.domain.user;

import java.util.List;
import java.util.UUID;

public interface UserRepository
{
	User create(User user);
	List<User> findAll();
	User findById(UUID id);
	User update(User user);
	void delete(User user);
}
