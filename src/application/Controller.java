package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Matrix;

public class Controller implements Initializable{
	private Matrix matriz;
	private GridPane gPane;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private VBox root;
	private TextField tx;
	private Stage s;
	private Scene sc;
	
	public Controller(Stage s) {
		this.s = s;
		bt1 = new Button("method 1");
		actionButton1();
		bt2 = new Button("method 2");
		actionButton2();
		bt3 = new Button("method 3");
		actionButton3();
		root = new VBox(2);
		gPane = new GridPane();
		start(s);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void start(Stage s) {
		VBox vb2 = new VBox(4);
		Text title = new Text("INGRESE EL NUMERO");
		tx = new TextField();
		Text text = new Text("Seleccione el metodo");
		HBox hv = new HBox();
		
		
		hv.getChildren().addAll(bt1, bt2, bt3);
		vb2.getChildren().addAll(title,  tx, text, hv);
		root.getChildren().addAll(vb2,gPane);
		
		sc = new Scene(root);
		s.setScene(sc);
		s.show();
		
	}
	
	public void createMatriz(int option) {
		int num = Integer.parseInt(tx.getText());
		matriz = new Matrix(num,option);
	}
	
	public void actionButton1() {
		bt1.setOnAction(e->{
			createMatriz(1);
			gPane.getChildren().clear();
			fillGPane();			
		});
		
	}
	public void actionButton2() {
		bt2.setOnAction(e->{
			createMatriz(2);	
			gPane.getChildren().clear();
			fillGPane();
		});
	}
	public void actionButton3() {
		bt3.setOnAction(e->{
			createMatriz(3);			
			gPane.getChildren().clear();
			fillGPane();			
		});
	}
	
	public void fillGPane() {
		for (int i = 0; i < matriz.getNumbers().length; i++) {
			for (int j = 0; j < matriz.getNumbers()[0].length; j++) {
				if (matriz.getNumbers()[i][j] != null) {
					Button b = new Button(matriz.getNumbers()[i][j].getValue() + "");
					b.setDisable(true);
					if (matriz.getNumbers()[i][j].isPrime()) {
						b.setStyle("-fx-background-color :LAWNGREEN");
					} else {
						b.setStyle("-fx-background-color :RED");
					}
					gPane.add(b, j, i);
					try {
						s.setScene(sc);
						s.show();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	

}
