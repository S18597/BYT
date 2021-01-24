import java.util.*;

public class Configuration {
	public int interval;

	public int duration;

	public int departure;

	public void loadInterval(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new ConfiguratioException("monitor  interval");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		interval = value;
	}

	public void loadDuration(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		duration = value;
	}

	public void loadDeparture(Properties  props) throws ConfigurationException{
		String valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		departure = value;
	}

	public void load(Properties props) throws ConfigurationException{
		loadDeparture();
		loadDuration();
		loadInterval();
	}
}
