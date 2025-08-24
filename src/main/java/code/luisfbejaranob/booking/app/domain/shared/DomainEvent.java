package code.luisfbejaranob.booking.app.domain.shared;

import java.time.LocalDateTime;
import java.util.UUID;

public sealed interface DomainEvent
{
	// Booking Events
	record BookingReserved(UUID bookingId, LocalDateTime reservedAt) implements DomainEvent
	{}

	record BookingConfirmed(UUID bookingId, LocalDateTime confirmedAt) implements DomainEvent
	{}

	record BookingCancelled(UUID bookingId, String reason, LocalDateTime cancelledAt) implements DomainEvent
	{}

	record BookingCompleted(UUID bookingId, LocalDateTime completedAt) implements DomainEvent
	{}

	record BookingRejected(UUID bookingId, String reason, LocalDateTime rejectedAt) implements DomainEvent
	{}

	// User Events
	record UserCreated(UUID userId, String email, LocalDateTime createdAt) implements DomainEvent
	{}
}
