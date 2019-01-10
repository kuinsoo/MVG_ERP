package commonDocument.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import production.service.IProductionService;
import production.service.ProductionService;
import production.vo.ProductionJournalVO;

public class ChartController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart t1_pieChart;

    @FXML
    private ImageView img_logout;
    @FXML
    private ImageView img_exit;

    @FXML
    private BorderPane thisRoot;

    @FXML
    void click_img_exit(MouseEvent event) {
		Stage thisStage = (Stage)thisRoot.getScene().getWindow();
		thisStage.close();
    }

    /* 전역변수 */
    private IProductionService service = ProductionService.getInstance();
    
    @FXML
    void initialize() {
    	 assert thisRoot != null : "fx:id=\"thisRoot\" was not injected: check your FXML file 'Chart.fxml'.";
         assert img_exit != null : "fx:id=\"img_exit\" was not injected: check your FXML file 'Chart.fxml'.";
         assert t1_pieChart != null : "fx:id=\"t1_pieChart\" was not injected: check your FXML file 'Chart.fxml'.";

    	List<PieChart.Data> piedate = new ArrayList<>();
        List<ProductionJournalVO> prodList = service.getProductionJournal();
        for (ProductionJournalVO prodVo : prodList) {
			piedate.add(new PieChart.Data(prodVo.getProd_name(),prodVo.getProd_qty()));
		}
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(piedate);
           
        t1_pieChart.setData(pieChartData);
        t1_pieChart.autosize();
        
    }
    
}












