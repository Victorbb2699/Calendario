package dad.javafx.calendario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MonthComponent extends BorderPane implements Initializable {
	
	//model
	private IntegerProperty monthProperty = new SimpleIntegerProperty();
	private IntegerProperty yearProperty = new SimpleIntegerProperty();
	private ListProperty<Label> dias = new SimpleListProperty<Label>(FXCollections.observableArrayList());
	private Label diaActual;
	
	@FXML
	private BorderPane root;

	@FXML
	private Label mesLabel;

	@FXML
	private Label unoLabel;

	@FXML
	private Label dosLabel;

	@FXML
	private Label tresLabel;

	@FXML
	private Label cuatroLabel;

	@FXML
	private Label cincoLabel;

	@FXML
	private Label seisLabel;

	@FXML
	private Label sieteLabel;

	@FXML
	private Label ochoLabel;

	@FXML
	private Label nueveLabel;

	@FXML
	private Label diezLabel;

	@FXML
	private Label onceLabel;

	@FXML
	private Label doceLabel;

	@FXML
	private Label treceLabel;

	@FXML
	private Label catorceLabel;

	@FXML
	private Label quinceLabel;

	@FXML
	private Label diesiseisLabel;

	@FXML
	private Label diesisieteLabel;

	@FXML
	private Label diesiochoLabel;

	@FXML
	private Label diesinueveLabel;

	@FXML
	private Label veinteLabel;

	@FXML
	private Label veintiunoLabel;

	@FXML
	private Label veintidosLabel;

	@FXML
	private Label veintitresLabel;

	@FXML
	private Label veinticuatroLabel;

	@FXML
	private Label veinticincoLabel;

	@FXML
	private Label veintiseisLabel;

	@FXML
	private Label veintisieteLabel;

	@FXML
	private Label veintiochoLabel;

	@FXML
	private Label veintinueveLabel;

	@FXML
	private Label treintaLabel;

	@FXML
	private Label treintayunoLabel;

	@FXML
	private Label treintaydosLabel;

	@FXML
	private Label treintaytresLabel;

	@FXML
	private Label treintaycuatroLabel;

	@FXML
	private Label treintaycincoLabel;

	@FXML
	private Label treintayseisLabel;

	@FXML
	private Label treintaysieteLabel;

	@FXML
	private Label treintayochoLabel;

	@FXML
	private Label treintaynueveLabel;

	@FXML
	private Label cuarentaLabel;

	@FXML
	private Label cuarentayunoLabel;

	@FXML
	private Label cuarentaydosLabel;

	public MonthComponent() {
		super();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MonthComponentView.fxml"));
			loader.setController(this);
			loader.setRoot(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dias.addAll(unoLabel,dosLabel,tresLabel,cuatroLabel,cincoLabel,seisLabel,sieteLabel,ochoLabel,nueveLabel,diezLabel,onceLabel,doceLabel,treceLabel,catorceLabel
				,quinceLabel,diesiseisLabel,diesisieteLabel,diesiochoLabel,diesinueveLabel,veinteLabel,veintiunoLabel,veintidosLabel,veintitresLabel,veinticuatroLabel
				,veinticincoLabel,veintiseisLabel,veintisieteLabel,veintiochoLabel,veintinueveLabel,treintaLabel,treintayunoLabel,treintaydosLabel,treintaytresLabel,treintaycuatroLabel
				,treintaycincoLabel,treintayseisLabel,treintaysieteLabel,treintayochoLabel,treintaynueveLabel,cuarentaLabel,cuarentayunoLabel,cuarentaydosLabel);
		
		yearProperty.addListener((o,ov,nv)->{
			configurar();
		});
		
	}

	private void configurar() {
		GregorianCalendar aux = new GregorianCalendar(yearProperty.getValue(), monthProperty.getValue()-1, 1);
		YearMonth yearMonthObject = YearMonth.of(yearProperty.getValue(), monthProperty.getValue());
		int comienzo = aux.get(Calendar.DAY_OF_WEEK)-2;
		if(comienzo==-1) {
			comienzo=6;
		}
		
		for (int i = 0; i < dias.getSize(); i++) {
			dias.get().get(i).setText("");	
			if(dias.get().get(i).equals(diaActual)) {
				dias.get().get(i).getStyleClass().remove("today");
			}
		}
		for (int i = comienzo, j=1 ; j < yearMonthObject.lengthOfMonth()+1; i++,j++) {
			dias.get().get(i).setText(j+"");
			if(LocalDate.now().getYear()==yearProperty.get() && LocalDate.now().getMonthValue() == monthProperty.get() && j == LocalDate.now().getDayOfMonth()) {
				dias.get().get(i).getStyleClass().add("today");
				diaActual=dias.get(i);
			}
		}
		
		switch (monthProperty.getValue()) {
		case 1:
			mesLabel.setText("Enero");
			break;
		case 2:
			mesLabel.setText("Febrero");
			break;
		case 3:
			mesLabel.setText("Marzo");
			break;
		case 4:
			mesLabel.setText("Abril");
			break;
		case 5:
			mesLabel.setText("Mayo");
			break;
		case 6:
			mesLabel.setText("Junio");
			break;
		case 7:
			mesLabel.setText("Julio");
			break;
		case 8:
			mesLabel.setText("Agosto");
			break;
		case 9:
			mesLabel.setText("Septiembre");
			break;
		case 10:
			mesLabel.setText("Octubre");
			break;
		case 11:
			mesLabel.setText("Noviembre");
			break;
		case 12:
			mesLabel.setText("Diciembre");
			break;
		default:
			break;
		}
		
	}

	public final IntegerProperty monthPropertyProperty() {
		return this.monthProperty;
	}
	

	public final int getMonthProperty() {
		return this.monthPropertyProperty().get();
	}
	

	public final void setMonthProperty(final int monthProperty) {
		this.monthPropertyProperty().set(monthProperty);
	}
	

	public final IntegerProperty yearPropertyProperty() {
		return this.yearProperty;
	}
	

	public final int getYearProperty() {
		return this.yearPropertyProperty().get();
	}
	

	public final void setYearProperty(final int yearProperty) {
		this.yearPropertyProperty().set(yearProperty);
	}
	

}
