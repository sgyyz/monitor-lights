import java.util.Date;
import java.util.List;

public class MaterialSupply
{
	private String materialId;
	private List<Date> startDates;
	private List<Date> endDates;
	private List<Integer> supplyNums;

	public String getMaterialId()
	{
		return materialId;
	}

	public void setMaterialId(String materialId)
	{
		this.materialId = materialId;
	}

	public List<Date> getStartDates()
	{
		return startDates;
	}

	public void setStartDates(List<Date> startDates)
	{
		this.startDates = startDates;
	}

	public List<Date> getEndDates()
	{
		return endDates;
	}

	public void setEndDates(List<Date> endDates)
	{
		this.endDates = endDates;
	}

	public List<Integer> getSupplyNums()
	{
		return supplyNums;
	}

	public void setSupplyNums(List<Integer> supplyNums)
	{
		this.supplyNums = supplyNums;
	}
}