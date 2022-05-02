package hse.btf.pdfeditor;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static hse.btf.pdfeditor.Singleton.observableList;

public class PdfEditorController {
    @FXML
    private Button createButton;

    @FXML
    void createProjectButton(ActionEvent event) throws IOException {
        // closing previous
        Stage thisStage = (Stage) createButton.getScene().getWindow();
        thisStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("work-window.fxml"));

        Pane layout = new Pane();

        // synchronizing
        observableList.addListener((ListChangeListener<Node>) c -> {
            while (c.next()) {
                if (c.wasPermutated()) {
                } else if (c.wasUpdated()) {
                    //update item
                } else {
                    for (Node remItem : c.getRemoved()) {
                        layout.getChildren().remove(remItem);
                    }
                    for (Node addItem : c.getAddedSubList()) {
                        layout.getChildren().add(addItem);
                    }
                }
            }
        });

        layout.getChildren().add(fxmlLoader.load());

        Scene scene = new Scene(layout);
        // Scene scene = new Scene(fxmlLoader.load());

        // styling
        //String css = Sample.class.getResource("main.css").toExternalForm();
        //scene.getStylesheets().add(css);

        // creating stage
        Stage stage = new Stage();

        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("Working Window");
        stage.setScene(scene);
        stage.show();
    }
}