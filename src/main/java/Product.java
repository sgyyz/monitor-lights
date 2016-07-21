import java.util.Map;

public class Product
{
	private String id;

	private Map<String, Integer> materialBoms;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Map<String, Integer> getMaterialBoms()
	{
		return materialBoms;
	}

	public void setMaterialBoms(Map<String, Integer> materialBoms)
	{
		this.materialBoms = materialBoms;
	}
}
