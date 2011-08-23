package org.osmsurround.ra.context;

import java.util.List;

import org.osmsurround.ra.AnalyzerException;
import org.osmsurround.ra.analyzer.AggregatedSegment;
import org.osmsurround.ra.data.Relation;
import org.osmsurround.ra.graph.Graph;
import org.osmsurround.ra.segment.ConnectableSegment;

public class AnalyzerContext {

	private Relation relation;

	private List<ConnectableSegment> segments;
	private List<AggregatedSegment> aggregatedSegments;
	private List<Graph> graphs;

	AnalyzerContext(Relation relation) {
		this.relation = relation;
	}

	public Relation getRelation() {
		return relation;
	}

	public List<ConnectableSegment> getSegments() {
		if (segments == null)
			throw new AnalyzerException("Segments not initialized");
		return segments;
	}

	public void setSegments(List<ConnectableSegment> segments) {
		this.segments = segments;
	}

	public List<AggregatedSegment> getAggregatedSegments() {
		if (aggregatedSegments == null)
			throw new AnalyzerException("Aggregated segments not initialized");
		return aggregatedSegments;
	}

	public void setAggregatedSegments(List<AggregatedSegment> aggregatedSegments) {
		this.aggregatedSegments = aggregatedSegments;
	}

	public List<Graph> getGraphs() {
		if (graphs == null)
			throw new AnalyzerException("Graphs not initialized");
		return graphs;
	}

	public void setGraphs(List<Graph> graphs) {
		this.graphs = graphs;
	}

}
