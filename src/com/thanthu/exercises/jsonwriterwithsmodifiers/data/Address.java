package com.thanthu.exercises.jsonwriterwithsmodifiers.data;

public class Address {
	private static final int ZIP_CODE_MAX_DIGITS = 5;
	private final transient String zipCode;
	private final String street;
	private final short apartment;

	public Address(String street, short apartment, String zipCode) {
		this.zipCode = zipCode;
		this.street = street;
		this.apartment = apartment;
	}
}
