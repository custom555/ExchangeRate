package src.atj.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AverageRateResult {
	private double avgAsk;
	private double avgBid;
	
	public AverageRateResult() {}
	public AverageRateResult(double avgAsk, double avgBid) {
		this.avgAsk = avgAsk;
		this.avgBid = avgBid;
	}

	public double getAvgAsk() {
		return avgAsk;
	}

	public double getAvgBid() {
		return avgBid;
	}
	public void setAvgAsk(double avgAsk) {
		this.avgAsk = avgAsk;
	}
	public void setAvgBid(double avgBid) {
		this.avgBid = avgBid;
	}
}
