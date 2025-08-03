package code.luisfbejaranob.booking.app.domain.apartment;

import java.util.List;
import java.util.UUID;

public interface ApartmentRepository
{
	Apartment create(Apartment apartment);
	List<Apartment> findAll();
	Apartment findByApartmentId(UUID apartmentId);
	Apartment findById(UUID id);
	Apartment update(Apartment apartment);
	void delete(Apartment apartment);
}
