package sample;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class patientMenu extends Scene {

	private TextField patientName;
	private ChoiceBox month, day, year;
	private Button back, start;
	private String name, birthMonth, birthDay, birthYear;
	private String[] info = new String[4];
	
	public patientMenu(Parent root, double width, double height) {
		super(root, width, height);
	}
	
	public Pane patient_Pane(paneController paneController) {
	
		StackPane patient_Pane = new StackPane();
		patient_Pane.setStyle("-fx-background-color: white");
		
		patientName = new TextField("Patient Name");
		patientName.setMaxWidth(200);
		patient_Pane.setAlignment(patientName, Pos.CENTER);
		
		month = new ChoiceBox();
		month.getItems().addAll("Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
		patient_Pane.setAlignment(month, Pos.CENTER);
		month.setValue("Month");
		month.setTranslateY(30);
		
		day = new ChoiceBox();
		day.getItems().addAll("Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
		"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
		"23", "24", "25", "26", "27", "28", "29", "29", "30", "31");
		day.setValue("Day");
		patient_Pane.setAlignment(day, Pos.CENTER);
		day.setTranslateY(60);
		
		year = new ChoiceBox();
		year.getItems().addAll("Year", "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909",
		"1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919",
		"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929",
		"1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939",
		"1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949",
		"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
		"1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
		"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
		"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
		"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
		"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
		"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018");
		patient_Pane.setAlignment(year, Pos.CENTER);
		year.setValue("Year");
		year.setTranslateY(90);
		
		start = new Button("Start");
		StackPane.setAlignment(start, Pos.BOTTOM_RIGHT);
		start.setTranslateY(-15);
	    start.setTranslateX(-15);
	    start.setOnAction(e -> {setDay(day.getValue().toString());
	        					setMonth(month.getValue().toString());
	    						setYear(year.getValue().toString());
	    						setName(patientName.getText());
	    						setInfo();
	    						paneController.setInfo(info);
	    						paneController.enterExamMenu();
	    });
		
		back = new Button("Back");
		StackPane.setAlignment(back, Pos.BOTTOM_LEFT);
		back.setTranslateY(-15);
	    back.setTranslateX(15);
	    back.setOnAction(e -> paneController.enterMainMenu());
	    patient_Pane.getChildren().addAll(patientName, month, day, year, start, back);
	    
	    return patient_Pane;
	}
	
	public void setDay(String day) {
		birthDay = day;
	}
	
	public void setMonth(String month) {
		birthMonth = month;
	}
	
	public void setYear(String year) {
		birthYear = year;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDay() {
		return birthDay;
	}
	
	public String getMonth() {
		return birthMonth;
	}
	
	public String getYear() {
		return birthYear;
	}
	
	public String getName() {
		return name;
	}
	
	public void setInfo() {
		info[0] = getName();
		info[1] = getMonth();
		info[2] = getDay();
		info[3] = getYear();
	}

	public String[] getInfo() {
		return info;
	}
}