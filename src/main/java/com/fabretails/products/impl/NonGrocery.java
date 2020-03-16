/**
 * 
 */
package com.fabretails.products.impl;

import com.fabretails.products.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NonGrocery implements Product {

	String productName;
	double productAmount;
}
