package com.example.demo.responsitory;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.itemCart;

public class itemCartRepository {
	
	
	Map<Integer, itemCart> map = new HashMap<Integer,itemCart>();
	
	
	public void add( itemCart item) {
		itemCart exsistItemCart = map.get(item.getId());
		
		if (exsistItemCart != null) {
			exsistItemCart.setQuantity(exsistItemCart.getQuantity() + item.getQuantity());
		}
		map.put(item.getId(),item);
		
	}
	public void remove(int id) {
		map.remove(id);
	}
	
	public void clear() {
		map.clear();
	}
	public Collection<itemCart> getList (){
		return map.values();
	}

	public void update( int productId, int quantity) {
		itemCart item = map.get(productId);
		
		item.setQuantity(quantity + item.getQuantity());
		if (item.getQuantity() <= 0) {
         
			map.remove(productId);
		}
	}
	
	public double getAmount() {
		
	return	map.values().stream().mapToDouble(item -> item.getQuantity()* item.getPrice() ).sum();
	}
}
