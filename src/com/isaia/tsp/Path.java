package com.isaia.tsp;

public class Path {

	public Path(final Node a, final Node b, final int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

	Node a, b;

	int cost;

	@Override
	public String toString() {
		return "Path [a=" + this.a + ", b=" + this.b + ", cost=" + this.cost + "]";
	}

}
