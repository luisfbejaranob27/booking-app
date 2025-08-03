package code.luisfbejaranob.booking.app.domain.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import code.luisfbejaranob.booking.app.domain.apartment.Apartment;
import code.luisfbejaranob.booking.app.domain.booking.events.BookingCancelled;
import code.luisfbejaranob.booking.app.domain.booking.events.BookingCompleted;
import code.luisfbejaranob.booking.app.domain.booking.events.BookingConfirmed;
import code.luisfbejaranob.booking.app.domain.booking.events.BookingRejected;
import code.luisfbejaranob.booking.app.domain.booking.events.BookingReserved;
import code.luisfbejaranob.booking.app.domain.shared.DomainEvent;
import code.luisfbejaranob.booking.app.domain.shared.Money;
import code.luisfbejaranob.booking.app.domain.shared.Result;
import code.luisfbejaranob.booking.app.domain.shared.Error;

public class Booking
{
	private UUID id;
	private UUID userId;
	private UUID apartmentId;
	private DateRange dateRange;
	private LocalDate confirmedOn;
	private LocalDate rejectedOn;
	private LocalDate cancelledOn;
	private LocalDate completedOn;
	private Money priceForPeriod;
	private Money cleaningFee;
	private Money amenitiesUpcharge;
	private Money totalPrice;
	private List<DomainEvent> domainEvents = new ArrayList<>();
	private BookingStatus status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private Booking(
		UUID id,
		UUID userId,
		UUID apartmentId,
		DateRange dateRange,
		LocalDate confirmedOn,
		LocalDate rejectedOn,
		LocalDate cancelledOn,
		LocalDate completedOn,
		Money priceForPeriod,
		Money cleaningFee,
		Money amenitiesUpcharge,
		Money totalPrice,
		BookingStatus status,
		LocalDateTime createdAt,
		LocalDateTime updatedAt)
	{
		this.id = id;
		this.userId = userId;
		this.apartmentId = apartmentId;
		this.dateRange = dateRange;
		this.confirmedOn = confirmedOn;
		this.rejectedOn = rejectedOn;
		this.cancelledOn = cancelledOn;
		this.completedOn = completedOn;
		this.priceForPeriod = priceForPeriod;
		this.cleaningFee = cleaningFee;
		this.amenitiesUpcharge = amenitiesUpcharge;
		this.totalPrice = totalPrice;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UUID getId()
	{
		return id;
	}

	public void setId(UUID id)
	{
		this.id = id;
	}

	public UUID getUserId()
	{
		return userId;
	}

	public void setUserId(UUID userId)
	{
		this.userId = userId;
	}

	public UUID getApartmentId()
	{
		return apartmentId;
	}

	public void setApartmentId(UUID apartmentId)
	{
		this.apartmentId = apartmentId;
	}

	public DateRange getDateRange()
	{
		return dateRange;
	}

	public void setDateRange(DateRange dateRange)
	{
		this.dateRange = dateRange;
	}

	public LocalDate getConfirmedOn()
	{
		return confirmedOn;
	}

	public void setConfirmedOn(LocalDate confirmedOn)
	{
		this.confirmedOn = confirmedOn;
	}

	public LocalDate getRejectedOn()
	{
		return rejectedOn;
	}

	public void setRejectedOn(LocalDate rejectedOn)
	{
		this.rejectedOn = rejectedOn;
	}

	public LocalDate getCancelledOn()
	{
		return cancelledOn;
	}

	public void setCancelledOn(LocalDate cancelledOn)
	{
		this.cancelledOn = cancelledOn;
	}

	public LocalDate getCompletedOn()
	{
		return completedOn;
	}

	public void setCompletedOn(LocalDate completedOn)
	{
		this.completedOn = completedOn;
	}

	public Money getPriceForPeriod()
	{
		return priceForPeriod;
	}

	public void setPriceForPeriod(Money priceForPeriod)
	{
		this.priceForPeriod = priceForPeriod;
	}

	public Money getCleaningFee()
	{
		return cleaningFee;
	}

	public void setCleaningFee(Money cleaningFee)
	{
		this.cleaningFee = cleaningFee;
	}

	public Money getAmenitiesUpcharge()
	{
		return amenitiesUpcharge;
	}

	public void setAmenitiesUpcharge(Money amenitiesUpcharge)
	{
		this.amenitiesUpcharge = amenitiesUpcharge;
	}

	public Money getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(Money totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public BookingStatus getStatus()
	{
		return status;
	}

	public void setStatus(BookingStatus status)
	{
		this.status = status;
	}

	public LocalDateTime getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt()
	{
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt)
	{
		this.updatedAt = updatedAt;
	}

	public List<DomainEvent> getDomainEvents()
	{
		return new ArrayList<>(domainEvents);
	}

	public void clearDomainEvents()
	{
		domainEvents.clear();
	}

	public void addDomainEvent(DomainEvent event)
	{
		domainEvents.add(event);
	}

	public static Booking reserve(
		UUID userId,
		Apartment apartment,
		DateRange dateRange,
		LocalDate now,
		PricingService pricingService)
	{
		PricingDetails pricingDetails = PricingService.calculatePrice(apartment, dateRange);
		Booking booking = new Booking(
			UUID.randomUUID(),
			userId,
			apartment.getId(),
			dateRange,
			now,
			null,
			null,
			null,
			pricingDetails.priceForPeriod(),
			pricingDetails.cleaningFee(),
			pricingDetails.amenitiesUpcharge(),
			pricingDetails.totalPrice(),
			BookingStatus.RESERVED,
			LocalDateTime.now(),
			null);

		booking.addDomainEvent(new BookingReserved(booking.id));

		apartment.setLastBookedOn(now);

		return booking;
	}

	public Result<Booking> confirm(LocalDate now)
	{
		if (status != BookingStatus.RESERVED)
		{
			return Result.failure(new Error(BookingError.NotPending));
		}

		status = BookingStatus.CONFIRMED;
		confirmedOn = now;
		updatedAt = LocalDateTime.now();

		addDomainEvent(new BookingConfirmed(id));

		return Result.success(this);
	}

	public Result<Booking> reject(LocalDate now)
	{
		if (status != BookingStatus.RESERVED)
		{
			return Result.failure(new Error(BookingError.NotPending));
		}

		status = BookingStatus.REJECTED;
		rejectedOn = now;
		updatedAt = LocalDateTime.now();

		addDomainEvent(new BookingRejected(id));

		return Result.success(this);
	}

	public Result<Booking> complete(LocalDate now)
	{
		if (status != BookingStatus.CONFIRMED)
		{
			return Result.failure(new Error(BookingError.NotConfirmed));
		}

		status = BookingStatus.COMPLETED;
		completedOn = now;
		updatedAt = LocalDateTime.now();

		addDomainEvent(new BookingCompleted(id));

		return Result.success(this);
	}

	public Result<Booking> cancel(LocalDate now)
	{
		if (status != BookingStatus.CONFIRMED)
		{
			return Result.failure(new Error(BookingError.NotConfirmed));
		}

		if (now.isAfter(dateRange.start()))
		{
			return Result.failure(new Error(BookingError.AlreadyStarted));
		}

		status = BookingStatus.CANCELLED;
		cancelledOn = now;
		updatedAt = LocalDateTime.now();

		addDomainEvent(new BookingCancelled(id));

		return Result.success(this);
	}
}
