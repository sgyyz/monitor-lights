import java.util.*;

public class ProductProduce
{
	public void getOutput(List<Product> productList, List<MaterialSupply> supplyList)
	{

		List<Result> resultList = new ArrayList<>();

		for (Product product : productList)
		{
			Result r = new Result(product.getId());

			for (MaterialSupply supply : supplyList)
			{
				if (product.getMaterialBoms().keySet().contains(supply.getMaterialId()))
				{
					intersectOfSupply(r, supply, product.getMaterialBoms().get(supply.getMaterialId()));
				}
			}

			resultList.add(r);
		}

		for (Result r : resultList)
			r.printResult();

	}

	private void intersectOfSupply(Result result, MaterialSupply supply, int productNeeds)
	{
		if (result == null)
			throw new NullPointerException();

		if (supply == null)
			return;

		if (result.getStartDates() == null)
		{
			result.setStartDates(supply.getStartDates());
			result.setEndDates(supply.getEndDates());
			ArrayList<Integer> provides = new ArrayList<>();
			for (Integer supplyNum : supply.getSupplyNums())
			{
				Integer provide = supplyNum / productNeeds;
				provides.add(provide);
			}
			result.setProvides(provides);
			return;
		}

		Date min, max;
		ArrayList<Date> startDates = new ArrayList<>();
		ArrayList<Date> endDates = new ArrayList<>();

		ArrayList<Integer> provides = new ArrayList<>();

		for (int i = 0; i < result.getStartDates().size(); i++)
		{
			for (int j = 0; j < supply.getStartDates().size(); j++)
			{
				Date r_start = result.getStartDates().get(i);
				Date r_end = result.getEndDates().get(i);
				Date s_start = supply.getStartDates().get(j);
				Date s_end = supply.getEndDates().get(j);

				if (r_end.before(r_start))
					continue;
				if (s_end.before(s_start))
					continue;
				if (s_end.before(r_start))
					continue;
				if (r_end.before(s_start))
					continue;

				int provide = result.getProvides().get(i);
				int supplyNum = supply.getSupplyNums().get(j) / productNeeds;
				if (supplyNum < provide)
					provide = supplyNum;

				if (provide > 0)
				{
					provides.add(provide);

					min = r_start;
					if (s_start.after(r_start))
						min = s_start;

					max = r_end;
					if (s_end.before(r_end))
						max = s_end;

					startDates.add(min);
					endDates.add(max);
				}
			}
		}

		result.setStartDates(startDates);
		result.setEndDates(endDates);
		result.setProvides(provides);
	}

	public static class Result
	{
		private String productId;

		private List<Integer> provides;

		private List<Date> startDates;

		private List<Date> endDates;

		public Result(String productId)
		{
			this.productId = productId;
		}

		public void printResult()
		{
			if (productId == null || "".equals(productId) || provides == null || provides.isEmpty() || startDates == null || startDates.isEmpty() || endDates == null || endDates.isEmpty())
				return;

			for (int i = 0; i < startDates.size(); i++)
			{
				System.out.println(String.format("%1$s  %2$tF  %3$tF  %4$d", productId, startDates.get(i), endDates.get(i), provides.get(i)));
			}

		}

		public String getProductId()
		{
			return productId;
		}

		public void setProductId(String productId)
		{
			this.productId = productId;
		}

		public List<Integer> getProvides()
		{
			return provides;
		}

		public void setProvides(List<Integer> provides)
		{
			this.provides = provides;
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
	}
}
