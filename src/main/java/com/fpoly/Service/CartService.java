package com.fpoly.Service;

import java.util.Collection;

import com.fpoly.Entity.Item;

public interface CartService {

	Item addCart(Integer id);
	
	void remove(Integer id);
	
	void clear();
	
	int getCount();
	
	double getAmount();
	
	Collection<Item> getItems();

}
