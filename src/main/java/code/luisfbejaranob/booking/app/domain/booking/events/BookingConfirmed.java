package code.luisfbejaranob.booking.app.domain.booking.events;

import java.util.UUID;

import code.luisfbejaranob.booking.app.domain.shared.DomainEvent;

public record BookingConfirmed(UUID bookingId) implements DomainEvent
{}
