/**
 * 
 */
package com.fabretails.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ItemGrocery implements Item {

	String itemName;
	double itemAmount;

}
