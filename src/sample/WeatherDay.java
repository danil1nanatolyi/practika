package sample;

public class WeatherDay {
    private int day;
    private int month;
    private int precipitation;
    private int temperature;
    private int pressure;
    private int humidity;

    public WeatherDay(int day, int month, int precipitation, int temperature, int pressure, int humidity) {
        this.day = day;
        this.month = month;
        this.precipitation = precipitation;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getPrecipitation() { return precipitation; }
    public void setPrecipitation(int precipitation) { this.precipitation = precipitation; }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }

    public int getPressure() { return pressure; }
    public void setPressure(int pressure) { this.pressure = pressure; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }
}
