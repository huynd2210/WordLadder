package solver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordDistanceGraph {
    public WordDistanceGraph(){

    }

    public Graph<String, DefaultEdge> buildGraph(int wordLength) throws IOException {
        Graph<String, DefaultEdge> wordDistanceGraph = new SimpleGraph<>(DefaultEdge.class);
        List<String> wordList = getWordList();
        List<String> wordListWithLengthN = wordList.stream()
                .filter(string -> string.length() == wordLength)
                .collect(Collectors.toList());
        for (int i = 0; i < wordListWithLengthN.size() - 1; i++){
            for (int j = i + 1; j < wordListWithLengthN.size(); j++){
                if (WordJumpSolver.findSubsitutionDistance(wordListWithLengthN.get(i), wordListWithLengthN.get(j)) == 1){
                    wordDistanceGraph.addVertex(wordListWithLengthN.get(i));
                    wordDistanceGraph.addVertex(wordListWithLengthN.get(j));
                    wordDistanceGraph.addEdge(wordListWithLengthN.get(i), wordListWithLengthN.get(j));
                }
            }
        }


        return wordDistanceGraph;
    }

    private List<String> getWordList() throws IOException {
        List<String> mw = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("wordList.txt")));
        String st;
        while ((st = br.readLine()) != null){
            mw.add(st);
        }
        br.close();
        return mw;
    }

    private void writeJSON(Graph<String, DefaultEdge> g) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("WordDistance4.json"), g);
    }


}
