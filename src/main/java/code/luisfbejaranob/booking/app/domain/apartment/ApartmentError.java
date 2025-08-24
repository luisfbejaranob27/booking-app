package code.luisfbejaranob.booking.app.domain.apartment;

public sealed interface ApartmentError
{
	String getCode();

	String getMessage();

	record ApartmentNotFound(String apartmentId) implements ApartmentError
	{
		@Override
		public String getCode()
		{
			return "Apartment.NotFound";
		}

		@Override
		public String getMessage()
		{
			return "Apartment not found with id: " + apartmentId;
		}
	}

	record ApartmentNotAvailable(String apartmentId, String reason) implements ApartmentError
	{
		@Override
		public String getCode()
		{
			return "Apartment.NotAvailable";
		}

		@Override
		public String getMessage()
		{
			return "The apartment is not available: " + reason;
		}
	}

	record InvalidPrice(String apartmentId, String reason) implements ApartmentError
	{
		@Override
		public String getCode()
		{
			return "Apartment.InvalidPrice";
		}

		@Override
		public String getMessage()
		{
			return "The apartment price is not valid: " + reason;
		}
	}

	record InvalidAddress(String apartmentId, String reason) implements ApartmentError
	{
		@Override
		public String getCode()
		{
			return "Apartment.InvalidAddress";
		}

		@Override
		public String getMessage()
		{
			return "The apartment address is not valid: " + reason;
		}
	}

	record ApartmentAlreadyExists(String apartmentId) implements ApartmentError
	{
		@Override
		public String getCode()
		{
			return "Apartment.AlreadyExists";
		}

		@Override
		public String getMessage()
		{
			return "Apartment already exists with id: " + apartmentId;
		}
	}
}
