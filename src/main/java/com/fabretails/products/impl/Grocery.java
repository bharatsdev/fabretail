/**
 * 
 */
package com.fabretails.products.impl;

import com.fabretails.products.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Grocery implements Product {

	String productName;
	double productAmount; 

}
