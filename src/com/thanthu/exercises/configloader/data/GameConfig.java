package com.thanthu.exercises.configloader.data;

public class GameConfig {
	private int releaseYear;
	private String gameName;
	private double price;

	public int getReleaseYear() {
		return this.releaseYear;
	}

	public String getGameName() {
		return this.gameName;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "GameConfig{" + "releaseYear=" + releaseYear + ", gameName='" + gameName + '\'' + ", price=" + price
				+ '}';
	}
}
