package com.isaia.tsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TravellingSalesmanSolver {

	private Node home;

	private Map<Node, List<Path>> graph;

	private List<Node> visited = new ArrayList<>();

	private Journey journey = new Journey(0);

	public TravellingSalesmanSolver(final Node home, final Map<Node, List<Path>> graph) {
		this.home = home;
		this.graph = graph;
		this.visited.add(home);
	}

	public Journey solve() {
		List<Integer> costList = new ArrayList<>();

		this.journey.addNode(this.home);

		this.travelToClosestAllowed(this.home, this.home, costList);

		int total = 0;
		for (Integer cost : costList) {
			total += cost;
		}

		this.journey.setCost(total);

		return this.journey;
	}

	private void travelToClosestAllowed(final Node first, final Node current, final List<Integer> costList) {
		if (this.metAll()) {
			this.returnHome(current, this.graph, costList);
			return;
		}

		Path bestPath = this.findCurrentBestPath(current, this.graph, this.visited, costList);

		this.journey.addNode(bestPath.b);

		this.travelToClosestAllowed(first, bestPath.b, costList);
	}

	private boolean metAll() {
		return this.visited.size() == this.graph.keySet().size();
	}

	private Path findCurrentBestPath(final Node current, final Map<Node, List<Path>> graph, final List<Node> visited,
			final List<Integer> costList) {
		List<Path> paths = graph.get(current);

		Path bestPath = null;

		for (Path path : paths) {
			if (visited.contains(path.b))
				continue;

			if (bestPath == null) {
				bestPath = path;
				continue;
			}

			if (path.cost < bestPath.cost) {
				bestPath = path;
			}
		}

		costList.add(bestPath.cost);
		visited.add(bestPath.b);

		return bestPath;
	}

	private void returnHome(final Node current, final Map<Node, List<Path>> graph, final List<Integer> costList) {

		this.journey.addNode(this.home);

		List<Path> paths = graph.get(current);

		for (Path path : paths) {
			if (path.b.value == this.home.value) {
				costList.add(path.cost);
			}
		}
	}

}
