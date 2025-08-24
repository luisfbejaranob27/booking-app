package code.luisfbejaranob.booking.app.domain.booking;

import java.util.UUID;

public sealed interface BookingError
{
	String getCode();

	String getMessage();

	record NotPending(UUID bookingId) implements BookingError
	{
		@Override
		public String getCode()
		{
			return "Booking.NotPending";
		}

		@Override
		public String getMessage()
		{
			return "Booking is not pending";
		}
	}

	record NotConfirmed(UUID bookingId) implements BookingError
	{
		@Override
		public String getCode()
		{
			return "Booking.NotConfirmed";
		}

		@Override
		public String getMessage()
		{
			return "Booking is not confirmed";
		}
	}

	record AlreadyStarted(UUID bookingId) implements BookingError
	{
		@Override
		public String getCode()
		{
			return "Booking.AlreadyStarted";
		}

		@Override
		public String getMessage()
		{
			return "Booking has already started";
		}
	}

	record BookingNotFound(UUID bookingId) implements BookingError
	{
		@Override
		public String getCode()
		{
			return "Booking.NotFound";
		}

		@Override
		public String getMessage()
		{
			return "Booking not found with id: " + bookingId;
		}
	}

	record InvalidDateRange(UUID bookingId, String reason) implements BookingError
	{
		@Override
		public String getCode()
		{
			return "Booking.InvalidDateRange";
		}

		@Override
		public String getMessage()
		{
			return "Invalid date range: " + reason;
		}
	}

	record BookingConflict(UUID bookingId, String conflictingBookingId) implements BookingError
	{
		@Override
		public String getCode()
		{
			return "Booking.Conflict";
		}

		@Override
		public String getMessage()
		{
			return "Booking conflicts with existing booking: " + conflictingBookingId;
		}
	}
}
