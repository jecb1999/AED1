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
import model.*;
import model.Number;


public class Controller implements Initializable {
	private Matrix matriz;
	private Text gPane;
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

		bt2 = new Button("method 2");

		bt3 = new Button("method 3");

		root = new VBox(2);
		gPane = new Text();
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
		root.getChildren().addAll(vb2, gPane);
		sc = new Scene(root);
		s.setScene(sc);
		s.show();

	}

	public void createMatriz(int option) {
		int num = Integer.parseInt(tx.getText());
		matriz = new Matrix(num, option);
		new Thread() {
			public void run() {
				try {
					boolean noEnd = true;
					while (noEnd) {
						sleep(1000);
						fillGPane();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}.start();
	}

	public void actionButton1() {
		bt1.setOnAction(e -> {
			createMatriz(1);
			fillGPane();
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

	public void fillGPane() {
		Number[][] matrizdraw = matriz.getNumbers();
		boolean exit = false;
		for (int i = 0; i < matrizdraw.length && exit == false; i++) {
			for (int j = 0; j < matrizdraw[0].length && exit == false; j++) {
					if (matrizdraw[i][j] != null &&!matrizdraw[i][j].getDraw()) {
						if(j == matrizdraw[0].length - 1) {
							if(matrizdraw[i][j].isPrime()){
								gPane.setStyle("-fx-text-fill: red");
								gPane.setText(gPane.getText()+matrizdraw[i][j].getValue() + "\n");
							}else {
								gPane.setText(gPane.getText()+matrizdraw[i][j].getValue() + "\n");
							}
						}else {
							gPane.setText(gPane.getText()+matrizdraw[i][j].getValue() + "  ");
						}
						matrizdraw[i][j].setDraw(true);
						exit = true;
					}
				}
			}

		

//	new Thread(() ->{
//		for (int i = 0; i < matriz.getNumbers().length; i++) {
//			for (int j = 0; j < matriz.getNumbers()[0].length; j++) {
//				if (matriz.getNumbers()[i][j] != null) {
//					Button b = new Button(matriz.getNumbers()[i][j].getValue() + "");
//					b.setDisable(true);
//					if (matriz.getNumbers()[i][j].isPrime()) {
//						b.setStyle("-fx-background-color :LAWNGREEN");
//					} else {
//						b.setStyle("-fx-background-color :RED");
//					}
//					gPane.add(b, j, i);
//						s.setScene(sc);
//						s.show(); 
//						fn.start();
//				}

//			}
//		}
//	}).start();
//	

}
}
