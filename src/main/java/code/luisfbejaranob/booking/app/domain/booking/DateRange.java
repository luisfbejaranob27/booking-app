package code.luisfbejaranob.booking.app.domain.booking;

import java.time.LocalDate;
import java.time.Period;

public record DateRange(
	LocalDate startDate,
	LocalDate endDate)
{}
