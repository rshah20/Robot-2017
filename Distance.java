import java.util.ArrayList;

public class Distance { 
	ArrayList<Double> Distance = new ArrayList<Double>();


	public void ParseDistance(String str){
		String[] Data = str.split("\\*");
		//ArrayList<Double>Temperature = new ArrayList<Double>();
		Distance.clear();
		int all = 1;
	
		while (all < Data.length){
			Distance.add(Double.parseDouble(Data[all]));
			all = all + 1;
		}
	}
	public Double getDistance(int index){
		return (Double) Distance.toArray()[index];		
	}
	public int getLength(){
		return Distance.size();
	}
}
