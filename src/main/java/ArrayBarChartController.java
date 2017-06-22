import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class ArrayBarChartController {
    @FXML
    private BarChart<String, Integer> bc;

    private IntArray array;

    public void initialize() {
        bc.setAnimated(false);
        bc.setBarGap(0);
        array = new IntArray();

        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.updateBarChart(bc);
        //((XYChart.Data) arraySeries.getData().get(2)).getNode().setStyle("-fx-bar-fill: aqua;");
        array.changeColor(2, "aqua");
    }

    public BarChart getBC() {
        return bc;
    }

    public void clear() {
        array.clear();
    }

    public void get(int i) {
    }

    public void add(int value) {
        array.addLast(value);
    }

}
