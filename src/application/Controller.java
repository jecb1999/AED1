package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import model.Number;


public class Controller implements Initializable {
	private Matrix matriz;
	private Text text;
	private GridPane gpane;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private VBox root;
	private TextField tx;
	private Stage s;
	private Scene sc;
	private int globalI;
	private int globalJ;
	private boolean noEnd;
	private AnchorPane grilla;

	public Controller(Stage s) {
		this.s = s;
		bt1 = new Button("method 1");
		grilla = new AnchorPane();
		bt2 = new Button("method 2");
		globalI = 0;
		globalJ = 0;
		bt3 = new Button("method 3");
		noEnd = false;
		gpane = new GridPane();
		root = new VBox(2);
		text = new Text();
		actionButton1();
		actionButton2();
		actionButton3();
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
		vb2.getChildren().addAll(title, tx, text, hv);
		root.getChildren().addAll(vb2, grilla);
		sc = new Scene(root);
		s.setScene(sc);
		s.show();

	}
	public void createMatriz(int option) {
		int num = Integer.parseInt(tx.getText());
		matriz = new Matrix(num, option);
//		new Thread() {
//			public void run() {
//				try {
//					while (!noEnd) {
//						sleep(1000);
//						System.out.println("si");
//					}
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}.start();
	}

	public void actionButton1() {
		bt1.setOnAction(e -> {
			createMatriz(1);
			new Thread() {
				public void run() {
					try {
						while (!noEnd) {
							sleep(1000);
							System.out.println("si");
							fillGpane3();
//							noEnd = true;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}.start();
			
		});
		
	}

	public void actionButton2() {
		bt2.setOnAction(e -> {
			createMatriz(2);

		});

	}

	public void actionButton3() {

		bt3.setOnAction(e -> {
			createMatriz(3);
		});
	}

	public void fillGpane3() {
//		grilla.getChildren().clear();
		Number[][] matrizdraw = matriz.getNumbers();
		boolean exit = false;
		matrizdraw[0][0].setDraw(true);
		for (int i = 0; i < matrizdraw.length && !exit; i++) {
			for (int j = 0; j < matrizdraw[0].length && !exit; j++) {
				Label tsd = new Label();
				String t = "";
				if (matrizdraw[i][j] != null) {
					if (matrizdraw[i][j].getDraw() == true) {
						if (matrizdraw[i][j].isPrime()) {
							t += matrizdraw[i][j].getValue();
							tsd.setTextFill(Color.LAWNGREEN);
							tsd.setLayoutX(globalJ);
							tsd.setLayoutY(globalI);
							tsd.setText(t);
						} else {
							t += matrizdraw[i][j].getValue();
							tsd.setTextFill(Color.RED);
							tsd.setLayoutX(globalJ);
							tsd.setLayoutY(globalI);
							tsd.setText(t);
						}
						
						Platform.runLater(new Runnable() {
						      public void run() {
						  		grilla.getChildren().add(tsd);
								globalJ += 50;
						      }
						  });
				
					} else {
						exit = true;
						if(matrizdraw[i][j] != null) {
							matrizdraw[i][j].setDraw(true);
						}
					}
				}
			}
			globalJ = 0;
//			globalI += 50;
		}
	}
	
//	funciona sin hilo
	public void fillGpane2() {
		Number[][] matrizdraw = matriz.getNumbers();
		for (int i = 0; i < matrizdraw.length; i++) {
			for (int j = 0; j < matrizdraw[0].length; j++) {
				Label tsd = new Label();
				String t = "";
				if (matrizdraw[i][j] != null ) {
					if (matrizdraw[i][j].isPrime()) {
						t += matrizdraw[i][j].getValue();
						tsd.setTextFill(Color.LAWNGREEN);
						tsd.setLayoutX(globalJ);
						tsd.setLayoutY(globalI);
						tsd.setText(t);
					} else {
						t += matrizdraw[i][j].getValue();
						tsd.setTextFill(Color.RED);
						tsd.setLayoutX(globalJ);
						tsd.setLayoutY(globalI);
						tsd.setText(t);
					}
				}
				grilla.getChildren().add(tsd);
				globalJ += 50; 
				try {
					Thread.sleep(1000);
					System.out.println("v");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			globalJ = 0; 
			globalI += 50;
		}
	}
}



	

