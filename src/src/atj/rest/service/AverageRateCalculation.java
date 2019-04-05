package src.atj.rest.service;

import java.util.Iterator;
import java.util.List;

import src.atj.rest.model.ExchangeRatesSeries;
import src.atj.rest.model.Rate;
import src.atj.rest.model.Rates;

public class AverageRateCalculation {
	private ExchangeRatesSeries exch;
	private List<Rates> rates;
	private Iterator<Rates> ratesIter;

	private int count = 0;
	private double askTotal = 0;
	private double bidTotal = 0;

	public AverageRateCalculation(ExchangeRatesSeries exch) {
		this.exch = exch;
		rates = exch.getRates();
		ratesIter = rates.iterator();
		calculate();
	}

	public double getAvgBid() {
		return bidTotal / count;
	}

	public double getAvgAsk() {
		return askTotal / count;
	}

	private void calculate() {
		while (ratesIter.hasNext()) {
			List<Rate> rate = ratesIter.next().getRate();
			Iterator<Rate> rateIter = rate.iterator();
			while (rateIter.hasNext()) {
				count++;
				Rate rateItem = rateIter.next();
				askTotal += rateItem.getAsk();
				bidTotal += rateItem.getBid();
			}
		}
	}
}
