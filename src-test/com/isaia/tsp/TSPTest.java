package com.isaia.tsp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TSPTest {

	@Test
	void tsp() {
		// prepare structures
		Node one = new Node();
		one.value = 1;

		Node two = new Node();
		two.value = 2;

		Node three = new Node();
		three.value = 3;

		Node four = new Node();
		four.value = 4;

		Map<Node, List<Path>> graph = new HashMap<>();

		graph.put(one, new ArrayList<>());
		graph.get(one).add(new Path(one, two, 10));
		graph.get(one).add(new Path(one, four, 20));
		graph.get(one).add(new Path(one, three, 15));

		graph.put(two, new ArrayList<>());
		graph.get(two).add(new Path(two, one, 10));
		graph.get(two).add(new Path(two, four, 25));
		graph.get(two).add(new Path(two, three, 35));

		graph.put(three, new ArrayList<>());
		graph.get(three).add(new Path(three, one, 15));
		graph.get(three).add(new Path(three, four, 30));
		graph.get(three).add(new Path(three, two, 35));

		graph.put(four, new ArrayList<>());
		graph.get(four).add(new Path(four, one, 20));
		graph.get(four).add(new Path(four, two, 25));
		graph.get(four).add(new Path(four, three, 30));

		Node start = one;

		TravellingSalesmanSolver solver = new TravellingSalesmanSolver(start, graph);
		Journey theBest = solver.solve();

		assertEquals(80, theBest.getCost());

		List<Node> path = theBest.getPath();

		assertEquals(start.value, path.get(0).value);
		assertEquals(two.value, path.get(1).value);
		assertEquals(four.value, path.get(2).value);
		assertEquals(three.value, path.get(3).value);
		assertEquals(start.value, path.get(4).value);

		System.out.println(theBest);
	}

}
