package com.example.demo.service.impl;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.itemCart;
import com.example.demo.service.ItemCartService;

@Service
public class itemCartServiceImpl implements ItemCartService {
	
	
	Map<Integer, itemCart> map = new HashMap<Integer,itemCart>();
	
	
	@Override
	public void add( itemCart item) {
		itemCart exsistItemCart = map.get(item.getId());
		
		if (exsistItemCart != null) {
			exsistItemCart.setQuantity(exsistItemCart.getQuantity() + item.getQuantity());
		}else {
		map.put(item.getId(),item);
		}
		
	}
	@Override
	public void remove(int id) {
		map.remove(id);
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	@Override
	public Collection<itemCart> getList (){
		return map.values();
	}
	
	@Override
	public int getsize() {
		return map.size();
	}

	@Override
	public void update( int productId, int quantity) {
		itemCart item = map.get(productId);
		
		item.setQuantity(quantity + item.getQuantity());
		if (item.getQuantity() <= 0) {
         
			map.remove(productId);
		}
	}
	
	@Override
	public double getAmount() {
		
	return	map.values().stream().mapToDouble(item -> item.getQuantity()* item.getPrice() ).sum();
	}
}
