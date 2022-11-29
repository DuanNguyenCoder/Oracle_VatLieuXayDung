package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entity.itemCart;

public interface ItemCartService {

	double getAmount();

	void update(int productId, int quantity);

	Collection<itemCart> getList();

	void clear();

	void remove(int id);

	void add(itemCart item);

	int getsize();

}
