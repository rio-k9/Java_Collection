/* 
 * CLASS #6
 * 
 * //getter and setter for stock information
 * 
 */
package application;

public class Stocks {
	
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
	private String adjclose;
	
	public Stocks() {
		this.date = "";
		this.open = "";
		this.high = "";
		this.low = "";
		this.close = "";
		this.volume = "";
		this.adjclose = "";
	}
	
	//ARGUMENTS FOR STOCK INFO
	public Stocks(String date, String open, String high, String low, String close, String volume, String adjclose){
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.adjclose = adjclose;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getAdjclose() {
		return adjclose;
	}

	public void setAdjclose(String adjclose) {
		this.adjclose = adjclose;
	}
	
	
}
