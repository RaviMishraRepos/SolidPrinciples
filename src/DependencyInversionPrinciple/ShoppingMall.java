package DependencyInversionPrinciple;

import java.util.Optional;

public class ShoppingMall {

	private BankCard card;

	public ShoppingMall(BankCard card) {
		this.card = card;
	}

	void purchase(long amount) {
		card.doTransaction(amount);
	}

	public static void main(String[] args) {
		BankCard card = new CreditCard();
		Optional<BankCard> checkCard = Optional.ofNullable(card);
		if (checkCard.isPresent()) {
			ShoppingMall shoppingMall = new ShoppingMall(card);
			shoppingMall.purchase(5000);
		} else {
			card = new DebitCard();
			ShoppingMall shoppingMall = new ShoppingMall(card);
			shoppingMall.purchase(5000);
		}

	}
}
