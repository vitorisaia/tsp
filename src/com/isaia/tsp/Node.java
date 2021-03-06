package com.isaia.tsp;

public class Node {
	int value;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.value;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (this.value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + this.value + "";
	}
}
