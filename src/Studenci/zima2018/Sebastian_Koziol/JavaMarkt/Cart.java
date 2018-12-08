package JavaMarkt.JavaMarkt2;

import java.util.ArrayList;

public class Cart {
	private ArrayList<CartItem> items = new ArrayList<>();
	private ArrayList<IPromotion> promotions = new ArrayList<>();
	double promotionSumOfProducts = 0;
	
	public double totalPriceOfProducts(){
		double sum = 0;
		for(CartItem it : items)
			sum += it.getProduct().getPrice();
		return sum;
	}
	public double totalPriceOfDiscountedProducts(){
		double sum = 0;
		for(CartItem it : items)
			sum += it.getCurrentPrice();
		return sum;
	}
	public ArrayList<CartItem> getItems() {
		return items;
	}
	
	public Cart addProduct(Product p) {
		items.add(new CartItem(p));
		promotionSumOfProducts += p.getPrice();
		promotionSumOfProducts = Math.ceil(promotionSumOfProducts * 100.0)/100.0;
		return this;
	}

	public Cart addPromotion(IPromotion p) {
		promotions.add(p);
		return this;
	}
	
	public Cart applyPromotions(){
		for(IPromotion p : promotions){
			p.CalculateOffer(this);
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "In Cart are: \n" + items + "\npromotions=" + promotions + "\npromotionSumOfProducts = " + promotionSumOfProducts + " PLN";
	}

}