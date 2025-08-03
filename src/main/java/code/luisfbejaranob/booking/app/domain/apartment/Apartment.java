package code.luisfbejaranob.booking.app.domain.apartment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import code.luisfbejaranob.booking.app.domain.shared.Address;
import code.luisfbejaranob.booking.app.domain.shared.Money;

public class Apartment
{
	private UUID id;
	private String name;
	private String description;
	private Address address;
	private String phone;
	private Money price;
	private Money cleaningFee;
	private List<Amenity> amenities;
	private LocalDate lastBookedOn;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Apartment(
		UUID id,
		String name,
		String description,
		Address address,
		String phone,
		Money price,
		Money cleaningFee,
		List<Amenity> amenities,
		LocalDate lastBookedOn,
		String status,
		LocalDateTime createdAt,
		LocalDateTime updatedAt)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.phone = phone;
		this.price = price;
		this.cleaningFee = cleaningFee;
		this.amenities = amenities;
		this.lastBookedOn = lastBookedOn;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public Money getPrice()
	{
		return price;
	}

	public void setPrice(Money price)
	{
		this.price = price;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Money getCleaningFee()
	{
		return cleaningFee;
	}

	public void setCleaningFee(Money cleaningFee)
	{
		this.cleaningFee = cleaningFee;
	}

	public List<Amenity> getAmenities()
	{
		return amenities;
	}

	public void setAmenities(List<Amenity> amenities)
	{
		this.amenities = amenities;
	}

	public LocalDate getLastBookedOn()
	{
		return lastBookedOn;
	}

	public void setLastBookedOn(LocalDate lastBookedOn)
	{
		this.lastBookedOn = lastBookedOn;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
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
}
