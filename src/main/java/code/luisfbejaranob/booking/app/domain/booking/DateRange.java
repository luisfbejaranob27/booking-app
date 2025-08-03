package code.luisfbejaranob.booking.app.domain.booking;

import java.time.LocalDate;
import java.time.Period;

public record DateRange(LocalDate start, LocalDate end)
{
	public static DateRange create(LocalDate start, LocalDate end)
	{
		if (start.isAfter(end))
		{
			throw new IllegalArgumentException("Start date must be before end date");
		}

		return new DateRange(start, end);
	}

	public int getDays()
	{
		return Period.between(start, end).getDays();
	}

}
