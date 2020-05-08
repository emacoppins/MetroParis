package it.polito.tdp.metroparis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.metroparis.db.MetroDAO;

public class Model {

	Graph<Fermata, DefaultEdge> grafo;		
	Map<Integer, Fermata>fermateIdMap= new HashMap<>();
	MetroDAO dao=new MetroDAO();
	List<Adiacenza>adiacenze=dao.getAdiacenze();
	
	public Model () {
		this.grafo = new SimpleDirectedGraph<>(DefaultEdge.class) ;
		dao.getAllFermate(fermateIdMap);
		Graphs.addAllVertices(grafo, this.fermateIdMap.values());
		
		for(Adiacenza a: adiacenze) {
			grafo.addEdge(this.fermateIdMap.get(a.getStP()), this.fermateIdMap.get(a.getStA()));
		
		}
		System.out.format("Grafo caricato con %d vertici %d archi",
				this.grafo.vertexSet().size(),
				this.grafo.edgeSet().size());
	
	}
		public static void main(String args[]) {
			new Model() ;
		}
	
	
}
