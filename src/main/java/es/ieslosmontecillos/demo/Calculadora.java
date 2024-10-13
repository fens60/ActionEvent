package es.ieslosmontecillos.demo;

/*
* @author: Shangfeng Shan
* @date:  ${date}
* */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application {

    @Override
    public void start(Stage primaryStage) {
        //crear etiquetas y campos de texto
        Label interes_anual = new Label("Tasa de interes anual:");
        TextField Textinteres_anual = new TextField();

        Label NAnos = new Label("Número de años:");
        TextField TextNAnos = new TextField();

        Label pretamo = new Label("Monto del préstamo:");
        TextField TextPrestamo = new TextField();

        Label PagoMes = new Label("Pago mensual:");
        TextField PagoMesResu = new TextField();

        Label Pagototal = new Label("Pago Total:");
        TextField PagototalResu = new TextField();

        Button carcular = new Button("Calcular");

        //configurar el evento del botón usando expresión lambda
        carcular.setOnAction(e -> {
            try {
                //obtener los valores ingresados
                double InteresAnual = Double.parseDouble(Textinteres_anual.getText());
                int Nanos = Integer.parseInt(TextNAnos.getText());
                double prestamo = Double.parseDouble(TextPrestamo.getText());

                //calcular r (interés mensual)
                double r = InteresAnual / (100 * 12);

                //calcular la cuota mensual (fórmula)
                double pagoMes = (prestamo * r) / (1 - Math.pow(1 + r, -12 * Nanos));

                //calcular el pago total
                double pagoTotal = pagoMes * 12 * Nanos;

                //mostrar los resultados redondeados a dos decimales
                PagoMesResu.setText(String.format("%.2f", pagoMes));
                PagototalResu.setText(String.format("%.2f", pagoTotal));
            } catch (NumberFormatException ex) {
                PagoMesResu.setText("Error en los datos.");
                PagototalResu.setText("");
            }
        });

        //configurar el layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        //añadir los controles al layout
        grid.add(interes_anual, 0, 0);
        grid.add(Textinteres_anual, 1, 0);
        grid.add(NAnos, 0, 1);
        grid.add(TextNAnos, 1, 1);
        grid.add(pretamo, 0, 2);
        grid.add(TextPrestamo, 1, 2);
        grid.add(PagoMes, 0, 3);
        grid.add(PagoMesResu, 1, 3);
        grid.add(Pagototal, 0, 4);
        grid.add(PagototalResu, 1, 4);
        grid.add(carcular, 1, 5);

        //configurar la escena
        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Carculadora");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}