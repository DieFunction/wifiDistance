import java.io.BufferedReader;
import java.io.InputStreamReader;
//www.DieFunction.com
//www.DieFunction.com
//www.DieFunction.com
//www.DieFunction.com
public final class Wifi {
	private Process processor;
	private BufferedReader br;
	private double[] output;
	
	public Wifi(){
		try{
			processor = null ;
			br = null;
			output = new double[2];
		}
		catch(Exception e){
			System.err.println("Error");
		}
	}
	
	public void setEssid(String essid){
		String pointerBuff;
		int p=0;
		try{
			processor = Runtime.getRuntime().exec("Wifi " + essid);
			br = new BufferedReader(new InputStreamReader(processor.getInputStream()));
			while ((pointerBuff = br.readLine()) != null){
				output[p] = Double.parseDouble(pointerBuff);
				p++;
			}
			processor.destroy();
		}
		catch(Exception e){
			System.err.println("Error");
		}
	}
	
	public void setDbmOutput(double output){
		this.output[0] = output;
	}
	
	public double getDbmOutput(){
		return output[0];
	}
	
	public void setFreqOutput(double output){
		this.output[1] = output;
	}
	
	public double getFreqOutput(){
		return output[1]*1000;
	}
	
	public String distanceWifi(){
		double distance = (27.55 - (20 * Math.log10(getFreqOutput())) + Math.abs(getDbmOutput())) / 20.0;
		return String.format("%.2f m",Math.pow(10.0, distance));
	}
}
