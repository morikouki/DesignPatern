package idcard;

import java.util.ArrayList;
import java.util.List;

import framework.Factory;
import framework.Product;

public class IDCardFactory extends Factory {

	private List owners = new ArrayList();
	private int id = 1;

	// IDCardインスタンを作成することで、「製品を作る」ことを実際に表現している
	protected Product createProduct(String owner) {
		return new IDCard(owner, id++);
	}


	// IDCardのowner（所有者）をownersフィールドに追加して、「登録」という機能を表現している
	protected void registerProduct(Product product) {
		owners.add(((IDCard)product).getOwner());
	}

	public List getOwners() {
		return owners;
	}

}
