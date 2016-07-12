package in.mahendrabagul.products.bean;

public class Product
{
	private String developer;

	public Product(String id, String name, String developer)
	{
		super();
		this.developer = developer;
		this.id = id;
		this.name = name;
	}

	public Product()
	{
		super();
	}

	private String	id;

	private String	name;

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDeveloper()
	{
		return developer;
	}

	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}
}
