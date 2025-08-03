package code.luisfbejaranob.booking.app.domain.user.events;

import java.util.UUID;

import code.luisfbejaranob.booking.app.domain.shared.DomainEvent;

public record UserCreated(UUID userId) implements DomainEvent
{}
