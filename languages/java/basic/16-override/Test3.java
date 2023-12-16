
public class Test3 extends Sales{
	int amount;	// ÃÑ¾×
	
	void setProcess() {
		amount = getQty() * getCost();
	}
	void getDisplay() {	
		// ÆÇ¸Å°¡°Ý = ÃÑ¾× - ÃÑ¾×*ÇÒÀÎÀ²
		int resultSales = (int)(amount - amount*getDiscount());
		System.out.println(getArticle() + "\t" + resultSales);
	}
}
