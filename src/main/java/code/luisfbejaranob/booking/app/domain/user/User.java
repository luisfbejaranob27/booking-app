package code.luisfbejaranob.booking.app.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import code.luisfbejaranob.booking.app.domain.shared.Address;
import code.luisfbejaranob.booking.app.domain.shared.DomainEvent;
import code.luisfbejaranob.booking.app.domain.user.events.UserCreated;

public class User
{
	private UUID id;
	private String names;
	private String surnames;
	private String email;
	private Address address;
	private List<DomainEvent> domainEvents = new ArrayList<>();

	public User()
	{
		this.domainEvents = new ArrayList<>();
	}

	private User(
		UUID id,
		String names,
		String surnames,
		String email,
		Address address)
	{
		this.id = id;
		this.names = names;
		this.surnames = surnames;
		this.email = email;
		this.address = address;
	}

	public UUID getId()
	{
		return id;
	}

	public void setId(UUID id)
	{
		this.id = id;
	}

	public String getNames()
	{
		return names;
	}

	public void setNames(String names)
	{
		this.names = names;
	}

	public String getSurnames()
	{
		return surnames;
	}

	public void setSurnames(String surnames)
	{
		this.surnames = surnames;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
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

	public static User create(String names, String surnames, String email, Address address)
	{
		User user = new User(UUID.randomUUID(), names, surnames, email, address);
		user.addDomainEvent(new UserCreated(user.id));

		return user;
	}
}
