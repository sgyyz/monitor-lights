import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Homework
{
	public static void main(String[] args)
	{
		try
		{
			List<Product> productList = simulateReadProduct();
			List<MaterialSupply> supplyList = simulateReadSupply();

			ProductProduce p = new ProductProduce();
			p.getOutput(productList, supplyList);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}

	private static List<MaterialSupply> simulateReadSupply() throws ParseException
	{
		List<MaterialSupply> supplyList = new ArrayList<>();

		ArrayList<Date> startDates;
		ArrayList<Date> endDates;
		ArrayList<Integer> supplyNums;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		MaterialSupply supply = new MaterialSupply();
		supply.setMaterialId("RAW_ROSE_005");

		startDates = new ArrayList<>();
		endDates = new ArrayList<>();
		supplyNums = new ArrayList<>();

		startDates.add(sdf.parse("2014-10-01"));
		endDates.add(sdf.parse("2014-10-31"));
		supplyNums.add(18);

		startDates.add(sdf.parse("2015-01-01"));
		endDates.add(sdf.parse("2015-01-31"));
		supplyNums.add(666);

		supply.setStartDates(startDates);
		supply.setEndDates(endDates);
		supply.setSupplyNums(supplyNums);

		supplyList.add(supply);


		/*---------------------------*/

		supply = new MaterialSupply();
		supply.setMaterialId("CAPACITY");

		startDates = new ArrayList<>();
		endDates = new ArrayList<>();
		supplyNums = new ArrayList<>();

		startDates.add(sdf.parse("2014-02-04"));
		endDates.add(sdf.parse("2015-01-15"));
		supplyNums.add(999);

		supply.setStartDates(startDates);
		supply.setEndDates(endDates);
		supply.setSupplyNums(supplyNums);

		supplyList.add(supply);

		/*---------------------------*/

		supply = new MaterialSupply();
		supply.setMaterialId("RAW_EUCALYPTUS_001");

		startDates = new ArrayList<>();
		endDates = new ArrayList<>();
		supplyNums = new ArrayList<>();

		startDates.add(sdf.parse("2014-02-04"));
		endDates.add(sdf.parse("2014-11-30"));
		supplyNums.add(6000);

		startDates.add(sdf.parse("2015-02-01"));
		endDates.add(sdf.parse("2038-01-19"));
		supplyNums.add(6000);

		supply.setStartDates(startDates);
		supply.setEndDates(endDates);
		supply.setSupplyNums(supplyNums);

		supplyList.add(supply);

		return supplyList;
	}

	private static List<Product> simulateReadProduct()
	{
		List<Product> productList = new ArrayList<>();

		Product product = new Product();
		product.setId("98100201");

		HashMap<String, Integer> materialBoms = new HashMap<>();
		materialBoms.put("RAW_ROSE_005", 14);
		materialBoms.put("CAPACITY", 1);
		product.setMaterialBoms(materialBoms);

		productList.add(product);

		/*---------------------------------*/
		product = new Product();
		product.setId("98102601");

		materialBoms = new HashMap<>();
		materialBoms.put("RAW_EUCALYPTUS_001", 4);
		materialBoms.put("RAW_ROSE_005", 12);
		materialBoms.put("CAPACITY", 1);
		product.setMaterialBoms(materialBoms);

		productList.add(product);

		return productList;
	}
}
