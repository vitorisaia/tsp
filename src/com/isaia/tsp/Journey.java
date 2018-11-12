package com.isaia.tsp;

import java.util.ArrayList;
import java.util.List;

public class Journey {

	private int cost;

	private List<Node> path = new ArrayList<>();

	public Journey(final int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(final int cost) {
		this.cost = cost;
	}

	public void addNode(final Node node) {
		this.path.add(node);
	}

	public List<Node> getPath() {
		return this.path;
	}

	@Override
	public String toString() {
		return "Journey [cost=" + this.cost + ", path=" + this.path + "]";
	}

}
